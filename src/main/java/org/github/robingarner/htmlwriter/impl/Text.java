package org.github.robingarner.htmlwriter.impl;

import org.github.robingarner.htmlwriter.Visitor;

/**
 * Literal text in an HTML document
 */
public class Text extends BaseElement {

  private final String text;

  public Text(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }


  /*
   * Generated hashcode and equals
   */

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((text == null) ? 0 : text.hashCode());
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
    Text other = (Text) obj;
    if (text == null) {
      if (other.text != null)
        return false;
    } else if (!text.equals(other.text))
      return false;
    return true;
  }

}
