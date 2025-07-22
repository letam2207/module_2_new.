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
                System.out.println("-------ỨNG DỤNG QUẢN LÝ SẢN PHẨM--------" +
                        "\n 1. Thêm mới sản phẩm." +
                        "\n 2. Sửa sản phẩm" +
                        "\n 3. Xóa sản phẩm" +
                        "\n 4. Hiển thị danh sách sản phẩm" +
                        "\n 5. Tìm kiếm sản phẩm theo tên" +
                        "\n 6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá" +
                        "\n 7. Kết thúc chương trình !");
                System.out.print("Chọn chức năng: ");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 1:
                        ProductView.addProduct();
                        break;
                    case 2:
                        System.out.print("Nhập ID sản phẩm cần sửa: ");
                        int idUpdate = Integer.parseInt(scanner.nextLine());

                        Product productToUpdate = productService.findById(idUpdate);
                        if (productToUpdate == null) {
                            System.out.println(" Không tìm thấy sản phẩm có ID = " + idUpdate);
                        } else {
                            ProductView.updateProduct(productToUpdate);
                        }
                        break;

                    case 3:
                        ProductView.deleteProduct();
                        break;
                    case 4:
                        List<Product> products = productService.findAll();
                        ProductView.displayProduct(products);
                        break;
                    case 5:
                        ProductView.searchProduct();
                        break;
                    case 6:
                        ProductView.arrangeProduct();
                        break;
                    case 7:
                        System.out.println("Đã thoát chương trình.");
                        System.exit(0);
                    default:
                        System.out.println("Nhập sai lựa chọn, vui lòng nhập lại!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Nhập sai định dạng! Vui lòng nhập số.");
            }
        } while (true);
    }
}
