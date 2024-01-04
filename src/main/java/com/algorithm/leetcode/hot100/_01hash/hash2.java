package com.algorithm.leetcode.hot100._01hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @description: #49 字母异位词分组
 * @author: shangqj
 * @date: 2024/1/3
 * @version: 1.0
 */
public class hash2 {
    /**
     给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

     示例 1:
     输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

     示例 2:
     输入: strs = [""]
     输出: [[""]]

     示例 3:
     输入: strs = ["a"]
     输出: [["a"]]

     提示：
     1 <= strs.length <= 104   0 <= strs[i].length <= 100   strs[i] 仅包含小写字母
     * @param args a
     */
    public static void main(String[] args) {
        String [] strings = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams1(strings);
        List<List<String>> lists2 = groupAnagrams2(strings);
        List<List<String>> lists3 = groupAnagrams3(strings);
        List<List<String>> lists4 = groupAnagrams4(strings);
        System.out.println("lists = " + lists);
        System.out.println("lists2 = " + lists2);
        System.out.println("lists3 = " + lists3);
        System.out.println("lists4 = " + lists4);
    }


    /**
     * key1：异位词 按字母从小到大排序 具有相同的顺序特征
     * key2：一旦需要根据特征进行归类，就应该使用散列表   本题：字母的顺序排序是key，包含单词的数组是value
     * key3：将map的value值返回即可
     *
     * 时间复杂度：O(nklogk) -> 其中n是strs中字符串的数量，k是strs中字符串最大长度，需要遍历n个字符串，对于每个字符串
     * 需要O(klogk)的时间排序以及O(1)的时间更新哈希表，因此总的时间复杂度为O(nklogk)
     *
     * 空间复杂度：O(nk) -> 其中n是str中字符串的数量，k是strs中字符串的最大长度。需要用哈希表存储全部字符串
     *
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams1(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();
        HashMap<String, List> map = new HashMap<>();
        for (String str : strs) {
            //获取到字符的字母排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            //将字母排序作为key
            String key = String.valueOf(charArray);

            //判断有没有key  没有则将key添加到map中
            if (!map.containsKey(key)){
                map.put(key,new ArrayList());
            }
            //list中添加当前字符串
            map.get(key).add(str);
        }
        //返回map的values值
        return new ArrayList(map.values());
    }


    public static List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length != 0){
            HashMap<String, List> map = new HashMap<>();
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key = Arrays.toString(charArray);

                if (!map.containsKey(key)){
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(str);
            }
            return new ArrayList(map.values()) ;
        }else
            throw new IllegalArgumentException("数组异常");

    }


    public static List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<String, List> map = new HashMap<>();
        if (strs.length != 0){
            for (String str : strs) {
                char[] charArray = str.toCharArray();
                Arrays.sort(charArray);
                String key = Arrays.toString(charArray);

                if (!map.containsKey(key)){
                    map.put(key,new ArrayList<>());
                }
                map.get(key).add(str);

            }
            return new ArrayList(map.values());
        }else
            throw new IllegalArgumentException("数组异常");

    }

    /**
     * 使用stream流 解决
     * @param strs 数组
     * @return list
     */
    public static List<List<String>> groupAnagrams4(String[] strs) {

        return new ArrayList(Arrays.stream(strs).collect(
                Collectors.groupingBy(o -> {
                    char[] charArray = o.toCharArray();
                    Arrays.sort(charArray);
                    return new String(charArray);
                })
        ).values())  ;
    }

}
