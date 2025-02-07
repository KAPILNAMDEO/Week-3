package com.week3.day6AlgorithmRuntimeAnalysis;

import java.util.Arrays;
import java.util.Random;

public class SortingCompare {

    // Bubble Sort (O(N²))
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort (O(N log N))
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) arr[k++] = leftArray[i++];
            else arr[k++] = rightArray[j++];
        }
        while (i < leftArray.length) arr[k++] = leftArray[i++];
        while (j < rightArray.length) arr[k++] = rightArray[j++];
    }

    // Quick Sort (O(N log N))
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10_000, 1_000_000};  // Different dataset sizes
        Random rand = new Random();

        for (int N : datasetSizes) {
            int[] data1 = new int[N], data2 = new int[N], data3 = new int[N];

            // Fill the arrays with random numbers
            for (int i = 0; i < N; i++) {
                int value = rand.nextInt(N * 10); // Random values up to 10N
                data1[i] = value;
                data2[i] = value;
                data3[i] = value;
            }

            // Measure Bubble Sort time
            long startTime = System.nanoTime();
            if (N <= 10_000) { // Bubble Sort is too slow for large N
                bubbleSort(data1);
            }
            long bubbleTime = System.nanoTime() - startTime;

            // Measure Merge Sort time
            startTime = System.nanoTime();
            mergeSort(data2, 0, N - 1);
            long mergeTime = System.nanoTime() - startTime;

            // Measure Quick Sort time
            startTime = System.nanoTime();
            quickSort(data3, 0, N - 1);
            long quickTime = System.nanoTime() - startTime;

            // Print results
            System.out.println("Dataset Size: " + N);
            if (N <= 10_000) {
                System.out.println("Bubble Sort Time: " + bubbleTime / 1_000_000.0 + " ms");
            } else {
                System.out.println("Bubble Sort: Too slow to measure (>1hr)");
            }
            System.out.println("Merge Sort Time: " + mergeTime / 1_000_000.0 + " ms");
            System.out.println("Quick Sort Time: " + quickTime / 1_000_000.0 + " ms");
            System.out.println("---------------------------------");
        }
    }
}

