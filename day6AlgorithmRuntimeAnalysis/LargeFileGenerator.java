package com.week3.day6AlgorithmRuntimeAnalysis;

import java.io.*;
import java.util.Random;



public class LargeFileGenerator {
    public static void main(String[] args) {
        String filePath = "src/com/week3/day6AlgorithmRuntimeAnalysis/SmallFile1MB.txt"; // Output file
        long fileSizeInMB = 1; // Target file size
        long fileSizeInBytes = fileSizeInMB * 1024 * 1024; // Convert MB to bytes

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            // Generating a random line of 100 characters
            for (int i = 0; i < 100; i++) {
                sb.append((char) ('A' + random.nextInt(26))); // Random uppercase letters
            }
            sb.append("\n"); // New line

            long bytesWritten = 0;
            while (bytesWritten < fileSizeInBytes) {
                writer.write(sb.toString()); // Write line to file
                bytesWritten += sb.length(); // Update bytes written

                // Flush every 10MB to ensure data is written to disk
                if (bytesWritten % (10 * 1024 * 1024) == 0) {
                    writer.flush();
                }
            }

            writer.flush(); // Final flush to ensure all data is written
            System.out.println("1MB text file generated successfully: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
