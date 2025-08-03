package case_study.controller;

import case_study.entity.*;
import case_study.service.*;
import case_study.view.OrderView;

import java.time.LocalDateTime;
import java.util.*;

public class OrderController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ICustomerService customerService = new CustomerService();
    private static final IEmployeeService employeeService = new EmployeeService();
    private static final IDrinkService drinkService = new DrinkService();
    private static final IOrderService orderService = new OrderService();

    public static void orderController() {
        boolean check = true;
        do {
            try {
                System.out.println("""
                        ╔══════════════════════════════════════╗
                        ║       ▸ CHỨC NĂNG QUẢN LÝ ORDER ◂     ║
                        ╠══════════════════════════════════════╣
                        ║ 1. Tạo đơn hàng mới                  ║
                        ║ 2. Lịch sử đơn hàng đã mua           ║
                        ║ 3. Trở về menu chính                 ║
                        ╚══════════════════════════════════════╝
                        """);
                System.out.print("➤ Vui lòng chọn chức năng (1-3): ");
                int choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1 -> createOrder();
                    case 2 -> showOrderHistory();
                    case 3 -> {
                        System.out.println("⇨ Trở về menu chính...");
                        check = false;
                    }
                    default -> System.out.println("⚠ Lựa chọn không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Nhập sai định dạng! Vui lòng nhập số.");
            }
        } while (check);
    }

    private static void createOrder() {
        System.out.println("➤ TẠO ĐƠN HÀNG MỚI");

        String customerId = OrderView.inputCustomerId();
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            System.out.println("❌ Không tìm thấy khách hàng.");
            return;
        }

        String employeeId = OrderView.inputEmployeeId();
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) {
            System.out.println("❌ Không tìm thấy nhân viên.");
            return;
        }

        List<Drink> drinks = drinkService.findAll();
        drinkService.displayAllGroupedByType();

        List<OrderItem> items = OrderView.inputOrderItems(drinks);
        if (items.isEmpty()) {
            System.out.println("⚠ Đơn hàng trống, huỷ thao tác.");
            return;
        }

        Order order = new Order();
        order.setOrderId("OD-" + System.currentTimeMillis());
        order.setCustomer(customer);
        order.setEmployee(employee);
        order.setItems(items);
        order.setDateTime(LocalDateTime.now());

        OrderView.printInvoice(order);

        if (OrderView.confirmPayment()) {
            orderService.add(order);
            drinkService.updateQuantitiesAfterOrder(items);
            System.out.println("✅ Đơn hàng đã được lưu.");
        } else {
            System.out.println("❎ Huỷ thanh toán.");
        }
    }

    private static void showOrderHistory() {
        System.out.println("➤ LỊCH SỬ ĐƠN HÀNG ĐÃ MUA");
        List<Order> orders = orderService.findAll();
        if (orders.isEmpty()) {
            System.out.println("⚠ Chưa có đơn hàng nào.");
            return;
        }
        for (Order order : orders) {
            OrderView.printInvoice(order);
        }
    }


}
