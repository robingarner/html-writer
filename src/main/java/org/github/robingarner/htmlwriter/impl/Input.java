package org.github.robingarner.htmlwriter.impl;

import org.github.robingarner.htmlwriter.Visitor;

public class Input extends SimpleElement {

  public Input() {
    super("input");
  }

  public Input size(int size) {
    setAttr("size", Integer.valueOf(size).toString());
    return this;
  }

  public Input type(String type) {
    setAttr("type", type);
    return this;
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
