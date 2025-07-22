package ss10_stack_queue.bai_tap.count_occurrences;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào một chuỗi:");
        String input = scanner.nextLine();

        Map<String, Integer> result = TextWordCounter.countWords(input);
        TextWordCounter.printWordCount(result);
    }
}
