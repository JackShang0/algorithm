package com.algorithm.leetcode.hot100._05list;

/**
 * @description: #238 除自身以外数组的乘积
 * @author: shangqj
 * @date: 2024/1/11
 * @version: 1.0
 */
public class list4 {

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 示例 1:
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 示例 2:
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        //productExceptSelf1(nums);
        productExceptSelf(nums);

    }

    private static int[] productExceptSelf1(int[] nums) {
        int[] intPrefix = new int[nums.length];

        intPrefix[0] = 1;
        //先求出当前数组每个元素的前缀积
        for (int i = 1; i < nums.length; i++) {
            intPrefix[i] = intPrefix[i-1] * nums[i - 1];
            System.out.println(nums[i]);
        }
        //再求出当前数组每个元素的后缀积
        System.out.println(" ========== ");
        //intSuffix[intSuffix.length - 1] = 1;


        int R = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            intPrefix[i] = intPrefix[i] * R;
            R *= nums[i];
            System.out.println(intPrefix[i]);
        }

        return intPrefix;
    }


    public static int[] productExceptSelf(int[] nums) {

        int[] ints = new int[nums.length];
        ints[0]=1;
        for (int i = 1; i < nums.length; i++) {
            ints[i]=ints[i-1] * nums[i-1] ;
            System.out.println("i = " + ints[i]);
        }
        System.out.println("ints.length = " + ints.length);
        //前缀[1，2，6，24]nums[i]

        int R = 1;
        for (int i = ints.length-1; i >= 0; i--) {
            //System.out.println("nums[i] = " + nums[i]);
            //后缀【24、12、4、1】
            System.out.println("R = " + R);
            ints[i] = R*ints[i];
            R *= nums[i];
            System.out.println("result= " + i +"   "+ints[i]);
        }



        return ints;
    }
}
