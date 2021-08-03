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

