package ss1_Introduction_to_java.bai_tap;

import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số dưới 100:");
        int number = scanner.nextInt();
        int phanNguyen = 0;
        int phanDu = 0;
        String donVi = "";
        String hangChuc = "";
        boolean repeat = true;

        while (repeat) {
            if (phanDu != 0) {
                number = phanDu;
            }

            if (number < 20) {
                repeat = false;
                switch (number) {
                    case 0:
                        donVi = "không";
                        break;
                    case 1:
                        donVi = "một";
                        break;
                    case 2:
                        donVi = "hai";
                        break;
                    case 3:
                        donVi = "ba";
                        break;
                    case 4:
                        donVi = "bốn";
                        break;
                    case 5:
                        donVi = "năm";
                        break;
                    case 6:
                        donVi = "sáu";
                        break;
                    case 7:
                        donVi = "bảy";
                        break;
                    case 8:
                        donVi = "tám";
                        break;
                    case 9:
                        donVi = "chín";
                        break;
                    case 10:
                        hangChuc = "mười";
                        break;
                    case 11:
                        hangChuc = "mười một";
                        break;
                    case 12:
                        hangChuc = "mười hai";
                        break;
                    case 13:
                        hangChuc = "mười ba";
                        break;
                    case 14:
                        hangChuc = "mười bốn";
                        break;
                    case 15:
                        hangChuc = "mười lăm";
                        break;
                    case 16:
                        hangChuc = "mười sáu";
                        break;
                    case 17:
                        hangChuc = "mười bảy";
                        break;
                    case 18:
                        hangChuc = "mười tám";
                        break;
                    case 19:
                        hangChuc = "mười chín";
                        break;
                    case 20:
                        hangChuc = "hai mươi";
                        break;
                }
            } else {
                phanDu = number % 10;
                phanNguyen = number / 10;
                if (phanDu == 0) {
                    repeat = false;
                }

                switch (phanNguyen) {
                    case 2:
                        hangChuc = "hai mươi";
                        break;
                    case 3:
                        hangChuc = "ba mươi";
                        break;
                    case 4:
                        hangChuc = "bốn mươi";
                        break;
                    case 5:
                        hangChuc = "năm mươi";
                        break;
                    case 6:
                        hangChuc = "sáu mươi";
                        break;
                    case 7:
                        hangChuc = "bảy mươi";
                        break;
                    case 8:
                        hangChuc = "tám mươi";
                        break;
                    case 9:
                        hangChuc = "chín mươi";
                        break;
                }

                switch (phanDu) {
                    case 1:
                        donVi = "mốt";
                        break;
                    case 2:
                        donVi = "hai";
                        break;
                    case 3:
                        donVi = "ba";
                        break;
                    case 4:
                        donVi = "bốn";
                        break;
                    case 5:
                        donVi = "lăm";
                        break;
                    case 6:
                        donVi = "sáu";
                        break;
                    case 7:
                        donVi = "bảy";
                        break;
                    case 8:
                        donVi = "tám";
                        break;
                    case 9:
                        donVi = "chín";
                        break;
                }
            }
        }

        System.out.println("Đọc là: " + (hangChuc + " " + donVi).trim());
    }
}
