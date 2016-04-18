package org.github.robingarner.htmlwriter.impl;

import org.github.robingarner.htmlwriter.Labeller;

public class NumberedLabels implements Labeller {

  private final String base;

  public NumberedLabels(String base) {
    this.base = base;
  }

  @Override
  public String get(int i) {
    return base + i;
  }

}
