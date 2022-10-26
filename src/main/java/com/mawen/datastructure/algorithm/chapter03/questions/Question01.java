package com.mawen.datastructure.algorithm.chapter03.questions;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 用链表实现栈
 */
public class Question01 {


    @Data
    @RequiredArgsConstructor
    public static class StackExample {

        private final int data;

        private StackExample next;

        @Override
        public String toString() {

            List<Integer> list = new ArrayList<>();
            StackExample current = this;
            while (current != null) {
                list.add(current.getData());
                current = current.getNext();
            }

            StringBuilder builder = new StringBuilder("Stack {");
            builder.append(StringUtils.join(list, ","));
            builder.append("}.");
            return builder.toString();
        }

        // =====================基本操作==========================

        /**
         * 栈大小
         * - 时间复杂度 O(n)
         * - 空间复杂度 O(1)
         */
        public int getLength(StackExample head) {
            int count = 0;
            StackExample current = head;
            while(current != null) {
                count++;
                current = current.getNext();
            }

            return count;
        }

        /**
         * 入栈
         * - 列表头部插入结点
         * - 时间复杂度 O(1)
         * - 空间复杂度 O(1)
         */
        public StackExample insertAtBeginInStack(StackExample head, StackExample nodeToInsert) {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
            return head;
        }

        /**
         * 出栈
         * - 时间复杂度 O(1)
         * - 空间复杂度 O(1)
         */
        public StackExample deleteFrontNodeOFStack(StackExample head) {
            if (head == null) return null;
            StackExample current = head;
            head = current.getNext();
            current.setNext(null);
            return current;
        }
    }

}
