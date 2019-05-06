package com.alg.array;

import java.util.Stack;

public class StackQueue {

    Stack<Integer> stack1 = new Stack<Integer>(); //for push
    Stack<Integer> stack2 = new Stack<Integer>(); //for pop

    public void queue(int node) {
        stack1.push(node);
    }

    public int dequeue() {
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            if (stack1.empty()) {
                throw new RuntimeException("empty queue");
            } else {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
                return stack2.pop();
            }
        }
    }
}
