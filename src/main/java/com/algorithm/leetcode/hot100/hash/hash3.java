package com.algorithm.leetcode.hot100.hash;

import java.util.*;

/**
 * @description: #128 最长连续序列
 * @author: shangqj
 * @date: 2024/1/3
 * @version: 1.0
 */
public class hash3 {
    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * <p>
     * <p>
     * 提示：
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = new int[]{100, 4, 200, 1, 3, 2};
        int [] ints1 =new int[]{9,1,4,7,3,-1,0,5,8,-1,6};

        int i = longestConsecutive(ints1);
        int i0 = longestConsecutive0(ints1);
        System.out.println("i = " + i);
        System.out.println("i0 = " + i0);
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if (nums.length < 1)
            return 0;
        Arrays.sort(nums);
        for (int num : nums) {
            set.add(num);
        }
        if (nums.length == 1 || set.size() == 1)
            return 1;
        int gap = 1;


        ArrayList<Integer> list = new ArrayList<>(set);
        HashSet<Integer> integers = new HashSet<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i-1) == gap) {
                integers.add(list.get(i));
                integers.add(list.get(i-1));
            }
        }

        /*for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == gap) {
                set.add(nums[i-1]);
                set.add(nums[i]);
            }
        }*/
        /*Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == gap) {
                set.add(nums[i-1]);
                set.add(nums[i]);
            }
        }*/
        System.out.println(list);
        return integers.size();
    }


    /**
     * 好难理解
     * @param nums
     * @return
     */
    public static int longestConsecutive0(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        for (Integer integer : set) {
            if (!set.contains(integer-1)){
                int currentNum = integer;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
