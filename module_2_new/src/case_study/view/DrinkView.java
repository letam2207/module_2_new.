package case_study.view;

import case_study.entity.Drink;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DrinkView {
    private static final Scanner scanner = new Scanner(System.in);

    public static Drink addDrink() {
        System.out.println("----- THÊM MỚI MÓN NƯỚC -----");

        String id;
        Pattern idPattern = Pattern.compile("^D-\\d{4}$");
        while (true) {
            System.out.print("Nhập mã đồ uống (VD: D-0001): ");
            id = scanner.nextLine();
            if (idPattern.matcher(id).matches()) break;
            System.out.println("Sai định dạng. Mã phải có dạng D-XXXX với X là số.");
        }

        System.out.print("Nhập tên đồ uống: ");
        String name = scanner.nextLine();

        String type = chooseOption(
                "Chọn loại đồ uống:",
                new String[]{"1. Cà phê", "2. Trà", "3. Sinh tố", "4. Nước ngọt"}
        );
        switch (type) {
            case "1. Cà phê":
                type = "Cà phê";
                break;
            case "2. Trà":
                type = "Trà";
                break;
            case "3. Sinh tố":
                type = "Sinh tố";
                break;
            case "4. Nước ngọt":
                type = "Nước ngọt";
                break;
        }

        double price;
        while (true) {
            System.out.print("Nhập giá đồ uống: ");
            try {
                price = Double.parseDouble(scanner.nextLine());
                if (price > 0) break;
                System.out.println("Giá phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số thực hợp lệ.");
            }
        }

        int quantity;
        while (true) {
            System.out.print("Nhập số lượng: ");
            try {
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity >= 0) break;
                System.out.println("Số lượng không được âm.");
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }

        return new Drink(id, name, type, price, quantity);
    }

    public static String inputUpdateId() {
        System.out.println("----- CẬP NHẬT ĐỒ UỐNG -----");
        System.out.print("Nhập mã đồ uống cần cập nhật: ");
        return scanner.nextLine();
    }

    public static Drink updateDrink(Drink oldDrink) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== Cập nhật thông tin món nước =====");
        System.out.println("➤ Thông tin hiện tại:");
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-8s\n",
                "Mã", "Tên", "Loại", "Giá", "Số lượng");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-10s | %-20s | %-10s | %-10.2f | %-8d\n",
                oldDrink.getId(), oldDrink.getName(), oldDrink.getType(),
                oldDrink.getPrice(), oldDrink.getQuantity());


        System.out.printf("Nhập tên mới [%s]: ", oldDrink.getName());
        String nameInput = scanner.nextLine().trim();
        String name = nameInput.isEmpty() ? oldDrink.getName() : nameInput;

        String type = oldDrink.getType();
        System.out.printf("Loại hiện tại [%s]. Bạn có muốn thay đổi không? (Y/N): ", type);
        String changeType = scanner.nextLine().trim();
        if (changeType.equalsIgnoreCase("Y")) {
            String choice = chooseOption(
                    "Chọn loại đồ uống:",
                    new String[]{"1. Cà phê", "2. Trà", "3. Sinh tố", "4. Nước ngọt"}
            );
            switch (choice) {
                case "1. Cà phê":
                    type = "Cà phê"; break;
                case "2. Trà":
                    type = "Trà"; break;
                case "3. Sinh tố":
                    type = "Sinh tố"; break;
                case "4. Nước ngọt":
                    type = "Nước ngọt"; break;
            }
        }

        double price;
        while (true) {
            System.out.printf("Nhập giá mới [%s]: ", oldDrink.getPrice());
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                price = oldDrink.getPrice();
                break;
            }
            try {
                price = Double.parseDouble(input);
                if (price > 0) break;
                System.out.println("❌ Giá phải lớn hơn 0.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số thực hợp lệ.");
            }
        }


        int quantity;
        while (true) {
            System.out.printf("Nhập số lượng mới [%s]: ", oldDrink.getQuantity());
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                quantity = oldDrink.getQuantity();
                break;
            }
            try {
                quantity = Integer.parseInt(input);
                if (quantity >= 0) break;
                System.out.println("❌ Số lượng không được âm.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Vui lòng nhập số nguyên hợp lệ.");
            }
        }

        return new Drink(oldDrink.getId(), name, type, price, quantity);
    }


    public static String inputDeleteId() {
        System.out.println("----- XÓA MÓN NƯỚC -----");
        System.out.print("Nhập mã đồ uống cần xóa: ");
        return scanner.nextLine();
    }

    public static String inputSearchName() {
        System.out.println("----- TÌM KIẾM ĐỒ UỐNG -----");
        System.out.print("Nhập tên món nước muốn tìm: ");
        return scanner.nextLine();
    }

    public static void displayDrinkList(List<Drink> drinks) {
        System.out.println("----- DANH SÁCH MÓN NƯỚC -----");
        if (drinks.isEmpty()) {
            System.out.println("Không có món nước nào.");
        } else {
            for (Drink drink : drinks) {
                System.out.println(drink);
            }
        }
    }

    public static String chooseOption(String prompt, String[] options) {
        while (true) {
            System.out.println(prompt);
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Lựa chọn của bạn: ");
            String input = scanner.nextLine().trim();
            for (String option : options) {
                if (option.startsWith(input + ".")) {
                    return option;
                }
            }
            System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
        }
    }
}
