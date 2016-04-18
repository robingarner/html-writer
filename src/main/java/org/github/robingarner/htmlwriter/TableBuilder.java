package org.github.robingarner.htmlwriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.github.robingarner.htmlwriter.impl.AttributeImpl;
import org.github.robingarner.htmlwriter.impl.NumberedLabels;

/**
 * Helper class to facilitate building a table.
 */
public class TableBuilder {

  private String tableClass = null;

  private List<String> columnClasses = new ArrayList<>();
  private List<String> columnText = new ArrayList<>();

  private List<List<Element>> rows = new LinkedList<>();

  private List<Attribute> tableAttrs = new LinkedList<>();

  private boolean linePerRow = false;

  private Labeller rowLabels = new NumberedLabels("row");

  /**
   * Create a TableBuilder
   */
  public TableBuilder() {
  }

  /**
   * Set the class(es) for the {@code <table>} element
   */
  public TableBuilder setTableClass(String tableClass) {
    this.tableClass = tableClass;
    return this;
  }

  /**
   * Set an arbitrary attribute value for the {@code <table>} element
   */
  public TableBuilder setTableAttr(String attr, String value) {
    this.tableAttrs.add(new AttributeImpl(attr, value));
    return this;
  }

  public boolean isLinePerRow() {
    return linePerRow;
  }

  public void setLinePerRow(boolean linePerRow) {
    this.linePerRow = linePerRow;
  }

  /**
   * Provide the bodies (text only) of the columns.  Also sets
   * the classes of each column to be the same as the column header text.
   */
  public TableBuilder setColumns(String...cols) {
    setColumnClasses(cols);
    setColumnTexts(cols);
    return this;
  }

  /**
   * Provide the bodies (text only) of the columns.  Does not set classes
   * for each of the columns.
   * @return this
   */
  public TableBuilder setColumnTexts(String... cols) {
    columnText.clear();
    columnText.addAll(Arrays.asList(cols));
    return this;
  }

  /**
   * Provide the classes of the columns.
   * @param cols The n-th element of cols is the CSS class for the
   * nth column of the table
   * @return this
   */
  public TableBuilder setColumnClasses(String... cols) {
    columnClasses.clear();
    columnClasses.addAll(Arrays.asList(cols));
    return this;
  }

  /**
   * Add a row of simple text data to the table
   * @param cells
   * @return this
   */
  public TableBuilder addRow(String... cells) {
    List<Element> row = new ArrayList<>(cells.length);
    for (String cell : cells) {
      row.add(HTML.text(cell));
    }
    rows.add(row);
    return this;
  }

  /**
   * Add a row of HTML elements
   * @param cells
   * @return this
   */
  public TableBuilder addRow(Element... cells) {
    rows.add(Arrays.asList(cells));
    return this;
  }

  /**
   * Render the table described by this builder, as the next child of the given parent
   * element.
   * @param parent The parent element for this table.
   * @return The newly created table element.
   */
  public Element build(Element parent) {
    Element tab = parent.table(tableAttrs);
    if (tableClass != null) {
      tab.cls(tableClass);
    }
    if (columnText.size() > 0) {
      buildHead(tab);
    }
    if (rows.size() > 0) {
      buildBody(tab);
    }
    return tab;
  }

  /**
   * Build the head of the table
   * @param tab
   */
  void buildHead(Element tab) {
    Element thead = tab.thead();
    Element tr = thead.tr();
    for (int i=0; i < Math.max(columnClasses.size(), columnText.size()); i++) {
      Element th = tr.th();
      if (columnClasses.size() > i) {
        th.cls(columnClasses.get(i));
      }
      if (columnText.size() > i) {
        th.text(columnText.get(i));
      }
    }
    if (linePerRow) {
      thead.cr();
    }
  }

  /**
   * Build the body of the table
   * @param tab
   */
  private void buildBody(Element tab) {
    Element body = tab.tbody();
    for (int r=0; r < rows.size(); r++) {
      List<Element> row = rows.get(r);
      Element tr = body.tr();
      for (int c = 0; c < row.size(); c++) {
        Element col = row.get(c);
        Element td = tr.td();
        String classes = rowLabels.get(r+1);
        if (columnClasses.size() > c) {
          classes += " "+columnClasses.get(c);
        }
        td.cls(classes).append(col);
      }
      if (linePerRow) {
        body.cr();
      }
    }
  }


}
