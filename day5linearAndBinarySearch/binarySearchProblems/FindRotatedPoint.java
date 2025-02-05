
/*Binary Search Problem 1: Find the Rotation Point in a Rotated Sorted Array
Problem:
You are given a rotated sorted array. Write a program that performs Binary Search to find the index of the smallest
element in the array (the rotation point).
Approach:
Initialize left as 0 and right as n - 1.
Perform a binary search:
Find the middle element mid = (left + right) / 2.
If arr[mid] > arr[right], then the smallest element is in the right half, so update left = mid + 1.
If arr[mid] < arr[right], the smallest element is in the left half, so update right = mid.
Continue until left equals right, and then return arr[left] (the rotation point).*/
package com.week3.day5linearAndBinarySearch.binarySearchProblems;
public class FindRotatedPoint {
    //method to find rotated point
    public static int rotatedPoint(int []array){
        int n=array.length;
        int left=0;
        int right =n-1;

        while (left<right){
            int middle=(left+right)/2;
            //If arr[mid] > arr[right], then the smallest element is in the right half, so update left = mid + 1.
            if(array[middle]>array[right]){
                left=middle+1;
            }
            //If arr[mid] < arr[right], the smallest element is in the left half, so update right = mid.
            if(array[middle]<array[right]){
                right=middle;
            }
        }
        //Continue until left equals right, and then return arr[left] (the rotation point).*/
        return left;

    }
    public static void main(String[] args) {
        int[] array = {15, 18, 1,2, 3, 6, 12};
        int rotationPoint=rotatedPoint(array);
        System.out.println("The rotation point index is: " + rotationPoint);
        System.out.println("The smallest element is: " + array[rotationPoint]);

    }
}
