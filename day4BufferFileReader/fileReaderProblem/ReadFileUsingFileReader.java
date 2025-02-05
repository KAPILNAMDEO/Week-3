/*FileReader Problem 1: Read a File Line by Line Using FileReader
Problem:
Write a program that uses FileReader to read a text file line by line and print each line to the console.
Approach:
Create a FileReader object to read from the file.
Wrap the FileReader in a BufferedReader to read lines efficiently.
Use a loop to read each line using the readLine() method and print it to the console.
Close the file after reading all the lines.*/

package com.week3.day4BufferFileReader.fileReaderProblem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingFileReader {
    public static void main(String[] args) {
        // Define the relative file path (ensure the file is placed correctly)
        String filepath = "src/com/week3/day4BufferFileReader/fileReaderProblem/textFile.txt";

        // Use try-with-resources to automatically close resources after use
        try (FileReader fileReader = new FileReader(filepath);  // Create FileReader to read the file
             BufferedReader bufferedReader = new BufferedReader(fileReader)) { // Wrap FileReader in BufferedReader for efficient reading

            String line;
            // Read the file line by line until EOF (End Of File) is reached
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Print each line to the console
            }

        } catch (IOException e) { // Handle exceptions if the file is not found or can't be read
            System.err.println("Error reading the file: " + e.getMessage()); // Print error message
            e.printStackTrace(); // Print detailed error trace for debugging
        }
    }
}

