package org.github.robingarner.htmlwriter.impl;

import org.github.robingarner.htmlwriter.AttributeFactory;
import org.github.robingarner.htmlwriter.BaseTest;
import org.github.robingarner.htmlwriter.Element;
import org.github.robingarner.htmlwriter.HTML;
import org.github.robingarner.htmlwriter.impl.AttributeFactoryImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlockRendererTest extends BaseTest {

  @Test
  public void html() {
    Element root = HTML.html();
    Assert.assertEquals(renderPretty(root), "<html/>\n");
  }

  @Test
  public void simple() {
    Element root = HTML.html();
    root.body();
    Assert.assertEquals(renderPretty(root), "<html>\n"
        + " <body/>\n"
        + "</html>\n");
  }

  @Test
  public void simplePage() {
    Element root = HTML.html();
    root.head().title().text("Title");
    root.body().text("Body");
    Assert.assertEquals(renderPretty(root), "<html>\n"
        + " <head>\n"
        + "  <title>Title</title>\n"
        + " </head>\n"
        + " <body>Body</body>\n"
        + "</html>\n");
  }

  @Test
  public void chainText() {
    Element p = HTML.html().p();
    p.text("a ").text("b");
    Assert.assertEquals(renderPretty(p), "<p>a b</p>\n");
  }

  @Test
  public void chainTextCr() {
    Element p = HTML.html().p();
    p.text("a").cr().text("b");
    Assert.assertEquals(renderPretty(p), "<p>a\n b</p>\n");
  }

  @Test
  public void chainTextCrCr() {
    Element p = HTML.html().p();
    p.text("a").cr().cr().text("b");
    Assert.assertEquals(renderPretty(p), "<p>a\n\n b</p>\n");
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

    Assert.assertEquals(renderPretty(root), "<html>\n"
        + " <body>\n"
        + "  <table>\n"
        + "   <thead>\n"
        + "    <tr>\n"
        + "     <th>H1</th>\n"
        + "     <th>H2</th>\n"
        + "    </tr>\n"
        + "   </thead>\n"
        + "   <tr>\n"
        + "    <td>C11</td>\n"
        + "    <td>C12</td>\n"
        + "   </tr>\n"
        + "   <tr>\n"
        + "    <td>C21</td>\n"
        + "    <td>C22</td>\n"
        + "   </tr>\n"
        + "  </table>\n"
        + " </body>\n"
        + "</html>\n");
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

    Assert.assertEquals(renderPretty(root), "<html>\n"
        + " <body>\n"
        + "  <table class=\"table-cls\">\n"
        + "   <thead>\n"
        + "    <tr>\n"
        + "     <th class=\"th col1\">H1</th>\n"
        + "     <th class=\"th col2\">H2</th>\n"
        + "    </tr>\n"
        + "   </thead>\n"
        + "   <tr>\n"
        + "    <td class=\"row1 col2\">C11</td>\n"
        + "    <td class=\"row1 col2\">C12</td>\n"
        + "   </tr>\n"
        + "   <tr>\n"
        + "    <td class=\"row2 col1\">C21</td>\n"
        + "    <td class=\"row2 col2\">C22</td>\n"
        + "   </tr>\n"
        + "  </table>\n"
        + " </body>\n"
        + "</html>\n");
  }
}
