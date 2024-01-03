package com.algorithm.leetcode.hot100.twoPointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:  #15 三数之和
 * @author: shangqj
 * @date: 2024/1/3
 * @version: 1.0
 */
public class twoPoints3 {
    /**
     给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
     同时还满足 nums[i] + nums[j] + nums[k] == 0 。
     请你返回所有和为 0 且不重复的三元组。
     注意：答案中不可以包含重复的三元组。

     示例 1：
     输入：nums = [-1,0,1,2,-1,-4]
     输出：[[-1,-1,2],[-1,0,1]]
     解释：
     nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     注意，输出的顺序和三元组的顺序并不重要。
     示例 2：
     输入：nums = [0,1,1]
     输出：[]
     解释：唯一可能的三元组和不为 0 。
     示例 3：
     输入：nums = [0,0,0]
     输出：[[0,0,0]]
     解释：唯一可能的三元组和为 0 。
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(ints);
        System.out.println("lists = " + lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            for (int i : nums) {
                for (int num1 : nums) {
                    if ((num+i+num1 == 0 ) && ((num1 != num) || (num1 != i) || (i != num))){
                        List<Integer> integers = new ArrayList<>();
                        integers.add(num);
                        integers.add(num1);
                        integers.add(i);
                        list.add(new ArrayList<>(integers));
                    }

                }
            }
        }

        return list.stream().distinct().collect(Collectors.toList());
    }


    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            for (int i : nums) {
                for (int num1 : nums) {
                    if ((num+i+num1 == 0 ) && ((num1 != num) || (num1 != i) || (i != num))){
                        List<Integer> integers = new ArrayList<>();
                        integers.add(num);
                        integers.add(num1);
                        integers.add(i);
                        list.add(new ArrayList<>(integers));
                    }

                }
            }
        }

        return list.stream().distinct().collect(Collectors.toList());
    }
}
