package org.github.robingarner.htmlwriter;

import org.github.robingarner.htmlwriter.impl.Empty;
import org.github.robingarner.htmlwriter.impl.Link;
import org.github.robingarner.htmlwriter.impl.Newline;
import org.github.robingarner.htmlwriter.impl.SimpleElement;
import org.github.robingarner.htmlwriter.impl.Text;

/**
 * Visitor interface - has a visit method for every
 * <i>concrete</i> implementation of {@code Element}
 */
public interface Visitor {

  void visit(SimpleElement element);

  void visit(Text text);

  void visit(Newline lf);

  void visit(Empty noop);

  void visit(Link link);

}
