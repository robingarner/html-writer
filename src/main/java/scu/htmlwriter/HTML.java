package scu.htmlwriter;

import java.io.PrintWriter;
import java.io.StringWriter;

import scu.htmlwriter.impl.AttributeFactoryImpl;
import scu.htmlwriter.impl.BlockRenderer;
import scu.htmlwriter.impl.Empty;
import scu.htmlwriter.impl.Renderer;
import scu.htmlwriter.impl.SimpleElement;
import scu.htmlwriter.impl.Text;

/**
 * Primary entrypoint into the HTMLWriter library.
 * <p>
 * The methods html() and empty() create initial elements as the starting
 * points for building an HTML document.
 * <p>
 * The method 'attributeFactory()' returns an instance that can be used to
 * create Attributes.
 * <p>
 * The remaining methods render a document to a PrintWriter or to a String.
 */
public class HTML {

  /**
   * @return an Attribute Factory instance.
   */
  public static AttributeFactory attributeFactory() {
    return new AttributeFactoryImpl();
  }

  /**
   * @return an HTML element.
   */
  public static Element html() {
    return new SimpleElement("html");
  }

  /**
   * @return an HTML element.
   */
  public static Element element(String name) {
    return new SimpleElement(name);
  }

  /**
   * @return an HTML text element.
   */
  public static Element text(String text) {
    return new Text(text);
  }

  /**
   * @return an Empty (non-rendering) element.
   */
  public static Empty empty() {
    return new Empty();
  }

  /**
   * Render an HTML element to a PrintWriter.
   *
   * @param e
   * @return
   */
  public static void render(Element e, PrintWriter wr) {
    e.accept(new Renderer(wr));
  }

  /**
   * Render an HTML element to a PrintWriter, laying out the HTML
   * in a block-structured way, with indents.
   *
   * @param e
   * @return
   */
  public static void renderPretty(Element e, PrintWriter wr) {
    e.accept(new BlockRenderer(wr));
  }

  /**
   * Render an HTML element to a String.
   *
   * @param e
   * @return
   */
  public static String format(Element e) {
    StringWriter wr = new StringWriter();
    render(e, new PrintWriter(wr));
    return wr.toString();
  }


  /**
   * Render an HTML element to a String, as a block-structured indented document.
   *
   * @param e
   * @return
   */
  public static String formatPretty(Element e) {
    StringWriter wr = new StringWriter();
    renderPretty(e, new PrintWriter(wr));
    return wr.toString();
  }

}
