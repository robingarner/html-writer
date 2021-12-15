package org.github.robingarner.htmlwriter;

import java.util.Arrays;
import java.util.List;

import org.github.robingarner.htmlwriter.impl.SimpleElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HTMLTest extends BaseTest {

  @Test
  public void simpleElement() {
    Assert.assertEquals(render(new SimpleElement("tag")), "<tag/>");
  }

  @Test
  public void simpleElementWithContents() {
    Assert.assertEquals(render(new SimpleElement("tag").text("")), "<tag></tag>");
  }

  @Test
  public void attr() {
    Assert.assertEquals(render(new SimpleElement("tag").setAttr("a","b")),
        "<tag a=\"b\"/>");
  }

  @Test
  public void attrs() {
    Assert.assertEquals(render(new SimpleElement("tag").setAttr("a","b").setAttr("c","d")),
        "<tag a=\"b\" c=\"d\"/>");
  }

  @Test
  public void simpleClass() {
    Assert.assertEquals(render(new SimpleElement("body", "cls")),
        "<body class=\"cls\"/>");
  }

  @Test
  public void simpleClassWithContents() {
    Assert.assertEquals(render(new SimpleElement("body", "cls").text("")),
        "<body class=\"cls\"></body>");
  }

  /**
   * Test that each HTML element produces the right tag
   */
  @Test
  public void elements() {
    Assert.assertEquals(render(HTML.empty()), "");

    Assert.assertEquals(render(HTML.html().a()), "<a/>");
    Assert.assertEquals(render(HTML.html().b()), "<b/>");
    Assert.assertEquals(render(HTML.html().blockquote()), "<blockquote/>");
    Assert.assertEquals(render(HTML.html().button()), "<button/>");
    Assert.assertEquals(render(HTML.html().body()), "<body/>");
    Assert.assertEquals(render(HTML.html().br()), "<br/>");
    Assert.assertEquals(render(HTML.html().caption()), "<caption/>");
    Assert.assertEquals(render(HTML.html().cite()), "<cite/>");
    Assert.assertEquals(render(HTML.html().code()), "<code/>");
    Assert.assertEquals(render(HTML.html().div()), "<div/>");
    Assert.assertEquals(render(HTML.html().dl()), "<dl/>");
    Assert.assertEquals(render(HTML.html().fieldset()), "<fieldset/>");
    Assert.assertEquals(render(HTML.html().form()), "<form/>");
    Assert.assertEquals(render(HTML.html().head()), "<head/>");
    Assert.assertEquals(render(HTML.html().heading(1)), "<h1/>");
    Assert.assertEquals(render(HTML.html().hr()), "<hr/>");
    Assert.assertEquals(render(HTML.html().html()), "<html/>");
    Assert.assertEquals(render(HTML.html().i()), "<i/>");
    Assert.assertEquals(render(HTML.html().input()), "<input/>");
    Assert.assertEquals(render(HTML.html().img()), "<img/>");
    Assert.assertEquals(render(HTML.html().label()), "<label/>");
    Assert.assertEquals(render(HTML.html().li()), "<li/>");
    Assert.assertEquals(render(HTML.html().menu()), "<menu/>");
    Assert.assertEquals(render(HTML.html().meta()), "<meta/>");
    Assert.assertEquals(render(HTML.html().menuitem()), "<menuitem/>");
    Assert.assertEquals(render(HTML.html().nav()), "<nav/>");
    Assert.assertEquals(render(HTML.html().ol()), "<ol/>");
    Assert.assertEquals(render(HTML.html().optgroup()), "<optgroup/>");
    Assert.assertEquals(render(HTML.html().option()), "<option/>");
    Assert.assertEquals(render(HTML.html().p()), "<p/>");
    Assert.assertEquals(render(HTML.html().pre()), "<pre/>");
    Assert.assertEquals(render(HTML.html().q()), "<q/>");
    Assert.assertEquals(render(HTML.html().select()), "<select/>");
    Assert.assertEquals(render(HTML.html().small()), "<small/>");
    Assert.assertEquals(render(HTML.html().span()), "<span/>");
    Assert.assertEquals(render(HTML.html().strong()), "<strong/>");
    Assert.assertEquals(render(HTML.html().sub()), "<sub/>");
    Assert.assertEquals(render(HTML.html().sup()), "<sup/>");
    Assert.assertEquals(render(HTML.html().table()), "<table/>");
    Assert.assertEquals(render(HTML.html().tbody()), "<tbody/>");
    Assert.assertEquals(render(HTML.html().td()), "<td/>");
    Assert.assertEquals(render(HTML.html().tfoot()), "<tfoot/>");
    Assert.assertEquals(render(HTML.html().th()), "<th/>");
    Assert.assertEquals(render(HTML.html().thead()), "<thead/>");
    Assert.assertEquals(render(HTML.html().title()), "<title/>");
    Assert.assertEquals(render(HTML.html().tr()), "<tr/>");
    Assert.assertEquals(render(HTML.html().u()), "<u/>");
    Assert.assertEquals(render(HTML.html().ul()), "<ul/>");
  }

  /**
   * Test the helper methods for headings
   */
  @Test
  public void headings() {
    Assert.assertEquals(render(HTML.html().heading(1)), "<h1/>");
    Assert.assertEquals(render(HTML.html().heading(2)), "<h2/>");
    Assert.assertEquals(render(HTML.html().heading(1,"Heading")), "<h1>Heading</h1>");
    Assert.assertEquals(render(HTML.html().heading(2,"Heading")), "<h2>Heading</h2>");
    Assert.assertEquals(render(HTML.html().h1("Heading 1")), "<h1>Heading 1</h1>");
    Assert.assertEquals(render(HTML.html().h2("Heading 2")), "<h2>Heading 2</h2>");
    Assert.assertEquals(render(HTML.html().h3("Heading 3")), "<h3>Heading 3</h3>");
    Assert.assertEquals(render(HTML.html().h4("Heading 4")), "<h4>Heading 4</h4>");
    Assert.assertEquals(render(HTML.html().h5("Heading 5")), "<h5>Heading 5</h5>");
    Assert.assertEquals(render(HTML.html().h6("Heading 6")), "<h6>Heading 6</h6>");
  }

  @Test
  public void link() {
    Assert.assertEquals(render(HTML.html().link("stylesheet")), "<link rel=\"stylesheet\"/>");
    Assert.assertEquals(render(HTML.html().link("alternate").anon()), "<link rel=\"alternate\" crossorigin=\"anonymous\"/>");
    Assert.assertEquals(render(HTML.html().link("stylesheet").useCredentials()), "<link rel=\"stylesheet\" crossorigin=\"use-credentials\"/>");
    Assert.assertEquals(render(HTML.html().link("stylesheet").href("url")), "<link rel=\"stylesheet\" href=\"url\"/>");
    Assert.assertEquals(render(HTML.html().link("stylesheet").integrity("abc")), "<link rel=\"stylesheet\" integrity=\"abc\"/>");
  }

  @Test
  public void script() {
    Assert.assertEquals(render(HTML.html().script()), "<script></script>");
  }

  @Test public void example() {
    Element body = HTML.html();
    Element panel = body.div().cls("span6 panel panel-info saml-creds");
    panel.div().cls("panel-heading").h4("Exception");
    panel.cr();
    Element p = panel.p();
    List<String> lines = Arrays.asList("first", "second");
    for (String element : lines) {
      p.br().text(element);
      p.cr();
    }
    panel.p();
    System.out.println(render(panel));
  }
}
