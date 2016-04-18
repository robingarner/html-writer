package org.github.robingarner.htmlwriter.impl;

import org.github.robingarner.htmlwriter.Visitor;

public class Empty extends BaseElement {

  public Empty() {
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }

}
