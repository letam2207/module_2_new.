package ss16_IO_binary_file_serialization.bai_tap.view;

import ss16_IO_binary_file_serialization.bai_tap.entity.Product;

import java.util.Scanner;

public class ProductView {
    private final Scanner scanner = new Scanner(System.in);

    public Product addProduct() {
        System.out.print("Nhập mã sản phẩm: ");
        String id = scanner.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Nhập mô tả: ");
        String description = scanner.nextLine();

        return new Product(id, name, price, manufacturer, description);
    }

    public String searchProduct() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        return scanner.nextLine();
    }
}
