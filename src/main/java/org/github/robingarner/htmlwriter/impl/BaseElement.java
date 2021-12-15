package org.github.robingarner.htmlwriter.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.github.robingarner.htmlwriter.Attribute;
import org.github.robingarner.htmlwriter.Element;

/**
 * Basic HTML element
 */
public abstract class BaseElement implements Element {

  private final Map<String, Attribute> attrs = new LinkedHashMap<>();

  private final List<Element> contents = new ArrayList<>();

  @Override
  public Map<String, Attribute> getAttrs() {
    return attrs;
  }

  @Override
  public List<Attribute> getAttributeList() {
    return new ArrayList<>(attrs.values());
  }

  /** {@inheritDoc} */
  @Override
  public List<Element> getContents() {
    return contents;
  }

  /** {@inheritDoc} */
  @Override
  public <T extends Element> T append(T element, Attribute...attrs) {
    return append(element, Arrays.asList(attrs));
  }

  /** {@inheritDoc} */
  public <T extends Element> T append(T element, Collection<Attribute> attrs) {
    contents.add(element);
    for (Attribute attr : attrs) {
      element.setAttr(attr);
    }
    return element;
  }

  /** {@inheritDoc} */
  @Override
  public Element setAttr(Attribute attr) {
    attrs.put(attr.getName(), attr);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Element setAttr(String name, String value) {
    attrs.put(name, new AttributeImpl(name, value));
    return this;
  }

  /*
   *
   * Methods that add an attribute to the current element.
   *
   * All these return the base element
   *
   */

  /** {@inheritDoc} */
  @Override
  public Element cls(String classNames) {
    setAttr(new AttributeImpl("class", classNames));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Element id(String id) {
    setAttr(new AttributeImpl("id",id));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Element style(String css) {
    setAttr(new AttributeImpl("style", css));
    return this;
  }


  /*
   * Methods that add a new leaf element to the current element.
   *
   * All these return the base element, because since they don't have
   * subordinates that wouldn't make sense.
   */


  /** {@inheritDoc} */
  @Override
  public Element text(String text) {
    append(new Text(text));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Element cr() {
    append(new Newline());
    return this;
  }

  /*
   *
   * Methods that add a new subordinate element to the current element.
   *
   * All these return the newly created element
   *
   */

  /** {@inheritDoc} */
  @Override
  public Element empty() {
    return append(new Empty());
  }

  @Override
  public SimpleElement element(String name, Attribute...attrs) {
    return append(new SimpleElement(name), attrs);
  }

  @Override
  public SimpleElement element(String name, Collection<Attribute> attrs) {
    return append(new SimpleElement(name), attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement html(Attribute...attrs) {
    return element("html",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement head(Attribute...attrs) {
    return element("head",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement body(Attribute...attrs) {
    return element("body",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement title(Attribute...attrs) {
    return element("title",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement title(String text, Attribute...attrs) {
    SimpleElement element = new SimpleElement("title");
    element.text(text);
    return append(element, attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement div(Attribute...attrs) {
    return element("div",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement p(Attribute... attrs) {
    return element("p",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement table(Attribute... attrs) {
    return element("table",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement table(Collection<Attribute> attrs) {
    return element("table",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement thead(Attribute... attrs) {
    return element("thead",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement tbody(Attribute... attrs) {
    return element("tbody",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement tr(Attribute... attrs) {
    return element("tr",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement th(Attribute... attrs) {
    return element("th",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement td(Attribute... attrs) {
    return element("td",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement heading(int i, Attribute... attrs) {
    return append(new SimpleElement("h"+i), attrs);
  }

  @Override
  public SimpleElement heading(int i, String string, Attribute... attrs) {
    SimpleElement heading = heading(i,attrs);
    heading.text(string);
    return heading;
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h1(Attribute... attrs) {
    return heading(1,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h1(String string, Attribute... attrs) {
    return heading(1,string,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h2(Attribute... attrs) {
    return heading(2,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h2(String string, Attribute... attrs) {
    return heading(2,string,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h3(Attribute... attrs) {
    return heading(3,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h3(String string, Attribute... attrs) {
    return heading(3,string,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h4(Attribute... attrs) {
    return heading(4,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h4(String string, Attribute... attrs) {
    return heading(4,string,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h5(Attribute... attrs) {
    return heading(5,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h5(String string, Attribute... attrs) {
    return heading(5,string,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h6(Attribute... attrs) {
    return heading(6,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement h6(String string, Attribute... attrs) {
    return heading(6,string,attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement a(Attribute... attrs) {
    return element("a",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement a(String href, String linkText, Attribute... attrs) {
    SimpleElement a = a(new AttributeImpl("href",href));
    for (Attribute attr : attrs) {
      a.setAttr(attr);
    }
    a.text(linkText);
    return a;
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement br(Attribute... attrs) {
    return element("br",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement hr(Attribute... attrs) {
    return element("hr",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement b(Attribute... attrs) {
    return element("b",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement i(Attribute... attrs) {
    return element("i",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement span(Attribute... attrs) {
    return element("span",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement pre(Attribute... attrs) {
    return element("pre",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement form(Attribute... attrs) {
    return element("form",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement fieldset(Attribute... attrs) {
    return element("fieldset",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement input(Attribute... attrs) {
    return element("input",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement label(Attribute... attrs) {
    return element("label",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement menu(Attribute... attrs) {
    return element("menu",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement menuitem(Attribute... attrs) {
    return element("menuitem",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement meta(Attribute... attrs) {
    return element("meta",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement nav(Attribute... attrs) {
    return element("nav",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement optgroup(Attribute... attrs) {
    return element("optgroup",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement option(Attribute... attrs) {
    return element("option",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement ul(Attribute... attrs) {
    return element("ul",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement ol(Attribute... attrs) {
    return element("ol",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement dl(Attribute... attrs) {
    return element("dl",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement li(Attribute... attrs) {
    return element("li",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public Link link(String rel, Attribute... attrs) {
    return append(new Link(rel), attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement u(Attribute... attrs) {
    return element("u",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public Script script(Attribute... attrs) {
    return append(new Script(), attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement small(Attribute... attrs) {
    return element("small",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement strong(Attribute... attrs) {
    return element("strong",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement sub(Attribute... attrs) {
    return element("sub",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement sup(Attribute... attrs) {
    return element("sup",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement img(Attribute... attrs) {
    return element("img",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement q(Attribute... attrs) {
    return element("q",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement tfoot(Attribute... attrs) {
    return element("tfoot",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement select(Attribute... attrs) {
    return element("select",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement blockquote(Attribute... attrs) {
    return element("blockquote",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement cite(Attribute... attrs) {
    return element("cite",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement code(Attribute... attrs) {
    return element("code",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement caption(Attribute... attrs) {
    return element("caption",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public SimpleElement button(Attribute... attrs) {
    return element("button",attrs);
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((attrs == null) ? 0 : attrs.hashCode());
    result = prime * result + ((contents == null) ? 0 : contents.hashCode());
    return result;
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    BaseElement other = (BaseElement) obj;
    if (attrs == null) {
      if (other.attrs != null)
        return false;
    } else if (!attrs.equals(other.attrs))
      return false;
    if (contents == null) {
      if (other.contents != null)
        return false;
    } else if (!contents.equals(other.contents))
      return false;
    return true;
  }

}
