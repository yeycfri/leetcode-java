package Design._0703_Kth_Largest_Element_in_a_Stream;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {

    private int k;
    private Queue<Integer> heap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (heap.size() < k) {
            heap.add(val);
        } else if (val > heap.peek()) {
            heap.poll();
            heap.add(val);
        }
        return heap.peek();
    }
}
