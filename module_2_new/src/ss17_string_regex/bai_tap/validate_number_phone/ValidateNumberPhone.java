package ss17_string_regex.bai_tap.validate_number_phone;

import java.util.Scanner;

public class ValidateNumberPhone {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberPhone;

        do {
            System.out.print("Nhập số điện thoại muốn kiểm tra: ");
            numberPhone = scanner.nextLine();

            if (isValidClassName(numberPhone)) {
                System.out.println(" Nhập sai định dạng! Số điện thoại phải có dạng: (xx)-(0xxxxxxxxx)");
            }
        } while (isValidClassName(numberPhone));

        System.out.println(" Số điện thoại hợp lệ: " + numberPhone);
    }

    public static boolean isValidClassName(String className) {
        String numberPhoneRegex = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";
        return !className.matches(numberPhoneRegex);
    }
}
