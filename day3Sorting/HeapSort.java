package com.week3.day3Sorting;

import java.util.Arrays;

public class HeapSort {
    // Function to perform heap sort
    public static void heapSort(int[] salaries) {
        int n = salaries.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            swap(salaries, 0, i);

            // Heapify the reduced heap
            heapify(salaries, i, 0);
        }
    }

    // Function to heapify a subtree with root at index i
    private static void heapify(int[] salaries, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If left child is larger than root
        if (left < n && salaries[left] > salaries[largest]) {
            largest = left;
        }

        // If right child is larger than largest so far
        if (right < n && salaries[right] > salaries[largest]) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            swap(salaries, i, largest);

            // Recursively heapify the affected subtree
            heapify(salaries, n, largest);
        }
    }

    // Utility function to swap two elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main method to test the heap sort implementation
    public static void main(String[] args) {
        int[] salaries = {50000, 70000, 40000, 60000, 80000, 30000};
        System.out.println("Original Salary Demands: " + Arrays.toString(salaries));

        heapSort(salaries);

        System.out.println("Sorted Salary Demands: " + Arrays.toString(salaries));
    }
}

