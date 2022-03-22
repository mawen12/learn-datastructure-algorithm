package com.mawen.datastructure.algorithm.chapter02.recursion;

/**
 * 递归 - 判断数组中元素是否有序
 * -
 */
public class ArraySortedExample {

    /**
     * check array is sorted order
     * @param a array
     * @param index index
     * @return 1 is sortedOrder, 0 is not
     */
    public static int isArrayInSortedOrder(int[] a, int index) {
        // only one element or index can not use to compare is ordered
        if (a.length == 1 || index == 1) return 1;

        // compare current and next
        return (a[index - 2] <= a[index - 1]) ? isArrayInSortedOrder(a, index - 1) : 0;
    }

}
