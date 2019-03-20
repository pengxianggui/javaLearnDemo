package com.pengxg.demo.sort.bubble;

import java.util.Arrays;

/**
 * 冒泡排序: 将数组从前到后遍历，遍历到i个元素，便将第i个元素与后面的length - i个元素以此进行比较，小（大）的则
 * 放在交换位置。
 */
public class Main {

    public static void main(String... args) {
        int[] arr = {2, 1, 6, 4, 0, 3, 5, 7, 8};
        bubbleSort(arr);
        System.out.println("result: " + Arrays.toString(arr));
    }

    /**
     * n为数组长度，则时间复杂度为O(n^2)
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int i;
        for (i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }


    public static void bubbleSort2(int[] a) {
        int team=a.length-1;
        for(int i= 0 ;i<team;i++){
            if(a[i]>a[i+1]){
                int tem =a[i];
                a[i]=a[i+1];
                a[i+1]=tem;
            }
            if(i==team-1){
                i=-1;
                team--;
            }
        }
    }


}
