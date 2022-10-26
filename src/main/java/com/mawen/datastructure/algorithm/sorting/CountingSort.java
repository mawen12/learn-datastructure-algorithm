package com.mawen.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * 计数排序
 *  - 时间复杂度：O(n + k)
 *  - 空间复杂度：O(k)
 *  - 稳定性：稳定
 * @author mawen
 * @since 2022/10/26
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        new CountingSort().countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void countSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[arr.length + 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }
}
