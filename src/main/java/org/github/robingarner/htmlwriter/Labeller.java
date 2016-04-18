package org.github.robingarner.htmlwriter;

/**
 * Interface for entities that generate a label according to a scheme, e.g.
 * for the i-th row or column of a table.
 */
public interface Labeller {

  /**
   * Return the class for the i-th element.
   * @param i
   * @return
   */
  String get(int i);

}
