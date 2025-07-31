package case_study.controller;


import java.util.Scanner;

public class ControllerMenu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void controllerMenu() {
        do {
            try {
                System.out.println("""
                        -------ỨNG DỤNG QUẢN LÝ BÁN HÀNG CAFE--------
                        1. Quản lý khách hàng
                        2. Quản lý nhân viên
                        3. Quản lý món nước
                        4. Quản lý kho
                        5. Mua hàng
                        6. Thoát
                        """);
                System.out.print("Chọn chức năng: ");
                int choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        CustomerController.customerController();
                        break;

                    case 2:
                        EmployeeController.employeeController();
                        break;

                    case 3:
                        DrinkController.drinkController();
                        break;

                    case 4:
                        WarehouseController.customerController();
                        break;

                    case 5:
                        OrderController.orderController();
                        break;

                    case 6:
                        System.out.println(" Đã thoát chương trình.");
                        System.exit(0);

                    default:
                        System.out.println(" Lựa chọn không hợp lệ. Vui lòng thử lại.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println(" Nhập sai định dạng! Vui lòng nhập số.");
            }
        } while (true);
    }
}
