package ss6_inheritance.bai_tap.circle_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle =new Circle(5,"red");
        Cylinder cylinder = new Cylinder(6,5,"red");
        System.out.println(circle.toString());
        System.out.println(cylinder.toString());
    }
}
