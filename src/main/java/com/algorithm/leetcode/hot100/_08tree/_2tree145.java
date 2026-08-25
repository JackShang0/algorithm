package com.algorithm.leetcode.hot100._08tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: #145 中序遍历  目前只掌握递归方法
 * @author: shangqj
 * @date: 2024/3/25
 * @version: 1.0
 */
public class _2tree145 {

    /*
     * 递归遍历二叉树的三部曲：
     * 1、确定递归函数的参数和返回值
     * 2、确定终止条件
     * 3、确定单层递归的逻辑
     */

    public List<Integer> traversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        midOrderTraversal(root,list);
        return list;
    }

    /**
     * 中序遍历
     * @param root 根节点
     * @param list 数组存储遍历后的数据
     */
    public void midOrderTraversal(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        //中序遍历  左中右
        midOrderTraversal(root.left,list);
        list.add(root.val);
        midOrderTraversal(root.right,list);
    }
}
