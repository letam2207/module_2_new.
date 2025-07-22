package ss10_stack_queue.bai_tap.check_palindrome_string;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeChecker {

    public static boolean isPalindrome(String input) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();

        String[] characters = input.split("");
        for (String ch : characters) {
            stack.push(ch);
            queue.add(ch);
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        return true;
    }
}
