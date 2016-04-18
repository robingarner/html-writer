package org.github.robingarner.htmlwriter;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.github.robingarner.htmlwriter.Element;
import org.github.robingarner.htmlwriter.HTML;

public class BaseTest {

  protected String render(Element e) {
    StringWriter wr = new StringWriter();
    HTML.render(e, new PrintWriter(wr));
    return wr.toString();
  }

  protected String renderPretty(Element e) {
    StringWriter wr = new StringWriter();
    HTML.renderPretty(e, new PrintWriter(wr));
    return wr.toString();
  }
}
