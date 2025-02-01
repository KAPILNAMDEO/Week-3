package com.week3.day2StackQueueHashMap;

import java.util.Stack;

public class SortStackRecursively {

    // Function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop(); // Remove the top element
            sortStack(stack); // Recursively sort the remaining stack
            insertSorted(stack, temp); // Insert the popped element back in sorted order
        }
    }

    // Helper function to insert an element into the sorted stack
    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            insertSorted(stack, element);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}

