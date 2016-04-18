package org.github.robingarner.htmlwriter.impl;

import org.github.robingarner.htmlwriter.Visitor;

public class SimpleElement extends BaseElement {

  private final String name;

  public SimpleElement(String name) {
    this.name = name;
  }

  public SimpleElement(String name, String classAttr) {
    this(name);
    setAttr("class", classAttr);
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public String getName() {
    return name;
  }

  /*
   * Generated hashcode and equals
   */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    SimpleElement other = (SimpleElement) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }

}
