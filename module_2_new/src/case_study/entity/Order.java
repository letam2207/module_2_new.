package case_study.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order {
    private String orderId;
    private Customer customer;
    private Employee employee;
    private List<OrderItem> items;
    private LocalDateTime dateTime;

    public Order() {
    }

    public Order(String orderId, Customer customer, Employee employee, List<OrderItem> items, LocalDateTime dateTime) {
        this.orderId = orderId;
        this.customer = customer;
        this.employee = employee;
        this.items = items;
        this.dateTime = dateTime;
    }

    public Order(String orderId, Customer customer, Employee employee, String phone, LocalDateTime time, List<OrderItem> items) {
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n＿＿＿＿＿＿＿＿  HÓA ĐƠN THANH TOÁN ＿＿＿＿＿＿＿＿\n");
        sb.append("🧾 Mã đơn hàng: ").append(orderId).append("\n");
        sb.append("👤 Khách hàng: ").append(customer != null ? customer.getName() : "null").append("\n");
        sb.append("📞 SĐT: ").append(customer != null ? customer.getPhoneNumber() : "null").append("\n");
        sb.append("👨‍💼 Nhân viên bán hàng: ").append(employee != null ? employee.getName() : "null").append("\n");
        sb.append("⏰ Thời gian: ").append(dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).append("\n");
        sb.append("─────────────────────────────────────────────\n");

        for (OrderItem item : items) {
            sb.append("🍹 ").append(item.getDrink().getName())
                    .append("  | SL: ").append(item.getQuantity())
                    .append("  | Đơn giá: ").append(String.format("%,.0f VND", item.getDrink().getPrice()))
                    .append("  | Thành tiền: ").append(String.format("%,.0f VND", item.getSubtotal()))
                    .append("\n");
        }

        sb.append("💵 TỔNG TIỀN: ").append(String.format("%,.0f VND", getTotalPrice())).append("\n");

        return sb.toString();
    }
}
