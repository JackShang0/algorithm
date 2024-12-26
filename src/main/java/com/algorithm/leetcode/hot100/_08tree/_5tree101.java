package com.algorithm.leetcode.hot100._08tree;

/**
 * @description: #101 对称二叉树
 * @author: shangqj
 * @date: 2024/3/25
 * @version: 1.0
 */
public class _5tree101 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(9);
        treeNode.left = treeNode1;

        TreeNode treeNode2 = new TreeNode(9);
        treeNode.right = treeNode2;

        TreeNode treeNode3 = new TreeNode(15);
        //treeNode2.left = treeNode3;

        TreeNode treeNode4 = new TreeNode(7);
        //treeNode2.right = treeNode4;
        boolean symmetric = isSymmetric(treeNode);
        System.out.println(symmetric);
    }
    public static boolean isSymmetric(TreeNode root) {


        return compare(root.left, root.right);
    }


    /**
     * 需要使用后序遍历
     *
     * @param left  左节点
     * @param right 右节点
     * @return
     */
    private static boolean compare(TreeNode left, TreeNode right) {
        //先对节点进行判断
        if (left != null && right == null) {
            return false;
        }

        if (left == null && right != null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }

        if (left.val != right.val) {
            return false;
        }

        //剩余情况就是左右节点不为空，且数值相同的。接下来就是要向下递归
        //递归逻辑：外侧节点相同，内侧节点相同，才返回ture

        boolean outSide = compare(left.left, right.right);
        boolean inSide = compare(left.right, right.left);

        return outSide && inSide;

    }


}
