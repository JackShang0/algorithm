package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #25 K个一组翻转链表
 * @author: shangqj
 * @date: 2024/3/12
 * @version: 1.0
 */
public class linkedList10 {

    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * <p>
     * 提示：
     * 链表中的节点数目为 n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     * <p>
     * 进阶：你可以设计一个只用 O(1) 额外内存空间的算法解决此问题吗？
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        //定义一个 虚拟头节点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre, mid = head;
        while (cur.next != null) {
            while (k != 0) {
                cur = cur.next;
                k--;
            }
            //拿到 下一次开始分组的头节点
            ListNode next = cur.next;
            pre.next = cur;
            pre.next.next = mid;
            mid.next = next;

            //while ()


        }

        return null;
    }


    public ListNode reverseKGroup1(ListNode head, int k) {

        //定义一个 虚拟头节点
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            //查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null){
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head,tail);
            head = reverse[0];
            tail = reverse[1];

            //把子链表重新接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;


        }


        return hair.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev!=tail){
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail,head};
    }


    public ListNode reverseKGroup2(ListNode head, int k) {

        //定义一个 虚拟头节点
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;


        while (head != null) {
            ListNode tail = pre;
            //查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null){
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head,tail);
            head = reverse[0];
            tail = reverse[1];

            //把子链表重新接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }


        return hair.next;
    }
}
