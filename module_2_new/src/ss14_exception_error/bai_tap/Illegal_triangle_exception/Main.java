package ss14_exception_error.bai_tap.Illegal_triangle_exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;
        boolean check = true;
        while (check) {
            try {
                System.out.println("nhập cạnh thứ nhất: ");
                a = Integer.parseInt(scanner.nextLine());
                System.out.println("nhập cạnh thứ hai: ");
                b = Integer.parseInt(scanner.nextLine());
                System.out.println("nhập cạnh thứ ba: ");
                c = Integer.parseInt(scanner.nextLine());
                checkTriangle(a, b, c);
                System.out.println("Đây là 3 cạnh của tam giác");
                check = false;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
                check = false;
            } catch (Exception e) {
                System.out.println("Nhập sai kiểu giữ liệu");
                System.out.println("Nhập lại!");

            }
        }

    }

    private static void checkTriangle(int a, int b, int c) throws IllegalTriangleException {
        if (a < 1 || b < 1 || c < 1 || a + b <= c || a + c <= b || b + c <= a) {
            throw new IllegalTriangleException("đây không phải 3 cạnh tam giác");
        }
    }
}
