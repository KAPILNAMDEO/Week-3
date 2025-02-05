/*Binary Search Problem 2: Find the Peak Element in an Array
Problem:
A peak element is an element that is greater than its neighbors. Write a program that performs Binary Search to find a peak element in an array. If there are multiple peak elements, return any one of them.
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1], arr[mid] is a peak element.
If arr[mid] < arr[mid - 1], then search the left half, updating right = mid - 1.
If arr[mid] < arr[mid + 1], then search the right half, updating left = mid + 1.
Continue until a peak element is found.*/
package com.week3.day5linearAndBinarySearch.binarySearchProblems;

public class FindPeakElement{
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        for (; left < right; ) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than the next element, search in the left half
            if (arr[mid] > arr[mid + 1]) {
                right = mid; // Move to the left half
            }
            // Otherwise, search in the right half
            else {
                left = mid + 1; // Move to the right half
            }
        }

        // Left now points to a peak element
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0}; // Example array
        int peakIndex = findPeakElement(arr);
        System.out.println("A peak element is at index: " + peakIndex);
        System.out.println("The peak element is: " + arr[peakIndex]);
    }
}

