package BinarySearch._1095_Find_in_Mountain_Array;

public class Solution {
    static class MountainArray {
        int[] arr;

        public MountainArray(int[] arr) {
            this.arr = arr;
        }

        public int length() {
            return arr.length;
        }

        public int get(int i) {
            return arr[i];
        }
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = maxIdx(mountainArr);
        int ans = search(target, 0, peak, mountainArr, false);
        if (ans != -1) return ans;
        return search(target, peak, mountainArr.length() - 1, mountainArr, true);
    }

    public int maxIdx(MountainArray mountainArr) {
        int n = mountainArr.length();
        int left = 0, right = n - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public int search(int target, int left, int right, MountainArray mountainArr, boolean isRightSide) {
        if ((right - left) == 0) return (mountainArr.get(left) == target) ? left : -1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int mmid = mountainArr.get(mid);
            if (mmid == target) {
                return mid;
            } else if ((!isRightSide && (mmid > target)) || (isRightSide && (mmid < target))) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findInMountainArray(2, new MountainArray(new int[]{1, 5, 2})));
    }
}
