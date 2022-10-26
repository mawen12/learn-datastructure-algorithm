package com.mawen.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * 选择排序
 *  - 时间复杂度：O(n^2)
 *  - 空间复杂度：O(1)
 *  - 稳定性：不稳定
 * @author mawen
 * @since 2022/10/25
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        System.out.println(Arrays.toString(new SelectionSort().selectionSort(arr)));
    }

    public int[] selectionSort(int[] arr) {
        int minIndex, temp;
        for (int i = 0; i < arr.length; i++) {
            minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return arr;
    }
}
