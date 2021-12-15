package org.github.robingarner.htmlwriter;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.github.robingarner.htmlwriter.impl.Link;
import org.github.robingarner.htmlwriter.impl.Script;

public interface Element {

  /**
   * Apply an attribute to this element.
   *
   * @param name Attribute name
   * @param value Attribute value
   * @return this
   */
  Element setAttr(String name, String value);

  /**
   * Apply an attribute to this element
   *
   * @param attr Attribute
   * @return this
   */
  Element setAttr(Attribute attr);


  /**
   * Append a child element to this element.
   * @param element The element to append
   * @param attrs The attributes of the appended element
   * @return This element.
   */
  <T extends Element> T append(T element, Attribute...attrs);

  /**
   * @return The immediately nested elements that this element contains
   */
  List<Element> getContents();

  /**
   * @return The attributes of this element, as a map
   */
  Map<String, Attribute> getAttrs();

  /**
   *
   * @return The attributes of this element, as a list
   */
  List<Attribute> getAttributeList();

  /**
   * The 'accept' method of the Visitor pattern.  Does the double-dispatch required
   * to call the correct visit method of the visitor object.
   * @param visitor
   */
  void accept(Visitor visitor);

  /*
   * Helpers for common attributes
   */

  /**
   * Adds the "class" attribute to the current element
   * @param classNames The classes to add
   * @return this
   */
  Element cls(String classNames);

  /**
   * Adds the "id" attribute to the current element
   * @param id
   * @return this
   */
  Element id(String id);

  /**
   * Adds the "style" attribute to the current element
   *
   * @param css CSS styling to add
   * @return this
   */
  Element style(String css);

  /**
   * A text element.  Breaks the standard by returning its parent not itself.
   *
   * @return this
   */
  Element text(String text);

  /**
   * Force a line-break (not a real HTML element).
   * Breaks the standard by returning its parent not itself.
   *
   * @return this
   */
  Element cr();

  /**
   * An empty element that doesn't render, but which can have children etc.
   *
   * @return The new, empty element.
   */
  Element empty();

  /**
   * An element, by name.  Can be used to add any elements missed by this interface
   * (or new elements).
   *
   * @param name HTML Attribute Name
   * @param attrs Attributes to apply
   * @return The new element.
   */
  Element element(String name, Attribute...attrs);

  /**
   * An element, by name.  Can be used to add any elements missed by this interface
   * (or new elements).
   *
   * @param name HTML Attribute Name
   * @param attrs Attributes to apply
   * @return The new element.
   */
  Element element(String name, Collection<Attribute> attrs);


  /*
   * Creator methods for sub-elements
   */

  /**
   * @param attrs Attributes
   * @return An &lt;a&gt; element.
   */
  Element a(Attribute...attrs);

  /**
   * Helper method for common versions of hyperlink anchors
   * @param href The hyper-ref
   * @param linkText The text of the anchor
   * @param attrs Other attributes
   * @return The new &lt;a&gt; element.
   */
  Element a(String href, String linkText, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return A &lt;b&gt; element.
   */
  Element b(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return A &lt;blockquote&gt; element.
   */
  Element blockquote(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element body(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element button(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element br(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element cite(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element code(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element caption(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element div(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element dl(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element fieldset(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element form(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h1(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h1(String string, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h2(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h2(String string, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h3(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h3(String string, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h4(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h4(String string, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h5(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h5(String string, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h6(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element h6(String string, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element head(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element heading(int i, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element heading(int i, String string, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element hr(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element html(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element i(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element input(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element img(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element label(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element li(Attribute...attrs);

  /**
   * A link element (to add resources to a header).  Not to be confused with an
   * &lt;a&gt; element.
   *
   * @param rel The "rel" element of the link
   * @param attrs Additional attributes for the link
   * @return this
   */
  Link link(String rel, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element menu(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element menuitem(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element meta(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element nav(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element ol(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element optgroup(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element option(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element p(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element pre(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element q(Attribute...attrs);

  /**
   * A link element (to add resources to a header).  Not to be confused with an
   * &lt;a&gt; element.
   *
   * @param rel The "rel" element of the link
   * @param attrs Additional attributes for the link
   * @return this
   */
  Script script(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element select(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element small(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element span(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element strong(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element sub(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element sup(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element table(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element table(Collection<Attribute> attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element tbody(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element td(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element tfoot(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element th(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element thead(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element title(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element title(String text, Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element tr(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element u(Attribute...attrs);

  /**
   * @param attrs Attributes
   * @return The new element.
   */
  Element ul(Attribute...attrs);
}
