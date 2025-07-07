package ss2_array_loop.bai_tap;

public class MergeArrays {
    public static void main(String[] args) {
        int[] array1 = {12, 32, 44, 23, 78, 9};
        System.out.print("Mảng 1 : ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i]+", ");
        }
        int[] array2 = {34, 72, 49, 53, 90};
        System.out.print("\nMảng 2 : ");
        for (int i = 0; i < array2.length; i++) {
            System.out.print(array2[i]+", ");
        }
        int[] array3 = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            array3[array1.length + i] = array2[i];
        }
        System.out.print("\nMảng sau khi gộp: ");
        for (int i = 0; i < array3.length; i++) {
            System.out.print(array3[i] + ", ");
        }
    }
}
