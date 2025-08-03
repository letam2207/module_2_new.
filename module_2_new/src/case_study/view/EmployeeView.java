package case_study.view;

import case_study.entity.Employee;

import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Employee addEmployee() {
        String id = inputWithPattern(
                "Nhập ID (Định dạng 'NV-XXXX' X là số 0-9): ",
                "^NV-\\d{4}$",
                "Sai định dạng, nhập lại!");

        String name = inputWithPattern(
                "Nhập tên nhân viên : ",
                "^[\\p{Lu}][\\p{Ll}]+(\\s[\\p{Lu}][\\p{Ll}]+)+$",
                "Sai định dạng, nhập lại!");

        String numberPhone = inputWithPattern(
                "Nhập số điện thoại của nhân viên : ",
                "^(0)\\d{9}$",
                "Sai định dạng, nhập lại!");

        String position = chooseOption(
                "Chọn chức vụ của nhân viên:",
                new String[]{
                        "Nhân viên thu ngân",
                        "Nhân viên phục vụ",
                        "Nhân viên pha chế",
                        "Giám sát"
                });

        String employeeType = chooseOption(
                "Chọn loại nhân viên:",
                new String[]{
                        "Nhân viên Full Time",
                        "Nhân viên Pass Time"
                });

        return new Employee(id, name, numberPhone, position, employeeType);
    }
    public static Employee updateEmployee(Employee employee) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Cập nhật thông tin nhân viên =====");
        System.out.println("➤ Thông tin hiện tại:");
        System.out.printf("%-10s | %-20s | %-12s | %-20s | %-15s\n",
                "Mã", "Tên", "SĐT", "Chức vụ", "Loại NV");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-12s | %-20s | %-15s\n",
                employee.getId(),
                employee.getName(),
                employee.getPhoneNumber(),
                employee.getPosition(),
                employee.getEmployeeType());


        String name;
        while (true) {
            System.out.printf("Nhập tên nhân viên [%s]: ", employee.getName());
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                name = employee.getName();
                break;
            }
            if (input.matches("^[\\p{Lu}][\\p{Ll}]+(\\s[\\p{Lu}][\\p{Ll}]+)+$")) {
                name = input;
                break;
            } else {
                System.out.println("❌ Sai định dạng tên. Viết hoa chữ cái đầu mỗi từ (VD: Nguyễn Văn B)");
            }
        }

        String numberPhone;
        while (true) {
            System.out.printf("Nhập số điện thoại nhân viên [%s]: ", employee.getPhoneNumber());
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                numberPhone = employee.getPhoneNumber();
                break;
            }
            if (input.matches("^(0)\\d{9}$")) {
                numberPhone = input;
                break;
            } else {
                System.out.println("❌ Sai định dạng SĐT. VD: 0901234567");
            }
        }

        String position = employee.getPosition();
        System.out.printf("Chức vụ hiện tại [%s]. Bạn có muốn thay đổi không? (Y/N): ", position);
        String changePosition = scanner.nextLine().trim();
        if (changePosition.equalsIgnoreCase("Y")) {
            String choice = chooseOption(
                    "Chọn chức vụ mới:",
                    new String[]{
                            "Nhân viên thu ngân",
                            "Nhân viên phục vụ",
                            "Nhân viên pha chế",
                            "Giám sát"
                    });
            position = choice;
        }

        String employeeType = employee.getEmployeeType();
        System.out.printf("Loại nhân viên hiện tại [%s]. Bạn có muốn thay đổi không? (Y/N): ", employeeType);
        String changeType = scanner.nextLine().trim();
        if (changeType.equalsIgnoreCase("Y")) {
            String choice = chooseOption(
                    "Chọn loại nhân viên mới:",
                    new String[]{
                            "Nhân viên Full Time",
                            "Nhân viên Pass Time"
                    });
            employeeType = choice;
        }

        return new Employee(employee.getId(), name, numberPhone, position, employeeType);
    }

    static String inputWithPattern(String prompt, String regex, String errorMsg) {
        Pattern pattern = Pattern.compile(regex);
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (pattern.matcher(input).matches()) return input;
            System.out.println(errorMsg);
        }
    }

    static String chooseOption(String title, String[] options) {
        System.out.println(title);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d. %s\n", i + 1, options[i]);
        }
        while (true) {
            System.out.print("Nhập lựa chọn : ");
            String choice = scanner.nextLine();
            try {
                int index = Integer.parseInt(choice);
                if (index >= 1 && index <= options.length) {
                    return options[index - 1];
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
        }
    }

    public static String inputDeleteId() {
        System.out.print("Nhập ID nhân viên cần xóa: ");
        return scanner.nextLine();
    }

    public static String inputSearchName() {
        System.out.print("Nhập tên nhân viên cần tìm: ");
        return scanner.nextLine();
    }

    public static String inputUpdateId() {
        System.out.print("Nhập ID nhân viên cần cập nhật: ");
        return scanner.nextLine();
    }
}
