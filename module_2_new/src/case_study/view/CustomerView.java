package case_study.view;

import case_study.entity.Customer;

import java.util.Scanner;
import java.util.regex.Pattern;

import static case_study.view.EmployeeView.chooseOption;

public class CustomerView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Customer addCustomer() {
        System.out.println("----- THÊM MỚI KHÁCH HÀNG -----");

        String id;
        Pattern idPattern = Pattern.compile("^KH-\\d{4}$");
        while (true) {
            System.out.print("Nhập mã khách hàng (VD: KH-0001): ");
            id = scanner.nextLine();
            if (idPattern.matcher(id).matches()) break;
            System.out.println("Sai định dạng. Mã phải có dạng KH-XXXX với X là số.");
        }

        String name;
        Pattern namePattern = Pattern.compile("^([\\p{Lu}][\\p{Ll}]+)(\\s[\\p{Lu}][\\p{Ll}]+)+$");
        while (true) {
            System.out.print("Nhập họ và tên: ");
            name = scanner.nextLine();
            if (namePattern.matcher(name).matches()) break;
            System.out.println("Sai định dạng. Tên phải viết hoa chữ cái đầu mỗi từ (VD: Nguyễn Văn A).");
        }

        String phoneNumber;
        Pattern phonePattern = Pattern.compile("^0\\d{9}$");
        while (true) {
            System.out.print("Nhập số điện thoại (10 số, bắt đầu bằng 0): ");
            phoneNumber = scanner.nextLine();
            if (phonePattern.matcher(phoneNumber).matches()) break;
            System.out.println("Sai định dạng số điện thoại.");
        }

        String email;
        Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();
            if (emailPattern.matcher(email).matches()) break;
            System.out.println("Email không hợp lệ.");
        }

        String customerType = "";
        while (true) {
            System.out.println("Chọn loại khách hàng:");
            System.out.println("1. Thành viên");
            System.out.println("2. Vãng lai");
            System.out.println("3. VIP");
            System.out.print("Lựa chọn của bạn (1-3): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    customerType = "Thành viên";
                    break;
                case "2":
                    customerType = "Vãng lai";
                    break;
                case "3":
                    customerType = "VIP";
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập 1, 2 hoặc 3.");
                    continue;
            }
            break;
        }


        return new Customer(id,name,phoneNumber, email, customerType);
    }

    public static String inputUpdateId() {
        System.out.println("----- CẬP NHẬT KHÁCH HÀNG -----");
        System.out.print("Nhập mã khách hàng cần cập nhật: ");
        return scanner.nextLine();
    }

    public static Customer updateCustomer(Customer oldCustomer) {
        System.out.println("===== Cập nhật thông tin khách hàng =====");
        System.out.println("➤ Thông tin hiện tại:");
        System.out.printf("%-10s | %-20s | %-12s | %-25s | %-10s\n",
                "Mã", "Tên", "SĐT", "Email", "Loại");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-12s | %-25s | %-10s\n",
                oldCustomer.getId(),
                oldCustomer.getName(),
                oldCustomer.getPhoneNumber(),
                oldCustomer.getEmail(),
                oldCustomer.getCustomerType());

        Scanner scanner = new Scanner(System.in);

        String name;
        while (true) {
            System.out.printf("Nhập tên khách hàng [%s]: ", oldCustomer.getName());
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                name = oldCustomer.getName();
                break;
            }
            if (input.matches("^[\\p{Lu}][\\p{Ll}]+(\\s[\\p{Lu}][\\p{Ll}]+)+$")) {
                name = input;
                break;
            } else {
                System.out.println("❌ Sai định dạng tên. Viết hoa chữ cái đầu mỗi từ (VD: Nguyễn Văn A)");
            }
        }

        String phoneNumber;
        while (true) {
            System.out.printf("Nhập SĐT khách hàng [%s]: ", oldCustomer.getPhoneNumber());
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                phoneNumber = oldCustomer.getPhoneNumber();
                break;
            }
            if (input.matches("^(0)\\d{9}$")) {
                phoneNumber = input;
                break;
            } else {
                System.out.println("❌ Sai định dạng SĐT. VD: 0901234567");
            }
        }

        String email;
        while (true) {
            System.out.printf("Nhập email khách hàng [%s]: ", oldCustomer.getEmail());
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                email = oldCustomer.getEmail();
                break;
            }
            if (input.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
                email = input;
                break;
            } else {
                System.out.println("❌ Sai định dạng email. VD: abc@gmail.com");
            }
        }

        String customerType = oldCustomer.getCustomerType();
        System.out.printf("Loại khách hàng hiện tại [%s]. Bạn có muốn thay đổi không? (Y/N): ", customerType);
        String changeType = scanner.nextLine().trim();

        if (changeType.equalsIgnoreCase("Y")) {
            String choice = chooseOption(
                    "Chọn loại khách hàng mới:",
                    new String[]{
                            "1. Thành viên",
                            "2. Vãng lai",
                            "3. VIP"
                    });

            switch (choice) {
                case "1. Thành viên":
                    customerType = "Thành viên";
                    break;
                case "2. Vãng lai":
                    customerType = "Vãng lai";
                    break;
                case "3. VIP":
                    customerType = "VIP";
                    break;
            }
        }

        return new Customer(oldCustomer.getId(), name, phoneNumber, email, customerType);
    }



    public static String inputDeleteId() {
        System.out.println("----- XÓA KHÁCH HÀNG -----");
        System.out.print("Nhập mã khách hàng cần xóa: ");
        return scanner.nextLine();
    }

    public static String inputSearchName() {
        System.out.println("----- TÌM KIẾM KHÁCH HÀNG -----");
        System.out.print("Nhập tên khách hàng muốn tìm: ");
        return scanner.nextLine();
    }
}
