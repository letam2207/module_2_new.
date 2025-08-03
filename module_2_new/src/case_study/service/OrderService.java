package case_study.service;

import case_study.common.ReadAndWrite;
import case_study.entity.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {
    private static final String ORDER_FILE_PATH = "src/case_study/data/order.csv";
    private static final ICustomerService CUSTOMER_SERVICE = new CustomerService();
    private static final IEmployeeService EMPLOYEE_SERVICE = new EmployeeService();
    private static final IDrinkService DRINK_SERVICE = new DrinkService();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void add(Order order) {
        List<String> lines = ReadAndWrite.readFileCSV(ORDER_FILE_PATH);
        lines.add(convertOrderToString(order));
        ReadAndWrite.writeFileCSV(ORDER_FILE_PATH, lines, false);
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        List<String> lines = ReadAndWrite.readFileCSV(ORDER_FILE_PATH);

        for (String line : lines) {
            String[] parts = line.split(",", 5);
            if (parts.length < 5) continue;

            String orderId = parts[0];
            Customer customer = CUSTOMER_SERVICE.findById(parts[1]);
            Employee employee = EMPLOYEE_SERVICE.findById(parts[2]);
            LocalDateTime dateTime = LocalDateTime.parse(parts[3], FORMATTER);
            List<OrderItem> items = parseOrderItems(parts[4]);

            Order order = new Order(orderId, customer, employee, items, dateTime);
            orders.add(order);
        }

        return orders;
    }


    private String convertOrderToString(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append(order.getOrderId()).append(",")
                .append(order.getCustomer().getId()).append(",")
                .append(order.getEmployee().getId()).append(",")
                .append(order.getDateTime().format(FORMATTER)).append(",");
        for (OrderItem item : order.getItems()) {
            sb.append(item.getDrink().getId())
                    .append(":")
                    .append(item.getQuantity())
                    .append(";");
        }

        return sb.toString();
    }

    private List<OrderItem> parseOrderItems(String itemsString) {
        List<OrderItem> items = new ArrayList<>();
        if (itemsString == null || itemsString.trim().isEmpty()) return items;

        String[] itemParts = itemsString.split(";");
        for (String item : itemParts) {
            String[] details = item.split(":");
            if (details.length == 2) {
                String drinkId = details[0];
                int quantity = Integer.parseInt(details[1]);

                Drink drink = DRINK_SERVICE.findById(drinkId);
                if (drink != null) {
                    items.add(new OrderItem(drink, quantity));
                }
            }
        }
        return items;
    }
}
