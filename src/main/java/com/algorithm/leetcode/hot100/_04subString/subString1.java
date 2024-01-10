package com.algorithm.leetcode.hot100._04subString;

import java.util.HashMap;

/**
 * @description: #560 和为k的子数组
 * @author: shangqj
 * @date: 2024/1/10
 * @version: 1.0
 */
public class subString1 {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * 子数组是数组中元素的连续非空序列。
     * <p>
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 1};
        int k = 2;
        int i = subarraySum(ints, k);
        int i1 = subarraySum1(ints, k);
        int i2 = subarraySum2(ints, k);
        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
    }


    /**
     * 暴力枚举
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }

    /**
     * 前缀和 + 哈希表优化
     *
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum1(int[] nums, int k) {

        //次数
        int count = 0;
        //开始前缀节点
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //开始的时候，前缀和为0 出现1次，在哈希表中存储
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            //进行累加
            pre += nums[i];
            //判断哈希表中是否存在，存在则count 加出现的次数
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            //不存在则将当前值存储到哈希表中，存在则对当前数值+1
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }

        return count;
    }


    public static int subarraySum2(int[] nums, int k) {
        //次数
        int count = 0;
        //当前前缀节点
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        //初始map的时候，前缀和为0，出现一次
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            //进行累加
            pre += nums[i];
            //pre - k = num[i]+num[i+1]+ ······ +num[j]
            if (map.containsKey(pre - k)) {
                //当前count + pre-k的次数
                count += map.get(pre - k);
            }
            //将当前前缀和 作为key 如果存在则将次数+1，不存在则将添加到map中
            map.put(pre, map.getOrDefault(pre , 0) + 1);
        }

        return count;
    }


    public static int subarraySum3(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            //对pre累加
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


}
