package com;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by chengcheng on 8/31/16.
 */
public class ImplementStackUsingQueues {
    public static void main(String[] args) {

    }

    Queue<Integer> queue = new ArrayDeque<>();
    public void push(int x) {
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue.size() == 0) return;
        if (queue.size() == 1) queue.poll();

        Queue<Integer> tmpQueue = new ArrayDeque<>();

        while (queue.size() > 1) {
            tmpQueue.add(queue.poll());
        }
        queue.poll();
        queue = tmpQueue;
    }

    // Get the top element.
    public int top() {
        if (queue.size() == 1) return queue.peek();

        Queue<Integer> tmp = new ArrayDeque<>();
        while (queue.size() > 1) {
            tmp.add(queue.poll());
        }
        int top = queue.peek();
        tmp.add(queue.poll());
        queue = tmp;
        return top;



    }

    // Return whether the stack is empty.
    public boolean empty() {
        if (queue.isEmpty()) {
            return true;
        }
        return false;
    }
}
