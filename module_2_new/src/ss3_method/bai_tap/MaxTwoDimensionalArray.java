package ss3_method.bai_tap;

public class MaxTwoDimensionalArray {
    public static void main(String[] args) {
        int[][] array = {{12, 32, 45, 33, 77, 100}, {96, 37, 11, 21, 4, 7}};
        int max = array[0][0];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("giá trị lớn nhất trong mảng trên là : " + max);
    }
}
