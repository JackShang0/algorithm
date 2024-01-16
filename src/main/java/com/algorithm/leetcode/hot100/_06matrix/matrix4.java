package com.algorithm.leetcode.hot100._06matrix;

/**
 * @description: #240 搜索二维矩阵
 * @author: shangqj
 * @date: 2024/1/15
 * @version: 1.0
 */
public class matrix4 {

    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
     * 输出：true
     * 示例 2：
     * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
     * 输出：false
     *
     * @param args a
     */
    public static void main(String[] args) {

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean b = searchMatrix(matrix, 5);
        System.out.println("b = " + b);

    }

    /**
     * 2024.1.16 利用二分法进行  并非最优解，但是优于暴力解
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return flag
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int search = search(matrix[i], target);
            if (search >= 0)
                return true;
        }
        return false;
    }

    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public static boolean searchMatrix1(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;
        //规定遍历范围为 0 ， n-1
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] > target)
                --y;
            else
                ++x;
        }

        return false;

    }

}
