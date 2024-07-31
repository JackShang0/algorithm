package com.algorithm.leetcode.hot100._08tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: #102 二叉树的层序遍历
 * @author: shangqj
 * @date: 2024/3/25
 * @version: 1.0
 */
public class _3tree102 {


    /**
     * 二叉树层序遍历
     * @param root 根节点
     * @return 返回二维数组
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        return getListByQueue(root);
    }


    /*public static ArrayList<List<Integer>> getListByFor(TreeNode root,Integer deep){
        if (root!=null )
        return null;
    }*/

    /**
     * 使用队列遍历二叉树
     * @param root 根节点
     * @return 返回二维数组
     */
    private static ArrayList<List<Integer>> getListByQueue(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root != null) {

            //此处创建队列
            LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                ArrayList<Integer> list = new ArrayList<>();
                int size = queue.size();

                while (size > 0) {
                    TreeNode poll = queue.poll();
                    list.add(poll.val);

                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                    size--;
                }
                result.add(list);
            }
        }

        return result;
    }


    private static ArrayList<List<Integer>> getListByQueue1(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root!=null){
            //使用队列
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()){
                int size = queue.size();
                ArrayList<Integer> list = new ArrayList<>();

                while (size>0){
                    //从队列中取值
                    TreeNode poll = queue.poll();
                    list.add(poll.val);


                    //如果当前节点的左右存在，则添加到队列中，下一轮进来在队列中再取出来
                    if (root.left!=null){
                        queue.offer(root.left);
                    }
                    if (root.right!=null){
                        queue.offer(root.right);
                    }

                    size --;
                }

                result.add(list);
            }
        }
        return result;
    }

}
