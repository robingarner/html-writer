SAML Test Application
=====================

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

The 

# Building

    $ buildr [clean] package
    
or

    $ buildr [clean] upload
    
which publishes the latest version to the shared repository.

## Modifying

    $ buildr eclipse

will auto-generate the eclipse configuration files.

## Dependencies

`buildr` downloads the dependencies automatically from the Maven repository, 
but the system also depends on one local project, `HTMLWriter`.  There is a 
copy of the pre-built jar file (and maven metadata) on a local repository on
idmdev1---to use the buildfile as committed you will need ssh access to this system.  If this isn't possible, you can easily modify the local repository location in the buildfiles of both HTMLWriter and saml-test.


You can always download and build HTMLWriter locally and add it to the eclipse
project's path (best if you need to make changes to the HTMLWriter code).