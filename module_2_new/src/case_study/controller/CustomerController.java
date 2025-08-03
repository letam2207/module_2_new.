package case_study.controller;

import case_study.entity.Customer;
import case_study.service.CustomerService;
import case_study.service.ICustomerService;
import case_study.view.CustomerView;

import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ICustomerService CUSTOMER_SERVICE = new CustomerService();

    public static void customerController() {
        boolean check = true;
        do {
            try {
                System.out.println("╔════════════════════════════════════════════════╗");
                System.out.println("║         ▸ CHỨC NĂNG QUẢN LÝ KHÁCH HÀNG ◂       ║");
                System.out.println("╠════════════════════════════════════════════════╣");
                System.out.println("║ 1. Thêm mới khách hàng                         ║");
                System.out.println("║ 2. Chỉnh sửa thông tin khách hàng              ║");
                System.out.println("║ 3. Xóa khách hàng                              ║");
                System.out.println("║ 4. Hiển thị danh sách khách hàng               ║");
                System.out.println("║ 5. Tìm kiếm khách hàng theo tên                ║");
                System.out.println("║ 6. Trở về menu chính                           ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.print("➤ Vui lòng chọn chức năng (1-6): ");
                int choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1 -> add();
                    case 2 -> update();
                    case 3 -> delete();
                    case 4 -> displayCustomer(CUSTOMER_SERVICE.findAll());
                    case 5 -> search();
                    case 6 -> {
                        System.out.println("⇨ Trở về menu chính...");
                        check = false;
                    }
                    default -> System.out.println("⚠ Lựa chọn không hợp lệ. Vui lòng thử lại!");
                }

            } catch (NumberFormatException e) {
                System.out.println("⚠ Nhập sai định dạng! Vui lòng nhập số từ 1 đến 6.");
            }
        } while (check);
    }

    public static void displayCustomer(List<Customer> customers) {
        System.out.println("════════════ DANH SÁCH KHÁCH HÀNG ════════════");
        if (customers == null || customers.isEmpty()) {
            System.out.println("⚠ Danh sách khách hàng trống.");
        } else {
            System.out.println(Customer.getTableDivider());
            System.out.println(Customer.getTableHeader());
            System.out.println(Customer.getTableDivider());
            for (Customer c : customers) {
                System.out.println(c);
            }
            System.out.println(Customer.getTableDivider());
        }
    }

    public static void add() {
        System.out.println("➤ BẮT ĐẦU THÊM KHÁCH HÀNG MỚI");
        Customer customer = CustomerView.addCustomer();
        String newId = customer.getId();
        Customer byId = CUSTOMER_SERVICE.findById(newId);

        if (byId != null) {
            System.out.println("⚠ ID khách hàng đã tồn tại. Vui lòng nhập ID khác.");
        } else {
            CUSTOMER_SERVICE.add(customer);
            System.out.println("✅ Thêm khách hàng thành công.");
        }
    }

    public static void update() {
        System.out.println("➤ CẬP NHẬT THÔNG TIN KHÁCH HÀNG");
        String idUpdate = CustomerView.inputUpdateId();

        Customer oldCustomer = CUSTOMER_SERVICE.findById(idUpdate);
        if (oldCustomer == null) {
            System.out.println("⚠ Không tìm thấy khách hàng có ID: " + idUpdate);
        } else {
            Customer customer = CustomerView.updateCustomer(oldCustomer);
            CUSTOMER_SERVICE.updateById(idUpdate, customer);
            System.out.println("✅ Cập nhật thông tin khách hàng thành công.");
        }
    }

    public static void search() {
        System.out.println("➤ TÌM KIẾM KHÁCH HÀNG THEO TÊN");
        String nameSearch = CustomerView.inputSearchName();
        List<Customer> result = CUSTOMER_SERVICE.findByName(nameSearch);
        displayCustomer(result);
    }

    public static void delete() {
        System.out.println("➤ XOÁ KHÁCH HÀNG");
        String deleteId = CustomerView.inputDeleteId();
        Customer temp = CUSTOMER_SERVICE.findById(deleteId);
        if (temp == null) {
            System.out.println("⚠ Không tìm thấy khách hàng có ID: " + deleteId);
        } else {
            System.out.println("➤ Thông tin khách hàng:");
            System.out.println(temp);
            System.out.print("❓Bạn có chắc chắn muốn xoá khách hàng này không? (Y để xác nhận): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                CUSTOMER_SERVICE.delete(deleteId);
                System.out.println("✅ Xoá khách hàng thành công.");
            } else {
                System.out.println("❎ Đã huỷ thao tác xoá.");
            }
        }
    }
}
