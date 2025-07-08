package ss3_method.bai_tap;

import java.util.Scanner;

public class CharacterFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "code gym da nang";
        System.out.println("Chuỗi ban đầu là : " + str);
        System.out.println("Nhập kí tự kiểm tra: ");
        char targetChar = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (targetChar == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("Ký tự '" + targetChar + "' xuất hiện " + count + " lần trong chuỗi.");
    }
}
