# 二分查找

## 模版I

- 搜索区间：[left..right)
``` java
public int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length;
    while (left < right) {
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    // End Condition: left == right
    return -1;
}
```

## 模板II

- 搜索区间：[left..right]
``` java
public int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
    // End Condition: left == right + 1
    return -1;
}
```

## 模板III

``` java
public int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left + 1 < right){
        // Prevent (left + right) overflow
        int mid = left + ((right - left) >> 1);
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }
    // End Condition: left + 1 == right

    // Post-processing:
    if(nums[left] == target) return left;
    if(nums[right] == target) return right;
    return -1;
}
```

## 二区间

- 搜索区间：[left..right]
- 循环条件：left < right
- `left = mid + 1`与`right = mid`搭配
- `left = mid`与`right = mid - 1`搭配，mid向上取整
- 退出循环时，`left == right`
- 后处理，判断`nums[left]`是否符合要求

> 在写`if`语句的时候，通常把容易想到的、不容易出错的逻辑写在`if`里面，这样就把复杂的、容易出错的情况放在了`else`部分，这样编写代码不容易出错。

参考链接 <https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/>

### 示例
- 大于等于 target 的下标最小的元素
``` java
public int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int mid = left + ((right - left) >> 1);
        if (nums[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}
```

- 小于等于 target 的下标最大的元素
``` java
public int binarySearch(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
        int mid = left + ((right - left + 1) >> 1);
        if (nums[mid] > target) {
            right = mid - 1;
        } else {
            left = mid;
        }
    }
    return left;
}
```

## 题目

### 题型一：二分下标（在数组中查找符合条件的元素的下标）

一般而言这个数组是有序的，也可能是半有序的（旋转有序数组或者山脉数组）。

|题目|难度||
|---|---|---|
| [704. 二分查找](https://leetcode-cn.com/problems/binary-search/) | 简单 | √ |
| [74. 搜索二维矩阵](https://leetcode-cn.com/problems/search-a-2d-matrix/) | 中等 | √ |
| [240. 搜索二维矩阵 II](https://leetcode-cn.com/problems/search-a-2d-matrix-ii/) | 中等 | √ |
| [35. 搜索插入位置](https://leetcode-cn.com/problems/search-insert-position/) | 简单 | √ |
| [34. 在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | 中等 | √ |
| [33. 搜索旋转排序数组](https://leetcode-cn.com/problems/search-in-rotated-sorted-array/) | 中等 | √ |
| [81. 搜索旋转排序数组 II](https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/) | 中等 | √ |
| [153. 寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) | 中等 | √ |
| [154. 寻找旋转排序数组中的最小值 II](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/) | 困难 | √ |
| [300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/) | 中等 | √ |
| [275. H 指数 II](https://leetcode-cn.com/problems/h-index-ii/) | 中等 | √ |
| [852. 山脉数组的峰顶索引](https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/) | 简单 | √ |
|[162. 寻找峰值](https://leetcode-cn.com/problems/find-peak-element/)|中等|√|
| [1095. 山脉数组中查找目标值](https://leetcode-cn.com/problems/find-in-mountain-array/) | 困难 | √ |
| [4. 寻找两个正序数组的中位数](https://leetcode-cn.com/problems/median-of-two-sorted-arrays/) | 困难 ||
| [658. 找到 K 个最接近的元素](https://leetcode-cn.com/problems/find-k-closest-elements/) | 中等 ||

### 题型二：二分答案（在一个有范围的区间里搜索一个整数）

定位一个有范围的整数，这件事情也叫「二分答案」或者叫「二分结果」。如果题目要求的是一个整数，这个整数有明确的范围，可以考虑使用二分查找。

|题目|难度||
|---|---|---|
| [367. 有效的完全平方数](https://leetcode-cn.com/problems/valid-perfect-square/) | 简单 | √ |
| [69. x 的平方根](https://leetcode-cn.com/problems/sqrtx/) | 简单 | √ |
| [287. 寻找重复数](https://leetcode-cn.com/problems/find-the-duplicate-number/) | 中等 ||
| [374. 猜数字大小](https://leetcode-cn.com/problems/guess-number-higher-or-lower/) | 简单 ||
| [1300. 转变数组后最接近目标值的数组和](https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/) | 中等 ||

### 题型三：二分答案的升级版：判别条件需要遍历数组

|题目|难度||
|---|---|---|
| [410. 分割数组的最大值](https://leetcode-cn.com/problems/split-array-largest-sum/) | 困难 ||
| [875. 爱吃香蕉的珂珂](https://leetcode-cn.com/problems/koko-eating-bananas/) | 中等 ||
| [LCP 12. 小张刷题计划](https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua/) | 中等 ||
| [1482. 制作 m 束花所需的最少天数](https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/) | 中等 ||
| [1552. 两球之间的磁力](https://leetcode-cn.com/problems/magnetic-force-between-two-balls/) | 中等 ||
