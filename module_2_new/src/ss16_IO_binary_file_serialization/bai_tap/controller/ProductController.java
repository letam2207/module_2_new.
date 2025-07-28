package ss16_IO_binary_file_serialization.bai_tap.controller;

import ss16_IO_binary_file_serialization.bai_tap.entity.Product;
import ss16_IO_binary_file_serialization.bai_tap.service.ProductService;
import ss16_IO_binary_file_serialization.bai_tap.view.ProductView;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private final ProductView productView = new ProductView();
    private final ProductService productService = new ProductService();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n=== QUẢN LÝ SẢN PHẨM ===");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị tất cả sản phẩm");
            System.out.println("3. Tìm kiếm sản phẩm theo tên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    showAllProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ !");

            }
        } while (true);
    }

    private void showAllProducts() {
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            System.out.println("Danh sách sản phẩm trống.");
        } else {
            for (Product p : products) {
                System.out.println(p);
            }
        }
    }

    private void addProduct() {
        Product product = productView.addProduct();
        productService.addProduct(product);
        System.out.println("Đã thêm sản phẩm.");
    }

    private void searchProduct() {
        String keyword = productView.searchProduct();
        List<Product> results = productService.searchByName(keyword);
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy sản phẩm.");
        } else {
            for (Product p : results) {
                System.out.println(p);
            }
        }
    }
}
