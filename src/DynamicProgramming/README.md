# 动态规划

## 1. 动规五部曲

1. 确定 dp 数组以及下标的含义
2. 确定递推公式（状态转移公式）
3. 确定 dp 数组初始化
4. 确定遍历顺序
5. 举例推导 dp 数组

### 题目

|题目|难度||
|---|---|---|
|[509. 斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/)|简单|√|
|[70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)|简单|√|
|[746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)|简单|√|
|[62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)|中等|√|
|[63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)|中等|√|
|[64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)|中等|√|
|[343. 整数拆分](https://leetcode-cn.com/problems/integer-break/)|中等|√|
|[96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)|中等|√|
|[338. 比特位计数](https://leetcode-cn.com/problems/counting-bits/)|简单|√|
|[10. 正则表达式匹配](https://leetcode-cn.com/problems/regular-expression-matching/)|困难|√|
|[32. 最长有效括号](https://leetcode-cn.com/problems/longest-valid-parentheses/)|困难|√|
|[312. 戳气球](https://leetcode-cn.com/problems/burst-balloons/)|困难|√|
|[91. 解码方法](https://leetcode-cn.com/problems/decode-ways/)|中等|√|

## 2. 背包问题

![](https://camo.githubusercontent.com/5c5af3f54a3503cdb989ab1c28e2933202a33259608c70af0e72db5a858f14e6/68747470733a2f2f696d672d626c6f672e6373646e696d672e636e2f32303231303131373137313330373430372e706e67)

### 2.1 01背包

物品列表 item[0..n]，重量列表 weight[0..n]，价值列表 value[0..n]，背包重量 bagWeight，每个物品只能取一次或不取。

每个物品取或不取，dp[i][j]：从下标为 [0..i] 的物品里任意取，放进容量为 j 的背包，价值总和最大是多少。 常见递推公式：

- 求价值最大：`dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);`
- 求排列组合数：`dp[i][j] += dp[i - 1][j - weight[i]];`

递推过程：

``` java
// 初始化后
for(int i = 1; i < weight.length; i++) { // 遍历物品
    for(int j = 0; j <= bagWeight; j++) { // 遍历背包容量
        if (j < weight[i]) dp[i][j] = dp[i - 1][j]; 
        else dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
    }
}
```

可简化为一维，dp[i]：容量为 i 的背包，所背的物品价值可以最大为 dp[i]。此时背包重量要倒序遍历：

``` java
// 初始化后
for(int i = 0; i < weight.length; i++) { // 遍历物品
    for(int j = bagWeight; j >= weight[i]; j--) { // 倒序遍历背包容量
        dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
    }
}
```

注意：*01背包的物品与容量遍历顺序不可互换，因为容量倒序遍历时，前面状态还未更新。*

|题目|难度||
|---|---|---|
|[416. 分割等和子集](https://leetcode-cn.com/problems/partition-equal-subset-sum/)|中等|√|
|[1049. 最后一块石头的重量 II](https://leetcode-cn.com/problems/last-stone-weight-ii/)|中等|√|
|[698. 划分为k个相等的子集](https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/)|中等|√|
|[473. 火柴拼正方形](https://leetcode-cn.com/problems/matchsticks-to-square/)|中等|√|
|[494. 目标和](https://leetcode-cn.com/problems/target-sum/)|中等|√|
|[474. 一和零](https://leetcode-cn.com/problems/ones-and-zeroes/)|中等|√|

### 2.2 完全背包

物品列表 item[0..n]，重量列表 weight[0..n]，价值列表 value[0..n]，背包重量 bagWeight，每个物品能取无限次。

01背包为了保证物品只用一次，背包容量要倒序遍历。完全背包的物品是可以添加多次的，所以背包容量正序遍历，即：

``` java
// 初始化后
for(int i = 0; i < weight.size(); i++) { // 遍历物品
    for(int j = weight[i]; j <= bagWeight ; j++) { // 正序遍历背包容量
        dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
    }
}
```

一维滚动数组情况下，完全背包的物品与容量遍历顺序确定：

- 求价值数，物品与容量遍历顺序可以互换。
- 求组合数，就是外层遍历物品，内层遍历容量。
- 求排列数，就是外层遍历容量，内层遍历物品。

|题目|难度||
|---|---|---|
|[518. 零钱兑换 II](https://leetcode-cn.com/problems/coin-change-2/)|中等|√|
|[377. 组合总和 Ⅳ](https://leetcode-cn.com/problems/combination-sum-iv/)|中等|√|
|[322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/)|中等|√|
|[279. 完全平方数](https://leetcode-cn.com/problems/perfect-squares/)|中等|√|
|[139. 单词拆分](https://leetcode-cn.com/problems/word-break/)|中等|√|

### 2.3 多重背包

物品列表 item[0..n]，重量列表 weight[0..n]，价值列表 value[0..n]，数量列表 amount[0..n]，背包重量 bagWeight。

解决方法：

- 物品 item_i 有 amount_i 件可用，把 amount_i 件摊开，转化为01背包。

``` java
for (int i = 0; i < amount.length; i++) {
    while (amount[i] > 1) { // amount[i]展开至保留到1
        weight.add(weight[i]);
        value.add(value[i]);
        amount[i]--;
    }
}
```

- 01背包最内层再遍历一次每种商品的个数。

``` java
for(int i = 0; i < weight.length; i++) { // 遍历物品
    for(int j = bagWeight; j >= weight[i]; j--) { // 遍历背包容量
        // 以上为01背包，然后再遍历物品个数
        for (int k = 1; k <= amount[i] && (j - k * weight[i]) >= 0; k++) { // 遍历物品个数
            dp[j] = max(dp[j], dp[j - k * weight[i]] + k * value[i]);
        }
    }
}
```

## 3. 打家劫舍

|题目|难度||
|---|---|---|
|[198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)|中等|√|
|[213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)|中等|√|
|[337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)|中等|√|

## 4. 股票问题

|题目|难度||
|---|---|---|
|[121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)|简单|√|
|[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)|简单|√|
|[123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)|困难|√|
|[188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)|困难|√|
|[309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|中等|√|
|[714. 买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)|中等|√|

## 5. 子序列问题

### 5.1 连续子序列

|题目|难度||
|---|---|---|
|[300. 最长递增子序列](https://leetcode-cn.com/problems/longest-increasing-subsequence/)|中等|√|
|[1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/)|中等|√|
|[1035. 不相交的线](https://leetcode-cn.com/problems/uncrossed-lines/)|中等|√|

### 5.2 不连续子序列

|题目|难度||
|---|---|---|
|[674. 最长连续递增序列](https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/)|简单|√|
|[718. 最长重复子数组](https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/)|中等|√|
|[53. 最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)|简单|√|

### 5.3 编辑距离

|题目|难度||
|---|---|---|
|[392. 判断子序列](https://leetcode-cn.com/problems/is-subsequence/)|简单|√|
|[115. 不同的子序列](https://leetcode-cn.com/problems/distinct-subsequences/)|困难|√|
|[583. 两个字符串的删除操作](https://leetcode-cn.com/problems/delete-operation-for-two-strings/)|中等|√|
|[72. 编辑距离](https://leetcode-cn.com/problems/edit-distance/)|困难|√|

### 5.4 回文

|题目|难度||
|---|---|---|
|[647. 回文子串](https://leetcode-cn.com/problems/palindromic-substrings/)|中等|√|
|[5. 最长回文子串](https://leetcode-cn.com/problems/longest-palindromic-substring/)|中等|√|
|[516. 最长回文子序列](https://leetcode-cn.com/problems/longest-palindromic-subsequence/)|中等|√|

## 参考

- 代码随想录 [https://github.com/youngyangyang04/leetcode-master](https://github.com/youngyangyang04/leetcode-master)