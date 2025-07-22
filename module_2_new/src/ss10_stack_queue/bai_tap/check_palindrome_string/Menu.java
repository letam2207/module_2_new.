package ss10_stack_queue.bai_tap.check_palindrome_string;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi muốn kiểm tra: ");
        String input = scanner.nextLine();

        boolean result = PalindromeChecker.isPalindrome(input);
        if (result) {
            System.out.println("Đây là chuỗi Palindrome!");
        } else {
            System.out.println("Đây không phải chuỗi Palindrome!");
        }
    }
}
