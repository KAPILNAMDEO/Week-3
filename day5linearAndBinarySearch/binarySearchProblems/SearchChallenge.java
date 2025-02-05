/*Challenge Problem (for both Linear and Binary Search)
Problem:
You are given a list of integers. Write a program that uses Linear Search to find the first missing positive integer in the list and Binary Search to find the index of a given target number.
Approach:
Linear Search for the first missing positive integer:
Iterate through the list and mark each number in the list as visited (you can use negative marking or a separate array).
Traverse the array again to find the first positive integer that is not marked.
Binary Search for the target index:
After sorting the array, perform binary search to find the index of the given target number.
Return the index if found, otherwise return -1*/

package com.week3.day5linearAndBinarySearch.binarySearchProblems;


import java.util.Arrays;

public class SearchChallenge {

    // Linear Search to find the first missing positive integer
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;

        // Step 1: Mark numbers (negative marking approach)
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with arr[arr[i] - 1]
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        // Step 2: Identify the first missing positive
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) {
                return i + 1;
            }
        }

        // If all values are present from 1 to n, return n+1
        return n + 1;
    }

    // Binary Search to find the index of a target number
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid; // Target found, return index
            } else if (arr[mid] < target) {
                left = mid + 1; // Search in right half
            } else {
                right = mid - 1; // Search in left half
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -1, 1};
        int target = 4;

        // Find first missing positive integer using Linear Search
        int missingPositive = findFirstMissingPositive(arr);
        System.out.println("First missing positive integer: " + missingPositive);

        // Sort the array for Binary Search
        Arrays.sort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));

        // Find target index using Binary Search
        int targetIndex = binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }
}

