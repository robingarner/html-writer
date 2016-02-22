package scu.htmlwriter;

import scu.htmlwriter.impl.Empty;
import scu.htmlwriter.impl.Link;
import scu.htmlwriter.impl.Newline;
import scu.htmlwriter.impl.SimpleElement;
import scu.htmlwriter.impl.Text;

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
