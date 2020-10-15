package com.jonas.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用两个stack实现queue
 *
 * @author shenjy
 * @version 1.0
 * @date 2020-10-13
 */
public class MyQueue {
    private List<Integer> stack1;
    private List<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new ArrayList<>();
        stack2 = new ArrayList<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.add(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.remove(stack2.size() - 1);
        }

        for (int i = stack1.size() - 1; i >= 0; i--) {
            int x = stack1.remove(i);
            stack2.add(x);
        }
        return stack2.remove(stack2.size() - 1);
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.get(stack2.size() - 1);
        }

        for (int i = stack1.size() - 1; i >= 0; i--) {
            int x = stack1.remove(i);
            stack2.add(x);
        }
        if (0 < stack2.size()) {
            return stack2.get(stack2.size() - 1);
        } else {
            return stack1.get(stack1.size() - 1);
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}
