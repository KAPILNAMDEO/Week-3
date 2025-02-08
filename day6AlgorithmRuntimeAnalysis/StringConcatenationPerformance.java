/*3. Problem Statement: String Concatenation Performance
Objective:
Compare the performance of String (O(N²)), StringBuilder (O(N)), and StringBuffer (O(N)) when concatenating a million strings.
        Approach:
Using String (Immutable, creates new object each time)
Using StringBuilder (Fast, mutable, thread-unsafe)
Using StringBuffer (Thread-safe, slightly slower than StringBuilder)
*/



package com.week3.day6AlgorithmRuntimeAnalysis;

public class StringConcatenationPerformance {
    public static void main(String[] args) {
            int[] iterations = {1000, 10000, 1000000};

            System.out.println("String Concatenation Performance Benchmark:");
            System.out.println("------------------------------------------");

            for (int iterationCount : iterations) {
                System.out.println("\nIterations: " + iterationCount);
                runBenchmark(iterationCount);
            }
        }

        public static void runBenchmark(int iterations) {
            System.out.printf("  String: %.6f s\n", stringConcatenation(iterations));
            System.out.printf("  StringBuilder: %.6f s\n", stringBuilderConcatenation(iterations));
            System.out.printf("  StringBuffer: %.6f s\n", stringBufferConcatenation(iterations));
        }

        public static double stringConcatenation(int iterations) {
            long startTime = System.nanoTime();
            String result = "";
            for (int i = 0; i < iterations; i++) {
                result += "a";
            }
            long endTime = System.nanoTime();
            // Convert nanoseconds to seconds
            return (double)(endTime - startTime) / 1_000_000_000.0;
        }

        public static double stringBuilderConcatenation(int iterations) {
            long startTime = System.nanoTime();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < iterations; i++) {
                stringBuilder.append("a");
            }
            // Ensure the string is materialized
            stringBuilder.toString();
            long endTime = System.nanoTime();
            // Convert nanoseconds to seconds
            return (double)(endTime - startTime) / 1_000_000_000.0;
        }

        public static double stringBufferConcatenation(int iterations) {
            long startTime = System.nanoTime();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < iterations; i++) {
                stringBuffer.append("a");
            }
            // Ensure the string is materialized
            stringBuffer.toString();
            long endTime = System.nanoTime();
            return (double)(endTime - startTime) / 1_000_000_000.0; // Convert nanoseconds to seconds
        }
}


