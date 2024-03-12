package com.algorithm.leetcode.hot100._07linkedList;


/**
 * @description: #24 两两交换链表中的节点
 * @author: shangqj
 * @date: 2024/3/12
 * @version: 1.0
 */
public class linkedList9 {

    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     * 输入：head = [1]
     * 输出：[1]
     * 提示：
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     *
     * @param args
     */
    public static void main(String[] args) {

    }


    public ListNode swapPairs(ListNode head) {
        //定义临时节点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        //如果是奇数个节点，则需要使得 cur.next.next 不为空，如果是偶数个节点，则需要使得 cur.next 不为空
        while (cur.next != null && cur.next.next != null) {  //终止遍历的条件
            //定义两个临时节点  因为这两个节点会用到，并且当后续使用的时候会找不到，所以需要先存储
            ListNode tem1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            //节点交换
            cur.next = cur.next.next;
            cur.next.next = tem1;
            cur.next.next.next = temp2;

            //移动cur指针
            cur = cur.next.next;
        }
        return pre.next;
    }


    public ListNode swapPairs1(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        //当前节点指向虚拟头节点
        ListNode cur = pre;
        //当前节点的下一个节点以及 当前节点的下下个节点不为空
        while (cur.next != null && cur.next.next != null) {
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp2;

            cur = cur.next.next;
        }

        return pre.next;
    }

    /**
     * 解题思路：
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;
        while (cur.next != null && cur.next.next != null){
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;

            cur.next = cur.next.next;
            cur.next.next = temp1;
            cur.next.next.next = temp2;

            cur = cur.next.next;

        }

        return pre.next;
    }

}
