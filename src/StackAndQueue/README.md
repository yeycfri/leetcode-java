# 栈与队列

|题目|难度||
|---|---|---|
|[622. 设计循环队列](https://leetcode-cn.com/problems/design-circular-queue/)|中等
|[20. 有效的括号](https://leetcode-cn.com/problems/valid-parentheses/)|简单|√|
|[71. 简化路径](https://leetcode-cn.com/problems/simplify-path/)|中等|√|
|[150. 逆波兰表达式求值](https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/)|中等|√|

# 单调栈

单调栈主要解决以下问题：

- 寻找下一个更大元素
- 寻找前一个更大元素
- 寻找下一个更小元素
- 寻找前一个更小元素
- qualified 的 窗口的 max/min
- sliding window max/min

基本模式：

``` java
for (E e : elements) {
    while (!stack.isEmpty() && stack.peek() > target) {
        stack.pop();
        doSomething();
    }
    stack.push(e);
}
```

|题目|难度||
|---|---|---|
|[496. 下一个更大元素 I](https://leetcode-cn.com/problems/next-greater-element-i/)|简单|√|
|[503. 下一个更大元素 II](https://leetcode-cn.com/problems/next-greater-element-ii/)|中等|√|
|[42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)|困难|√|
|[84. 柱状图中最大的矩形](https://leetcode-cn.com/problems/largest-rectangle-in-histogram/)|困难|√|
|[739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)|中等|√|
|[901. 股票价格跨度](https://leetcode-cn.com/problems/online-stock-span/)|中等|√|

# 单调队列

单调 + 双端队列

``` java
for (E e : elements) {
    while (!deque.isEmpty() && deque.peekLast() < target) {
        deque.pollLast();
    }
    deque.offerLast(e);
    
    // 此时队首为最大值
    doSomething(deque.peekFirst());
}
```

与滑动窗口结合时，一般单调队列中会保存下标，用于从队首弹出窗口外的元素。

|题目|难度||
|---|---|---|
|[239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)|困难|√|
|[1438. 绝对差不超过限制的最长连续子数组](https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/)|中等|√|
|[剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)|困难|√|
|[剑指 Offer 59 - II. 队列的最大值](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/)|中等|√|
|[1696. 跳跃游戏 VI](https://leetcode-cn.com/problems/jump-game-vi/)|中等|√|
|[862. 和至少为 K 的最短子数组](https://leetcode-cn.com/problems/shortest-subarray-with-sum-at-least-k/)|困难|√|
|[918. 环形子数组的最大和](https://leetcode-cn.com/problems/maximum-sum-circular-subarray/)|中等|√|
