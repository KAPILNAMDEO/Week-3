package com.week3.day4BufferFileReader.stringBuilderAndStringBuffer;



public class CompareStringBufferAndStringBuilder {
    public static void main(String[] args) {
        int iterations = 1_000_000; // 1 million iterations
        String text = "hello";

        // Measure time for StringBuffer
        long startTime1 = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long endTime1 = System.nanoTime();
        long stringBufferTime = endTime1 - startTime1;

        // Measure time for StringBuilder
        long startTime2 = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long endTime2 = System.nanoTime();
        long stringBuilderTime = endTime2 - startTime2;

        // Output the results
        System.out.println("Time taken by StringBuffer: " + stringBufferTime / 1_000_000 + " ms");
        System.out.println("Time taken by StringBuilder: " + stringBuilderTime / 1_000_000 + " ms");

        // Compare results
        if (stringBufferTime > stringBuilderTime) {
            System.out.println("StringBuilder is faster.");
        } else {
            System.out.println("StringBuffer is faster.");
        }
    }
}

