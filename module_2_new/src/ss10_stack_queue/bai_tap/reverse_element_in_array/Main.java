package ss10_stack_queue.bai_tap.reverse_element_in_array;

public class Main {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Mảng ban đầu:");
        ReverseUtils.printIntArray(intArray);

        ReverseUtils.reverseIntArray(intArray);
        System.out.println("Mảng sau khi đảo ngược:");
        ReverseUtils.printIntArray(intArray);

        String input = "một hai ba bốn năm";
        String[] stringArray = input.split(" ");

        System.out.println("Chuỗi ban đầu:");
        ReverseUtils.printStringArray(stringArray);

        ReverseUtils.reverseStringArray(stringArray);
        System.out.println("Chuỗi sau khi đảo ngược:");
        ReverseUtils.printStringArray(stringArray);
    }
}
