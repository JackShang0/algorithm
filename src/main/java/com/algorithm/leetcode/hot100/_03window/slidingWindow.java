package com.algorithm.leetcode.hot100._03window;

import java.util.HashMap;

/**
 * @description:
 * @author: shangqj
 * @date: 2024/1/9
 * @version: 1.0
 */
public class slidingWindow {
    public static void main(String[] args) {

    }


    /**
     * 滑动窗口算法框架
     *
     * 其中两处...表示的更新窗口数据的地方，到时候直接填即可，并且两处...分别对应着左移和右移操作
     *
     * @param s
     * @param t
     */
    public void slidingWindowTemplate(String s, String t){
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int left = 0;
            int right = 0;
            int valid = 0;

            while (right<s.length()){
                //c是将移入窗口的字符
                char c = s.charAt(right);

                //右移窗口
                right++;

                // 进行窗口内数据的一系列更新
                //...

                System.out.println(left+"\t"+right);

                // 判断左侧窗口是否要收缩
                while (true){
                    // d 是将移出窗口的字符
                    char d = s.charAt(left);
                    // 左移窗口
                    left++;
                    // 进行窗口内数据的一系列更新
                    //...
                }
            }
        }
    }

}
