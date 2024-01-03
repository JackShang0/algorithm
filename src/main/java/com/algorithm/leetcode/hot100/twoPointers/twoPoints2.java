package com.algorithm.leetcode.hot100.twoPointers;

/**
 * @description: #11  盛水最多的容器
 * @author: shangqj
 * @date: 2024/1/3
 * @version: 1.0
 */
public class twoPoints2 {
    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * 返回容器可以储存的最大水量。
     * 说明：你不能倾斜容器。
     * <p>
     * 示例 1：
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     * 示例 2：
     * 输入：height = [1,1]
     * 输出：1
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints1 = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxArea(ints1);
        System.out.println(i);
    }

    /**
     * 解题思路：
     * key1 ：由左右两端向内移动
     * key2： 移动左右两端的短板
     *
     * @param height 板的高度
     * @return 面积
     */
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;

        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }

        return res;

    }


    public static int maxArea1(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;

    }


    /**
     * 暴力枚举
     *
     * @param height 板的高度
     * @return 面积
     */
    public static int maxArea2(int[] height) {

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }


    public static int maxArea3(int[] height) {

        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }
}
