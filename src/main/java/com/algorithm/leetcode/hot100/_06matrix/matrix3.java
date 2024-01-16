package com.algorithm.leetcode.hot100._06matrix;

/**
 * @description: #48 旋转图像
 * @author: shangqj
 * @date: 2024/1/15
 * @version: 1.0
 */
public class matrix3 {

    /**
     *
     给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。


     示例 1：
     输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     输出：[[7,4,1],[8,5,2],[9,6,3]]
     示例 2：
     输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
     输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

     * @param args a
     */
    public static void main(String[] args) {

        int [][] matrix = {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};
        //rotate1(matrix);
        rotate2(matrix);
    }

    /**
     * 解题方法
     https://leetcode.cn/problems/rotate-image/solutions/526980/xuan-zhuan-tu-xiang-by-leetcode-solution-vu3m

     分析：旋转之后 -> 第i行 变为了 n-i-1列 ; 第j列 变为了 第j行
     * @param matrix 数组
     */
    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        int[][] matrix_new = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix_new[j][n - i - 1] = matrix[i][j];
                //System.out.print("  " + matrix_new[i][j]);
            }
            //System.out.println(" \t " );
        }

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                matrix[i][j] = matrix_new[i][j];
                //System.out.print("  " + matrix[i][j] + "\t");
                //System.out.println("\t");
                //System.out.print("  " + matrix_new[i][j]);
            }
            System.out.println(" \t " );
        }
    }


    /**

     * @param matrix
     */
    public static void rotate1(int[][] matrix) {

        int n = matrix.length;
        // 深拷贝 matrix -> tmp
        int[][] tmp = new int[n][];
        for (int i = 0; i < n; i++){
            tmp[i] = matrix[i].clone();
            //System.out.println("tmp[i] = " + tmp[i]);
            for (int j : tmp[i]) {
                System.out.print(j + "\t");
            }
            System.out.println(" \n " );
        }
        // 根据元素旋转公式，遍历修改原矩阵 matrix 的各元素
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[j][n - 1 - i] = tmp[i][j];
                System.out.print("  " + matrix[j][n - 1 - i]);
            }
            System.out.println(" \n " );
        }
    }

    /**
     2021.1.16
     时间复杂度 O(n²)
     空间复杂度 O(n²)
     * @param matrix
     */
    public static void rotate2(int[][] matrix) {

        int n = matrix.length;
        //需要将数值进行copy，否则随着数据的赋值，二维数组的元素会丢失
        int[][] matrix_new = new int[n][n];

        //数值copy  旋转之后，第 i 行变为了 n-i-1 列  第j列变为了j行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[j][n-1-i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix_new[i][j];

                System.out.print("  " + matrix[i][j]);
            }
            System.out.println(" \t ");
        }
    }



}
