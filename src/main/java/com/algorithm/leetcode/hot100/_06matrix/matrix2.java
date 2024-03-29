package com.algorithm.leetcode.hot100._06matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: #54 螺旋矩阵
 * @author: shangqj
 * @date: 2024/1/15
 * @version: 1.0
 */
public class matrix2 {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * <p>
     * 示例 1：
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @param args a
     */
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //List<Integer> integers = spiralOrder(matrix);
        List<Integer> integers2 = spiralOrder2(matrix);
        //System.out.println("integers = " + integers);
        System.out.println("integers2 = " + integers2);

    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        //定义行、列
        int rows = matrix.length, columns = matrix[0].length;
        //定义一个是否访问的二维数组
        boolean[][] visit = new boolean[rows][columns];
        //定义二维数组的大小，即list的数组长度
        int total = rows * columns;
        //默认开始位置
        int row = 0, column = 0;
        //方向
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //方向索引
        int directionIndex = 0;

        //遍历二维数组所有元素
        for (int i = 0; i < total; i++) {
            //添加这个元素到list中
            list.add(matrix[row][column]);
            //已经添加该数据，则置为true
            visit[row][column] = true;

            //根据 row、方向、方向索引 决定出下一个位置的行和列
            int nextRow = row + directions[directionIndex][0];
            int nextColum = column + directions[directionIndex][1];
            System.out.println("nextRow = " + nextRow);
            System.out.println("nextColum = " + nextColum);
            //如果 下一个行 <0 || 下一个行 >= 最大行数  || 下一个列 < 0 || 下一个列 >= 最大列数  ||  当前元素已经访问过
            if (nextRow < 0 || nextRow >= rows || nextColum < 0 || nextColum >= columns || visit[nextRow][nextColum]) {
                //对索引 + 1 并对4取余
                directionIndex = (directionIndex + 1) % 4;
                System.out.println("directionIndex = " + directionIndex);
            }


            // 通过用 directions 中的元素进行累加，从而实现方向的控制
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }


        return list;
    }


    /**
     * 问题定位并解决 两个地方

     nextRow >= rows || nextCol >= columns   ->  nextRow >= rows || nextCol >= columns
     || visit[row][col])  ->  || visit[nextRow][nextCol])
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder1(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        //定义行
        int rows = matrix.length, columns = matrix[0].length;
        //定义方向  即坐标轴的方向
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //访问标识
        boolean[][] visit = new boolean[rows][columns];
        //方向索引
        int dirIndex = 0;
        //定义初始位置
        int row = 0, column = 0;
        //总数
        int total = rows * columns;

        for (int i = 0; i < total; i++) {
            list.add(matrix[row][column]);
            visit[row][column] = true;
            int nextRow = row + dir[dirIndex][0];
            int nextCol = column + dir[dirIndex][1];
            //此处需要包含 >=
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= columns
                    //注意此处的索引是应该是下一个位置
                    || visit[nextRow][nextCol]) {
                dirIndex = (dirIndex + 1) % 4;
            }

            row += dir[dirIndex][0];
            column += dir[dirIndex][1];
        }
        return list;
    }


    /**
     * 2024.1.15  ac by self
     * @param matrix
     * @return
     */
    public static List<Integer> spiralOrder2(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        //定义行和列
        int rows = matrix.length;
        int columns = matrix[0].length;
        //定义数组大小
        int total = rows * columns;
        //定义初始位置
        int row = 0, col = 0;
        //标记位置的二维数组
        boolean[][] visit = new boolean[rows][columns];
        //方向数组
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //方向索引
        int dirIndex = 0;

        for (int i = 0; i < total; i++) {
            list.add(matrix[row][col]);
            //位置标记
            visit[row][col] = true;
            int nextRow = row + dir[dirIndex][0];
            int nextCol = col + dir[dirIndex][1];
            //如果超出当前数组的最大值，并且下一个位置已经被访问过  就对索引进行+1，然后改变其方向
            if (nextRow < 0 || nextCol < 0 || nextRow >= rows || nextCol >= columns || visit[nextRow][nextCol]) {
                dirIndex = (dirIndex +1) % 4;
            }

            //方向进行控制  行加索引为0的位置   列加索引为1的位置
            row += dir[dirIndex][0];
            col += dir[dirIndex][1];
        }


        return list;
    }
}
