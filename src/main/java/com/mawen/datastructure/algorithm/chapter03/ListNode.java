package com.mawen.datastructure.algorithm.chapter03;

/**
 * 单向链表
 */
public class ListNode {

    private int data;

    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    // =====================基本操作==========================

    /**
     * 遍历链表，统计链表中结点的个数 - O(n)
     */
    public int listLength(ListNode headNode) {
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    /**
     * 插入新结点
     * - 头部 / 中部 / 尾部
     * - 时间复杂度 O(n)
     * - 空间复杂度 O(1)
     */
    public ListNode insertInListNode(ListNode headNode, ListNode nodeToInsert, int position) {
        if (headNode == null) return nodeToInsert;

        int size = listLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is invalid. The valid inputs are 1 to" + (size + 1));
            return headNode;
        }
        if (position == 1) { // 在链表开头插入
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            // 在链表中间或末尾插入
            ListNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }

        return headNode;
    }

    /**
     * 单向链表的删除结点
     * - 头部 / 中部 / 尾部
     * - 时间复杂度 O(n) 最差需要删除末尾
     * - 空间复杂度 O(1)
     */
    public ListNode deleteNodeFromLinkedList(ListNode headNode, int position) {
        int size = listLength(headNode);
        if (position > size || position < 1) {
            System.out.println("Position of node to delete is invalid. The valid inputs are 1 to " + size);
            return headNode;
        }

        if (position == 1) { // 删除单向链表的表头结点
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        } else { // 删除中间或表尾结点
            ListNode previousNode = headNode.getNext();
            int count = 1;
            while (count < position) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode = null;
        }
        return headNode;
    }

    /**
     * 清空单向链表
     * - 时间复杂度 O(n) 扫描大小为n的整个链表
     * - 空间复杂度 O(1) 在实际应用中，不需要实现该内容
     */
    public void deleteLinkedList(ListNode headNode) {
        ListNode auxilaryNode, iterator = headNode;
        while (iterator != null) {
            auxilaryNode = iterator.getNext();
            iterator = null;
            iterator = auxilaryNode;
        }
    }
}
