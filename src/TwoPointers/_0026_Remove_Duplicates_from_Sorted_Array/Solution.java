package TwoPointers._0026_Remove_Duplicates_from_Sorted_Array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0, n = nums.length;
        while (r < n) {
            if (nums[l] != nums[r])
                nums[++l] = nums[r];
            r++;
        }
        return l + 1;
    }
}
