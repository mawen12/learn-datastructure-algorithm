package com.mawen.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * 归并排序
 *  - 时间复杂度：O(logn)
 *  - 空间复杂度：O(n)
 *  - 稳定性：稳定
 * @author mawen
 * @since 2022/10/25
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        System.out.println(Arrays.toString(new MergeSort().mergeSort(arr)));
    }

    public int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;
        int middle = (int) Math.floor(arr.length / 2);
        int[] left = Arrays.copyOfRange(arr, 0, middle);
        int[] right = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }
}
