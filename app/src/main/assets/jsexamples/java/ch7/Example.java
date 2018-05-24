// A simple class hierarchy.

// Use accessor methods to set and get private members.

// A class for two-dimensional objects.
// A multilevel hierarchy. (p 242)
// Create an abstract class. (p 259)
abstract class TwoDShape {
    private double width; // these are
    private double height; // now private
    private String name = "none";

    // A default constructor. (p 235)
    TwoDShape() {
        width = height = 0.0;
        name = "none";
    }

    // Parameterized constructor. (p 234)
    TwoDShape(double w, double h) {
        width = w;
        height = h;
    }

    // Parameterized constructor.
    TwoDShape(double w, double h, String n) {
        width = w;
        height = h;
        name = n;
    }

    // Constructor with equal width and height. (p 236)
    TwoDShape(double x) {
        width = height = x;
    }

    // Constructor with equal width and height. (p 236)
    TwoDShape(double x, String n) {
        width = height = x;
        name = n;
    }

    // Construct an object from an object.
    TwoDShape(TwoDShape ob) {
        width = ob.width;
        height = ob.height;
        name = ob.name;
    }

    // Accessor methods for width and height.
    String getName() {
        return name;
    }

    double getWidth() {
        return width;
    }

    double getHeight() {
        return height;
    }

    void setWidth(double w) {
        width = w;
    }

    void setHeight(double h) {
        height = h;
    }

    void showDim() {
        System.out.println("Width and height are " + width + " and " + height);
    }

    abstract double area(); // Make area() into an abstract method.
}

// A subclass of TwoDShape for triangles.
class Triangle extends TwoDShape {
    String style;

    // A default constructor
    Triangle() {
        super();
        style = "none";
    }

    // Constructor (p 233)
    Triangle(String s, double w, double h) {
        super(w, h); // call superclass constructor
        style = s;
    }

    // One argument constructor. (p 236)
    Triangle(double x) {
        super(x); // call superclass constructor
        style = "filled";
    }

    // Construct an object from an object.
    Triangle(Triangle ob) {
        super(ob); // pass object to TwoDShape constructor
        style = ob.style;
    }

    // Override area() for Triangle. (p 257)
    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

// Extend Triangle.
class ColorTriangle extends Triangle {
    private String color;

    ColorTriangle(String c, String s, double w, double h) {
        super(s, w, h);
        color = c;
    }

    String getColor() {
        return color;
    }

    void showColor() {
        System.out.println("Color is " + color);
    }
}

// A subclass of TwoDShape for rectangles. (p 229)
class Rectangle extends TwoDShape {
    Rectangle(double w, double h) {
        super(w, h);
    }

    Rectangle(double w) {
        super(w, w);
    }

    boolean isSquare() {
        if (getWidth() == getHeight()) return true;
        return false;
    }

    // Override area() for Rectangle. (p 257)
    double area() {
        return getWidth() * getHeight();
    }
}

// Using super to overcome name hiding. (p 238)
class A {
    int i;
}

class B extends A {
    int i; // this i hides the i in A

    B(int a, int b) {
        super.i = a; // i in A -- Here, super i refers to the i in A
        i = b; // i in B
    }

    void show() {
        System.out.println("i in superclass: " + super.i);
        System.out.println("i in subclass: " + i);
    }

}

// Demonstrate when constructors are executed.
// Create a super class.
class A2 {
    A2() {
        System.out.println("Constructing A2.");
    }
}

class B2 extends A2 {
    B2() {
        System.out.println("Constructing B2.");
    }
}

class C2 extends B2 {
    C2() {
        System.out.println("Constructing C2.");
    }
}

class X {
    int a;

    X(int i) {
        a = i;
    }
}

class Y extends X {
    int b;

    Y(int i) {
        super(i);
    }

    Y(int i, int j) {
        super(j);
        b = i;
    }
}

// Method overriding. (p 250)
class A3 {
    int i, j;
    A3(int a, int b) {
        i = a;
        j = b;
    }

