package ss3_method.bai_tap;

import java.util.Scanner;

public class ColumnSumCalculator {
    public static int[][] inputArray(int row, int column) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Nhập giá trị tại [" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextInt();
            }
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số hàng: ");
        int row = scanner.nextInt();
        System.out.print("Nhập số cột: ");
        int column = scanner.nextInt();
        int[][] myArray = inputArray(row, column);
        System.out.println("Mảng vừa nhập là:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(myArray[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.print("Nhập chỉ số cột muốn tính tổng: ");
        int columnIndex = scanner.nextInt();
        if (columnIndex < 0 || columnIndex >= column) {
            System.out.println("Chỉ số cột không hợp lệ.");
        } else {
            int sum = 0;
            for (int i = 0; i < row; i++) {
                sum += myArray[i][columnIndex];
            }
            System.out.println("Tổng các số ở cột " + columnIndex + " là: " + sum);
        }
        scanner.close();
    }
}
