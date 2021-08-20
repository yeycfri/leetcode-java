package Array._0169_Majority_Element;

public class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0, cand = nums[0];
        for (int num : nums) {
            if (cnt == 0) cand = num;
            if (cand == num) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return cand;
    }
}
