package ss2_array_loop.bai_tap;

public class DisplayFirst20PrimeNumbers {
    public static void main(String[] args) {
        int demSo = 0;
        int soNguyenTo = 2;
        System.out.println("20 số nguyên tố đầu tiên là :");
        while (demSo <= 20) {
            boolean kiemTra = true;
            for (int i = 2; i < soNguyenTo; i++) {
                if (soNguyenTo % i == 0) {
                    kiemTra = false;
                    break;
                }
            }
            if (kiemTra) {
                System.out.print(soNguyenTo +", ");
                demSo++;
            }
            soNguyenTo++;
        }
    }
}
