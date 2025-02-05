/*Binary Search Problem 4: Find the First and Last Occurrence of an Element in a Sorted Array
Problem:
Given a sorted array and a target element, write a program that uses Binary Search to find the first and last occurrence of the target element in the array. If the element is not found, return -1.
Approach:
Use binary search to find the first occurrence:
Perform a regular binary search, but if the target is found, continue searching on the left side (right = mid - 1) to find the first occurrence.
Use binary search to find the last occurrence:
Similar to finding the first occurrence, but once the target is found, continue searching on the right side (left = mid + 1) to find the last occurrence.
Return the indices of the first and last occurrence. If not found, return -1.*/

package com.week3.day5linearAndBinarySearch.binarySearchProblems;

public class TargetValueInTwoDMatrix {
    public static boolean searchMatrix(int matrix[][],int target){
        int rows=matrix.length;
        int columns=matrix[0].length;
        int left=0,right=rows*columns-1;

        while(left<=right){
            int middle=left+(right-left)/2;
            // Convert mid index to row and column
            int row=middle/columns;
            int column=middle%columns;
            int midElement=matrix[row][column];
            if (midElement == target) {
                return true; // Target found
            } else if (midElement < target) {
                left = middle + 1; // Search right half
            } else {
                right = middle - 1; // Search left half
            }
        }
        return false;//target not find;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println("Is target present? " + searchMatrix(matrix, target));
    }
}
