package com.algorithm.leetcode.hot100._08tree;

public class _110tree {

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
        boolean balanced = isBalanced(treeNode);
        System.out.println("balanced = " + balanced);
    }
    public static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        // 左右子树高度差大于1，return -1表示已经不是平衡树了
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
