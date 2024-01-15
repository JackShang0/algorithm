package com.algorithm.leetcode.hot100._05list;

/**
 * @description: #238 除自身以外数组的乘积
 * @author: shangqj
 * @date: 2024/1/11
 * @version: 1.0
 */
public class list4 {

    /**
     给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

     示例 1:
     输入: nums = [1,2,3,4]
     输出: [24,12,8,6]
     示例 2:
     输入: nums = [-1,1,0,-3,3]
     输出: [0,0,9,0,0]
     * @param  args a
     */
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        productExceptSelf3(nums);
        int[] ints = new int[nums.length];
        for (int i = 0; i < ints.length; i++) {
            System.out.println("ints = " + ints[i]);
        }

    }


    /**
     * 1.15
     * 先求前缀积  再求后缀积  合并乘积 并返回 注意第一个前缀乘积为1  最后一个前缀积 也为1
     * @param nums 数组
     * @return 返回值
     */
    public static int[] productExceptSelf3(int[] nums) {

        int[] ints = new int[nums.length];
        ints[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ints[i]=nums[i-1]*ints[i-1];
            System.out.println("ints[i] = " + ints[i]);
            //前缀  1、1、2、6
        }

        //System.out.println("========== " );
        int R = 1;
        for (int i = ints.length-1; i >= 0; i--) {
            ints[i] = R*ints[i];
            //System.out.println("ints[i] = " + ints[i]);
            R *= nums[i];
            //System.out.println("R = " + R);
        }


        return ints;
    }
}
