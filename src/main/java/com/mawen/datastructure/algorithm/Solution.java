package com.mawen.datastructure.algorithm;

import java.util.*;

/**
 * two sum
 * - 两数之和
 * - 不能重复
 * - 可以乱序
 *
 * Tips: 聚焦于如何降低时间复杂度，将O(n)->O(1)
 */
public class Solution {


    public static void main(String[] args) {
        int x = 0;
        x = 121;
        System.out.println(isPalindrome1(x));
        x = -121;
        System.out.println(isPalindrome1(x));
        x = 10;
        System.out.println(isPalindrome1(x));
        x = 1221;
        System.out.println(isPalindrome1(x));
    }

    public static boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        List<Integer> list = new ArrayList<>();
        if (x < 0) {
            return !isPalindrome;
        }
        while (x > 0) {// O(n)
            list.add(x % 10);
            x = x / 10;
        }

        List<Integer> reverseList = new ArrayList<>(list);
        Collections.reverse(reverseList);


        for (int i = 0; i < list.size(); i++) {// O(n)
            if (!Objects.equals(list.get(i), reverseList.get(i))) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

    // revert half of the number
    // 取一半
    public static boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
