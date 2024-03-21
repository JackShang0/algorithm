package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #206 反转链表
 * @author: shangqj
 * @date: 2024/3/7
 * @version: 1.0
 */
public class linkedList2 {

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：[2,1]
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     * <p>
     * <p>
     * 提示：
     * 链表中节点的数目范围是 [0, 5000]
     * -5000 <= Node.val <= 5000
     * <p>
     * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     *
     * @param args a
     */
    public static void main(String[] args) {

        ListNode listNodeA = new ListNode(4);
        listNodeA.next = new ListNode(1);
        listNodeA = listNodeA.next;
        listNodeA.next = new ListNode(8);
        listNodeA = listNodeA.next;
        listNodeA.next = new ListNode(4);
        listNodeA = listNodeA.next;
        listNodeA.next = new ListNode(5);
        System.out.println("listNodeA = " + listNodeA.next);
        if (listNodeA.next != null) {

        }

        ListNode listNodeB = new ListNode(5);
        listNodeB.next = new ListNode(6);
        listNodeB = listNodeB.next;
        listNodeB.next = new ListNode(1);
        listNodeB = listNodeB.next;
        listNodeB.next = new ListNode(8);
        listNodeB = listNodeB.next;
        listNodeB.next = new ListNode(4);
        listNodeB = listNodeB.next;
        listNodeB.next = new ListNode(5);
        System.out.println("listNodeA = " + listNodeA);
        System.out.println("listNodeB = " + listNodeB);

        reverseList1(listNodeA);
    }

    public static ListNode reverseList1(ListNode listNode) {
        ListNode preNode = null;
        ListNode curNode = listNode;
        while (curNode != null) {
            ListNode next = curNode.next;
            //当前节点的下一个节点 指向 preNode
            curNode.next = preNode;
            //将 curNode 和 preNode 同时往后移动一个节点
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }


    public static ListNode reverseList2(ListNode listNode) {

        ListNode preNode = null, curNode;
        curNode = listNode;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;

            preNode = curNode;
            curNode = next;

        }

        return preNode;
    }


    public static ListNode reverseList3(ListNode head) {

        ListNode preNode = null, curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;

            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }


    /**
     * 反转链表
     *
     * @param head 链表
     * @return 反转后的链表
     */
    public static ListNode reverseList4(ListNode head) {

        //使用双指针，一个指针指向前一个引用，一个指针指向当前节点
        ListNode preNode = null, curNode = head;
        if (curNode != null) {
            ListNode next = curNode.next;
            //第一个节点的后一个指向null
            curNode.next = preNode;

            //两个指针分别向后移动一个单位
            preNode = curNode;
            curNode = next;
        }
        return preNode;

    }


    public static ListNode reverseList5(ListNode head) {

        ListNode pre = null, cur = head;
        pre.next = cur;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;

            pre = cur;
            cur = next;

        }
        return pre;
    }
}

