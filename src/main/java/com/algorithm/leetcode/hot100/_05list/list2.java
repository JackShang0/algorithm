package com.algorithm.leetcode.hot100._05list;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: #56 合并区间
 * @author: shangqj
 * @date: 2024/1/10
 * @version: 1.0
 */
public class list2 {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * <p>
     * 示例 1：
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ints = merge2(intervals);
    }


    public static int[][] merge(int[][] intervals) {
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        if (intervals.length < 2 || intervals == null)
            return intervals;

        //排序
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        for (int[] interval : intervals) {
            if (arrayList.size()==0 || interval[0]>arrayList.get(arrayList.size()-1)[1]){
                arrayList.add(interval);
            } else {
                arrayList.get(arrayList.size()-1)[1] = Math.max(arrayList.get(arrayList.size()-1)[1],interval[1]);
            }
        }


        return arrayList.toArray(new int[arrayList.size()][2]);
    }

    /**
     * 2024.1.10
     * @param intervals
     * @return
     */
    public static int[][] merge1(int[][] intervals) {
        //创建一个数组，因为不好确定二维数组的第一个纬度的值大小
        ArrayList<int[]> ints = new ArrayList<>();

        //首先对数组进行排序  ->   按照二维数组的第一个数的大小排序
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        for (int[] interval : intervals) {
            //如果 当前数组没有值，则将当前的区间添加进行
            // 如果数组有值，则需要使得数组的最后一个区间的最大范围是小于当前区间的开区间的
            if (ints.size()==0 || interval[0]>ints.get(ints.size()-1)[1]){
                ints.add(interval);
            }else {
                //否则，我们认为区间是没有间隙的，是相连的
                //需要判断数组的最大范围和当前区间的最大值谁大  谁大用谁
                ints.get(ints.size()-1)[1] = Math.max(interval[1],ints.get(ints.size()-1)[1]);
            }
        }


        //转换为二维数组
        return ints.toArray(new int[ints.size()][2]);
    }


    /**
     * 2024.1.11
     * @param intervals
     * @return
     */
    public static int[][] merge2(int[][] intervals) {

        //创建一个list，因为数组需要确定一维的长度  暂时未知，需要后面转为二维数组
        ArrayList<int[]> ints = new ArrayList<>();

        //排序  以区间的开区间大小排序
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);

        for (int[] interval : intervals) {
            //如果当前 interval 的左边大于当前 ints 中最右边的区间，则添加到 ints中
            if (ints.size()==0 || interval[0]>ints.get(ints.size()-1)[1]){
                ints.add(interval);
            }else {
                //否则 说明区间之间有交集，需要做合并处理
                ints.get(ints.size()-1)[1]=Math.max(interval[1],ints.get(ints.size()-1)[1]);
            }
        }


        return ints.toArray(new int[ints.size()][2]);
    }
}
