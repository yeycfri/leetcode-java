# 排序

### 稳定性

排序算法的稳定性：假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，即在原序列中，r[i] = r[j]，且 r[i] 在 r[j] 之前，而在排序后的序列中，r[i] 仍在 r[j]
之前，则称这种排序算法是稳定的；否则称为不稳定的。

稳定性的意义：当要排序的内容是一个对象的多个属性，且其原本的顺序存在意义时，如果我们需要在二次排序后保持原有排序的意义，就需要使用到稳定性的算法。

举个例子，如果我们要对一组商品排序，商品存在两个属性：价格和销量。当我们按照价格从高到低排序后，要再按照销量对其排序，这时，如果要保证销量相同的商品仍保持价格从高到低的顺序，就必须使用稳定性算法。

### 排序算法性质总结

|排序算法|时间复杂度|空间复杂度|稳定性|
|:---:|:---:|:---:|:---:|
|冒泡排序|O(n^2)|O(1)|稳定|
|选择排序|O(n^2)|O(1)|不稳定|
|插入排序|O(n^2)|O(1)|稳定|
|希尔排序|O(n) ～ O(n^2)|O(1)|不稳定|
|堆排序|O(nlogn)|O(1)|不稳定|
|快速排序|O(nlogn) ～ O(n^2)|O(logn) ～ O(n)|不稳定|
|归并排序|O(nlogn)|O(n)|稳定|
|计数排序|O(n+k)|O(n+k)|稳定|
|基数排序|O(d(n+k))|O(n+k)|稳定|

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

## 4. 希尔排序 O(n) ～ O(n^2)

``` java
public void shellSort(int[] nums) {
    int n = nums.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i++) {
            int num = nums[i];
            int j = i - gap;
            while (j >= 0 && num < nums[j]) {
                nums[j + gap] = nums[j];
                j -= gap;
            }
            nums[j + gap] = num;
        }
    }
}
```

增量元素不互质，则小增量可能根本不起作用。

事实上，希尔排序时间复杂度非常难以分析，它的平均复杂度界于 O(n) 到 O(n^2) 之间，普遍认为它最好的时间复杂度为 O(n^1.3)。

## 5. 堆排序 O(nlogn)

完全二叉树：深度为 k，k-1 层为满二叉树，第 k 层叶子节点向左靠齐。

堆：符合以下两个条件之一的完全二叉树：

- 根节点的值 ≥ 子节点的值，这样的堆被称之为最大堆，或大顶堆；
- 根节点的值 ≤ 子节点的值，这样的堆被称之为最小堆，或小顶堆。

完全二叉树数组中，根节点的下标视为 0，则数组有如下性质：

- 对于完全二叉树中的第 i 个数，它的左子节点下标：left = 2i + 1
- 对于完全二叉树中的第 i 个数，它的右子节点下标：right = left + 1
- 对于有 n 个元素的完全二叉树 (n ≥ 2)，它的最后一个非叶子结点的下标：n/2 - 1

``` java
public void heapSort(int[] nums) {
    buildHeap(nums);
    int n = nums.length;
    for (int i = n - 1; i > 0; i--) {
        swap(nums, 0, i);
        heapify(nums, 0, i);
    }
}

private void buildHeap(int[] nums) {
    int n = nums.length;
    for (int i = (n >> 1) - 1; i >= 0; i--) {
        heapify(nums, i, n);
    }
}

private void heapify(int[] nums, int i, int size) {
    int l = (i << 1) + 1, r = l + 1, large = i;
    if (l < size && nums[l] > nums[large]) {
        large = l;
    }
    if (r < size && nums[r] > nums[large]) {
        large = r;
    }
    if (large != i) {
        swap(nums, large, i);
        heapify(nums, large, size);
    }
}
```

## 6. 快速排序 O(nlogn) ～ O(n^2)

挖坑填空+分治

时间复杂度 O(nlogn) ～ O(n^2)，平均时间复杂度 O(nlogn)

空间复杂度 O(logn) ～ O(n)，平均时间复杂度 O(logn)

``` java
public void quickSort(int[] arr, int l, int r) {
    if (l >= r) return;
    
    int i = l, j = r, p = l + ((r - l) >> 1);
    swap(arr, l, p);
    int x = arr[l];
    while (i < j) {
        while (i < j && arr[j] >= x) j--;
        if (i < j) arr[i] = arr[j];
        while (i < j && arr[i] <= x) i++;
        if (i < j) arr[j] = arr[i];
    }
    arr[i] = x;
    quickSort(arr, l, i - 1);
    quickSort(arr, i + 1, r);
}
```

## 7. 归并排序 (Merge Sort) O(nlogn)

原地归并排序需要不断腾挪位置以插入新数字，本质是插入排序。因此，归并排序必然需要额外 O(n) 空间。

