package case_study.view;

import case_study.entity.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputCustomerId() {
        System.out.print("Nhập mã khách hàng: ");
        return scanner.nextLine().trim();
    }

    public static String inputEmployeeId() {
        System.out.print("Nhập mã nhân viên bán hàng: ");
        return scanner.nextLine().trim();
    }

    public static List<OrderItem> inputOrderItems(List<Drink> drinkList) {
        Scanner scanner = new Scanner(System.in);
        List<OrderItem> orderItems = new ArrayList<>();

        System.out.println("Nhập các món nước và số lượng (ví dụ: D-0001:2,D-0003:1):");
        String input = scanner.nextLine();
        String[] entries = input.split(",");

        for (String entry : entries) {
            String[] parts = entry.trim().split(":");

            if (parts.length != 2) {
                System.out.println("❌ Định dạng không hợp lệ: " + entry);
                continue;
            }

            String drinkId = parts[0].trim();
            String quantityStr = parts[1].trim();

            Drink drink = null;
            for (Drink d : drinkList) {
                if (d.getId().equalsIgnoreCase(drinkId)) {
                    drink = d;
                    break;
                }
            }

            if (drink == null) {
                System.out.println("❌ Không tìm thấy món nước với ID: " + drinkId);
                continue;
            }

            int quantity;
            try {
                quantity = Integer.parseInt(quantityStr);
                if (quantity <= 0 || quantity > drink.getQuantity()) {
                    System.out.println("❌ Số lượng không hợp lệ cho mã: " + drinkId);
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Số lượng không hợp lệ cho mã: " + drinkId);
                continue;
            }

            orderItems.add(new OrderItem(drink, quantity));
        }

        return orderItems;
    }


    public static boolean confirmPayment() {
        System.out.print("Xác nhận thanh toán (Y để xác nhận): ");
        return scanner.nextLine().equalsIgnoreCase("Y");
    }

    public static void printInvoice(Order order) {
        System.out.println("\n════════════ HOÁ ĐƠN THANH TOÁN ════════════");
        System.out.println("🧾 Mã đơn hàng: " + order.getOrderId());
        System.out.println("👤 Khách hàng: " + order.getCustomer().getName());
        System.out.println("📞 SĐT: " + order.getCustomer().getPhoneNumber());
        System.out.println("👨‍🍳 Nhân viên bán hàng: " + order.getEmployee().getName());
        System.out.println("🕒 Thời gian: " + order.getDateTime());
        System.out.println("════════════════════════════════════════════");

        for (OrderItem item : order.getItems()) {
            System.out.printf("☕ %-20s | SL: %-3d | Đơn giá: %,.0f | Thành tiền: %,.0f VND\n",
                    item.getDrink().getName(),
                    item.getQuantity(),
                    item.getDrink().getPrice(),
                    item.getSubtotal());
        }

        System.out.println("════════════════════════════════════════════");
        System.out.printf("💵 TỔNG TIỀN: %,.0f VND\n", order.getTotalPrice());
        System.out.println("════════════════════════════════════════════\n");
    }
}
