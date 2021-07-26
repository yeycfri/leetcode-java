# 排序

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

## 3. 插入排序 O(n^2)

## 4. 堆排序 O(nlogn)

## 5. 快速排序

## 6. 归并排序 (Merge Sort)

## 7. 希尔排序

## 8. 计数排序 (Counting Sort)

## 9. 基数排序 (Radix Sort)

## 10. 桶排序 (Bucket Sort)

|题目|难度||
|---|---|---|
|[剑指 Offer 45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)|中等
|