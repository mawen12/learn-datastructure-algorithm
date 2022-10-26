package com.mawen.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * 希尔排序
 *  - 时间复杂度：O(logn)
 *  - 空间复杂度：O(1)
 *  - 稳定性：不稳定
 * @author mawen
 * @since 2022/10/25
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        new ShellSort().shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }
}
