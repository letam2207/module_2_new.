package ss10_stack_queue.bai_tap.binary_to_decimal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số muốn đổi sang nhị phân: ");
        int number = scanner.nextInt();

        String binary = BinaryConverter.convertToBinary(number);
        System.out.println("Kết quả hệ nhị phân: " + binary);
    }
}
