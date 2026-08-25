package com.algorithm.leetcode.codeThoughts.hashTable;

import java.util.HashSet;

/**
 * 202.快乐数
 */
public class hash202 {


    public static void main(String[] args) {
        boolean happy = isHappy(19);
        System.out.println("happy = " + happy);
    }


    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private static int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            //用n对10取余数，得到当前数对个位数字
            int temp = n % 10;
            res += temp * temp;
            //在用n对10做除法，得到新对当前数
            n = n / 10;
        }
        return res;
    }

}
