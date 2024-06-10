package by.aston.bakumenko.fifthTask;

import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String[] arrayOfWords = {"cat", "dog", "elephant", "boa", "butterfly", "dog", "spider", "boa", "cat", "dolphin", "monkey", "dog", "bee", "cat", "fish", "bear", "cat"};
        List<String> unique = new ArrayList<>();
        Map<String, Integer> wordCounts = new HashMap<>();
        for (int i = 0; i < arrayOfWords.length; i++) {
            int count = 0;
            for (int j = 0; j < arrayOfWords.length; j++) {
                if (arrayOfWords[i].equals(arrayOfWords[j]) && i != j) {
                    count++;
                }
            }
            wordCounts.put(arrayOfWords[i], count);
            if (count == 0) {
                unique.add(arrayOfWords[i]);
            }
        }
        System.out.println("Уникальные слова:");
        for (String word : unique) {
            System.out.println(word);
        }
        System.out.println("Количество повторений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}