package ss11_java_collection_framework.bai_tap.array_list_linked_list.controller;

import ss11_java_collection_framework.bai_tap.array_list_linked_list.entity.Product;
import ss11_java_collection_framework.bai_tap.array_list_linked_list.service.IProductService;
import ss11_java_collection_framework.bai_tap.array_list_linked_list.service.ProductService;
import ss11_java_collection_framework.bai_tap.array_list_linked_list.view.ProductView;

import java.util.List;
import java.util.Scanner;

public class ProductController {
    private static final IProductService productService = new ProductService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void displayMenu() {
        do {
            try {
                System.out.println("""
                        -------ỨNG DỤNG QUẢN LÝ SẢN PHẨM--------
                        1. Thêm mới sản phẩm
                        2. Sửa sản phẩm
                        3. Xóa sản phẩm
                        4. Hiển thị danh sách sản phẩm
                        5. Tìm kiếm sản phẩm theo tên
                        6. Sắp xếp sản phẩm theo giá
                        7. Thoát
                        """);
                System.out.print("Chọn chức năng: ");
                int choose = Integer.parseInt(scanner.nextLine());

                switch (choose) {
                    case 1:
                        add();
                        break;

                    case 2:
                        update();
                        break;

                    case 3:
                        delete();
                        break;

                    case 4:
                        List<Product> allProducts = productService.findAll();
                        ProductView.displayProduct(allProducts);
                        break;

                    case 5:
                        search();
                        break;

                    case 6:
                        arrangeProduct();
                        break;

                    case 7:
                        System.out.println(" Đã thoát chương trình.");
                        System.exit(0);

                    default:
                        System.out.println(" Lựa chọn không hợp lệ. Vui lòng thử lại.");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println(" Nhập sai định dạng! Vui lòng nhập số.");
            }
        } while (true);
    }

    public static void update() {
        System.out.print("Nhập ID sản phẩm cần sửa: ");
        int idUpdate = Integer.parseInt(scanner.nextLine());

        Product oldProduct = productService.findById(idUpdate);
        if (oldProduct == null) {
            System.out.println(" Không tìm thấy sản phẩm có ID: " + idUpdate);
        } else {
            Product updatedProduct = ProductView.updateProductInfo(oldProduct);
            if (updatedProduct != null) {
                productService.updateById(idUpdate, updatedProduct);
                System.out.println(" Cập nhật thành công!");
            }
        }

    }

    public static void search() {
        String nameSearch = ProductView.inputSearchName();
        List<Product> result = productService.findByName(nameSearch);
        ProductView.displayProduct(result);
    }

    public static void add() {
        Product newProduct = ProductView.inputNewProduct();
        if (newProduct != null) {
            productService.add(newProduct);
            System.out.println("Thêm sản phẩm thành công.");
        }
    }

    public static void delete() {
        int deleteId = ProductView.inputDeleteId();
        if (deleteId != -1) {
            boolean result = productService.delete(deleteId);
            if (result) {
                System.out.println("Xóa sản phẩm thành công.");
            } else {
                System.out.println(" Không tìm thấy sản phẩm để xóa.");
            }
        }
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
                    ProductView.displayProduct(products);
                    break;
                case 2:
                    products.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
                    ProductView.displayProduct(products);
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
