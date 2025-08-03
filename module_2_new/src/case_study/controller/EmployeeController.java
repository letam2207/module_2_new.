package case_study.controller;

import case_study.entity.Employee;
import case_study.service.EmployeeService;
import case_study.service.IEmployeeService;
import case_study.view.EmployeeView;

import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IEmployeeService EMPLOYEE_SERVICE = new EmployeeService();

    public static void employeeController() {
        boolean check = true;
        do {
            try {
                System.out.println("╔════════════════════════════════════════════════╗");
                System.out.println("║         ▸ CHỨC NĂNG QUẢN LÝ NHÂN VIÊN ◂        ║");
                System.out.println("╠════════════════════════════════════════════════╣");
                System.out.println("║ 1. Thêm mới nhân viên                          ║");
                System.out.println("║ 2. Chỉnh sửa thông tin nhân viên               ║");
                System.out.println("║ 3. Xóa nhân viên                               ║");
                System.out.println("║ 4. Hiển thị danh sách nhân viên                ║");
                System.out.println("║ 5. Tìm kiếm nhân viên theo tên                 ║");
                System.out.println("║ 6. Trở về menu chính                           ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.print("➤ Vui lòng chọn chức năng (1-6): ");
                int choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1 -> add();
                    case 2 -> update();
                    case 3 -> delete();
                    case 4 -> displayEmployee(EMPLOYEE_SERVICE.findAll());
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

    public static void displayEmployee(List<Employee> employees) {
        System.out.println("════════════ DANH SÁCH NHÂN VIÊN ════════════");
        if (employees == null || employees.isEmpty()) {
            System.out.println("⚠ Danh sách nhân viên trống.");
        } else {
            System.out.println(Employee.getTableDivider());
            System.out.println(Employee.getTableHeader());
            System.out.println(Employee.getTableDivider());
            for (Employee e : employees) {
                System.out.println(e);
            }
            System.out.println(Employee.getTableDivider());
        }
    }



    public static void add() {
        System.out.println("➤ BẮT ĐẦU THÊM NHÂN VIÊN MỚI");
        Employee employee = EmployeeView.addEmployee();
        String newId = employee.getId();
        Employee byId = EMPLOYEE_SERVICE.findById(newId);

        if (byId != null) {
            System.out.println("⚠ ID nhân viên đã tồn tại. Vui lòng nhập ID khác.");
        } else {
            EMPLOYEE_SERVICE.add(employee);
            System.out.println("✅ Thêm nhân viên thành công.");
        }
    }

    public static void update() {
        System.out.println("➤ CẬP NHẬT THÔNG TIN NHÂN VIÊN");
        String idUpdate = EmployeeView.inputUpdateId();

        Employee oldEmployee = EMPLOYEE_SERVICE.findById(idUpdate);
        if (oldEmployee == null) {
            System.out.println("⚠ Không tìm thấy nhân viên có ID: " + idUpdate);
        } else {
            Employee employee = EmployeeView.updateEmployee(oldEmployee);
            EMPLOYEE_SERVICE.updateById(idUpdate, employee);
            System.out.println("✅ Cập nhật thông tin nhân viên thành công.");
        }
    }

    public static void search() {
        System.out.println("➤ TÌM KIẾM NHÂN VIÊN THEO TÊN");
        String nameSearch = EmployeeView.inputSearchName();
        List<Employee> result = EMPLOYEE_SERVICE.findByName(nameSearch);
        displayEmployee(result);
    }

    public static void delete() {
        System.out.println("➤ XOÁ NHÂN VIÊN");
        String deleteId = EmployeeView.inputDeleteId();
        Employee temp = EMPLOYEE_SERVICE.findById(deleteId);
        if (temp == null) {
            System.out.println("⚠ Không tìm thấy nhân viên có ID: " + deleteId);
        } else {
            System.out.println("➤ Thông tin nhân viên:");
            System.out.println(temp);
            System.out.print("❓Bạn có chắc chắn muốn xoá nhân viên này không? (Y để xác nhận): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                EMPLOYEE_SERVICE.delete(deleteId);
                System.out.println("✅ Xoá nhân viên thành công.");
            } else {
                System.out.println("❎ Đã huỷ thao tác xoá.");
            }
        }
    }
}
