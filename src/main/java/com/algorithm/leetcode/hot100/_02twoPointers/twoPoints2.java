package com.algorithm.leetcode.hot100._02twoPointers;

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
        int i4 = maxArea4(ints1);
        int i5 = maxArea5(ints1);
        System.out.println(i);
        System.out.println(i4);
        System.out.println(i5);
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


    /**
     * 2024.1.8  盛水最多容器
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param height 数组
     * @return 最大值
     */
    public static int maxArea4(int[] height) {

        //定义左右两边的指针
        int res = 0;
        int i = 0;
        int j = height.length - 1;


        //当指针没有相遇时
        while (i < j) {
            //那边小那边向中间移动，寻找更大的值 同时 * （j-i）  -> 并且进行赋值与判断
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }


    /**
     * 盛水最大容量
     *
     * @param height 数组
     * @return 返回容量
     */
    public static int maxArea5(int[] height) {
        //定义左右两个指针
        int ri = 0;
        int le = height.length - 1;

        //定义最终容量
        int res = 0;

        while (ri < le) {
            res = height[ri] < height[le] ?
                    Math.max(res, (le - ri) * height[ri++]) : Math.max(res, (le - ri) * height[le--]);
        }
        return res;
    }
}