    // display i and j
    void show() {
        System.out.println("i and j: " + i + " " + j);
    }
}

class B3 extends A3 {
    int k;
    B3(int a, int b, int c) {
        super(a, b);
        k = c;
    }

    // display k - this overrides show() in A3
    void show() {
        super.show(); // Use super to call the version of show() defined in A3
        System.out.println("k: " + k);
    }

    // overload show()
    // Because signatures differ, this show() simply overloads show() (p 252)
    void show(String msg) {
        System.out.println(msg + k);
    }
}

// Demonstrate dynamic method dispatch. (p 253)
class Sup {
    void who() {
        System.out.println("who() is Sup");
    }
}

class Sub1 extends Sup {
    void who() {
        System.out.println("who() is Sub1");
    }
}

class Sub2 extends Sup {
    void who() {
        System.out.println("who() is Sub2");
    }
}

class ErrorMsg {
    // Declared final constants
    final int OUTERR = 0;
    final int INERR = 1;
    final int DISKERR = 2;
    final int INDEXERR = 3;

    String msgs[] = {
        "Output Error",
        "Input Error",
        "Disk Full",
        "Index Out-Of-Bounds"
    };

    String getErrorMsg(int i) {
        if (i>=0 & i<msgs.length)
            return msgs[i];
        else
            return "Invalid Error Code";
    }
}

class Example {
    // Inheritance Basics (p 227)
    static void shapes() {
        Triangle t1 = new Triangle();
        Triangle t2 = new Triangle("outlined", 8.0, 12.0);
        Triangle t3 = new Triangle(4.0);

        t1 = t2;

        System.out.println("Info for t1: ");
        t1.showStyle();
        t1.showDim();
        System.out.println("Area is " + t1.area());

        System.out.println();

        System.out.println("Info for t2: ");
        t2.showStyle();
        t2.showDim();
        System.out.println("Area is " + t2.area());

        System.out.println();

        System.out.println("Info for t3: ");
        t3.showStyle();
        t3.showDim();
        System.out.println("Area is " + t3.area());

        System.out.println();

        // Info for t1:
        // Triangle is outlined
        // Width and height are 8.0 and 12.0
        // Area is 48.0

        // Info for t2:
        // Triangle is outlined
        // Width and height are 8.0 and 12.0
        // Area is 48.0

        // Info for t3:
        // Triangle is filled
        // Width and height are 4.0 and 4.0
        // Area is 8.0
    }

    static void rectangleTest() {
        Rectangle r1 = new Rectangle(4.0, 4.0);
        Rectangle r2 = new Rectangle(8.0, 12.0);

        System.out.println("Info for r1: ");
        r1.showDim();
        System.out.println("Is " + (r1.isSquare() ? "" : " not") + "a square.");
        System.out.println("Area is " + r1.area());

        System.out.println();

        System.out.println("Info for r2: ");
        r2.showDim();
        System.out.println("Is " + (r2.isSquare() ? "" : " not") + "a square.");
        System.out.println("Area is " + r2.area());

        // Info for r1:
        // Width and height are 4.0 and 4.0
        // Is a square.
        // Area is 16.0

        // Info for r2:
        // Width and height are 8.0 and 12.0
        // Is  nota square.
        // Area is 96.0
    }

    static void useSuper() {
        B subOb = new B(1, 2);
        subOb.show();
        // i in superclass: 1
        // i in subclass: 2
    }

    static void shapes6() {
        ColorTriangle t1 = new ColorTriangle("Blue", "outlined", 8.0, 12.0);
        ColorTriangle t2 = new ColorTriangle("Red", "filled", 2.0, 2.0);

        System.out.println("Info for t1: ");
        t1.showStyle();
        t1.showDim();
        t1.showColor();
        System.out.println("Area is " + t1.area());

        System.out.println();

        System.out.println("Info for t2: ");
        t2.showStyle();
        t2.showDim();
        t2.showColor();
        System.out.println("Area is " + t2.area());
    }

