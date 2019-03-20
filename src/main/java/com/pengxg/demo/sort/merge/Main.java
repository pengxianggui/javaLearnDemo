package com.pengxg.demo.sort.merge;

import java.util.Arrays;

/**
 * 归并排序：将两个排好序的数组合并成一个有序的数组，称为归并排序。
 *
 */
@SuppressWarnings("Duplicates")
public class Main {


    public static void main(String... args) {
        int[] arr = {2, 1, 6, 4, 0, 3, 5, 7, 8};

        myMergeSort(arr, 0, arr.length - 1);
        System.out.println("result: " + Arrays.toString(arr));
    }

    /**
     * 对一个数组进行归并排序
     * 节点数为n时，算法的时间复杂度为O(nlogn)
     * @param arr 需要排序的数组
     * @param l 该数组最左边的索引。左闭区间
     * @param r 该数组最右边的索引。右闭区间
     */
    public static void myMergeSort(int[] arr, int l, int r) {

        if (l == r) {
            return;
        } else {

            int m = (r + l) / 2; // 取中间, 其实中间任意位置均可

            myMergeSort(arr, l, m);
            myMergeSort(arr, m + 1, r);

            myMerge(arr, l, m + 1, r);
        }
    }

    /**
     * 归并排序的核心逻辑。对有序的数组进行归并排序
     * @param arr 待排序的数组
     * @param l 数组最左边的索引
     * @param m 数组中间的索引
     * @param r 数组最右边的索引
     */
    public static void myMerge(int[] arr, int l, int m, int r) {
        System.out.println("l: " + l + "    m:" + m + "     ;r=" + r);
        int[] leftArr = new int[m - l]; // 定义数组左半部分的拷贝
        int[] rightArr = new int[r - m + 1]; // 定义素组右半部分的拷贝

        // 填充左数组
        for (int i = l; i < m; i++) {
            leftArr[i - l] = arr[i];
        }
        // 填充右数组
        for (int i = m; i <= r; i++) {
            rightArr[i - m] = arr[i];
        }

        int li = 0, ri = 0;
//         归并排序
        for (int i = l; i <= r; i++) {
            if (li > leftArr.length - 1) {
                arr[i] = rightArr[ri];
                ri++;
            } else if (ri > rightArr.length - 1) {
                arr[i] = leftArr[li];
                li++;
            } else if (leftArr[li] <= rightArr[ri]) {
                arr[i] = leftArr[li];
                li++;
            } else if (rightArr[ri] < leftArr[li]) {
                arr[i] = rightArr[ri];
                ri++;
            }
        }

    }


















    public static void main1(String... args) {
        int[] arrays = {1, 3, 5, 2, 9, 5, 4, 11, 0, 6};
        mergeSort(arrays, 0, arrays.length - 1);

        System.out.println("result: " + Arrays.toString(arrays));
    }

    /**
     * 归并排序
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param R      指向数组最后一个元素
     */
    public static void mergeSort(int[] arrays, int L, int R) {

        //如果只有一个元素，那就不用排序了
        if (L == R) {
            return;
        } else {

            //取中间的数，进行拆分
            int M = (L + R) / 2;

            //左边的数不断进行拆分
            mergeSort(arrays, L, M);

            //右边的数不断进行拆分
            mergeSort(arrays, M + 1, R);

            //合并
            merge(arrays, L, M + 1, R);

        }
    }


    /**
     * 合并数组
     *
     * @param arrays
     * @param L      指向数组第一个元素
     * @param M      指向数组分隔的元素
     * @param R      指向数组最后的元素
     */
    public static void merge(int[] arrays, int L, int M, int R) {
        System.out.println("l: " + L + "    m:" + M + "     ;r=" + R);

        //左边的数组的大小
        int[] leftArray = new int[M - L];

        //右边的数组大小
        int[] rightArray = new int[R - M + 1];

        //往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
        }


        int i = 0, j = 0;
        // arrays数组的第一个元素
        int  k = L;


        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {

            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            if (leftArray[i] < rightArray[j]) {
                arrays[k] = leftArray[i];

                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }

        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];

            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];

            k++;
            j++;
        }
//        System.out.println(Arrays.toString(arrays));
    }
}
