package ss7_abstract_interface.bai_tap.resizeable;

public class Circle extends Shape implements Colorable{
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()+
                " Area= "+getArea()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public String howToColor(String color) {

        return "This Circle is " + color;
    }
}
