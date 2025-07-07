package ss2_array_loop.bai_tap;

import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {2, 43, 5, 6, 23, 4};
        System.out.print("Mảng ban đầu: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("\nNhập số muốn thêm: ");
        int num = scanner.nextInt();
        System.out.println("Nhập vị trí muốn thêm: ");
        int index = scanner.nextInt();
        if (index < 0 || index > array.length) {
            System.out.println("Vị trí không hợp lệ!");
            return;
        }
        int[] array1 = new int[array.length + 1];
        for (int i = 0; i < index; i++) {
            array1[i] = array[i];
        }
        array1[index] = num;
        for (int i = index; i < array.length; i++) {
            array1[i + 1] = array[i];
        }
        System.out.print("Mảng sau khi thêm: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + ", ");
        }
    }
}
