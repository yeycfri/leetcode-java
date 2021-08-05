# 数学

## 1. 牛顿迭代法求平方根

设有方程 y = x^2 - C，一次导数 f'(x) = 2x，求根即为函数与 x 轴交点处 x 值。

![newton.png](../../resources/newton.png)

从 x0 = C 处开始迭代，作切线，切线斜率为 2x0，切线方程为 y = 2x0(x - x0) + x0^2 - C。

令 y = 0，可求得下一迭代点 x1 = (x0 + C / x0) / 2。

则有递推公式代码：`sqrt = (sqrt + C / sqrt) / 2;`

``` java
public int sqrt(int x) {
    long sqrt = x;
    while (sqrt * sqrt > x) {
        sqrt = (sqrt + x / sqrt) >> 1;
    }
    return (int) sqrt;
}
```

## 2. 随机抽样

### 2.1 均匀随机抽样

假设集合 S 有 n 个元素，设计算法随机选 k 个数，使得每个元素被选中的概率都是 1/n。一个朴素的想法，生成 k 个不重复的 [1,n] 之间的随机数为索引，然后找到索引对应的节点。

思考：当 n 很大、或者未知、甚至是一个无限数据流时，如何高效随机抽样？

#### 蓄水池抽样算法

该算法适用于 n 很大或者未知或者无限，不能把所有 n 个元素都存放到内存的情况，只需全部遍历一次，时间复杂度为 O(n)。

1. 假设 k = 1。抽样方法：流式遍历集合，遇到第 i 个元素时，以 `1/i` 的概率选择该元素，则有 `1 - 1/i` 的概率保留原选择。 证明：该方法能保证每个元素被选到的概率为 `1/n`，对于第 i
   个元素，它被选择的概率公式如下。

![reservoir-1.png](../../resources/reservoir-1.png)

代码实现：

``` java
int getRandom(Iterator itr) {
    Random r = new Random();
    int i = 0, res = 0;
    while (itr.hasNext()) {
        int val = itr.next();
        
        // 生成一个 [0, i) 之间的整数
        // 这个整数等于 0 的概率就是 1/i
        if (r.nextInt(++i) == 0) res = val;
    }
    return res;
}
```

2. 假设 k = 2。抽样方法：流式遍历集合，遇到第 i 个元素时，以 `k/i` 的概率选择该元素，则有 `1 - k/i` 的概率保留原选择。 证明：该方法能保证每个元素被选到的概率为 `k/n`，对于第 i
   个元素，它被选择的概率公式如下。

![reservoir-2.png](../../resources/reservoir-2.png)

``` java
int[] getRandom(Iterator itr, int k) {
    Random r = new Random();
    int[] res = new int[k];

    // 前 k 个元素先默认选上
    for (int j = 0; j < k && itr.hasNext(); j++)
        res[j] = itr.next();

    int i = k;
    while (itr.hasNext()) {
        int val = itr.next();
        
        // 生成一个 [0, i) 之间的整数
        // 这个整数小于 k 的概率就是 k/i
        int j = r.nextInt(++i);
        if (j < k) res[j] = val;
    }
    return res;
}
```

|题目|难度||
|---|---|---|
|[382. 链表随机节点](https://leetcode-cn.com/problems/linked-list-random-node/)|中等|√|
|[398. 随机数索引](https://leetcode-cn.com/problems/random-pick-index/)|中等|√|
|[497. 非重叠矩形中的随机点](https://leetcode-cn.com/problems/random-point-in-non-overlapping-rectangles/)|中等|√|
|[519. 随机翻转矩阵](https://leetcode-cn.com/problems/random-flip-matrix/)|中等|√|

### 2.2 加权随机抽样

假设集合 S 有 n 个元素，每个元素有权重 wi，加权随机抽样 k 个数。

#### A-Res

*TODO*

#### A-ExpJ

*TODO*

## 3. 洗牌算法

jdk8 源码写法：

``` java
for (int i = size; i > 1; i--)
   swap(arr, i - 1, r.nextInt(i));
```

分析洗牌算法正确性的准则：产生的结果必须有 n! 种可能，否则就是错误的。一个长度为 n 的数组的全排列有 n! 种，也就是说打乱结果总共有 n! 种。算法必须能够反映这个事实，才是正确的。

### 蒙特卡罗方法验证正确性

- 思路一：我们把数组 arr 的所有排列组合都列举出来。每次进行洗牌算法后，把得到的打乱结果对应的频数加一，重复进行 100 万次，如果每种结果出现的总次数差不多，那就说明每种结果出现的概率应该是相等的。
- 思路二：令数组中全都是 0，只有一个 1。对数组进行 100 万次打乱，记录每个索引位置出现 1 的次数，如果每个索引出现的次数差不多，也可以说明每种打乱结果的概率是相等的。

|题目|难度||
|---|---|---|
|[384. 打乱数组](https://leetcode-cn.com/problems/shuffle-an-array/)|中等|√|
