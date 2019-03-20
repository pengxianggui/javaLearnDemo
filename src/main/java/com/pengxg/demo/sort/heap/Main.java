package com.pengxg.demo.sort.heap;

/**
 * 堆排序，利用完全二叉树特性的一种排序方法，属于选择排序的一种
 */
public class Main {

    public static void main(String... args) {
        int[] arr = {1, 5, 6, 3, 2, 4, 7};

        new HeapSort(arr).sort();
    }
}
