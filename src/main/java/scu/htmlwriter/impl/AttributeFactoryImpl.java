package scu.htmlwriter.impl;

import scu.htmlwriter.Attribute;
import scu.htmlwriter.AttributeFactory;

public class AttributeFactoryImpl implements AttributeFactory {

  /** {@inheritDoc} */
  @Override
  public Attribute attr(String name, String value) {
    return new AttributeImpl(name, value);
  }

  /** {@inheritDoc} */
  @Override
  public Attribute cls(String classNames) {
    return attr("class",classNames);
  }

  /** {@inheritDoc} */
  @Override
  public Attribute id(String id) {
    return attr("id",id);
  }

  /** {@inheritDoc} */
  @Override
  public Attribute style(String css) {
    return attr("style",css);
  }
}
