package ss2_array_loop.bai_tap;

import java.util.Scanner;

public class ShowTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chose = 0;
        while (chose != 4) {
            System.out.println("Menu:");
            System.out.println("1.Print the rectangle");
            System.out.println("2.Print the square triangle ");
            System.out.println("3.Print isosceles triangle");
            System.out.println("4.exit");
            chose = Integer.parseInt(scanner.nextLine());
            switch (chose) {
                case 1:
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 5; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case 2:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (i == j || j < (i + 1)) {
                                System.out.print("*");
                            }
                        }
                        System.out.print("\n");
                    }
                    break;
                case 3:
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (j <= (5 - i - 1)) {
                                System.out.print("*");
                            }
                        }
                        System.out.print("\n");
                    }
                    break;
                case 4:
                    System.exit(4);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
