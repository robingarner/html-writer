package org.github.robingarner.htmlwriter.impl;

import org.github.robingarner.htmlwriter.Visitor;

public class Script extends SimpleElement {

  public Script() {
    super("script");
    this.empty(); // Always append an empty element = can't close a script with "/>" .. need <script ...></script>
  }

  /** Set crossorigin=anonymous */
  public Script anon() {
    setAttr("crossorigin","anonymous");
    return this;
  }

  /** Set crossorigin=use-credentials */
  public Script useCredentials() {
    setAttr("crossorigin","use-credentials");
    return this;
  }

  /** Set href attribute */
  public Script src(String url) {
    setAttr("src",url);
    return this;
  }

  /** Set integrity attribute */
  public Script integrity(String hash) {
    setAttr("integrity",hash);
    return this;
  }


  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
