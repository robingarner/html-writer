package org.github.robingarner.htmlwriter.impl;

import java.io.PrintWriter;

import org.github.robingarner.htmlwriter.Attribute;
import org.github.robingarner.htmlwriter.Element;
import org.github.robingarner.htmlwriter.Visitor;

/**
 * Renderer class that doesn't care about trying to format everything.
 * @author rgarner
 *
 */
public class Renderer implements Visitor {

  protected final PrintWriter wr;

  public Renderer(PrintWriter wr) {
    this.wr = wr;
  }

  /**
   * Insert a newline
   */
  protected void println() {
    wr.println();
  }

  /**
   * Print a string
   */
  protected void print(String str) {
    wr.print(str);
  }

  /**
   * Render the attributes of an html tag.
   *
   * @param element
   */
  void renderAttrs(Element element) {
    if (element.getAttributeList().size() > 0) {
      for (Attribute attr : element.getAttributeList()) {
        print(" ");
        print(attr.getName());
        print("=\"");
        print(attr.getValue());
        print("\"");
      }
    }
  }

  /**
   * Print the opening tag of an HTML element.
   * @param element
   */
  protected void openElement(SimpleElement element) {
    print("<");
    print(element.getName());
    renderAttrs(element);
    print(">");
  }

  /**
   * Print the closing tag of an HTML element.
   * @param element
   */
  protected void closeElement(SimpleElement element) {
    print("</");
    print(element.getName());
    print(">");
  }

  protected void openCloseElement(SimpleElement element) {
    print("<");
    print(element.getName());
    renderAttrs(element);
    print("/>");
  }

  private void render(SimpleElement element) {
    if (element.getContents().size() > 0) {
      openElement(element);
      for (Element sub : element.getContents()) {
        sub.accept(this);
      }
      closeElement(element);
    } else {
      openCloseElement(element);
    }
  }

  @Override
  public void visit(SimpleElement element) {
    render(element);
  }

  @Override
  public void visit(Text text) {
    print(text.getText());
  }

  @Override
  public void visit(Newline lf) {
    println();
  }

  /**
   * An empty element doesn't render in itself, but its sub-elements do.
   */
  @Override
  public void visit(Empty noop) {
    for (Element sub : noop.getContents()) {
      sub.accept(this);
    }
  }

  @Override
  public void visit(Link link) {
    render(link);
  }


}
