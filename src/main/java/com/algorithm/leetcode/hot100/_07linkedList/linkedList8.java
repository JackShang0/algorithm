package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #19 删除链表的倒数第N个节点
 * @author: shangqj
 * @date: 2024/3/11
 * @version: 1.0
 */
public class linkedList8 {

    /*
        给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

        示例 1：
        输入：head = [1,2,3,4,5], n = 2
        输出：[1,2,3,5]
        示例 2：
        输入：head = [1], n = 1
        输出：[]
        示例 3：
        输入：head = [1,2], n = 1
        输出：[1]
        提示：
        链表中结点的数目为 sz
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz

        进阶：你能尝试使用一趟扫描实现吗？
     */
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //疑问1：为什么要统一定义头节点？
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre, slow = pre;


        while (n != 0) {
            fast = fast.next;
            n--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = next.next;


        //为什么要返回头节点的next
        return pre.next;
    }


    /**
     * 算法思路：
     * 需要找到需要删除的节点的前一个位置的节点，然后将这个节点的引用指向删除节点的下一个节点即可
     * <p>
     * 具体实现：
     * 定义快节点、慢节点两个节点在头节点的位置处，
     * 1、让快节点移动n+1个单位，然后再让慢节从头节点开始移动
     * 2、当快节点移动到链表的尾节点的时候，此时慢节点的位置刚好是需要断开的节点的前一个节点
     * 3、将这个节点的下一个指针指向 删除节点的下一个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre, end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }

        while (start.next != null) {
            start = start.next;
            end = end.next;
        }

        end.next = end.next.next;
        return pre.next;
    }


    public ListNode removeNthFromEnd2(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre, slow = pre;
        while (n != 0) {
            fast = fast.next;
            n--;
        }


        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = next.next;

        return pre.next;

    }


    public ListNode removeNthFromEnd3(ListNode head, int n) {

        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fast = pre,slow = pre;
        while (n!=0){
            fast = fast.next;
            n--;
        }

        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = next.next;

        return pre.next;

    }
}
