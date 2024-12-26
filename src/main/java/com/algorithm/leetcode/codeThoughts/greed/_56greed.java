package com.algorithm.leetcode.codeThoughts.greed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class _56greed {
    public static void main(String[] args) {
        String a = "222";
        int b = 333;
        System.out.println(a+b);

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(3);
        System.out.println(list);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList);
        //[[1,3],[2,6],[8,10],[15,18]]
        int [] ints1 = {1,3};
        int [] ints2 = {2,6};
        int [] ints3 = {8,10};
        int [] ints4 = {15,18};
        LinkedList<int[]> ints = new LinkedList<>();
        ints.add(ints1);
        ints.add(ints2);
        ints.add(ints3);
        ints.add(ints4);
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Arrays.sort(intervals);

    }

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals,(o1,o2)->Integer.compare(o1[0],o2[0]) );
        result.add(intervals[0]);
        for(int i= 1;i < intervals.length;i++){
            //如果区间重合
            if(intervals[i][0]<=result.getLast()[1]){
                int start = result.getLast()[0];
                int end = Math.max(intervals[i][1],result.getLast()[1]);
                result.removeLast();
                result.add(new int[]{start,end});
            }else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }



    public int[][] merge2(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals,(o1, o2) -> o1[0]-o2[0]);
        for(int [] interval: intervals){
            if(result.size()==0|| interval[0]>result.get(result.size()-1)[1]){
                result.add(interval);
            }else {
                result.get(result.size()-1)[1]=Math.max(result.get(result.size()-1)[1],interval[1]);
            }
        }
        return  result.toArray(new int[result.size()][2]);
    }
}
