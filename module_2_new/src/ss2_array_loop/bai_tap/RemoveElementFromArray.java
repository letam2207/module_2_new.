package ss2_array_loop.bai_tap;

import java.util.Scanner;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 3, 4, 2, 6, 12, 9, 45
        };
        System.out.print("Mảng ban đầu: ");
        for (int i : array) System.out.print(i + ", ");
        System.out.println();
        int num;
        boolean found = false;
        while (true) {
            System.out.print("Nhập phần tử muốn xóa: ");
            num = scanner.nextInt();
            for (int i : array) {
                if (i == num) {
                    found = true;
                    break;
                }
            }
            if (found) break;
            System.out.println("Không tìm thấy phần tử trong mảng. Nhập lại!");
        }
        int[] newArray = new int[array.length - 1];
        boolean deleted = false;
        int index = 0;
        for (int i : array) {
            if (i == num && !deleted) {
                deleted = true;
                continue;
            }
            newArray[index++] = i;
        }
        System.out.print("Mảng sau khi xóa: ");
        for (int i : newArray) System.out.print(i + ", ");
    }
}
