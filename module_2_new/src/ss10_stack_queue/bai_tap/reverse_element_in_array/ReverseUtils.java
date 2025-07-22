package ss10_stack_queue.bai_tap.reverse_element_in_array;

import java.util.Stack;

public class ReverseUtils {

    public static void reverseIntArray(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            stack.push(num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void reverseStringArray(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String word : arr) {
            stack.push(word);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
    }

    public static void printIntArray(int[] arr) {
        for (int num : arr) {
            System.out.printf("%-5d", num);
        }
        System.out.println();
    }

    public static void printStringArray(String[] arr) {
        for (String word : arr) {
            System.out.printf("%-5s", word);
        }
        System.out.println();
    }
}
