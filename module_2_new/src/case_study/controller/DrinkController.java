package case_study.controller;

import java.util.Scanner;

public class DrinkController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void drinkController() {
        boolean check = true;
        do {
            try {
                System.out.println("""
                        -------CHỨC NĂNG QUẢN LÝ MÓN NƯỚC--------
                        1. Thêm mới món nước
                        2. Chỉnh sửa thông tin món nước
                        3. Xóa món nước
                        4. Hiển thị danh sách món nước
                        5. Trở về menu chính
                        """);
                System.out.print("Chọn chức năng: ");
                int choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:
                        check = false;
                        break;

                    default:
                        System.out.println(" Lựa chọn không hợp lệ. Vui lòng thử lại.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println(" Nhập sai định dạng! Vui lòng nhập số.");
            }
        } while (check);
    }
}
