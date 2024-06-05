package by.aston.bakumenko.fifthTask;

import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "elephant", "boa", "butterfly", "dog", "spider", "boa", "cat", "dolphin", "monkey", "dog", "bee", "cat", "fish", "bear", "cat"};
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
        Set<String> uniqueWords = new HashSet<>();
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueWords.add(entry.getKey());
            }
        }
        System.out.println("Уникальные слова:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
        System.out.println("Количество повторений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }
    }
}