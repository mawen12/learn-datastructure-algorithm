package com.mawen.datastructure.algorithm.chapter02;

/**
 * 递归和内存（可视化）
 */
public class PrintFunctionExample {

    public static void main(String[] args) {

    }

    public static int print(int n) {
        if (n == 0) // 用于递归结束的基本情形
            return 0;
        else { // 再次递归调用自身
            System.out.println(n);
            return print(n - 1);
        }
    }

}
