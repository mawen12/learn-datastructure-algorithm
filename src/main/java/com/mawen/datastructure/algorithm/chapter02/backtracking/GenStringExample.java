package com.mawen.datastructure.algorithm.chapter02.backtracking;

import java.util.Arrays;

/**
 * 回溯 - 生成所有n位长的2进制字符串，假设A[0..n-1]是一个大小为n的数组
 *
 */
public class GenStringExample {

    public static void binary(int[] arr, int n) {
        if (n < 1) System.out.println(Arrays.toString(arr)); // c
        else { // 2T(n-1) + d
            arr[n - 1] = 0; // d
            binary(arr, n - 1); // T(n-1)
            arr[n - 1] = 1; // d
            binary(arr, n - 1); // T(n-1)
        }
    }

}
