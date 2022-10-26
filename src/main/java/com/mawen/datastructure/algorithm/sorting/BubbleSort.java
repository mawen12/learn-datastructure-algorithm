package com.mawen.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * 冒泡排序
 *  - 时间复杂度：O(n^2)
 *  - 空间复杂度：O(1)
 *  - 稳定性：稳定
 * @author mawen
 * @since 2022/10/25
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {3, 2, 1};
        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(array)));
    }

    public int[] bubbleSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        return array;
    }

}
