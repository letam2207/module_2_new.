package ss10_stack_queue.bai_tap.count_occurrences;

import java.util.Map;
import java.util.TreeMap;

public class TextWordCounter {
    public static Map<String, Integer> countWords(String input) {
        input = input.toLowerCase();
        String[] words = input.split(" ");
        Map<String, Integer> wordMap = new TreeMap<>();
        int count;
        for (String word : words) {
            word = word.trim();
            if (word.isEmpty()) continue;

            if (wordMap.containsKey(word)) {
                count = wordMap.get(word);
                wordMap.put(word, count + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        return wordMap;
    }

    public static void printWordCount(Map<String, Integer> wordMap) {
        System.out.println("\nTần suất xuất hiện của các từ:");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue()+" lần");
        }
    }
}
