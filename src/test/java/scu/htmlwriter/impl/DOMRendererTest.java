package scu.htmlwriter.impl;

import java.io.StringWriter;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import scu.htmlwriter.Element;
import scu.htmlwriter.HTML;

public class DOMRendererTest {

  @Test
  public void visitHTML() throws Exception {
    DOMRenderer d = new DOMRenderer();
    HTML.html().accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\"/>");
  }

  @Test
  public void visitHTMLBody() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    html.body();
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\"><body/></html>");
  }

  @Test
  public void visitHTMLHead() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    html.head();
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<head/>"
        + "</html>");
  }

  @Test
  public void visitTitle() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    html.head().title("Fred");
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<head><title>Fred</title></head>"
        + "</html>");
  }

  @Test
  public void visitDiv() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    html.body().div();
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<body><div/></body>"
        + "</html>");
  }

  @Test
  public void visitA() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    html.head().title("Fred");
    html.body().a("http://","Anchor");
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<head><title>Fred</title></head>"
        + "<body><a href=\"http://\">Anchor</a></body>"
        + "</html>");
  }

  @Test
  public void visitLink() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    html.body().link("stylesheet").href("http://host/url");
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<body><link href=\"http://host/url\" rel=\"stylesheet\"/></body>"
        + "</html>");
  }

  @Test
  public void visitEmpty() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    html.body().empty().a();
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<body><a/></body>"
        + "</html>");
  }

  @Test
  public void visitEmpty2() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    Element body = html.body().empty();
    body.a();
    body.div();
    body.text("Hi There");
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<body><a/><div/>Hi There</body>"
        + "</html>");
  }

  @Test
  public void visitText() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    html.body().text("Line 1");
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<body>Line 1</body>"
        + "</html>");
  }

  @Test
  public void visitText2() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    Element body = html.body();
    body.text("Line 1");
    body.text("Line 2");
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<body>Line 1Line 2</body>"
        + "</html>");
  }

  @Test
  public void visitText3() throws Exception {
    DOMRenderer d = new DOMRenderer();
    Element html = HTML.html();
    Element body = html.body();
    body.text("Line 1").cr();
    body.text("Line 2").cr();
    html.accept(d);
    Assert.assertEquals(format(d.getDocument()),"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>"
        + "<html xmlns=\"http://www.w3.org/1999/xhtml\">"
        + "<body>Line 1\n"
        + "Line 2\n"
        + "</body>"
        + "</html>");
  }

  private String format(Document doc) throws TransformerFactoryConfigurationError, TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    //transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    //initialize StreamResult with File object to save to file
    StreamResult result = new StreamResult(new StringWriter());
    DOMSource source = new DOMSource(doc);
    transformer.transform(source, result);
    return result.getWriter().toString();
  }
}
