package com.mawen.datastructure.algorithm.chapter03.questions;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 找出链表的倒数第n个节点
 */
public class Question02 {

    @Data
    @RequiredArgsConstructor
    public static class ListNodeExample {
        private final int data;

        private ListNodeExample next;

        // =====================基本操作==========================

        /**
         * 获取长度
         */
        public int getLength(ListNodeExample head) {
            int size = 0;
            ListNodeExample current = head;
            while (current != null) {
                current = current.getNext();
                size++;
            }
            return size;
        }

        /**
         * 获取链表的倒数第n个结点
         */
        public ListNodeExample getNode(ListNodeExample head, int position) {
            int size = getLength(head);
            if (position > size || position < 1) {
                System.out.println("Invalid input.");
                return null;
            }

            int leftCount = size - position;
            ListNodeExample current = head;
            while(leftCount > 0) {
                leftCount--;
                current = current.getNext();
            }
            return current;
        }
    }
}
