package Design._0155_Min_Stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> data, min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        data.push(val);
        if (min.isEmpty() || min.peek() > val) {
            min.push(val);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
