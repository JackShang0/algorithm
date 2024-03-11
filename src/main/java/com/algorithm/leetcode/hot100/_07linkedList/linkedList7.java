package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #2 两数相加
 * @author: shangqj
 * @date: 2024/3/11
 * @version: 1.0
 */
public class linkedList7 {
    /*

     给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     请你将两个数相加，并以相同形式返回一个表示和的链表。
     你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

     示例 1：
     输入：l1 = [2,4,3], l2 = [5,6,4]
     输出：[7,0,8]
     解释：342 + 465 = 807.
     示例 2：
     输入：l1 = [0], l2 = [0]
     输出：[0]
     示例 3：
     输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     输出：[8,9,9,9,0,0,0,1]


     提示：
     每个链表中的节点数在范围 [1, 100] 内
     0 <= Node.val <= 9
     题目数据保证列表表示的数字不含前导零

     * @param args
     */
    public static void main(String[] args) {

    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;

        //按位累加
        while (head1 != null) {
            if (head2 != null) {
                head1.val += head2.val;

                head2 = head2.next;
            }

            //如果第二个链表的长度大于第一个链表，则需要将第二个链表中多余位的数据全部拿下来
            if (head1.next == null && head2 != null) {
                head1.next = head2;
                break;
            }

            head1 = head1.next;
        }
        merge(l1);
        return l1;
    }

    private void merge(ListNode l1) {
        while (l1 != null) {
            //如果大于>=10 则进位
            if (l1.val >= 10) {
                l1.val = l1.val % 10;
                //如果下一位为空，则初始化下一位节点
                if (l1.next == null) {
                    l1.next = new ListNode(0);
                }
                //对下一位+1
                l1.next.val += 1;
            }
            l1 = l1.next;
        }
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        ListNode nodeA = l1, nodeB = l2;

        //按位累加
        while (nodeA != null) {
            if (nodeB != null) {
                nodeA.val += nodeB.val;
                nodeB = nodeB.next;
            }

            //针对 链表A 的长度小于 链表B的长度的情况
            if (nodeA.next == null && nodeB != null) {
                //直接将链表B节点的值赋值给链表A
                nodeA.next = nodeB;
                break;//记得要break
            }
            nodeA = nodeA.next;

        }

        //进位处理
        merge2(l1);

        return l1;
    }

    private void merge2(ListNode l1) {
        while (l1 != null) {
            if (l1.val >= 10) {
                l1.val = l1.val % 10;

                //如果链表最后一位需要进位
                if (l1.next == null) {
                    l1.next = new ListNode(0);
                }
                l1.next.val += 1;
            }

            l1 = l1.next;
        }
    }


}
