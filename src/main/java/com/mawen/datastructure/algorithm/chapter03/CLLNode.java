package com.mawen.datastructure.algorithm.chapter03;

/**
 * 循环链表
 * - P46
 */
public class CLLNode {

    private int data;

    private CLLNode next;

    public CLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }

    // =====================基本操作==========================

    /**
     * 统计循环链表的结点个数
     * - 时间复杂度 O(n) 遍历到末尾结点
     * - 空间复杂度 O(1) 临时变量
     */
    public int getCLLLength(CLLNode headNode) {
        CLLNode currentNode = headNode;
        int size = 0;
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            size++;
            if (currentNode == headNode) {
                break;
            }
        }
        return size;
    }

    /**
     * 输出循环列表的内容
     * - 时间复杂度 O(n) 遍历到末尾结点
     * - 空间复杂度 O(1) 临时变量
     */
    public void printCircularListData(CLLNode headNode) {
        CLLNode cLLNode = headNode;
        while (cLLNode != null) {
            System.out.print(cLLNode.getData() + "->");
            cLLNode = cLLNode.getNext();
            if (cLLNode == headNode) {
                break;
            }
        }
        System.out.println("(" + cLLNode.getData() + ")headNode");
    }

    /**
     * 表末尾插入一个结点
     * - 时间复杂度 O(n) 扫描长度为n的整个链表
     * - 空间复杂度 O(1) 临时变量
     */
    public void insertAtEndInCLL(CLLNode headNode, CLLNode nodeToInsert) {
        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null) {
            headNode = nodeToInsert;
            return;
        }

        CLLNode currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        currentNode.setNext(nodeToInsert);
        nodeToInsert.setNext(headNode);
    }

    /**
     * 表头插入一个结点
     * - 时间复杂度 O(n)
     * - 空间复杂度 O(1)
     */
    public void insertAtBeginInCLL(CLLNode headNode, CLLNode nodeToInsert) {
        nodeToInsert.setNext(nodeToInsert);
        if (headNode == null) {
            headNode = nodeToInsert;
            return;
        }

        CLLNode currentNode = headNode;
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        currentNode.setNext(nodeToInsert);
        nodeToInsert.setNext(headNode);
        headNode = nodeToInsert;
    }

    /**
     * 删除循环链表的最后一个结点
     * - 时间复杂度 O(n) 扫描长度为n的链表
     * - 空间复杂度 O(1) 临时变量
     */
    public void deleteLastNodeFromCLL(CLLNode headNode) {
        CLLNode currentNode = headNode;
        CLLNode temp = headNode;
        if (currentNode == null) {
            System.out.println("List Empty");
            return;
        }
        while (currentNode.getNext() != headNode) {
            temp = currentNode;
            currentNode = currentNode.getNext();
        }
        temp.setNext(headNode);
        currentNode = null;
    }

    /**
     * 删除循环链表中第一个结点
     * - 时间复杂度 O(n)
     * - 空间复杂度 O(1)
     */
    public void deleteFrontNodeFromCLLNode(CLLNode headNode) {
        CLLNode currentNode = headNode;
        if (currentNode == null) {
            System.out.println("List Empty");
            return;
        }
        while (currentNode.getNext() != headNode) {
            currentNode.setNext(currentNode.getNext());
        }
        currentNode.setNext(headNode.getNext());
        headNode = headNode.getNext();
    }
}
