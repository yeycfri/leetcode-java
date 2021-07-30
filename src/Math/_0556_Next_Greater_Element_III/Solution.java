package Math._0556_Next_Greater_Element_III;

public class Solution {
    public int nextGreaterElement(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int i = s.length - 2;
        while (i >= 0 && s[i] >= s[i + 1]) {
            i--;
        }
        int j = s.length - 1;
        while (j >= 0 && s[j] <= s[i]) {
            j--;
        }
        swap(s, i, j);
        reverse(s, i + 1, s.length - 1);
        try {
            return Integer.parseInt(new String(s));
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l++, r--);
        }
    }
}
