package com.algorithm.leetcode.hot100._05list;


/**
 * @description: #189 轮转数组
 * @author: shangqj
 * @date: 2024/1/11
 * @version: 1.0
 */
public class list189 {

    /**
     给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

     示例 1:
     输入: nums = [1,2,3,4,5,6,7], k = 3
     输出: [5,6,7,1,2,3,4]
     解释:
     向右轮转 1 步: [7,1,2,3,4,5,6]
     向右轮转 2 步: [6,7,1,2,3,4,5]
     向右轮转 3 步: [5,6,7,1,2,3,4]
     示例 2:
     输入：nums = [-1,-100,3,99], k = 2
     输出：[3,99,-1,-100]
     解释:
     向右轮转 1 步: [99,-1,-100,3]
     向右轮转 2 步: [3,99,-1,-100]

     * @param args
     */
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        rotate2(ints,k);
    }

    /**
     * ac 不过
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {

        int[] ints = new int[nums.length];

        for (int i = 0; i < nums.length ;i++) {
            if (i < nums.length - k){
                ints[k+i] = nums[i];
            }
            else {
                ints[i-k-1] = nums[i];
            }
        }
        System.arraycopy(ints, 0, nums, 0, nums.length);
    }


    /**
     * 2024.1.11
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length ;i++) {
            ints[(i+k) % nums.length] = nums[i];
        }
        System.arraycopy(ints, 0, nums, 0, nums.length);

        for (int num : ints) {
            System.out.println("num = " + num);
        }
    }

    public static void rotate2(int[] nums, int k) {
        int[] ints = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ints[(i+k)% nums.length] = nums[i];
        }

        System.arraycopy(ints,0,nums,0,nums.length);

        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }

    }
}
