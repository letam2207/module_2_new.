package ss7_abstract_interface.bai_tap.resizeable;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(4.5, "indigo", false);
        System.out.println(circle);

        System.out.println(circle.howToColor("RED"));
    }
}