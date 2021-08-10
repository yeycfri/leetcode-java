package StackAndQueue._0071_Simplify_Path;

public class Solution {
    public String simplifyPath(String path) {
        char[] c = path.toCharArray();
        int n = c.length;
        int[] stack = new int[n];
        int top = -1;
        for (int i = 0, j; i < n; i = j) {
            j = i + 1;
            if (c[i] == '/') continue;
            while (j < n && c[j] != '/') j++;
            int len = j - i;
            if (len == 1 && c[i] == '.') continue;
            if (len == 2 && c[i] == '.' && c[i + 1] == '.') {
                top = Math.max(-1, top - 1);
            } else {
                stack[++top] = (i << 16) ^ len;
            }
        }
        StringBuffer stringBuffer = new StringBuffer(n);
        for (int i = 0; i <= top; i++) {
            int begin = stack[i] >> 16, len = stack[i] & (65535);
            stringBuffer.append('/').append(c, begin, len);
        }
        return top == -1 ? "/" : stringBuffer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(solution.simplifyPath("/../"));
        System.out.println(solution.simplifyPath("/home/"));
    }
}
