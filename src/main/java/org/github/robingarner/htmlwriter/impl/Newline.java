package org.github.robingarner.htmlwriter.impl;

import org.github.robingarner.htmlwriter.Visitor;


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
