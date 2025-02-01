package com.week3.day2StackQueueHashMap;


import java.util.Stack;

class StockSpan {
    // Method to calculate stock span
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n]; // Array to store span values
        Stack<Integer> stack = new Stack<>(); // Stack to store indices of prices

        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and the price at stack's top index is <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            // If stack is empty, it means no previous greater element exists, so span = i + 1
            // Otherwise, span is the difference between the current index and the last higher price's index
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());

            // Push current index onto the stack
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);

        // Print the price along with its span
        System.out.println("Price  -> Span");
        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i] + " -> " + span[i]);
        }
    }
}


