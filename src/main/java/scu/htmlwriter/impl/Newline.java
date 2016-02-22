package scu.htmlwriter.impl;

import scu.htmlwriter.Visitor;


/**
 * A pseudo-HTML element that renders as a newline.
 * @author rgarner
 *
 */
public class Newline extends BaseElement {

  public Newline() {
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
