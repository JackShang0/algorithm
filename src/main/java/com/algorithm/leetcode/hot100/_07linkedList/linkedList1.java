package com.algorithm.leetcode.hot100._07linkedList;

/**
 * @description: #160 相交链表
 * @author: shangqj
 * @date: 2024/3/7
 * @version: 1.0
 */
public class linkedList1 {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     * <p>
     * 图示两个链表在节点 c1 开始相交：
     * <p>
     * 题目数据 保证 整个链式结构中不存在环。
     * <p>
     * 注意，函数返回结果后，链表必须 保持其原始结构 。
     * <p>
     * 自定义评测：
     * <p>
     * 评测系统 的输入如下（你设计的程序 不适用 此输入）：
     * <p>
     * intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
     * listA - 第一个链表
     * listB - 第二个链表
     * skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
     * skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
     * 评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,6,1,8,4,5]。
     * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
     * — 请注意相交节点的值不为 1，因为在链表 A 和链表 B 之中值为 1 的节点 (A 中第二个节点和 B 中第三个节点) 是不同的节点。
     * 换句话说，它们在内存中指向两个不同的位置，而链表 A 和链表 B 中值为 8 的节点 (A 中第三个节点，B 中第四个节点) 在内存中指向相同的位置。
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
        System.out.println("listNodeA = " + listNodeA.next);


        ListNode listNodeB = new ListNode(5);
        listNodeB.next = new ListNode(6);
        listNodeB = listNodeB.next;
        listNodeB.next = new ListNode(1);
        listNodeB = listNodeB.next;
        listNodeB.next = new ListNode(8);
        listNodeB = listNodeB.next;
        listNodeB.next = new ListNode(4);
        listNodeB = listNodeB.next;
        listNodeB.next = new ListNode(5);
        System.out.println("listNodeA = " + listNodeA);
        System.out.println("listNodeB = " + listNodeB);

        getIntersectionNode1(listNodeA, listNodeB);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null)
            return null;
        else {
            if (headA.next == null && headB.next == null) {
                ListNode nodeA = headA.next;
                ListNode nodeB = headB.next;

                while (nodeA != nodeB) {
                    nodeA = nodeA == null ? nodeB : nodeA.next;
                    nodeB = nodeB == null ? nodeA : nodeB.next;
                }

                return nodeA;
            } else {

                return headA == headB ? headA : null;
            }
        }

    }


    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        //System.out.println("nodeA = " + nodeA);
        return nodeA;

    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }


    /**
     * 让长的那个链表从 m-n 的位置开始遍历
     *
     * @param headA nodeA
     * @param headB nodeB
     * @return node
     */
    /*public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        int la = 0,lb = 0;
        ListNode nodeA = headA,nodeB = headB;
        while (nodeA!=null){
            la ++;
            nodeA = nodeA.next;
        }
        while (nodeB != null){
            lb ++;
            nodeB = nodeB.next;
        }

        if (la < lb){
            nodeA = headB;
        }

    }*/
    public static ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return headA;
    }


    /**
     * 相交链表
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交的节点
     */
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        //使用双指针分别从链表的两个头节点开始遍历链表
        ListNode nodeA = headA, nodeB = headB;
        //如果节点A不等于节点B，作为控制条件一直向后遍历链表
        while (nodeA != nodeB) {
            //如果当前节点为空，则跳到另一条链表的头节点开始，否则将一直向链表下一个节点遍历
            //将先遍历完第一个链表，然后跳另一个链表开始遍历，为了保证两个开始位置的索引一致
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }
}

