package ss7_abstract_interface.bai_tap.colorable;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square(4);
        System.out.println(square);
        square.resize(50);
        System.out.println(square);
    }
}
