package com.mawen.datastructure.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 *  - 时间复杂度：O(n + k)
 *  - 空间复杂度：O(n + k)
 *  - 稳定性：稳定
 * @author mawen
 * @since 2022/10/26
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int bucketSize = 5;
        new BucketSort().bucketSort(arr, bucketSize);
        System.out.println(Arrays.toString(arr));
    }

    public void bucketSort(int[] arr, int bucketSize) {
        int n = arr.length;
        List<Integer>[] bucket = new ArrayList[bucketSize];

        for (int i = 0; i < n; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = arr[i] * n % bucketSize;
            bucket[bucketIndex].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(bucket[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bucket[i].size(); j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }
}
