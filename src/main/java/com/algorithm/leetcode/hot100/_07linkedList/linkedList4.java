package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #141 环形链表
 * @author: shangqj
 * @date: 2024/3/7
 * @version: 1.0
 */
public class linkedList4 {

    /**
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置
     * （索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
     * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。
     * <p>
     * 示例 1：
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * 示例 2：
     * <p>
     * 输入：head = [1,2], pos = 0
     * 输出：true
     * 解释：链表中有一个环，其尾部连接到第一个节点。
     * 示例 3：
     * <p>
     * 输入：head = [1], pos = -1
     * 输出：false
     * 解释：链表中没有环。
     * <p>
     * <p>
     * 提示：
     * 链表中节点的数目范围是 [0, 104]
     * -105 <= Node.val <= 105
     * pos 为 -1 或者链表中的一个 有效索引 。
     * 进阶：你能用 O(1)（即，常量）内存解决此问题吗？
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

        hasCycle(listNodeA);
    }


    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        //需要使得 fast 为head.next , slow 为 head,如果同为 head，下面的while循环不会执行
        ListNode fast = head.next, slow = head;
        while (fast != slow) {
            //如果fast或fast.next为空，则说明链表不是环形链表
            if (fast == null || fast.next ==null){
                return false;
            }
            //fast指针一次跳动两个节点，slow一次跳一个节点
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    public static boolean hasCycle1(ListNode head) {

        //如果链表长度不足二则返回false
        if (head==null|| head.next==null)
            return false;

        //定义两个指针，fast为head.next，slow为head，如果同为head则会导致while循环不执行
        ListNode fast = head.next,slow = head;
        while (fast != slow){
            //为空，则说明链表不是环形
            if (fast == null || fast.next ==null)
                return false;

            //定义快指针每次跳两个节点，慢指针每次跳一个节点
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

}