``` java
public void mergeSort(int[] nums) {
    int[] temp = new int[nums.length];
    sort(nums, 0, nums.length - 1, temp);
}

private void sort(int[] arr, int l, int r, int[] temp) {
    if (l >= r) return;
    int mid = l + ((r - l) >> 1);
    sort(arr, l, mid, temp);
    sort(arr, mid + 1, r, temp);
    merge(arr, l, mid, r, temp);
}

private void merge(int[] arr, int l, int mid, int r, int[] temp) {
    int i = l, j = mid + 1, cur = 0;
    while (i <= mid && j <= r) {
        if (arr[i] <= arr[j]) temp[cur++] = arr[i++];
        else temp[cur++] = arr[j++];
    }
    while (i <= mid) temp[cur++] = arr[i++];
    while (j <= r) temp[cur++] = arr[j++];
    for (cur = 0; l <= r; ) arr[l++] = temp[cur++];
}
```

## 8. 计数排序 (Counting Sort) O(n+k)

计数排序的时间复杂度为 O(n+k)，k 表示数据的范围大小，空间复杂度为 O(n+k)。

``` java
public void countingSort(int[] nums) {
    if (nums == null || nums.length < 2) return;

    int n = nums.length, min = nums[0], max = nums[0];
    for (int num : nums) {
        min = Math.min(min, num);
        max = Math.max(max, num);
    }
    int range = max - min + 1;
    int[] counting = new int[range];
    for (int num : nums) {
        counting[num - min]++;
    }
    for (int i = 1; i < range; i++) {
        counting[i] += counting[i - 1];
    }
    int[] temp = new int[n];
    // 此处倒序正序都可，但正序会导致不稳定
    for (int i = n - 1; i >= 0; i--) {
        temp[--counting[nums[i] - min]] = nums[i];
    }
    for (int i = 0; i < n; i++) {
        nums[i] = temp[i];
    }
}
```

## 9. 基数排序 (Radix Sort)

- 最高位优先法，简称 MSD (Most significant digital)
- 最低位优先法，简称 LSD (Least significant digital)

基数排序的时间复杂度为 O(d(n+k)) (d 表示最长数字的位数，k 表示每个基数可能的取值范围大小)。 使用的空间和计数排序一样，空间复杂度为 O(n+k)（k 表示每个基数可能的取值范围大小）。如果是对非负整数排序，则 k = 10，如果是对包含负数的数组排序，则 k = 19。

含负数排序，counting 数组的下标 [0, 18] 对应基数 [−9, 9]。

``` java
// LSD 实现
public void radixSort(int[] arr) {
    int max = 0, maxDigitLen = 0;;
    for (int val : arr) max = Math.max(max, Math.abs(val));
    while (max != 0) {
        maxDigitLen++;
        max /= 10;
    }
    int n = arr.length, dev = 1;
    int[] counting = new int[19], temp = new int[n];
    for (int i = 0; i < maxDigitLen; i++) {
        for (int val : arr) {
            int radix = val / dev % 10 + 9;
            counting[radix]++;
        }
        for (int j = 1; j < 19; j++)
            counting[j] += counting[j - 1];
        for (int j = n - 1; j >= 0; j--) {
            int radix = arr[j] / dev % 10 + 9;
            temp[--counting[radix]] = arr[j];
        }
        System.arraycopy(temp, 0, arr, 0, n);
        Arrays.fill(counting, 0);
        dev *= 10;
    }
}
```

## 10. 桶排序 (Bucket Sort)

桶排序是计数排序的扩展版本，计数排序可以看成每个桶只存储相同元素，而桶排序每个桶存储一定范围的元素，通过映射函数，将待排序数组中的元素映射到各个对应的桶中，对每个桶中的元素进行排序，最后将非空桶中的元素逐个放入原序列中。

``` java
// 划分为 n 份
int interval = (max - min) / n + 1;

// n 个桶
int[][] bucket = new int[n][];

// 映射桶 ID
int bucketId = (arr[i] - min) / interval;
```

|题目|难度||
|---|---|---|
|[912. 排序数组](https://leetcode-cn.com/problems/sort-an-array/)|中等|√|
|[剑指 Offer 45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)|中等|√|
|[147. 对链表进行插入排序](https://leetcode-cn.com/problems/insertion-sort-list/)|中等|√|
|[506. 相对名次](https://leetcode-cn.com/problems/relative-ranks/)|简单|√|
|[面试题 10.01. 合并排序的数组](https://leetcode-cn.com/problems/sorted-merge-lcci/)|简单|√|
|[剑指 Offer 51. 数组中的逆序对](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/)|困难|√|
|[1122. 数组的相对排序](https://leetcode-cn.com/problems/relative-sort-array/)|简单|√|
|[164. 最大间距](https://leetcode-cn.com/problems/maximum-gap/)|困难|√|
|[561. 数组拆分 I](https://leetcode-cn.com/problems/array-partition-i/)|简单|√|
|[220. 存在重复元素 III](https://leetcode-cn.com/problems/contains-duplicate-iii/)|中等|√|
|[347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)|中等|√|
|[215. 数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)|中等|√|
|[692. 前K个高频单词](https://leetcode-cn.com/problems/top-k-frequent-words/)|中等|√|
