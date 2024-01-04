package com.algorithm.leetcode.hot100._03window;

import java.util.HashSet;


/**
 * @description: #3 无重复字符的最长字串
 * @author: shangqj
 * @date: 2024/1/4
 * @version: 1.0
 */
public class window1 {

    /**
     *
     给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

     示例 1:
     输入: s = "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:
     输入: s = "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:
     输入: s = "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

     * @param args
     */
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "pwwkew";
        int i = lengthOfLongestSubstring(s);
        System.out.println("i = " + i);
    }

    public static int lengthOfLongestSubstring(String s) {
        /*char[] charArray = s.toCharArray();
        HashSet<Character> ch = new HashSet<>();

        for (char c : charArray) {
            System.out.println("c = " + c);
            ch.add(c);
        }
        System.out.println("ch = " + ch);
        return ch.size();*/

        //哈希集合  记录每个字符是否出现过
        HashSet<Character> set = new HashSet<>();
        int length = s.length();
        int rk = -1,ans = 0;
        for (int i = 0; i < length; i++) {
            if (i!=0){
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i-1));
            }
            while (rk + 1<length && !set.contains(s.charAt(rk + 1))){
                //不断移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            //第i到rk个字符是一个极长的无重复字符字串
            ans = Math.max(ans,rk-i+1);
        }
        return ans;

    }



}
