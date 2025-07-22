package ss11_java_collection_framework.bai_tap.array_list_linked_list.view;

import ss11_java_collection_framework.bai_tap.array_list_linked_list.entity.Product;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static final Scanner scanner = new Scanner(System.in);


    public static void displayProduct(List<Product> products) {
        if (products == null || products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }


    public static Product inputNewProduct() {
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

            return new Product(id, name, price, quantity, description);
        } catch (NumberFormatException e) {
            System.out.println(" Sai định dạng. Vui lòng nhập lại!");
            return null;
        }
    }


    public static int inputDeleteId() {
        System.out.print("Nhập ID sản phẩm cần xóa: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Sai định dạng ID.");
            return -1;
        }
    }

    public static String inputSearchName() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        return scanner.nextLine();
    }

    public static int inputUpdateId() {
        System.out.print("Nhập ID sản phẩm cần cập nhật: ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(" Sai định dạng ID.");
            return -1;
        }
    }


    public static Product updateProductInfo(Product oldProduct) {
        System.out.println("===== CẬP NHẬT SẢN PHẨM =====");
        System.out.println("Sản phẩm hiện tại: " + oldProduct);

        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine();

        System.out.print("Nhập giá mới: ");
        double newPrice;
        try {
            newPrice = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Giá không hợp lệ. Hủy cập nhật.");
            return null;
        }

        System.out.print("Nhập số lượng mới: ");
        int newQuantity;
        try {
            newQuantity = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Số lượng không hợp lệ. Hủy cập nhật.");
            return null;
        }

        System.out.print("Nhập mô tả mới: ");
        String newDescription = scanner.nextLine();

        return new Product(oldProduct.getId(), newName, newPrice, newQuantity, newDescription);
    }


}
