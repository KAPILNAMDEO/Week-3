/*4. Problem Statement: Large File Reading Efficiency
        Objective:
        Compare FileReader (Character Stream) and InputStreamReader (Byte Stream) when reading a large file (500MB).
        Approach:
        FileReader: Reads character by character (slower for binary files).
        InputStreamReader: Reads bytes and converts to characters (more efficient).*/


package com.week3.day6AlgorithmRuntimeAnalysis;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargeFileReadingComparison {
    public static void main(String[] args) {
        // Ensure these files exist before running the program
        String[] filePaths = {"src/com/week3/day6AlgorithmRuntimeAnalysis/SmallFile1MB.txt", "src/com/week3/day6AlgorithmRuntimeAnalysis/LargeFile100Mb.txt", "src/com/week3/day6AlgorithmRuntimeAnalysis/LargeFile500Mb.txt"};

        for(String filepath:filePaths){
            System.out.println("\nreading file:  "+filepath);

            long start =System.nanoTime();
            readUsingFileReader(filepath);
            long end=System.nanoTime();
            System.out.println("FileReader Time: "+(end-start)/1_000_000.0+" ms");

            start =System.nanoTime();
            readUsingInputStreamReader(filepath);
            end=System.nanoTime();
            System.out.println("InputStreamReader Time: "+(end-start)/1_000_000.0+" ms");
        }
    }

    // Read using FileReader (Character Stream)
    private static void readUsingFileReader(String filePath) {
        try (FileReader reader = new FileReader(filePath)) {
            char[] buffer = new char[8192]; // 8KB buffer for efficiency
            while (reader.read(buffer) != -1) {
                // Read file in chunks instead of character by character
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Read using InputStreamReader (Byte Stream)
    private static void readUsingInputStreamReader(String filePath) {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filePath))) {
            char[] buffer = new char[8192]; // 8KB buffer for efficiency
            while (reader.read(buffer) != -1) {
                // Read file in chunks instead of byte by byte
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
