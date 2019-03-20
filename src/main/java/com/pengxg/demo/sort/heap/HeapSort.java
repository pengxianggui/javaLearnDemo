package com.pengxg.demo.sort.heap;

/**
 * 堆排序。若n为数组的节点数，则堆排序的时间复杂度为：O(nlogn)
 */
public class HeapSort {

    private int[] array;

    public HeapSort(int[] array) {
        this.array = array;
    }

    private boolean less(int i, int j) {
        return array[i] > array[j];
    }

    private void swap(int k, int j) {
        int temp = array[k];

        array[k] = array[j];
        array[j] = temp;
    }

    /**
     * 下沉操作
     *
     * @param k
     */
    private void siftDown(int k, int length) {
        // loop
        // 判断是否存在子节点
        int childIndex = 2 * k + 1;

        while (childIndex < length) {
            // 查找最大的子节点
            if (childIndex + 1 < length && !less(childIndex, childIndex + 1)) {
                childIndex++;
            }

            // 若当前节点大于子节点 退出循环
            if (less(k, childIndex)) {
                break;
            }

            // 判断当前节点是否小于子节点, 若小于执行交换
            swap(k, childIndex);
            // 改变 k 指向
            k = childIndex;

            childIndex = 2 * k + 1;
        }
    }

    /**
     * 上浮操作
     *
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0) {
            int parent = (k - 1) / 2;

            // 小于父节点时退出
            if (less(parent, k)) {
                break;
            }
            // 与父节点交换数据
            swap(parent, k);
            // 改变 k 的指向
            k = parent;
        }
    }

    public void sort() {
        // 构造堆
        for (int i = 0; i < array.length; i++) {
            siftUp(i);
        }

        print();

        int n = array.length - 1;

        while (n > 0) {
            // 因为每次完成堆的构造后, 根节点为最大(小)值节点
            // 将根节点与最后一个节点交换
            swap(0, n);

            for (int i = 0; i <= n - 1; i++) {
                // 排除有序的节点
                // 重新构造堆
                siftUp(i);
            }

            print();

            n--;
        }
    }

    private void sort1() {
        // 构建堆
        // 因为堆是完全二叉树的特性, 所以下标小于等于 array.length / 2 的节点为非叶子节点
        // 采用下沉的方式 从下往上构建子堆
        for (int i = array.length / 2; i >= 0; i--) {
            siftDown(i, array.length);
        }

        print();

        int n = array.length - 1;

        while (n > 0) {
            // 因为每次完成堆的构造后, 根节点为最大(小)值节点
            // 将根节点与最后一个节点交换
            swap(0, n);

            for (int i = n / 2; i >= 0; i--) {
                // 排除有序的节点
                // 重新构造堆
                siftDown(i, n);
            }

            print();

            n--;
        }

    }

    private void print() {
        for (Integer num : array) {
            System.out.print(num);
            System.out.print(",");
        }
        System.out.println("");
    }
}