# 前缀和

前缀和思想：预处理前缀和数组，来解决区间查询的问题，前提是运算函数必须满足结合律（比如平均数就不满足结合律）。于是区间求值的问题就变成了：

S[m..n] = S[0..n] - S[0..m-1]

其中，S[0..n] = Sn = A0 + A1 + A2 + ... + An-1;

![prefix-sum.png](../../resources/prefix-sum.png)

前缀和预处理：

``` java
int[] P = new int[nums.length + 1];
for (int i = 0; i < nums.length; i++) {
      P[i + 1] = P[i] + nums[i];
 }
```

|题目|难度||
|---|---|---|
|[724. 寻找数组的中心下标](https://leetcode-cn.com/problems/find-pivot-index/)|简单|√|
|[560. 和为K的子数组](https://leetcode-cn.com/problems/subarray-sum-equals-k/)|中等|√|
|[930. 和相同的二元子数组](https://leetcode-cn.com/problems/binary-subarrays-with-sum/)|中等|√|
|[1248. 统计「优美子数组」](https://leetcode-cn.com/problems/count-number-of-nice-subarrays/)|中等|√|
|[974. 和可被 K 整除的子数组](https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/)|中等
|[523. 连续的子数组和](https://leetcode-cn.com/problems/continuous-subarray-sum/)|中等
|[303. 区域和检索 - 数组不可变](https://leetcode-cn.com/problems/range-sum-query-immutable/)|简单
|[304. 二维区域和检索 - 矩阵不可变](https://leetcode-cn.com/problems/range-sum-query-2d-immutable/)|中等
|[238. 除自身以外数组的乘积](https://leetcode-cn.com/problems/product-of-array-except-self/)|中等
|[327. 区间和的个数](https://leetcode-cn.com/problems/count-of-range-sum/)|困难
|

## 1. 静态前缀和

## 2. 动态前缀和

## 3. 阶段前缀和

## 4. 阶段数量为固定数的前缀和

## 5. 树状数组