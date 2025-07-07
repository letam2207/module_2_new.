package ss1_Introduction_to_java.bai_tap;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tuyChon;
        double tienTe;
        double  chuyenDoi;
        System.out.println(" Nhập 1 chuyển đổi USD thành VNĐ\n " +
                "Nhập 2 chuyển đổi VNĐ sang USD");
        tuyChon = scanner.nextInt();
        if (tuyChon == 1 || tuyChon == 2) {
            System.out.print("Nhập số tiền muốn đổi: ");
            tienTe = scanner.nextDouble();
            if (tuyChon == 1) {
                chuyenDoi = tienTe * 23000;
                System.out.println("Số tiền VNĐ là: " + chuyenDoi + " VNĐ");
            } else {
                chuyenDoi = tienTe / 23000;
                System.out.println("Số tiền USD là: " + chuyenDoi + " USD");
            }
        } else {
            System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
        }
    }
}
