package Stack._0225_Implement_Stack_using_Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue.offer(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        int size = queue.size() - 1;
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        int ele = this.pop();
        this.push(ele);
        return ele;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
