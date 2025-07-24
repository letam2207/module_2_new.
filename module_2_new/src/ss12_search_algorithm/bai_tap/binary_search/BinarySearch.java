package ss12_search_algorithm.bai_tap.binary_search;

import java.util.Scanner;

public class BinarySearch {
    public static Integer binarySearch(int[] array, int left, int right, int value) {

        if (right >= left) {
            int middle = (left + right) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] < value) {
                return binarySearch(array, middle + 1, right, value);
            } else {
                return binarySearch(array, left, middle - 1, value);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số muốn tìm kiếm: ");
        int num = Integer.parseInt(scanner.nextLine());
        int result = binarySearch(numbers,0,numbers.length-1,num);
        System.out.println("số vừa nhập có vị trí index là: "+result);

    }

}