package ss7_abstract_interface.bai_tap.colorable;


public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.getArea());

        circle = new Circle(3.5);
        System.out.println(circle.getArea());

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
        circle.resize(50);
        System.out.println(circle);
    }
}