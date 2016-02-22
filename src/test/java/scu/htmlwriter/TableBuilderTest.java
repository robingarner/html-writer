package scu.htmlwriter;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TableBuilderTest extends BaseTest {

  @Test
  public void noRowsPlain() {
    TableBuilder b = new TableBuilder();
    Assert.assertEquals(render(b.build(HTML.empty())), "<table/>");
  }

  @Test
  public void noRowsWithClass() {
    TableBuilder b = new TableBuilder();
    b.setTableClass("table-class");
    Assert.assertEquals(render(b.build(HTML.empty())), "<table class=\"table-class\"/>");
  }

  @Test
  public void setColumnNames() {
    TableBuilder b = new TableBuilder();
    b.setColumnTexts("","","");
    b.setColumnClasses("a","b","c");
    Assert.assertEquals(render(b.build(HTML.empty())), "<table><thead><tr>"
        + "<th class=\"a\"></th>"
        + "<th class=\"b\"></th>"
        + "<th class=\"c\"></th>"
        + "</tr></thead></table>");
  }

  @Test
  public void setColumnTexts() {
    TableBuilder b = new TableBuilder();
    b.setColumnTexts("a","b","c");
    Assert.assertEquals(render(b.build(HTML.empty())), "<table><thead><tr>"
        + "<th>a</th>"
        + "<th>b</th>"
        + "<th>c</th>"
        + "</tr></thead></table>");
  }

  @Test
  public void setColumns() {
    TableBuilder b = new TableBuilder();
    b.setColumns("a","b","c");
    Assert.assertEquals(render(b.build(HTML.empty())), "<table>"
        + "<thead><tr><th class=\"a\">a</th>"
        + "<th class=\"b\">b</th>"
        + "<th class=\"c\">c</th></tr>"
        + "</thead>"
        + "</table>");
  }

  @Test
  public void twoRowsPlain() {
    TableBuilder b = new TableBuilder();

    b.addRow("a","b","c");
    b.addRow("d","e","f");
    Assert.assertEquals(render(b.build(HTML.empty())), "<table>"
        + "<tbody><tr><td class=\"row1\">a</td><td class=\"row1\">b</td><td class=\"row1\">c</td></tr>"
        + "<tr><td class=\"row2\">d</td><td class=\"row2\">e</td><td class=\"row2\">f</td></tr>"
        + "</tbody></table>");
  }

  @Test
  public void twoRowsOfElements() {
    TableBuilder b = new TableBuilder();

    b.addRow(HTML.element("b").text("a"),
        HTML.element("i").text("b"),
        HTML.text("c"));
    b.addRow(HTML.element("div").text("d"),
        HTML.element("span").text("e"),
        HTML.element("button").text("f"));
    Assert.assertEquals(render(b.build(HTML.empty())), "<table>"
        + "<tbody><tr>"
        + "<td class=\"row1\"><b>a</b></td>"
        + "<td class=\"row1\"><i>b</i></td>"
        + "<td class=\"row1\">c</td>"
        + "</tr><tr>"
        + "<td class=\"row2\"><div>d</div></td>"
        + "<td class=\"row2\"><span>e</span></td>"
        + "<td class=\"row2\"><button>f</button></td>"
        + "</tr></tbody></table>");
  }

  @Test
  public void twoRowsColumnClasses() {
    TableBuilder b = new TableBuilder();

    b.setColumnClasses("ca","cb","cc");
    b.addRow("a","b","c");
    b.addRow("d","e","f");
    Assert.assertEquals(render(b.build(HTML.empty())), "<table><tbody>"
        + "<tr><td class=\"row1 ca\">a</td><td class=\"row1 cb\">b</td><td class=\"row1 cc\">c</td></tr>"
        + "<tr><td class=\"row2 ca\">d</td><td class=\"row2 cb\">e</td><td class=\"row2 cc\">f</td></tr>"
        + "</tbody></table>");
  }

  @Test
  public void prettyTableTest() {
    TableBuilder b = new TableBuilder();

    b.setColumnClasses("ca","cb","cc");
    b.addRow("a","b","c");
    b.addRow("d","e","f");
    Assert.assertEquals(renderPretty(b.build(HTML.empty())), ""
        + "<table>\n"
        + " <tbody>\n"
        + "  <tr>\n"
        + "   <td class=\"row1 ca\">a</td>\n"
        + "   <td class=\"row1 cb\">b</td>\n"
        + "   <td class=\"row1 cc\">c</td>\n"
        + "  </tr>\n"
        + "  <tr>\n"
        + "   <td class=\"row2 ca\">d</td>\n"
        + "   <td class=\"row2 cb\">e</td>\n"
        + "   <td class=\"row2 cc\">f</td>\n"
        + "  </tr>\n"
        + " </tbody>\n"
        + "</table>\n");
  }

  @Test
  public void linePerRow() {
    TableBuilder b = new TableBuilder();

    b.setColumns("a","b","c");
    b.addRow("a","b","c");
    b.addRow("d","e","f");
    b.setLinePerRow(true);
    Assert.assertEquals(render(b.build(HTML.empty())), "<table>"
        + "<thead><tr><th class=\"a\">a</th>"
        + "<th class=\"b\">b</th>"
        + "<th class=\"c\">c</th></tr>\n"
        + "</thead>"
        + "<tbody>"
        + "<tr><td class=\"row1 a\">a</td><td class=\"row1 b\">b</td><td class=\"row1 c\">c</td></tr>\n"
        + "<tr><td class=\"row2 a\">d</td><td class=\"row2 b\">e</td><td class=\"row2 c\">f</td></tr>\n"
        + "</tbody></table>");
  }



}
