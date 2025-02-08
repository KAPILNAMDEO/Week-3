/*
5. Problem Statement: Recursive vs Iterative Fibonacci Computation
Objective:
Compare Recursive (O(2ⁿ)) vs Iterative (O(N)) Fibonacci solutions.
Approach:
Recursive:
public static int fibonacciRecursive(int n) {
    if (n <= 1) return n;
    return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

Iterative:
public static int fibonacciIterative(int n) {
    int a = 0, b = 1, sum;
    for (int i = 2; i <= n; i++) {
        sum = a + b;
        a = b;
        b = sum;
    }
    return b;
}

 */
package com.week3.day6AlgorithmRuntimeAnalysis;

public class RecursiveVsIterativeFibonacci {

    // Recursive approach
    public static long fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative approach
    public static long fibonacciIterative(int n) {
        if (n <= 1) {
            return n; // Return n directly
        }

        long a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] iterations = {10, 30, 50}; // Use these values to check the difference

        System.out.println("Fibonacci Performance Benchmark:");
        System.out.println("-------------------------------");

        for (int n : iterations) {
            System.out.println("\nCalculating Fibonacci(" + n + "):");

            // Measure Recursive Time
            double recursiveDuration = 0.0;
            long recursiveResult = -1;
            if (n <= 40) { // Limit recursion due to exponential growth
                long startRecursive = System.nanoTime();
                recursiveResult = fibonacciRecursive(n);
                long endRecursive = System.nanoTime();
                recursiveDuration = (endRecursive - startRecursive) / 1_000_000.0;
                System.out.println("  Recursive: Result = " + recursiveResult +
                        ", Time = " + String.format("%.3f", recursiveDuration) + " ms");
            } else {
                System.out.println("  Recursive: Skipped (Too slow for large n)");
            }

            // Measure Iterative Time
            long startIterative = System.nanoTime();
            long iterativeResult = fibonacciIterative(n);
            long endIterative = System.nanoTime();
            double iterativeDuration = (endIterative - startIterative) / 1_000_000.0;
            System.out.println("  Iterative: Result = " + iterativeResult +
                    ", Time = " + String.format("%.3f", iterativeDuration) + " ms");

        }
    }
}




