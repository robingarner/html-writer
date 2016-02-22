package scu.htmlwriter;

import scu.htmlwriter.impl.AttributeFactoryImpl;

/**
 * An HTML attribute, as a name-value pair.
 * @see AttributeFactoryImpl#attr
 */
public interface Attribute {

  /**
   * @return The name of the attribute
   */
  String getName();

  /**
   * @return The value of the attribute
   */
  String getValue();

}
