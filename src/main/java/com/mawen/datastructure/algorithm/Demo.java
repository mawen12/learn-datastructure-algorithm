package com.mawen.datastructure.algorithm;

import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        int[] nums = null;

        nums = new int[]{5,0,1,2,3,4};
        System.out.println(Arrays.toString(buildArray(nums)));
        
    }

    // Time complexity: O(n) * 2
    // Space Complexity O(1)
    public static int[] buildArray(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int n = nums.length;
        for (int i = 0; i < n; i++) { // O(n)
            nums[i] = n * (nums[nums[i]] % n) + nums[i];
        }
        for (int i = 0; i < n; i++) { // O(n)
            nums[i] = nums[i] / n;
        }

        return nums;
    }

    public static int[] buildArray1(int[] nums) {
        if (nums == null || nums.length == 0) return nums;

        int q = nums.length;
        for (int i = 0; i < q; i++) {
            int a = (nums[nums[i]] % q) * q + nums[i];
        }
        return nums;
    }

}
