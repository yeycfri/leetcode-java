package BinaryTree._1104_Path_In_Zigzag_Labelled_Binary_Tree;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new LinkedList<>();
        int h = 31 - Integer.numberOfLeadingZeros(label);
        int cur = label / 2;
        ans.add(label);
        while (cur != 0) {
            h--;
            int l = 1 << h, r = (2 << h) - 1;
            cur = r - (cur - l);
            ans.add(0, cur);
            cur /= 2;
        }
        return ans;
    }
}
