/*Linear Search Problem 1: Search for the First Negative Number
Problem:
You are given an integer array. Write a program that performs Linear Search to find the first negative number in the array.
If a negative number is found, return its index. If no negative number is found, return -1.
Approach:
Iterate through the array from the start.
Check if the current element is negative.
If a negative number is found, return its index.
If the loop completes without finding a negative number, return -1.
*/
package com.week3.day5linearAndBinarySearch.linearSearchProblems;


public class SearchFirstNegativeNumber {

    // Function to find the first negative number's index
    static int findFirstNegative(int array[]) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                return i; // Return index of the first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }

    public static void main(String[] args) {
        // Test case: array with positive and negative numbers
        int array[] = {10, 20, -6, -17, 30, 15, 46, 17, 22};

        // Print the index of the first negative number
        System.out.println("Index of first negative number: " + findFirstNegative(array));
    }
}


