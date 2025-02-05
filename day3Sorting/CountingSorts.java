package com.week3.day3Sorting;

import java.util.Arrays;

public class CountingSort {
    // Function to perform counting sort on student ages
    public static void countingSort(int[] ages, int minAge, int maxAge) {
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        // Count occurrences of each age
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in their correct position in the output array
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        // Copy sorted elements back to the original array
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    // Main method to test the counting sort implementation
    public static void main(String[] args) {
        int[] ages = {12, 14, 10, 18, 16, 12, 14, 17, 11, 15, 13, 10, 16};
        System.out.println("Original Ages: " + Arrays.toString(ages));

        countingSort(ages, 10, 18);

        System.out.println("Sorted Ages: " + Arrays.toString(ages));
    }
}
