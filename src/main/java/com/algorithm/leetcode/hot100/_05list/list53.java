package com.algorithm.leetcode.hot100._05list;

/**
 * @description: #53 最大子数组和
 * @author: shangqj
 * @date: 2024/1/10
 * @version: 1.0
 */
public class list53 {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     * <p>
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     *
     * @param args a
     */
    public static void main(String[] args) {
        int[] ints = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(ints);
        int i1 = maxSubArray1(ints);
        int j = maxSubArray2(ints);
        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);
        System.out.println("j = " + j);
    }


    /**
     * 动态规划 ：若前面一个元素大于0，则将其加到当前元素上
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        //最大值从数组为0的位置开始
        int maxAns = nums[0];
        for (int num : nums) {
            //比较当前数与前缀和之间的大小   取出最大的值
            pre = Math.max(pre + num, num);
            //再将，最新的pre和最大值进行比较，返回最大值
            maxAns = Math.max(maxAns, pre);
        }

        return maxAns;
    }


    /**
     * 2024.1.10
     *
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int sum = 0;
        int maxAns = nums[0];
        for (int num : nums) {
            //比较当前的和与当前循环中的值的大小   取更大的值
            sum = Math.max(sum + num,num);

            //对当前最大值进行存储，与求和的最新值进行比较
            maxAns = Math.max(maxAns,sum);
        }
        return maxAns;
    }


    /**
     * 暴力法
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        int re = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum+nums[j];
            }
            re = Math.max(re,sum);
        }
        return re;
    }


    /**
     * 分治
     * @param nums
     * @return
     */
    public static int maxSubArray3(int[] nums) {

        return 0;
    }
}
