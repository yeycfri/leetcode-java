# 动态规划

## 动规五部曲

1. 确定dp数组以及下标的含义
2. 确定递推公式（状态转移公式）
3. 确定dp数组初始化
4. 确定遍历顺序
5. 举例推导dp数组

### 题目
|题目|难度||
|---|---|---|
|[509. 斐波那契数](https://leetcode-cn.com/problems/fibonacci-number/)|简单|√|
|[70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)|简单|√|
|[746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)|简单|√|
|[62. 不同路径](https://leetcode-cn.com/problems/unique-paths/)|中等|√|
|[63. 不同路径 II](https://leetcode-cn.com/problems/unique-paths-ii/)|中等|√|
|[343. 整数拆分](https://leetcode-cn.com/problems/integer-break/)|中等|√|
|[96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)|中等|√|
|[198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)|中等|√|
|[213. 打家劫舍 II](https://leetcode-cn.com/problems/house-robber-ii/)|中等|√|
|[337. 打家劫舍 III](https://leetcode-cn.com/problems/house-robber-iii/)|中等|√|
|[121. 买卖股票的最佳时机](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/)|简单|√|
|[122. 买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)|简单|√|
|[123. 买卖股票的最佳时机 III](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/)|困难|√|
|[188. 买卖股票的最佳时机 IV](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/)|困难|√|
|[309. 最佳买卖股票时机含冷冻期](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|中等|√|
|[714. 买卖股票的最佳时机含手续费](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/)|中等|

## 背包问题

![](https://camo.githubusercontent.com/5c5af3f54a3503cdb989ab1c28e2933202a33259608c70af0e72db5a858f14e6/68747470733a2f2f696d672d626c6f672e6373646e696d672e636e2f32303231303131373137313330373430372e706e67)

### 01背包

物品列表item[0..n]，重量列表weight[0..n]，价值列表value[0..n]，背包重量bagWeight，每个物品只能取一次或不取。

每个物品取或不取，dp[i][j]：从下标为[0..i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
常见递推公式：
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

可简化为一维，dp[i]：容量为i的背包，所背的物品价值可以最大为dp[i]。此时背包重量要倒序遍历：
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
|[698. 划分为k个相等的子集](https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/)|中等||
|[473. 火柴拼正方形](https://leetcode-cn.com/problems/matchsticks-to-square/)|中等||
|[494. 目标和](https://leetcode-cn.com/problems/target-sum/)|中等|√|
|[474. 一和零](https://leetcode-cn.com/problems/ones-and-zeroes/)|中等|√|

### 完全背包

物品列表item[0..n]，重量列表weight[0..n]，价值列表value[0..n]，背包重量bagWeight，每个物品能取无限次。

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

### 多重背包

物品列表item[0..n]，重量列表weight[0..n]，价值列表value[0..n]，数量列表amount[0..n]，背包重量bagWeight。

解决方法：
- 物品item_i有amount_i件可用，把amount_i件摊开，转化为01背包。
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

## 参考
- 代码随想录 [https://github.com/youngyangyang04/leetcode-master](https://github.com/youngyangyang04/leetcode-master)