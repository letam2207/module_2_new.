package ss10_stack_queue.bai_tap.binary_to_decimal;

import java.util.Stack;

public class BinaryConverter {
    public static String convertToBinary(int number) {
        if (number == 0) {
            return "0";
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder binary = new StringBuilder();

        while (number != 0) {
            stack.push(number % 2);
            number /= 2;
        }

        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }
}
