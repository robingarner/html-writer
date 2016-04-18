package org.github.robingarner.htmlwriter.impl;

import java.io.PrintWriter;

/**
 * Renderer class that cares about trying to format things in blocks with
 * indentation.
 */
public class BlockRenderer extends Renderer {

  private int indentLevel = 0;

  private boolean atSol = true;

  public BlockRenderer(PrintWriter wr) {
    super(wr);
  }

  /**
   * If necessary, insert leading white-space.
   */
  protected void doTab() {
    for (int i=0; i < indentLevel; i++) {
      wr.print(" ");
    }
  }

  @Override
  protected void print(String str) {
    if (atSol) {
      doTab();
    }
    super.print(str);
    atSol = false;
  }

  /**
   * Insert a newline
   */
  @Override
  protected void println() {
    super.println();
    atSol = true;
  }

  /**
   * Print the opening tag of an HTML element.
   * @param element
   */
  @Override
  protected void openElement(SimpleElement element) {
    if (!atSol) {
      println();
    }
    super.openElement(element);
    indentLevel++;
  }

  /**
   * Print the closing tag of an HTML element.
   * @param element
   */
  @Override
  protected void closeElement(SimpleElement element) {
    indentLevel--;
    super.closeElement(element);
    println();
  }

  @Override
  protected void openCloseElement(SimpleElement element) {
    if (!atSol) {
      println();
    }
    super.openCloseElement(element);
    println();
  }

}
