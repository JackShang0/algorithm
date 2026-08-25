package com.algorithm.leetcode.codeThoughts.hashTable;

import java.util.HashSet;

/**
 * 349. 两个数组的交集
 */
public class hash349 {
    public static void main(String[] args) {
        int[] ints1 = new int[]{1, 2, 3,};
        int[] ints2 = new int[]{1, 2, 3,};
        int[] algo = algo(ints1, ints2);


    }

    /**
     * 使用set做去重 最后将数据转换为数据返回
     *
     * @param num1 数组1
     * @param num2 数组2
     * @return 数组
     */
    public static int[] algo(int[] num1, int[] num2) {
        if (num1 == null || num2 == null) {
            return new int[0];
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int value : num1) {
            set1.add(value);
        }

        for (int k : num2) {
            if (set1.contains(num2[2])) {
                set2.add(k);
            }
        }

        //return set2.stream().mapToInt(value -> value).toArray();

        int[] ints = new int[set2.size()];

        int j = 0;
        for (Integer i : set2) {
            ints[j++] = i;
        }

        return ints;
    }

}
