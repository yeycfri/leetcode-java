package StackAndQueue._0901_Online_Stock_Span;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {

    int cur;
    Deque<Integer> pos;
    Deque<Integer> prc;

    public StockSpanner() {
        pos = new ArrayDeque<>();
        prc = new ArrayDeque<>();
        pos.push(0);
        prc.push(Integer.MAX_VALUE);
    }

    public int next(int price) {
        cur++;
        while (!prc.isEmpty() && prc.peek() <= price) {
            prc.pop();
            pos.pop();
        }
        int ans = cur - pos.peek();
        prc.push(price);
        pos.push(cur);
        return ans;
    }
}
