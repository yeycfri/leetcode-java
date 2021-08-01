package StackAndQueue.LCOF_59_II_Dui_Lie_De_Zui_Da_Zhi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> maxQueue;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        return maxQueue.isEmpty() ? -1 : maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value)
            maxQueue.pollLast();
        maxQueue.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty())
            return -1;
        int pop = queue.poll();
        if (pop == maxQueue.peekFirst())
            maxQueue.pollFirst();
        return pop;
    }
}
