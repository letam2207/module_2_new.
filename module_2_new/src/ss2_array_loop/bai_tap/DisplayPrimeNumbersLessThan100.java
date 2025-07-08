package ss2_array_loop.bai_tap;

public class DisplayPrimeNumbersLessThan100 {
    public static void main(String[] args) {
        System.out.println("Các số nguyên tố nhỏ hơn 100 là:");
        boolean kiemTra = true;
        for (int i = 2; i < 100; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    kiemTra = false;
                    break;
                }
            }

            if (kiemTra) {
                System.out.print(i + " ");
            }
        }
    }
}
