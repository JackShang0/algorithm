package com.algorithm.leetcode.hot100._03window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;


/**
 * @description: #3 无重复字符的最长字串
 * @author: shangqj
 * @date: 2024/1/4
 * @version: 1.0
 */
public class window1 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     * 示例 1:
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * @param args
     */
    public static void main(String[] args) {
        //String s = "abcabcbb";
        String s = "pwwkew";
        //int i = lengthOfLongestSubstring(s);
        //System.out.println("i = " + i);
        for (int i1 = 0; i1 < s.length(); i1++) {
            int i2 = s.indexOf(s.charAt(i1), i1 - 1);
            System.out.println("i2 = " + i2);
        }

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
        int rk = -1, ans = 0;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < length && !set.contains(s.charAt(rk + 1))) {
                //不断移动右指针
                set.add(s.charAt(rk + 1));
                ++rk;
            }
            //第i到rk个字符是一个极长的无重复字符字串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;

    }


    /**
     * 2024.1.9
     * 字符串中最长不重复字符序列   官解
     *
     * @param s 字符串
     * @return 最长字符
     */
    public static int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        if (n < 2) return n;

        //转换为字符数组
        char[] cs = s.toCharArray();
        // 存储上一个相同字符的索引
        int[] map = new int[128];
        Arrays.fill(map, -1);

        // li表示不包含重复字符的最左索引
        int longest = 1, li = 0;
        for (int i = 0; i < n; i++) {
            int prevIdx = map[cs[i]];
            if (prevIdx < li) {
                longest = Math.max(longest, i - li + 1);
            } else {
                longest = Math.max(longest, i - prevIdx);
                // 更新li
                li = prevIdx + 1;
            }
            // 更新prevIdx
            map[cs[i]] = i;
        }
        return longest;
    }


    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        if (n < 2) return n;


        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        int maxLength = 0;
        int currentLength = 0;
        int startIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            //if (hashtable.containsKey())
        }


        return 0;
    }

    public static int lengthOfLongestSubstring3(String s) {
        //创建一个散列表
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);

            //如果包含当前字符
            if (map.containsKey(ch)) {
                //
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }


    public static int lengthOfLongestSubstring4(String s) {
        int m = s.length();
        if (m == 0) {
            return 0;
        }
        int num = 1;  //初始值表示以s的第一个字符为结束的不重复的最长子串
        int max = 1;
        for (int i = 1; i < m; i++) {
            int index = s.indexOf(s.charAt(i), i - num);
            if (index < i) {  //num更新，表示以s的第i+1个字符为结束的不重复的最长子串
                num = i - index;
            } else {
                num = num + 1;
            }
            max = Math.max(max, num);
        }
        return max;
    }




}
