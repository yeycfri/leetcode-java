# 栈与队列

|题目|难度||
|---|---|---|
|[622. 设计循环队列](https://leetcode-cn.com/problems/design-circular-queue/)|中等

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
|[739. 每日温度](https://leetcode-cn.com/problems/daily-temperatures/)|中等|√|
|[901. 股票价格跨度](https://leetcode-cn.com/problems/online-stock-span/)|中等|√|

# 单调队列

|题目|难度||
|---|---|---|
|[239. 滑动窗口最大值](https://leetcode-cn.com/problems/sliding-window-maximum/)|困难|√|
