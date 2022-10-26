package com.mawen.datastructure.algorithm.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 插入排序
 *  - 时间复杂度：O(n^2)
 *  - 空间复杂度：O(1)
 *  - 稳定性：稳定
 * @author mawen
 * @since 2022/10/25
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        System.out.println(Arrays.toString(new InsertionSort().insertionSort(arr)));
    }

    public int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while(j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != 1) {
                arr[j] = temp;
            }
        }

        return arr;
    }

}
