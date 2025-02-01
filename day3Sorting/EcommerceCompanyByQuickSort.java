package com.week3.day3Sorting;

/*
4. Quick Sort - Sort Product Prices

Problem Statement:
An e-commerce company wants to display product prices in ascending order.
Implement Quick Sort to sort the product prices.

Hint:
- Pick a pivot element (first, last, or random).
- Partition the array such that elements smaller than the pivot are on the left and larger ones are on the right.
- Recursively apply Quick Sort on left and right partitions.
*/

import java.util.Arrays;

public class EcommerceCompanyByQuickSort {

    // Partition function to rearrange elements based on pivot
    static int partition(double productPrices[], int low, int high) {
        double pivot = productPrices[high]; // Choose last element as pivot
        int i = low - 1; // Index for smaller elements

        // Traverse through the array and compare elements with pivot
        for (int j = low; j < high; j++) {
            if (productPrices[j] < pivot) { // If element is smaller than pivot
                i++; // Move the smaller element index forward

                // Swap productPrices[i] and productPrices[j]
                double temp = productPrices[i];
                productPrices[i] = productPrices[j];
                productPrices[j] = temp;
            }
        }

        // Place pivot in its correct sorted position
        i++;
        double temp = productPrices[i];
        productPrices[i] = pivot;
        productPrices[high] = temp;

        return i; // Return the index of the pivot element
    }

    // Recursive QuickSort function
    static void sortProductPrices(double productPrices[], int low, int high) {
        if (low < high) { // Base condition: if low >= high, stop recursion

            // Partition the array and get pivot index
            int pivotIndex = partition(productPrices, low, high);

            // Recursively sort elements before and after pivot
            sortProductPrices(productPrices, low, pivotIndex - 1);
            sortProductPrices(productPrices, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        // Initialize product prices array
        double productPrices[] = {143.0, 152.2, 133.2, 170.6, 163.5};
        int n = productPrices.length; // Get the size of the array

        // Call QuickSort function to sort the array
        sortProductPrices(productPrices, 0, n - 1);

        // Print the sorted product prices
        System.out.println(Arrays.toString(productPrices));
    }
}

