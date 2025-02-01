package com.week3.day2StackQueueHashMap;

import java.util.*;

class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Output array to store max of each window
        Deque<Integer> deque = new LinkedList<>(); // Double-ended queue to store indices

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of this window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements from back that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current element index
            deque.offerLast(i);

            // Store result once we have a full window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxValues = maxSlidingWindow(arr, k);

        System.out.println("Maximum elements in each sliding window:");
        System.out.println(Arrays.toString(maxValues));
    }
}

