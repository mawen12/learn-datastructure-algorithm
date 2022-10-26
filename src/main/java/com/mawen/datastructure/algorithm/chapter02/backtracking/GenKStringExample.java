package com.mawen.datastructure.algorithm.chapter02.backtracking;

import java.util.Arrays;

/**
 * 回溯 - 生成所有n位长的字符串。串中每位的取值为0..k-1
 * 时间复杂度：
 * 空间复杂度：
 */
public class GenKStringExample {

    private int[] arr;

    public GenKStringExample(int[] arr) {
        this.arr = arr;
    }

    public void kString(int n, int k) {
        if (n < 1) System.out.println(Arrays.toString(arr)); // 运行时间 C
        else {
            for (int i = 0; i < k; i++) { // 运行时间 kT(n-1) + d
                arr[n - 1] = i; // d
                kString(n - 1, k); // kT(n-1)
            }
        }
    }
}
