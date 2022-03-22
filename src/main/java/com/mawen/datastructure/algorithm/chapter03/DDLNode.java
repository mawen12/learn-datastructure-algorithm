package com.mawen.datastructure.algorithm.chapter03;

/**
 * 双向链表
 */
public class DDLNode {

    private int data;

    private DDLNode next;

    private DDLNode previous;

    public DDLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DDLNode getNext() {
        return next;
    }

    public void setNext(DDLNode next) {
        this.next = next;
    }

    public DDLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DDLNode previous) {
        this.previous = previous;
    }

    // =====================基本操作==========================

    /**
     * 获取链表长度
     * - 范围 [0, size]
     * - 时间复杂度 O(n)
     * - 空间复杂度 O(1)
     */
    public int getDDLLength(DDLNode headNode) {
        int count = 0;
        DDLNode currentNode = headNode;
        while (currentNode != null) {
            count++;
            currentNode = headNode.getNext();
        }
        return count;
    }

    /**
     * 插入结点
     * - 范围 [1, size+1]
     * - 时间复杂度 O(n) 最差情况下，需要在链表的尾部插入结点
     * - 空间复杂度 O(1) 用于创建临时变量
     */
    public DDLNode ddlInsert(DDLNode headNode, DDLNode nodeToInsert, int position) {
        if (headNode == null) return nodeToInsert;

        int size = getDDLLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Invalid input");
            return headNode;
        }
        if (position == 1) {
            nodeToInsert.next = headNode;
            headNode.previous = nodeToInsert;
            return nodeToInsert;
        } else {
            DDLNode previousNode = headNode.getNext();
            int count = 1;
            while (count < position - 1) {
                count++;
                previousNode = previousNode.getNext();
            }
            DDLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if (currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }

    /**
     * 双向链表的删除
     * - 范围 [1, size]
     * - 时间复杂度 O(n) 最坏情况，待删除的结点在链表末尾
     * - 空间复杂度 O(1) 用于创建临时变量
     */
    public DDLNode ddlDelete(DDLNode headNode, int position) {
        int size = getDDLLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Invalid input.");
            return headNode;
        }
        if (position == 1) { // 表头删除的情况
            DDLNode nextNode = headNode.getNext();
            headNode.setNext(null);
            headNode = null;
            return nextNode;
        } else { // 表中部和末尾删除的情况
            DDLNode previousNode = headNode.getNext(); // 待删除结点的前驱结点
            int count = 1;
            while (count < position - 1) {
                count++;
                previousNode = previousNode.getNext();
            }
            DDLNode delNode = previousNode.getNext(); // 待删除结点的后驱结点
            DDLNode nextNode = delNode.getNext();
            if (nextNode != null) {
                nextNode.setPrevious(previousNode);
            }
            previousNode.setNext(nextNode);
            delNode.setNext(null);
            delNode.setPrevious(null);
            delNode = null;
        }
        return headNode;
    }

}
