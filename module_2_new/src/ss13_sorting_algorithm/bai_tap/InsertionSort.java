package ss13_sorting_algorithm.bai_tap;

public class InsertionSort {
    static int[] array = {4, 6, 9, 2, 3, 5, 6, 11, 43, -4};

    public static void insertionSort(int[] array) {
        int pos, x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;
        }
    }
    public static void main(String[] args) {
        insertionSort(array);
        System.out.println("mảng sau khi sắp xếp: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " , ");
        }
    }
}
