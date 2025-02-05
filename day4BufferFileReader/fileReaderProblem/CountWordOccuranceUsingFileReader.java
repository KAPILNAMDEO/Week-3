/*FileReader Problem 2: Count the Occurrence of a Word in a File Using FileReader
Problem:
Write a program that uses FileReader and BufferedReader to read a file and count how many times a specific word appears
 in the file.
Approach:
Create a FileReader to read from the file and wrap it in a BufferedReader.
Initialize a counter variable to keep track of word occurrences.
For each line in the file, split it into words and check if the target word exists.
Increment the counter each time the word is found.
Print the final count*/

package com.week3.day4BufferFileReader.fileReaderProblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CountWordOccuranceUsingFileReader {
    public static void main(String[] args) {
        String filepath="src/com/week3/day4BufferFileReader/fileReaderProblem/JavaDescription.txt";
        String targetedWord="java";
        int count =0;
        try (FileReader fileReader=new FileReader(filepath);
             BufferedReader bufferedReader=new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                /*The regular expression \\s+|\\W+ splits the string at:
                Whitespace (spaces, tabs, newlines), or
                Non-word characters (anything that's not a letter, number, or underscore)*/
                String[] words = line.split("\\s+|[^a-zA-Z0-9]+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetedWord)) {
                        count++;
                    }
                }
            }
            // Print the final count of occurrences
            System.out.println("The word \"" + targetedWord + "\" appears " + count + " times in the file.");
        }catch (IOException e){
            System.out.println("error while reading the file"+e.getMessage());
            e.printStackTrace();
        }



    }
}
