/*Problem:
Write a program that uses InputStreamReader to read binary data from a file and print it as characters. The file
 contains data encoded in a specific charset (e.g., UTF-8).
Approach:
Create a FileInputStream object to read the binary data from the file.
Wrap the FileInputStream in an InputStreamReader to convert the byte stream into a character stream.
Use a BufferedReader to read characters efficiently from the InputStreamReader.
Read the file line by line and print the characters to the console.
Handle any encoding exceptions as needed.*/
package com.week3.day4BufferFileReader.InputStreamReaderProblems;

import java.io.*;


public class ByteStreamtoCharacterStream {
    public static void main(String[] args) {
        // File path of the file with binary data
        String filePath = "src/com/week3/day4BufferFileReader/InputStreamReaderProblems/sample2.txt"; // Replace with your actual file path

        // Reading the file using InputStreamReader and BufferedReader
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8"); // Specify charset (UTF-8)
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String line;
            // Read file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Print each line of characters to the console
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

