// A simple class hierarchy.

// Use accessor methods to set and get private members.

// A class for two-dimensional objects.
class TwoDShape {
    private double width; // these are
    private double height; // now private

    // A default constructor. (p 235)
    TwoDShape() {
        width = height = 0.0;
    }

    // Parameterized constructor. (p 234)
    TwoDShape(double w, double h) {
        width = w;
        height = h;
    }

    // Constructor with equal width and height. (p 236)
    TwoDShape(double x) {
        width = height = x;
    }

    // Accessor methods for width and height.
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

    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

// A subclass of TwoDShape for rectangles. (p 229)
class Rectangle extends TwoDShape {
    Rectangle(double w, double h) {
        super(w, h);
    }

    boolean isSquare() {
        if (getWidth() == getHeight()) return true;
        return false;
    }

    double area() {
        return getWidth() * getHeight();
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

    public static void main(String[] args) {
        shapes();
        rectangleTest();
    }
}