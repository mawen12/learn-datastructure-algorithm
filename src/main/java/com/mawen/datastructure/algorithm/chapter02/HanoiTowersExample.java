package com.mawen.datastructure.algorithm.chapter02;

/**
 * 递归 -汉诺塔难题
 * 定义：
 * - 有三个柱子和一些可以在柱子之间来回移动的不同大小的圆盘开始时，所有的圆盘按照从小到大的次序自上而下叠放在 一 根
 * 柱子上，形成一个圆锥结构。 现在要求把整叠圆盘移动到另一根柱子上
 * - 每次只能移动一个圆盘
 * - 每次移动，只能移动柱子最上面的一个圆盘到另一根柱子（这根柱子上有可能已有圆盘）
 * - 任何时候不能出现大圆盘在小圆盘上方的情况
 * 算法：
 * - 将源柱最上面的n-1个圆盘移到辅助柱
 * - 将第n个圆盘从源柱移到目的柱
 * - 将辅助柱的n-1个圆盘移到目的柱
 * - 源柱最上面的n-1个圆盘移到辅助柱又可以认为是一个新问题，并且可以用同样的方式解决。
 * 一旦能解决了只有3个圆盘的汉诺塔问题，那么这个算法可以求解任意数量圆盘的汉诺塔问题
 */
public class HanoiTowersExample {

    public static void main(String[] args) {
        int n = 3;
        char fromPeg = 'A';
        char toPeg = 'B';
        char auxPeg = 'C';

        towersOfHanoi(3, fromPeg, toPeg, auxPeg);
    }

    /**
     *
     * @param n 圆盘数量
     * @param fromPeg 圆盘所在的A柱
     * @param toPeg 圆盘要移到到的B柱
     * @param auxPeg 中间柱
     */
    public static void towersOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
        // 如果仅有一个圆盘，直接移动，然后返回
        if (n == 1) {
            System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
            return;
        }

        // 利用C柱作辅助，将A柱最上面的n-1个圆盘移到B柱
        towersOfHanoi(n - 1, fromPeg, auxPeg, toPeg);
        // 将余下的圆盘从A柱移到C柱
        System.out.println("Move disk from peg " + fromPeg + " to peg " + toPeg);
        // 利用A柱作为辅助，将B柱上的n-1个圆盘到C柱
        towersOfHanoi(n-1, auxPeg, toPeg, fromPeg);
    }
}
