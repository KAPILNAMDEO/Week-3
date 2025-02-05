package com.week3.day4BufferFileReader.InputStreamReaderProblems;

import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        // File path to store user input
        String filePath = "src/com/week3/day4BufferFileReader/InputStreamReaderProblems/UserInput.txt";

        // Create InputStreamReader to read from System.in (console)
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader consoleReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true); // 'true' for appending to the file
             BufferedWriter fileWriterBuffered = new BufferedWriter(fileWriter)) {

            String userInput;
            System.out.println("Enter text (type 'exit' to quit):");

            // Keep reading input until "exit" is entered
            while (true) {
                userInput = consoleReader.readLine();

                if ("exit".equalsIgnoreCase(userInput)) {
                    break; // Exit the loop if the user types "exit"
                }

                // Write the input to the file
                fileWriterBuffered.write(userInput);
                fileWriterBuffered.newLine(); // Move to a new line in the file
            }

            System.out.println("User input has been written to " + filePath);
        } catch (IOException e) {
            System.err.println("Error handling the input/output: " + e.getMessage());
        }
    }
}
