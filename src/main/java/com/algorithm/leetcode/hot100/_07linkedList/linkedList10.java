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
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
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
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
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
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
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


    /**
     * 2024.3.13
     * 常规解题思路
     * @param head 链表
     * @param k k
     * @return 链表
     */
    public ListNode reverseKGroup3(ListNode head, int k) {

        //定义一个 虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //定义pre节点，这个节点是所有已经成功翻转之后的链表的尾节点
        ListNode pre = dummy;
        //定义一个end节点，这个节点的位置是每一次翻转链表的最后一个节点
        ListNode end = dummy;

        /**
         * -1->1->2->3->4->5->6->7（-1为虚拟头节点）
         * 为了避免影响已经翻转成功的节点以及后续需要翻转的节点，需要将翻转的子链表的前后指针断开（需要断开-1到1 之间，3与4之间）
         * 同时需要记录子链表中的头节点 以及 指针断开后的后续链表节点的头节点（即需要记录1以及4的节点位置）
         */

        while (end.next != null) {
            /**
             * 将原链表按照k个一组进行划分，如果长度不足k个
             * end不断向后移动，移动达不到k个节点，后面的节点就维持原有顺序
             */
            for (int i = 0; i < k && end != null; i++) {
                //如果移动的次数小于k，并且节点不为空，就向后移动
                end = end.next;
            }

            //如果发现 end 节点为空了，说明此时的节点个数不足k个，后续的链表保持原有顺序就行了
            if(end == null){
                break;
            }

            //next节点临时存储待翻转链表的第一个节点
            ListNode next = end.next;

            //翻转区中的节点与后续的链表断开
            end.next = null;

            //start 表示翻转区中的第一个节点
            ListNode start = pre.next;

            //翻转区的第一个节点与头节点的指针断开
            pre.next = null;

            //而pre要指向的节点就是我们翻转之后的头节点
            pre.next = reverseList(start);

            //然后为待翻转区的翻转做准备  next 为待翻转区的第一个节点
            start.next = next;

            //原来的 start -> end
            pre = start;

            //将end 设置为待翻转区的头节点的上一个节点
            end = start;
        }
        return dummy.next;
    }

    /**
     * 使用递归解决链表翻转的问题
     * @param head 待翻转链表
     * @return 翻转后的链表节点
     */
    private ListNode reverseList(ListNode head) {

        if (head == null|| head.next ==null){
            return head;
        }

        //使用递归不断调用，直到无法递归下去，递归的最小粒度是在最后一个节点
        //因为到最后一个节点的时候，由于当前节点 head 的 next 节点是空的，所以会直接返回 head
        ListNode node = reverseList(head.next);

        head.next.next = head;

        head.next = null;

        return node;
    }


    /**
     * todo
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup4(ListNode head, int k) {

        //定义一个 虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        return dummy.next;
    }
}
