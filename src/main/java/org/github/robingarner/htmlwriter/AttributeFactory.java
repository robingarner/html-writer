package org.github.robingarner.htmlwriter;

/**
 * A source of Attributes.
 *
 * In general you should obtain an instance of this class from the
 * {@link org.github.robingarner.htmlwriter.HTML#attributeFactory()} method.
 */
public interface AttributeFactory {

  /**
   * Create a "style" attribute
   * @param value The attribute value
   * @return An attribute that renders as {@code style="value"}
   */
  Attribute style(String css);

  /**
   * Create an "id" attribute
   * @param value The attribute value
   * @return An attribute that renders as {@code id="value"}
   */
  Attribute id(String id);

  /**
   * Create a "class" attribute
   * @param value The attribute value
   * @return An attribute that renders as {@code class="value"}
   */
  Attribute cls(String classNames);

  /**
   * Create an attribute
   * @param name The attribute name
   * @param value The attribute value
   * @return An attribute that renders as {@code name="value"}
   */
  Attribute attr(String name, String value);

}
