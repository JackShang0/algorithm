package com.algorithm.leetcode.hot100._02twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: #15 三数之和
 * @author: shangqj
 * @date: 2024/1/3
 * @version: 1.0
 */
public class twoPoints3 {
    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k
     * 同时还满足 nums[i] + nums[j] + nums[k] == 0 。
     * 请你返回所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 示例 1：
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {-1, 0, 1, 2, -1, -4};
        int[] ints1 = {0, 1, 1};//[0,1,1]
        int[] ints2 = {0, 0, 0};//[0,0,0]
        List<List<Integer>> lists = threeSum(ints2);
        List<List<Integer>> lists3 = threeSum3(ints2);
        List<List<Integer>> lists5 = threeSum5(ints2);
        List<List<Integer>> lists6 = threeSum6(ints);
        System.out.println("lists = " + lists);
        System.out.println("lists = " + lists3);
        System.out.println("lists = " + lists5);
        System.out.println("lists = " + lists6);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            for (int i : nums) {
                for (int num1 : nums) {
                    if ((num + i + num1 == 0) && ((num1 != num) || (num1 != i) || (i != num))) {
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


    /**
     * 暴力枚举没有办法解决重复问题
     *
     * @param nums 数组
     * @return answer
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (int num : nums) {
            for (int i : nums) {
                for (int num1 : nums) {
                    if ((num + i + num1 == 0) && ((num1 != num) || (num1 != i) || (i != num))) {
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


    public static List<List<Integer>> threeSum2(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        int length = nums.length;
        if (nums == null || length < 3)
            return list;

        //将数组排序
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            //如果当前数字>0 则三数之和一定>0，所以结束循环        num[i] num[L] L为n+1开始 num[R] R从length-1 开始
            if (nums[i] > 0)
                break;

            //去除重复的值
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            //两个指针  从 i+1 到 length-1
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1])
                        L++;
                    while (L < R && nums[R] == nums[R - 1])
                        R--;

                    L++;
                    R--;

                } else if (sum < 0)
                    L++;
                else if (sum > 0)
                    R--;
            }
        }
        return list;
    }


    public static List<List<Integer>> threeSum3(int[] nums) {

        ArrayList<List<Integer>> list = new ArrayList<>();

        int length = nums.length;

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0)
                break;
            //去除重复的值
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int L = i + 1;
            int R = length - 1;

            while (L < R) {
                int sum = nums[i] + nums[R] + nums[L];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[R], nums[L]));
                    while (L < R && nums[L] == nums[L + 1])
                        L++;
                    while (L < R && nums[R] == nums[R - 1])
                        R--;

                    //这个是为啥 没太明白？？？
                    L++;
                    R--;
                } else if (sum < 0)
                    L++;
                else if (sum > 0)
                    R--;
            }
        }
        return list;
    }


    public static List<List<Integer>> threeSum4(int[] nums) {

        ArrayList<List<Integer>> list = new ArrayList<>();

        int length = nums.length;

        //排序
        Arrays.sort(nums);

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0)
                break;
            //去除重复的值
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int L = i + 1;
            int R = length - 1;

            while (L < R) {
                int sum = nums[i] + nums[R] + nums[L];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[R], nums[L]));
                    while (nums[L] == nums[L + 1])
                        L++;
                    while (nums[R] == nums[R - 1])
                        R--;

                    //这个是为啥 没太明白？？？
                    L++;
                    R--;
                } else if (sum < 0)
                    L++;
                else if (sum > 0)
                    R--;
            }
        }
        return list;
    }


    public static List<List<Integer>> threeSum5(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3)
            return list;

        //从小到大
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 1; i++) {
            //去除重复的值   重复值不进行遍历
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int L = i + 1;
            int R = nums.length - 1;

            //如果大于0  则继续循环  todo
            if (nums[i] > 0) {
                break;
            }


            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //todo  重复值不参与
                    while (L < R && nums[L] == nums[L + 1])
                        L++;
                    while (L < R && nums[R] == nums[R - 1])
                        R--;

                    R--;
                    L++;

                } else if (sum > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                }
            }
        }
        return list;
    }


    public static List<List<Integer>> threeSum6(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return list;

        //排序
        Arrays.sort(nums);

        //数组遍历  定义两个指针 左面的从i+1开始，右面从数组最大开始
        for (int i = 0; i < nums.length; i++) {
            //i去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int le = i + 1;
            int ri = nums.length - 1;

            //如果大于0，则跳过
            if (nums[i] > 0)
                break;

            //当两个指针不相遇时
            while (le < ri) {

                int sum = nums[i] + nums[le] + nums[ri];
                //和为0，则添加到list中，同时对le和ri的值进行去重和向中间移动
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[le], nums[ri]));
                    //注意条件  le < ri
                    while (le < ri && nums[le] == nums[le + 1])
                        le++;
                    while (le < ri && nums[ri] == nums[ri - 1])
                        ri--;

                    ri--;
                    le++;
                } else if (sum < 0) {      //小于0，则需要向右移动
                    le++;
                } else if (sum > 0) {     //大于0，则需要向左移动
                    ri--;
                }
            }
        }
        return list;
    }


    public List<List<Integer>> threeSum7(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<>();

        if (nums.length < 3) {
            return null;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            // 定义两个指针
            int le = i + 1;
            int ri = nums.length - 1;

            while (le < ri) {
                int sum = nums[i] + nums[le] + nums[ri];

                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[le], nums[ri]));

                    if (le < ri && nums[le] == nums[le + 1]) {
                        le++;
                    }
                    if (le < ri && nums[ri] == nums[ri - 1]) {
                        ri--;
                    }

                    le++;
                    ri--;
                } else if (sum > 0) {
                    ri--;
                } else if (sum < 0) {
                    le++;
                }
            }

        }
        return list;
    }
}
