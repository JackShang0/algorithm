package com.algorithm.leetcode.hot100._08tree;


import java.util.*;

/**
 * @description: #144 二叉树的前序遍历
 * @author: shangqj
 * @date: 2024/3/22
 * @version: 1.0
 */
public class _1tree144 {
    public void main(String[] args) {

    }


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    /**
     * @param root 根节点
     * @param list 排序后的结果
     */
    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        //中左右  前序
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }



    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder1(root, list);
        return list;
    }

    /**
     * 中序遍历  左中右
     * @param root 根节点
     * @param list 数组
     */
    private void preorder1(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }

        preorder1(root.left,list);
        list.add(root.val);
        preorder1(root.right,list);

    }


    /**
     * 迭代实现 二叉树的中序遍历
     * @param root 根节点
     * @return list
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        //使用队列实现迭代
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


}


/*
class treeNode {
    int val;
    treeNode right;
    treeNode left;
    public treeNode() {
    }
    public treeNode(int val, treeNode right, treeNode left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
}
*/
