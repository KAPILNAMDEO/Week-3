package com.week3.day2StackQueueHashMap;

import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stackIn;  // Stack for enqueue
    private Stack<Integer> stackOut; // Stack for dequeue

    public QueueUsingStacks() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // Enqueue operation: Push to stackIn
    public void enqueue(int x) {
        System.out.println("Enqueuing: " + x);
        stackIn.push(x);
    }

    // Dequeue operation: Pop from stackOut, transferring from stackIn if necessary
    public int dequeue() {
        if (stackOut.isEmpty()) {
            // Transfer elements from stackIn to stackOut, reversing the order
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        // If stackOut is still empty, the queue is empty
        if (stackOut.isEmpty()) {
            System.err.println("Queue is empty!");
            return -1; // Return an error value
        }

        int dequeued = stackOut.pop();
        System.out.println("Dequeuing: " + dequeued);
        return dequeued;
    }

    // Peek operation: Look at the front of the queue
    public int peek() {
        if (stackOut.isEmpty()) {
            // Transfer elements from stackIn to stackOut if stackOut is empty
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        // If stackOut is empty, the queue is empty
        if (stackOut.isEmpty()) {
            System.err.println("Queue is empty!");
            return -1; // Return an error value
        }

        System.out.println("Peeking: " + stackOut.peek());
        return stackOut.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // Print the contents of the queue
    public void print() {
        System.out.print("Queue contents: ");
        // First, print elements from stackOut (the front part of the queue)
        for (int i = stackOut.size() - 1; i >= 0; i--) {
            System.out.print(stackOut.get(i) + " ");
        }

        // Then, print elements from stackIn (the back part of the queue)
        for (int i = 0; i < stackIn.size(); i++) {
            System.out.print(stackIn.get(i) + " ");
        }

        System.out.println();  // Newline after printing the queue
    }
}

public class QueueWithStacksDemo {
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.print();  // Output: 1 2 3

        System.out.println(queue.dequeue()); // Output: 1
        queue.print();  // Output: 2 3

        System.out.println(queue.peek());    // Output: 2
        queue.enqueue(4);
        queue.print();  // Output: 2 3 4

        System.out.println(queue.dequeue()); // Output: 2
        queue.print();  // Output: 3 4

        System.out.println("Both queue is empty: " + queue.isEmpty()); // false
    }
}

