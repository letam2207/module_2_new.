package case_study.controller;

import java.util.Scanner;

public class WarehouseController {
    private static final Scanner scanner = new Scanner(System.in);

    public static void customerController() {
        boolean check = true;
        do {
            try {
                System.out.println("""
                        -------CHỨC NĂNG QUẢN LÝ KHO HÀNG--------
                        1. Thêm mới nguyên liệu
                        2. Chỉnh sửa nguyên liệu
                        3. Xóa nguyên liệu
                        4. Danh sách nguyên liệu tồn kho
                        5. Nhập hàng vào kho
                        6. Trở về menu chính
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

                        break;

                    case 6:
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
