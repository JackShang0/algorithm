package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #142 环形链表2
 * @author: shangqj
 * @date: 2024/3/10
 * @version: 1.0
 */
public class linkedList5 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        //定义快慢指针
        ListNode fast = head, slow = head;

        //死循环 定义两个指针，如果两个指针第一次相遇，则跳出循环
        while (true) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        //将fast节点重新定义到头节点的位置
        //因为头节点到环的入口节点的距离 = 两个指针第一次相遇的位置到 环的入口节点的距离
        /*
         定义：
         头节点 到环的入口节点 的距离为 x
         环的入口节点 到 两个节点第一次相遇的节点 为 y
         两个节点第一次相遇的节点 到 环的入口节点 为 z
         （x+y）*2 = x+y+（y+z）*n
         （x+y）*2 = x+y+y+z+（y+z）*（n-1）
          x = z + （y+z）*（n-1）

          当n=1是，则有 x=z，所以可以得出x=z，
          即头节点到入口节点的位置=第一次相交的节点到入口节点的位置的距离
         */
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ListNode detectCycle2(ListNode head) {

        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                break;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
