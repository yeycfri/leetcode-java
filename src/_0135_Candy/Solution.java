package _0135_Candy;

public class Solution {
    // 两次遍历
    public int candy1(int[] ratings) {
        int n = ratings.length;
        int[] cd = new int[n];
        cd[0] = 1;
        for (int i = 1; i < n; i++) {
            cd[i] = (ratings[i] > ratings[i - 1]) ? cd[i - 1] + 1 : 1;
        }
        int sum = cd[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                cd[i] = Math.max(cd[i], cd[i + 1] + 1);
            }
            sum += cd[i];
        }
        return sum;
    }

    public int candy(int[] ratings) {
        int n = ratings.length;

        int sum = 1, increasing = 1, decreasing = 0, cur = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                cur = (ratings[i] == ratings[i - 1]) ? 1 : cur + 1;
                sum += cur;
                increasing = cur;
                decreasing = 0;
            } else {
                decreasing++;
                if (decreasing == increasing) {
                    decreasing++;
                }
                sum += decreasing;
                cur = 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.candy(new int[]{1, 3, 2, 2, 1}));
        System.out.println(solution.candy(new int[]{1, 0, 2}));
    }
}
