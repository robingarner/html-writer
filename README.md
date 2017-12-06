HTMLWriter
====
A fluent HTML library
---

HTMLWriter is a simple library for writing HTML in a fluent style.  Some examples
should illustrate what it does:

    Element root = HTML.html();
    
This creates a single `<html></html>` element.  You add elements to the body of an element by calling methods whose names are what you'd expect

    root.head();
    Element body = root.body();
    body.div();
    body.div();

Each of the methods creates an element, appends it to the parent element, and then returns itself.  This way you can chain calls together to create nested elements, such as

    body.div().p().text("This is some text");

will render as

    <div><p>This is some text</p></div>

Note that 

    body.div();
    body.div();

is not the same as

    body.div().div();

the first creates two `<div/>` elements in a row, while the second contains a nested `<div><div/></div>` pair.
    
Setting attributes is done in a similar way, either using the `setAttr` method, the `cls` method (a synonym for `setAttr("class",xxx)`) or element-specific methods (e.g. the `link` method---see the javadoc).

    Element panel = body.div().cls("span12 panel panel-info")
        .setAttr("style","font-size: 12px;");
    panel.div().cls("panel-heading").h4("Heading");
    panel. ...

which creates

    <div class="span12 panel panel-info" style="font-size: 12px;">
      <div class="panel-heading"><h4>Heading</h4></div>
      ...
    </div>

## Creating and rendering documents

The class `HTML` is the initial entry point into the system.

    Element html = HTML.html();
    
creates an `<html/>` element, and is the usual way to create the first element in a page.  There is also the static method `HTML.empty()` which creates a non-rendering placeholder element.

Once you have built a page, it is rendered using another static method of the HTML class,

    HTML.render(element, printWriter)

which renders the element onto 

## Classes

The fundamental class in the system is an interface called `Element`.  All the methods that create elements are defined by this interface.

## Creating Tables

The `TableBuilder` class simplifies building tables.  Some examples:

    TableBuilder b = new TableBuilder();
    b.setColumns("a","b");
    b.addRow("ra","rb");
    b.addRow("rd","re");
    b.build(parent);
    
this appends the following HTML to the children of `parent`,

    <table>
      <thead>
        <tr><th class="a">a</th><th class=\"b\">b</th></tr>
      </thead>
      <tbody>
        <tr><td class="row1">a</td><td class="row1">b</td></tr>
        <tr><td class="row2">d</td><td class="row2">e</td></tr>
      </tbody>
    </table>

# Building

    $ buildr [clean] package
    
or

    $ buildr [clean] upload
    
which publishes the latest version to the shared repository.


