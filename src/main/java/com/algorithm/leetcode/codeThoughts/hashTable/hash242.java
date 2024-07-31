package com.algorithm.leetcode.codeThoughts.hashTable;


import java.util.ArrayList;

/**
 * 242.有效的字母异位词
 */
public class hash242 {

    public static void main(String[] args) {
        String a = "ab";
        int[] record = new int[26];     //创建int数组

        //字符串相减
        char b = 'a';
        char c = 'c';
        System.out.println("===");
        System.out.println(b - c);

        for (int i = 0; i < a.length(); i++) {
            int i1 = a.charAt(i) - 'a';
            System.out.println("i1 = " + i1);
        }

        //字符串   .length()
        int length = a.length();
        //数组    .length
        int length1 = args.length;
        //集合    .size()
        ArrayList<String> strings = new ArrayList<>();
        int size = strings.size();

        boolean algo = algo("abc", "aba");
        System.out.println("algo = " + algo);


        String d = "abcdef";
        char[] charArray = d.toCharArray();
        for (char c1 : charArray) {
            System.out.println("c1 = " + c1);
        }
    }


    /**
     * 242 解法
     *
     * @param s 字符串1
     * @param t 字符串2
     * @return 返回值
     */
    public static boolean algo(String s, String t) {
        /*
         * 思路：定义一个长度为26的数组，然后数组索引位置用字符串相减的方式控制，没有位置记录对应的字符出现的次数
         */
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
