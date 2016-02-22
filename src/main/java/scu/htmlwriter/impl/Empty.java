package scu.htmlwriter.impl;

import scu.htmlwriter.Visitor;

public class Empty extends BaseElement {

  public Empty() {
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }

}
