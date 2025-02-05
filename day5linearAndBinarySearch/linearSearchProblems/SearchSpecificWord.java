package com.week3.day5linearAndBinarySearch.linearSearchProblems;




/*
Linear Search Problem 2: Search for a Specific Word in a List of Sentences

Problem:
You are given an array of sentences (strings). Write a program that performs
Linear Search to find the first sentence containing a specific word.
If the word is found, return the sentence. If no sentence contains the word, return "Not Found".

Approach:
1. Iterate through the list of sentences.
2. For each sentence, check if it contains the specific word.
3. If the word is found, return the current sentence.
4. If no sentence contains the word, return "Not Found".
*/

public class SearchSpecificWord {

    // Function to find the first sentence containing the specific word
    static String findSentenceWithWord(String sentences[], String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence; // Return the first sentence that contains the word
            }
        }
        return "Not Found"; // Return "Not Found" if no sentence contains the word
    }

    public static void main(String[] args) {
        // Sample sentences
        String sentences[] = {
                "The quick brown fox jumps over the lazy dog.",
                "Java is a popular programming language.",
                "Linear search is simple but not always efficient.",
                "Data structures and algorithms are important."
        };

        // Word to search for
        String wordToFind = "Java";

        // Search and print the first sentence containing the word
        System.out.println("Sentence found: " + findSentenceWithWord(sentences, wordToFind));
    }
}
