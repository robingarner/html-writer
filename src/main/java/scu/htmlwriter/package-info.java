/**
 * HTMLWriter is a simple library for writing HTML in a fluent style.<hr>
 * <pre>
 *   {@code
 *   Element root = HTML.html();
 *   }
 * </pre>
 * This creates a single `&lt;html&gt;&lt;/html&gt;` element.  You add elements to the body of an element by calling methods whose names are what you'd expect
 * <pre>
 *   {@code
 *   root.head();
 *  Element body = root.body();
 *  body.div();
 *  body.div();
 * }
 * </pre>
 * Each of the methods creates an element, appends it to the parent element, and then returns itself.  This way you can chain calls together to create nested elements, such as
 * <pre>
 *   {@code
 *     body.div().p().text("This is some text");
 *   }
 * </pre>
 * will render as
 * <pre>
 *   {@code
 *     <div><p>This is some text</p></div>
 *   }
 * </pre>
 * Note that
 * <pre>
 *   {@code
 *     body.div();
 *     body.div();
 *   }
 * </pre>
 * renders as <code>&lt;div/&gt;&lt;div/&gt;</code> whereas
 * <pre>
 *   {@code
 *     body.div().div();
 *   }
 * </pre>
 * renders as <code>&lt;div&gt;&lt;div/&gt;&lt;/div&gt;</code>
 * <p>
 * Setting attributes is done in a similar way, either using the `setAttr` method, the `cls` method (a synonym for `setAttr("class",xxx)`) or element-specific methods (e.g. the `link` method---see the javadoc).
 * <pre>
 *   {@code
 *     Element panel = body.div().cls("span12 panel panel-info")
 *         .setAttr("style","font-size: 12px;");
 *     panel.div().cls("panel-heading").h4("Heading");
 *     panel. ...
 *   }
 * </pre>
 * which creates
 * <pre>
 *   {@code
 *     <div class="span12 panel panel-info" style="font-size: 12px;">
 *       <div class="panel-heading"><h4>Heading</h4></div>
 *       ...
 *     </div>
 *   }
 * </pre>
 * <p>
 * Plain text is added using the pseudo-element "text", as in
 * <pre>
 *   {@code
 *     e.div().text("This is some text");
 *   }
 * </pre>
 * But be careful when adding several lines of text, because the default renderer won't add
 * any whitespace you don't specify, so
 * <pre>
 *   {@code
 *     element.text("a");
 *     element.text("b");
 *   }
 * </pre>
 * produces "ab", not "a b" or "a\nb".  There is a pseudo-element 'cr' that inserts a newline
 * into the output, so
 * <pre>
 *   {@code
 *     element.text("line1").cr();
 *     element.text("line2").cr();
 *   }
 * </pre>
 * adds two separate lines of text.  Note that the 'text' and 'cr' elements don't take
 * attributes or children, so the fluent constructors of these are an exception: they return
 * the parent element, since there's nothing useful you can do with the leaf element.
 * <hr>
 * To render an HTML document, the HTML class has two static methods,
 * {@code HTML.render(Element, PrintWriter)}, which formats the given element onto a PrintWriter.
 */
package scu.htmlwriter;