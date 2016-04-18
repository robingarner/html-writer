package org.github.robingarner.htmlwriter;

import org.github.robingarner.htmlwriter.AttributeFactory;
import org.github.robingarner.htmlwriter.Element;
import org.github.robingarner.htmlwriter.HTML;
import org.github.robingarner.htmlwriter.impl.AttributeFactoryImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FluentTest extends BaseTest {

  @Test
  public void html() {
    Element root = HTML.html();
    Assert.assertEquals(render(root), "<html/>");
  }

  @Test
  public void simple() {
    Element root = HTML.html();
    root.body();
    Assert.assertEquals(render(root), "<html><body/></html>");
  }

  @Test
  public void simplePage() {
    Element root = HTML.html();
    root.head().title().text("Title");
    root.body().text("Body");
    Assert.assertEquals(render(root), "<html><head><title>Title</title></head><body>Body</body></html>");
  }

  @Test
  public void chainText() {
    Element p = HTML.html().p();
    p.text("a ").text("b");
    Assert.assertEquals(render(p), "<p>a b</p>");
  }

  @Test
  public void chainTextCr() {
    Element p = HTML.html().p();
    p.text("a").cr().text("b");
    Assert.assertEquals(render(p), "<p>a\nb</p>");
  }

  @Test
  public void table() {
    Element root = HTML.html();
    Element t = root.body().table();

    Element header = t.thead().tr();
    header.th().text("H1");
    header.th().text("H2");

    Element row1 = t.tr();
    row1.td().text("C11");
    row1.td().text("C12");

    Element row2 = t.tr();
    row2.td().text("C21");
    row2.td().text("C22");

    Assert.assertEquals(render(root), "<html><body>"
        + "<table>"
        + "<thead>"
        + "<tr><th>H1</th><th>H2</th></tr>"
        + "</thead>"
        + "<tr><td>C11</td><td>C12</td></tr>"
        + "<tr><td>C21</td><td>C22</td></tr>"
        + "</table>"
        + "</body></html>");
  }

  @Test
  public void tableWithAttrs() {
    AttributeFactory a = new AttributeFactoryImpl();
    Element root = HTML.html();
    Element t = root.body().table(a.cls("table-cls"));

    Element header = t.thead().tr();
    header.th(a.cls("th col1")).text("H1");
    header.th(a.cls("th col2")).text("H2");

    Element row1 = t.tr();
    row1.td(a.cls("row1 col2")).text("C11");
    row1.td(a.cls("row1 col2")).text("C12");

    Element row2 = t.tr();
    row2.td(a.cls("row2 col1")).text("C21");
    row2.td(a.cls("row2 col2")).text("C22");

    Assert.assertEquals(render(root), "<html><body>"
        + "<table class=\"table-cls\">"
        + "<thead>"
        + "<tr><th class=\"th col1\">H1</th><th class=\"th col2\">H2</th></tr>"
        + "</thead>"
        + "<tr><td class=\"row1 col2\">C11</td><td class=\"row1 col2\">C12</td></tr>"
        + "<tr><td class=\"row2 col1\">C21</td><td class=\"row2 col2\">C22</td></tr>"
        + "</table>"
        + "</body></html>");
  }
}
