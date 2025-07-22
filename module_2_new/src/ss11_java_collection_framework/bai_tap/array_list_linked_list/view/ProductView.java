package ss11_java_collection_framework.bai_tap.array_list_linked_list.view;

import ss11_java_collection_framework.bai_tap.array_list_linked_list.entity.Product;
import ss11_java_collection_framework.bai_tap.array_list_linked_list.service.IProductService;
import ss11_java_collection_framework.bai_tap.array_list_linked_list.service.ProductService;

import java.util.List;
import java.util.Scanner;

public class ProductView {

    private static final IProductService productService = new ProductService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayProduct(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    public static void addProduct() {
        try {
            System.out.print("Nhập ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();

            System.out.print("Nhập giá: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập mô tả: ");
            String description = scanner.nextLine();

            Product product = new Product(id, name, price, quantity, description);
            productService.add(product);
            System.out.println("Thêm sản phẩm thành công!");
        } catch (NumberFormatException e) {
            System.out.println("Sai định dạng. Vui lòng nhập lại!");
        }
    }

    public static void deleteProduct() {
        try {
            System.out.print("Nhập ID sản phẩm cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            boolean result = productService.delete(id);
            if (result) {
                System.out.println("Xóa sản phẩm thành công.");
            } else {
                System.out.println("Không tìm thấy sản phẩm có ID: " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Sai định dạng ID.");
        }
    }

    public static void searchProduct() {
        System.out.println("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        List<Product> products = productService.findByName(name);
        displayProduct(products);
    }

    public static void updateProduct(Product product) {
        System.out.println("===== CẬP NHẬT SẢN PHẨM =====");
        System.out.println("Sản phẩm hiện tại: " + product);

        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine();

        System.out.print("Nhập giá mới: ");
        double newPrice;
        try {
            newPrice = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Giá không hợp lệ. Hủy cập nhật.");
            return;
        }

        System.out.print("Nhập số lượng mới: ");
        int newQuantity;
        try {
            newQuantity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Số lượng không hợp lệ. Hủy cập nhật.");
            return;
        }

        System.out.print("Nhập mô tả mới: ");
        String newDescription = scanner.nextLine();


        product.setName(newName);
        product.setPrice(newPrice);
        product.setQuantity(newQuantity);
        product.setDescription(newDescription);


        productService.updateById(product.getId(), product);

        System.out.println(" Cập nhật thành công!");
    }


    public static void arrangeProduct() {
        boolean check = true;
        while (check) {
            List<Product> products = productService.findAll();
            System.out.println("""
                    1. Sắp xếp tăng dần theo giá
                    2. Sắp xếp giảm dần theo giá
                    3. Thoát
                    """);
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
                    displayProduct(products);
                    break;
                case 2:
                    products.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
                    displayProduct(products);
                    break;
                case 3:
                    check = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập đúng lựa chọn.");
            }
        }
    }
}
