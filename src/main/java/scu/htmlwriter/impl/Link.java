package scu.htmlwriter.impl;

import scu.htmlwriter.Visitor;

public class Link extends SimpleElement {

  public Link(String rel) {
    super("link");
    setAttr("rel",rel);
  }

  /** Set crossorigin=anonymous */
  public Link anon() {
    setAttr("crossorigin","anonymous");
    return this;
  }

  /** Set crossorigin=use-credentials */
  public Link useCredentials() {
    setAttr("crossorigin","use-credentials");
    return this;
  }

  /** Set href attribute */
  public Link href(String url) {
    setAttr("href",url);
    return this;
  }

  /** Set integrity attribute */
  public Link integrity(String hash) {
    setAttr("integrity",hash);
    return this;
  }


  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }
}
