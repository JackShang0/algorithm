package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #234 回文链表
 * @author: shangqj
 * @date: 2024/3/7
 * @version: 1.0
 */
public class linkedList3 {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     * <p>
     * 示例 1：
     * 输入：head = [1,2,2,1]
     * 输出：true
     * 示例 2：
     * 输入：head = [1,2]
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * 链表中节点数目在范围[1, 105] 内
     * 0 <= Node.val <= 9
     * <p>
     * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
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

        isPalindrome(listNodeA);
    }

    /**
     * 使用 快慢指针 + 反转链表处理
     * 快指针：每次跳两个节点  慢指针：每次跳一个节点
     *
     * @param head head
     * @return boolean
     */
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        //如果快指针所在节点不为空，或者节点的下一个不为空，就连续跳两个节点
        //偶数个节点
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //奇数个节点，则需要使得慢节点再到后一个节点
        if (fast != null) {
            slow = slow.next;
        }

        //将慢节点开始到快节点这部分的数据进行反转
        slow = reverse(slow);
        //快指针重新移到头节点
        fast = head;

        //slow的长度更短，控制slow作为循环跳出的条件
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    /**
     * 链表反转
     *
     * @param slow 链表节点
     * @return node
     */
    private static ListNode reverse(ListNode slow) {

        ListNode preNode = null, curNode = slow;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;

            preNode = curNode;
            curNode = next;
        }

        return preNode;
    }


    public static boolean isPalindrome1(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //如果是奇数  快指针每次移动两个节点，如果是奇数，fast不为空
        if (fast != null) {
            slow = slow.next;
        }

        //对满指针到快指针的位置进行反转
        slow = reverse1(slow);
        fast = head;

        //慢指针的长度短，控制慢指针作为循环的条件
        while (slow != null) {
            //如果不想等，则说明不是回文链表
            if (slow.val != fast.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverse1(ListNode slow) {
        ListNode preNode = null, curNode = slow;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;

            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }


    public static boolean isPalindrome2(ListNode head) {
        //定义两个快慢指针
        ListNode fast = head, slow = head;

        //
        while (fast != null && fast.next !=null ) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //1 2 3 4 5 6
        //如果head不等于空，则说明链表的个数为偶数
        if (fast != null) {
            slow = slow.next;
        }

        //将从slow指针开始到尾节点开始反转
        slow = reverse2(slow);
        fast = head;

        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            //让链表一直往后移动
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    //链表反转
    private static ListNode reverse2(ListNode slow) {
        ListNode preNode = null, curNode = slow;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;

            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }
}

