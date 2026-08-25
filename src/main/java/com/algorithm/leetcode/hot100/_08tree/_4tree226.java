package com.algorithm.leetcode.hot100._08tree;

import java.util.ArrayList;

/**
 * @description: #226 翻转二叉树
 * @author: shangqj
 * @date: 2024/3/25
 * @version: 1.0
 */
public class _4tree226 {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        treeNode.left = treeNode1;

        TreeNode treeNode2 = new TreeNode(20);
        treeNode.right = treeNode2;

        TreeNode treeNode3 = new TreeNode(15);
        treeNode2.left = treeNode3;

        TreeNode treeNode4 = new TreeNode(7);
        treeNode2.right = treeNode4;
        TreeNode treeNode5 = invertTree(treeNode);
        System.out.println(treeNode5);

    }

    /**
     * 使用前后序解决较为方便   -> 递归的方式
     *
     * @param root 根节点
     * @return 返回
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        //元素翻转
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;


        ArrayList<Integer> list = new ArrayList<>();
        //前序、后序都可以，中序不可以
        list.add(root.val);
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }


    public TreeNode invertTree1(TreeNode root) {

        if (root == null) return root;


        TreeNode right = root.right;
        root.right = root.left;
        root.left = right;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(root.val);
        invertTree1(root.left);
        invertTree1(root.right);

        return root;
    }
}
