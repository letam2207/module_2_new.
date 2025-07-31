package ss17_string_regex.bai_tap.validate_class_name;

import java.util.Scanner;

public class ValidateClassName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String className;

        do {
            System.out.print("Nhập tên lớp muốn kiểm tra: ");
            className = scanner.nextLine();

            if (isValidClassName(className)) {
                System.out.println(" Nhập sai định dạng! Tên lớp phải có dạng: C/A/P + 4 chữ số + G/H/I/K");
            }
        } while (isValidClassName(className));

        System.out.println(" Tên lớp hợp lệ: " + className);
    }

    public static boolean isValidClassName(String className) {
        String classNameRegex = "^[CAP]\\d{4}[GHIK]$";
        return !className.matches(classNameRegex);
    }
}
