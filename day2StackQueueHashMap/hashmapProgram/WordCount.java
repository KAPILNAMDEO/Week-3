package com.week3.day2StackQueueHashMap.hashmapProgram;
import java.util.HashMap;

public class WordCount {
    public static void main(String[] args) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        String[] words = {"apple", "banana", "apple"};
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        System.out.println(wordCount);

    }
}
