# 排序

1. 稳定性

排序算法的稳定性：假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，即在原序列中，r[i] = r[j]，且 r[i] 在 r[j] 之前，而在排序后的序列中，r[i] 仍在 r[j]
之前，则称这种排序算法是稳定的；否则称为不稳定的。

稳定性的意义：当要排序的内容是一个对象的多个属性，且其原本的顺序存在意义时，如果我们需要在二次排序后保持原有排序的意义，就需要使用到稳定性的算法。

举个例子，如果我们要对一组商品排序，商品存在两个属性：价格和销量。当我们按照价格从高到低排序后，要再按照销量对其排序，这时，如果要保证销量相同的商品仍保持价格从高到低的顺序，就必须使用稳定性算法。

## 0. 交换

``` java
private void swap(int[] arr, int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
}

// 可能溢出
private void swap(int[] arr, int i, int j) {
    arr[i] = arr[i] + arr[j];
    arr[j] = arr[i] - arr[j];
    arr[i] = arr[i] - arr[j];
}

private void swap(int[] arr, int i, int j) {
    if (i == j) return;
    arr[i] ^= arr[j];
    arr[j] ^= arr[i];
    arr[i] ^= arr[j];
}
```

## 1. 冒泡排序 O(n^2)

### 写法一

``` java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - 1 - i; j++) {
            if (arr[i] > arr[i + 1]) swap(arr, i, i + 1);
        }
    }
}
```

### 写法二

``` java
public void bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        boolean swaped = false;
        for (int j = 0; j < n - 1 - i; j++) {
            if (arr[i] > arr[i + 1]) {
                swaped = true;
                swap(arr, i, i + 1);
            }
        }
        if (!swaped) break;
    }
}
```

## 2. 选择排序 O(n^2)

``` java
public void selectSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
        int minIdx = i;
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIdx]) minIdx = j;
        }
        swap(arr, i, minIdx);
    }
}
```

### 优化：二元选择排序

内层循环同时选出来最小和最大，外层循环只需遍历一半。

``` java
public void selectSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n / 2; i++) {
        int minIdx = i;
        int maxIdx = i;
        for (int j = i + 1; j < n - i; j++) {
            if (arr[j] < arr[minIdx]) minIdx = j;
            if (arr[j] > arr[maxIdx]) maxIdx = j;
        }
        if (minIdx == maxIdx) break;
        swap(arr, i, minIdx);
        if (maxIdx == i) maxIdx = minIdx;
        swap(arr, n - i - 1, maxIdx);
    }
}
```

## 3. 插入排序 O(n^2)

- 交换法：在新数字插入过程中，不断与前面的数字交换，直到找到自己合适的位置。

``` java
public void insertSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int j = i;
        while (j > 0 && arr[j] > arr[j - 1]) {
            swap(arr, j, j - 1);
            j--;
        }
    }
}
```

- 移动法：在新数字插入过程中，与前面的数字不断比较，前面的数字不断向后挪出位置，当新数字找到自己的位置后，插入一次即可。

``` java
public void insertSort(int[] arr) {
    int n = arr.length;
    for (int i = 1; i < n; i++) {
        int num = arr[i];
        int j = i - 1;
        while (j >= 0 && arr[j] > num) {
            nums[j + 1] = nums[j]; 
            j--;
        }
        nums[j + 1] = num;
    }
}
```

## 4. 堆排序 O(nlogn)

## 5. 快速排序

## 6. 归并排序 (Merge Sort)

## 7. 希尔排序

## 8. 计数排序 (Counting Sort)

## 9. 基数排序 (Radix Sort)

## 10. 桶排序 (Bucket Sort)

|题目|难度||
|---|---|---|
|[912. 排序数组](https://leetcode-cn.com/problems/sort-an-array/)|中等||
|[剑指 Offer 45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)|中等|√|
|[147. 对链表进行插入排序](https://leetcode-cn.com/problems/insertion-sort-list/)|中等|√|