package com.mawen.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * 堆排序
 *  - 时间复杂度：O(logn)
 *  - 空间复杂度：O(1)
 *  - 稳定性：不稳定
 * @author mawen
 * @since 2022/10/26
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        new HeapSort().heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

}
