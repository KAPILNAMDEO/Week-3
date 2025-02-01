package com.week3.day2StackQueueHashMap.hashmapProgram;

/*Longest Consecutive Sequence
Problem: Given an unsorted array, find the length of the longest consecutive elements sequence.
Hint: Use a hash map to store elements and check for consecutive elements efficiently.*/



import java.util.HashMap;

public class LongestConsecutiveSequance {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                // Check for consecutive sequences using the HashMap
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;

                // The length of the current sequence
                int currentLength = left + 1 + right;

                // Update the longest sequence found
                maxLength = Math.max(maxLength, currentLength);

                // Update the map with the new lengths of the sequences
                map.put(num, currentLength);
                map.put(num - left, currentLength);
                map.put(num + right, currentLength);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequance longestConsecutiveSequence = new LongestConsecutiveSequance();
        int[] nums = {100, 4, 1, 1, 1, 2};
        System.out.println("Length of Longest Consecutive Sequence: " + longestConsecutiveSequence.longestConsecutive(nums));
    }
}
