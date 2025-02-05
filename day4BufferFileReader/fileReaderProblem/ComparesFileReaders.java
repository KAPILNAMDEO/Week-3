/*Challenge Problem: Compare StringBuilder, StringBuffer, FileReader, and InputStreamReader
Problem:
Write a program that:
Uses StringBuilder and StringBuffer to concatenate a list of strings 1,000,000 times.
Uses FileReader and InputStreamReader to read a large file (e.g., 100MB) and print the number of words in the file.
Approach:
StringBuilder and StringBuffer:
Create a list of strings (e.g., "hello").
Concatenate the strings 1,000,000 times using both StringBuilder and StringBuffer.
Measure and compare the time taken for each.
FileReader and InputStreamReader:
Read a large text file (100MB) using FileReader and InputStreamReader.
Count the number of words by splitting the text on whitespace characters.
Print the word count and compare the time taken for reading the file*/


package com.week3.day4BufferFileReader.fileReaderProblem;

import java.io.FileReader;



import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ComparesFileReaders {

    public static void main(String[] args) throws IOException {
        // String concatenation test
        String testString = "hello";
        int iterations = 1000000;

        // Using StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(testString);
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        System.out.println("StringBuilder time: " + stringBuilderTime / 1_000_000 + " ms");

        // Using StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(testString);
        }
        long stringBufferTime = System.nanoTime() - startTime;
        System.out.println("StringBuffer time: " + stringBufferTime / 1_000_000 + " ms");

        // File reading test
        String filePath = "src/com/week3/day4BufferFileReader/fileReaderProblem/path_to_large_file.txt"; // Replace with the path to your 100MB file
        long wordCount = countWordsInFile(filePath);
        System.out.println("Word count in file: " + wordCount);
    }

    // Method to count words in a large file using FileReader and InputStreamReader
    public static long countWordsInFile(String filePath) throws IOException {
        long wordCount = 0;

        // Using FileReader and InputStreamReader
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
        }

        return wordCount;
    }
}

