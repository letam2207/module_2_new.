package ss3_method.bai_tap;

import java.util.Scanner;

public class SmallestValueInArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }
        System.out.println("mảng vừa nhập là :");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + ", ");
        }
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("\nphần tử nhỏ nhất trong mảng là: "+min);
    }
}
