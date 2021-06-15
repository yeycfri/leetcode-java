package _0150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int i = -1;
        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack[--i] += stack[i + 1];
                    break;
                case "-":
                    stack[--i] -= stack[i + 1];
                    break;
                case "*":
                    stack[--i] *= stack[i + 1];
                    break;
                case "/":
                    stack[--i] /= stack[i + 1];
                    break;
                default:
                    stack[++i] = Integer.parseInt(s);
            }
        }
        return stack[i];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
    }
}
