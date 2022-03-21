package com.mawen.datastructure.algorithm.chapter02;

/**
 * 递归 - 阶乘函数示例
 * 定义： n! 等于 n ~ 1之间所有整数的乘积
 * 递归定义：
 * - n! = 1            => n = 0/1
 * - n! = n * (n - 1)! => n > 1
 */
public class FactorialFunctionExample {

    public static void main(String[] args) {

    }

    public static int fact(int n) {
        // 基本情形，当参数为0或1时，返回1
        if (n == 1)
            return 1;
        else if (n == 0)
            return 1;
        else // 递归情形，返回 n * (n - 1)!
            return n * fact(n - 1);
    }


}
