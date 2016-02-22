package scu.htmlwriter.impl;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import scu.htmlwriter.Attribute;
import scu.htmlwriter.Element;
import scu.htmlwriter.Visitor;

/**
 * Renderer class that turns an Element (constructed with this library) into
 * a
 *
 */
public class DOMRenderer implements Visitor {

  private static final String NEWLINE = System.getProperty("line.separator");

  private final DOMImplementation domImpl;

  /**
   * The document currently being constructed
   */
  private Document doc = null;

  /**
   * The current element being rendered.  Methods that process child elements
   * should save and restore.
   */
  private org.w3c.dom.Element current = null;

  public DOMRenderer() throws IllegalAccessException, InstantiationException, ClassNotFoundException   {
    DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
    domImpl = registry.getDOMImplementation("XML");
  }

  public Document getDocument() {
    return doc;
  }

  private void visitCurrentElement(org.w3c.dom.Element cur, Element element) {
    for (Attribute a : element.getAttributeList()) {
      cur.setAttribute(a.getName(), a.getValue());
    }
    org.w3c.dom.Element savedCurrent = current;
    for (Element e : element.getContents()) {
      current = cur;
      e.accept(this);
    }
    current = savedCurrent;
  }

  private void visitHtml(SimpleElement element) {
    if (doc != null) {
      throw new IllegalStateException("An HTML element can only be a top-level element");
    }
    DocumentType type = domImpl.createDocumentType("html", "-//W3C//DTD XHTML 1.0 Strict//EN", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd");
    doc = domImpl.createDocument("http://www.w3.org/1999/xhtml", "html", type);
    visitCurrentElement(doc.getDocumentElement(), element);
  }

  //  /**
  //   * HEAD is a direct sub-component of the HTMLDocument.
  //   * @param element
  //   */
  //  private void visitHead(SimpleElement element) {
  //    if (doc == null) {
  //      throw new IllegalStateException("A HEAD element must be contained in an HTML element");
  //    }
  //    visitCurrentElement((org.w3c.dom.Element) doc.getElementsByTagName("head").item(0), element);
  //  }
  //
  //  /**
  //   * TITLE is a direct sub-component of the HEAD element - pre-created by the HTMLDocument.
  //   * @param element
  //   */
  //  private void visitTitle(SimpleElement element) {
  //    if (doc == null) {
  //      throw new IllegalStateException("A HEAD element must be contained in an HTML element");
  //    }
  //    org.w3c.dom.Element title = (org.w3c.dom.Element) doc.getElementsByTagName("title").item(0);
  //    title.setTextContent(null);
  //    visitCurrentElement(title, element);
  //  }
  //
  //  private void visitBody(SimpleElement element) {
  //    if (doc == null) {
  //      throw new IllegalStateException("A BODY element must be contained in an HTML element");
  //    }
  //    visitCurrentElement(doc.getBody(), element);
  //  }

  @Override
  public void visit(SimpleElement element) {
    String name = element.getName();
    switch (name) {
    case "html":
      visitHtml(element);
      return;
      //        case "head":
      //          visitHead(element);
      //          return;
      //        case "title":
      //          visitTitle(element);
      //          return;
      //        case "body":
      //          visitBody(element);
      //          return;
    }
    org.w3c.dom.Element cur = doc.createElement(name);
    current.appendChild(cur);
    visitCurrentElement(cur, element);
  }

  @Override
  public void visit(Text text) {
    current.appendChild(doc.createTextNode(text.getText()));
  }

  @Override
  public void visit(Newline lf) {
    current.appendChild(doc.createTextNode(NEWLINE));
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
    visit((SimpleElement)link);
  }


}
