package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #148 排序链表
 * @author: shangqj
 * @date: 2024/3/13
 * @version: 1.0
 */
public class linkedList12 {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * <p>
     * 示例 1：
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * 示例 2：
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * 示例 3：
     * 输入：head = []
     * 输出：[]
     * 提示：
     * 链表中节点的数目在范围 [0, 5 * 104] 内
     * -105 <= Node.val <= 105
     * <p>
     * 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *
     * @param args
     */
    public static void main(String[] args) {

    }


    /**
     * 解题思路：将链表拆分成子链表进行
     *
     * @param head 链表
     * @return return
     */
    public ListNode2 sortList(ListNode2 head) {
        if (head == null)
            return null;

        //获取到链表的长度
        int length = 0;
        ListNode2 node = head;
        while (node != head) {
            length++;
            node = node.next;
        }


        //创建一个虚拟头节点
        ListNode2 hair = new ListNode2(0, head);

        //
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode2 prev = hair, cur = hair.next;
            while (cur != null) {
                ListNode2 head1 = cur;
                for (int j = 1; j < subLength && cur.next != null; j++) {
                    cur = cur.next;
                }
                ListNode2 head2 = cur.next;
                cur.next = null;
                cur = head2;
                for (int i = 1; i < subLength && cur != null && cur.next != null; i++) {
                    cur = cur.next;
                }

                ListNode2 next = null;
                if (cur != null) {
                    next = cur.next;
                    cur.next = null;
                }
                ListNode2 merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                cur = next;

            }
        }
        return hair.next;
    }

    private ListNode2 merge(ListNode2 head1, ListNode2 head2) {

        ListNode2 dummyHead = new ListNode2(0);
        ListNode2 temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }

            temp = temp.next;
        }

        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }

        return dummyHead.next;
    }

}

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2() {
    }

    ListNode2(int val) {
        this.val = val;
    }

    ListNode2(int val, ListNode2 next) {
        this.val = val;
        this.next = next;
    }
}
