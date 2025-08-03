package case_study.controller;

import case_study.entity.Drink;
import case_study.service.DrinkService;
import case_study.service.IDrinkService;
import case_study.view.DrinkView;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DrinkController {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IDrinkService DRINK_SERVICE = new DrinkService();

    public static void drinkController() {
        boolean running = true;
        do {
            try {
                System.out.println("╔════════════════════════════════════════════════╗");
                System.out.println("║          ▸ CHỨC NĂNG QUẢN LÝ MÓN NƯỚC ◂        ║");
                System.out.println("╠════════════════════════════════════════════════╣");
                System.out.println("║ 1. Thêm mới món nước                           ║");
                System.out.println("║ 2. Chỉnh sửa thông tin món nước                ║");
                System.out.println("║ 3. Xóa món nước                                ║");
                System.out.println("║ 4. Hiển thị danh sách món nước                 ║");
                System.out.println("║ 5. Tìm kiếm món nước theo tên                  ║");
                System.out.println("║ 6. Trở về menu chính                           ║");
                System.out.println("╚════════════════════════════════════════════════╝");
                System.out.print("➤ Vui lòng chọn chức năng (1-6): ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> add();
                    case 2 -> update();
                    case 3 -> delete();
                    case 4 -> displayGroupedByType(DRINK_SERVICE.findAll());
                    case 5 -> search();
                    case 6 -> {
                        System.out.println("⇨ Trở về menu chính...");
                        running = false;
                    }
                    default -> System.out.println("⚠ Lựa chọn không hợp lệ. Vui lòng chọn từ 1 đến 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Nhập sai định dạng! Vui lòng nhập số.");
            }
        } while (running);
    }



        public static void displayGroupedByType(List<Drink> drinks) {
            if (drinks == null || drinks.isEmpty()) {
                System.out.println("⚠ Danh sách món nước trống.");
                return;
            }
            drinks.sort(Comparator.comparing(Drink::getType));

            String currentType = "";
            System.out.println("════════════ DANH SÁCH MÓN NƯỚC THEO LOẠI ════════════");

            for (Drink drink : drinks) {
                if (!drink.getType().equalsIgnoreCase(currentType)) {
                    currentType = drink.getType();
                    System.out.println();
                    System.out.println("∘∘∘ Loại: " + currentType.toUpperCase());
                    System.out.println(Drink.getTableDivider());
                    System.out.println(Drink.getTableHeader());
                    System.out.println(Drink.getTableDivider());
                }
                System.out.println(drink);
            }
            System.out.println(Drink.getTableDivider());
        }



    public static void add() {
        System.out.println("➤ BẮT ĐẦU THÊM MÓN NƯỚC MỚI");
        Drink drink = DrinkView.addDrink();
        String newId = drink.getId();
        Drink existing = DRINK_SERVICE.findById(newId);
        if (existing != null) {
            System.out.println("⚠ ID món nước đã tồn tại. Vui lòng nhập ID khác.");
        } else {
            DRINK_SERVICE.add(drink);
            System.out.println("✅ Thêm món nước thành công.");
        }
    }

    public static void update() {
        System.out.println("➤ CẬP NHẬT THÔNG TIN MÓN NƯỚC");
        String idUpdate = DrinkView.inputUpdateId();

        Drink existing = DRINK_SERVICE.findById(idUpdate);
        if (existing == null) {
            System.out.println("⚠ Không tìm thấy món nước có ID: " + idUpdate);
        } else {
            Drink updated = DrinkView.updateDrink(existing);
            DRINK_SERVICE.updateById(idUpdate, updated);
            System.out.println("✅ Cập nhật thông tin món nước thành công.");
        }
    }

    public static void search() {
        System.out.println("➤ TÌM KIẾM MÓN NƯỚC THEO TÊN");
        String nameSearch = DrinkView.inputSearchName();
        List<Drink> result = DRINK_SERVICE.findByName(nameSearch);
        displayGroupedByType(result);
    }

    public static void delete() {
        System.out.println("➤ XOÁ MÓN NƯỚC");
        String deleteId = DrinkView.inputDeleteId();
        Drink existing = DRINK_SERVICE.findById(deleteId);

        if (existing == null) {
            System.out.println("⚠ Không tìm thấy món nước có ID: " + deleteId);
        } else {
            System.out.println("➤ Thông tin món nước:");
            System.out.println(existing);
            System.out.print("❓Bạn có chắc chắn muốn xoá món nước này không? (Y để xác nhận): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                DRINK_SERVICE.delete(deleteId);
                System.out.println("✅ Xoá món nước thành công.");
            } else {
                System.out.println("❎ Đã huỷ thao tác xoá.");
            }
        }
    }
}