    static void orderOfConstruction() {
        C2 c2 = new C2();
        // Constructing A2.
        // Constructing B2.
        // Constructing C2.
    }

    static void incompatibleRef() {
        X x = new X(10);
        X x2;
        Y y = new Y(5);
        x2 = x; // OK, both of same type
    	/* error: incompatible types: Y cannot be converted to X
    	x2 = y; // Error, not of same type */
    }

    static void supSubRef() {
        X x = new X(10);
        X x2;
        Y y = new Y(5, 6);

        x2 = x; // OK, both of same type
        System.out.println("x2.a: " + x2.a);

        x2 = y; // still Ok because Y is derived from X
        System.out.println("x2.a: " + x2.a);

        // X references know only about X members
        x2.a = 19; // OK
    	/* error: cannot find symbol
    	symbol:   variable b
		location: variable x2 of type X
    	x2.b = 27; // Error, X doesn't have a b member */
        // x2.a: 10
        // x2.a: 6
    }

    static void shapes7() {
        Triangle t1 = new Triangle("outlined", 8.0, 12.0);
        // make a copy of t1
        Triangle t2 = new Triangle(t1);

        System.out.println("Info for t1: ");
        t1.showStyle();
        t1.showDim();
        System.out.println("Area is " + t1.area());

        System.out.println();

        System.out.println("Info for t2: ");
        t2.showStyle();
        t2.showDim();
        System.out.println("Area is " + t2.area());
        // Info for t1:
        // Triangle is outlined
        // Width and height are 8.0 and 12.0
        // Area is 48.0

        // Info for t2:
        // Triangle is outlined
        // Width and height are 8.0 and 12.0
        // Area is 48.0
    }

    public static void override() {
        A3 a3 = new A3(12, 28);
        B3 b3 = new B3(1, 2, 3);
        a3.show();
        // i and j: 12 28
        b3.show();
        // i and j: 1 2
        // k: 3
        b3.show("Here is k: ");
        // Here is k: 3
    }

    public static void dynDispDemo() {
        Sup superOb = new Sup();
        Sub1 subOb1 = new Sub1();
        Sub2 subOb2 = new Sub2();

        // In each case, the version of who() to call is determined at run time
        // by the type of object being referred to.
        Sup supRef;
        supRef = superOb;
        supRef.who();
        // who() is Sup

        supRef = subOb1;
        supRef.who();
        // who() is Sub1

        supRef = subOb2;
        supRef.who();
        // who() is Sub2
    }

    public static void dynShapes() {
        TwoDShape shapes[] = new TwoDShape[4];
        shapes[0] = new Triangle("outlined", 8.0, 12.0);
        shapes[1] = new Rectangle(10);
        shapes[2] = new Rectangle(10, 4);
        shapes[3] = new Triangle(7.0);
        // shapes[4] = new TwoDShape(10, 20, "generic");
        for (int i=0; i<shapes.length; i++) {
            System.out.println("object is "+shapes[i].getName());
            System.out.println("Area is "+shapes[i].area());
            System.out.println();
        }
        // object is none
        // Area is 48.0

        // object is none
        // Area is 100.0

        // object is none
        // Area is 40.0

        // object is none
        // Area is 24.5

        // object is generic
        // area() must be overriden
        // Area is 0.0
    }

    public static void finalD() {
        ErrorMsg err = new ErrorMsg();
        System.out.println(err.getErrorMsg(err.OUTERR));
        System.out.println(err.getErrorMsg(err.DISKERR));
        // Output Error
        // Disk Full
    }

    public static void main(String[] args) {
        shapes();
        rectangleTest();
        useSuper();
        shapes6();
        shapes7();
        orderOfConstruction();
        incompatibleRef();
        supSubRef();
        override();
        dynDispDemo();
        dynShapes();
        finalD();
    }
}

final class FinalA {
    // ...
}

/*
// error: cannot inherit from final FinalA
class Broken extends FinalA {
    // ...
} */