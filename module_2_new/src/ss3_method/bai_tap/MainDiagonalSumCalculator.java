package ss3_method.bai_tap;

import java.util.Scanner;

import static ss3_method.bai_tap.ColumnSumCalculator.inputArray;

public class MainDiagonalSumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row, column;
        do {
            System.out.print("Nhập số hàng: ");
            row = scanner.nextInt();
            System.out.print("Nhập số cột: ");
            column = scanner.nextInt();

            if (row != column) {
                System.out.println("Nhập số hàng = số cột Vui lòng nhập lại!\n");
            }
        } while (row != column);

        int[][] array = inputArray(row, column);

        System.out.println("\n Mảng vừa nhập là:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += array[i][i];
        }
        System.out.println("Tổng đường chéo chính là: " + sum);

        scanner.close();
    }
}
