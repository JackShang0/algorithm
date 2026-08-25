package com.algorithm.leetcode.codeThoughts.queue;

import java.util.LinkedList;

public class windowMax {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = {1, -1};
        int k = 3;
        int k2 = 1;
        int[] result = maxSlidingWindow(nums2, k2);
        if (result != null) {
            for (int i : result) {
                System.out.println(i);
            }
        }
    }

    /**
     * 主要是记录索引到数组中
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2)
            return nums;
        LinkedList<Integer> queue = new LinkedList<Integer>();

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            System.out.println("第 " + i + "轮循环");
            //队列不为空 && 队列中的这个数 < 当前传来的数
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                System.out.println("    queue" + queue + "====" + nums[queue.peekLast()] + "====" + nums[i]);
                //把队列中的数弹出
                Integer pollLast = queue.pollLast();
                System.out.println("    弹出值pollLast = " + pollLast);

            }
            //添加当前数
            queue.add(i);
            System.out.println("    队列中最新为：" + queue);
            Integer peek = queue.peek();
            if (peek <= i - k) {
                System.out.println("    peek" + peek);
                Integer poll = queue.poll();
                System.out.println("    poll = " + poll);
            }
            System.out.println(queue);
            if (i + 1 >= k) {
                System.out.println("    nums[queue.peek()] = " + nums[queue.peek()]);
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int[] result = new int[nums.length + 1 - k];
        if (nums == null || nums.length < 2) {
            return result;
        }
        //创建队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.add(i);

            if (queue.peek() <= i - k) {
                queue.poll();
            }

            if (i + 1 >= k) {
                result[i + 1 - k] = queue.peekLast();
            }
        }
        return result;
    }
}
