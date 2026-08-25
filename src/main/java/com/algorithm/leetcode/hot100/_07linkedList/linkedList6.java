package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #21 合并两个有序链表
 * @author: shangqj
 * @date: 2024/3/11
 * @version: 1.0
 */
public class linkedList6 {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * <p>
     * 示例 1：
     * 输入：l1 = [1,2,4], l2 = [1,3,4]
     * 输出：[1,1,2,3,4,4]
     * 示例 2：
     * 输入：l1 = [], l2 = []
     * 输出：[]
     * 示例 3：
     * 输入：l1 = [], l2 = [0]
     * 输出：[0]
     * <p>
     * <p>
     * 提示：
     * 两个链表的节点数目范围是 [0, 50]
     * -100 <= Node.val <= 100
     * l1 和 l2 均按 非递减顺序 排列
     *
     * @param args a
     */
    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists(ListNode nodeA, ListNode nodeB) {

        //定义一个头节点
        ListNode preNode = new ListNode(-1);
        ListNode pre = preNode;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val <= nodeB.val) {
                pre.next = nodeA;
                nodeA = nodeA.next;
            } else {
                pre.next = nodeB;
                nodeB = nodeB.next;
            }
            pre = pre.next;
        }

        // 合并后 nodeA 和 nodeB 最多只有一个还未被合并完，我们直接将链尾指向未合并完的链表即可
        pre.next = nodeA == null ? nodeB : nodeA;
        return preNode.next;
    }


    /**
     * 暴力解法，时间复杂度 O(M+N) M、N分别是链表的长度  空间复杂度 O(1)
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        //边界情况处理
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        //如果 链表1的值小于链表2的值，就将链表1的next指向 list53.next 和 list2 中更小的值   -> 递归
        else if (list1.val < list2.val) {
            list1.next = mergeTwoLists2(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists2(list1, list2.next);
            return list2;
        }
    }


    /**
     * 定义三个指针  链表各一个指针，另外一个哑节点指针
     *
     * @param nodeA 链表1
     * @param nodeB 链表2
     * @return 有序链表
     */
    public ListNode mergeTwoLists3(ListNode nodeA, ListNode nodeB) {

        ListNode preNode = new ListNode(0);
        ListNode pre = preNode;

        while (nodeA != null && nodeB != null) {
            if (nodeA.val <= nodeB.val){
                pre.next = nodeA;
                nodeA = nodeA.next;
            }else {
                pre.next = nodeB;
                nodeB = nodeB.next;
            }
            pre = pre.next;
        }

        pre.next = nodeA == null?nodeB:nodeA;

        return preNode.next;
    }


}
