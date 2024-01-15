package com.algorithm.leetcode.hot100._06matrix;

/**
 * @description: #79 矩阵置零
 * @author: shangqj
 * @date: 2024/1/15
 * @version: 1.0
 */
public class matrix1 {
    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：[[1,0,1],[0,0,0],[1,0,1]]
     * 示例 2：
     * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     *
     * @param args a
     */
    public static void main(String[] args) {

        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(matrix);
    }

    /**
     * 暴力解：将数组中包含0的位置进行标记，
     *
     * @param matrix 二维数组
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        //将当前二维数组进行拆分
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        //
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;

                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }


    /**
     * 1.15
     *
     * @param matrix 二维数组
     */
    public static void setZeroes1(int[][] matrix) {
        //要注意创建数组时候的取值   n为二维数组的长度
        int m = matrix.length, n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //如果当前位置数值为0，则将对应的行和列的位置全部置为true
                if (matrix[i][j] == 0) {
                    row[i] = col[j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (col[j] || row[i]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
