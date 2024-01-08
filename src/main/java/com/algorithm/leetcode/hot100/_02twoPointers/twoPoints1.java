package com.algorithm.leetcode.hot100._02twoPointers;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: 双指针案例1:  #283 移动零
 * @author: shangqj
 * @date: 2024/1/3
 * @version: 1.0
 */
public class twoPoints1 {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     * <p>
     * 提示:
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints1 = new int[]{0, 1, 0, 3, 12};
        //moveZeroes(ints1);
        //moveZeroes1(ints1);
        //moveZeroes2(ints1);
        moveZeroes5(ints1);
    }

    public static void moveZeroes(int[] nums) {

        List<int[]> collect = Stream.of(nums).sorted().collect(Collectors.toList());
        for (int[] ints : collect) {
            System.out.println("ints = " + ints);
        }
        System.out.println("collect = " + collect);

    }

    public static void moveZeroes1(int[] nums) {
        if (nums.length == 0)
            return;

        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }


    public static void moveZeroes2(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int num : nums) {
            System.out.println("j = " + num);
        }

    }


    /**
     * 2024.1.8  最优解
     *
     * @param nums 数组
     */
    public static void moveZeroes3(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
            j++;
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
    }

    /**
     * 算法解题思想：定义一个变量j，作为新的索引，将所有不为0的数全部放到0-j的位置上，然后将j-i位置的数全部置为0即可
     *
     * @param nums 待处理数组
     */
    public static void moveZeroes4(int[] nums) {
        if (nums.length == 0)
            return;

        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]  完成对0-j位置的数处理
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 2024.1.8 移动零
     * @param nums
     */
    public static void moveZeroes5(int[] nums) {
        if (nums.length == 0)
            return;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0)
                nums[j++]=nums[i];
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }


    }
}
