package com.algorithm.leetcode.hot100._01hash;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @description: 画解算法：#1. 两数之和
 * @author: shangqj
 * @date: 2024/1/2
 * @version: 1.0
 */
public class hash1 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     * <p>
     * <p>
     * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
     */
    public static void main(String[] args) {
        //测试用例：*3
        //int [] nums = {2,7,11,15};
        //int [] nums = {3,3};
        int[] nums = {3, 2, 4};
        //int target = 9;
        int target = 6;
        int[] ints1 = twoSum1(nums, target);
        int[] ints2 = twoSum2(nums, target);
        /*int[] ints3 = twoSum3(nums, target);
        int[] ints4 = twoSum4(nums, target);*/

        for (int anInt : ints2) {
            System.out.println("anInt = " + anInt);
        }
    }

    /**
     * 由于哈希查找的时间复杂度为 O(1)，所以可以利用哈希容器 map 降低时间复杂度
     * 遍历数组 nums，i 为当前下标，每个值都判断map中是否存在 target-nums[i] 的 key 值
     * 如果存在则找到了两个值，如果不存在则将当前的 (nums[i],i) 存入 map 中，继续遍历直到找到为止
     * @param nums 数组
     * @param target 目标值
     * @return 如果最终都没有结果则抛出异常
     */
    public static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    /**
     * 输入一个数组 和 目标target 输出和为target的数的索引
     * @param nums 数组
     * @param target 目标
     * @return int
     */
    public static int[] twoSum4(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{ map.get(target - nums[i]),i};
            }
            map.put(nums[i],i );
        }
        throw new IllegalArgumentException("");
    }







    public static int[] twoSum3(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        //对数组遍历
        for (int i = 0; i < nums.length; i++) {
            //判断map中是否有 tar - 当前遍历的值
            if (map.containsKey(target - nums[i])){
                //返回map中当前差值的索引  以及当前值的索引
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw  new IllegalArgumentException("no two sum solution");
    }


    /**
     * 暴露遍历  时间复杂度为O(n²)
     * @param nums 数组
     * @param target 目标值
     * @return 返回索引
     */
    public static int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (target == nums[i] + nums[j] && i != j) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 2024/01/05   前提：只返回一种答案，数组元素不重复出现
     */
    public static int[] twoSum5(int[] nums, int target) {
        //1、创建一个map  key为具体值，value为索引
        HashMap<Integer, Integer> map = new HashMap<>();

        //2、遍历数组
        for (int i = 0; i < nums.length; i++) {
            //4、如果map中含有满足和为target的值，则直接返回索引的int[]
            if (map.containsKey( target - nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            //3、如果map里面没有这个值，那就将这个值和索引给放进去
            map.put(nums[i],i );
        }
        throw new IllegalArgumentException("args error");
    }






}
