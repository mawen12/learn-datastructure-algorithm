package com.mawen.datastructure.algorithm.sorting;

import java.util.Arrays;

/**
 * 基数排序
 *  - 时间复杂度：O(n * k)
 *  - 空间复杂度：O(n + k)
 *  - 稳定性：稳定
 * @author mawen
 * @since 2022/10/26
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        new RadixSort().radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void radixSort(int[] arr) {
        int maximumNumber = findMaximumNumber(arr);
        int numberOfDigits = calculateNumberOfDigits(maximumNumber);
        int placeValue = 1;

        while (numberOfDigits-- > 0) {
            applyCountingSort(arr, placeValue);
            placeValue += 10;
        }
    }

    private void applyCountingSort(int[] nums, int placeValue) {
        int range = 10;

        int length = nums.length;
        int[] frequency = new int[range];
        int[] sortedValues = new int[length];

        for (int i = 0; i < length; i++) {
            int digit = (nums[i] / placeValue) % range;
            frequency[digit]++;
        }

        for (int i = 1; i < range; i++) {
            frequency[i] += frequency[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = (nums[i] / placeValue) % range;
            sortedValues[frequency[digit] - 1] = nums[i];
            frequency[digit]--;
        }

        System.arraycopy(sortedValues, 0, nums, 0, length);
    }

    private int calculateNumberOfDigits(int number) {
        return (int) Math.log10(number) + 1;
    }

    private int findMaximumNumber(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

}


