package com.algorithm.leetcode.codeThoughts.queue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347topKFrequent {
    public static void main(String[] args) {

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //按照从小到大的顺序排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //不足k个直接添加
            if (pq.size() < k) {
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > pq.peek()[1]) {
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;

    }


    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //创建优先队列
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[1]-o2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if (entry.getValue() > queue.peek()[1]) {
                    queue.poll();
                    queue.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < queue.size(); i++) {
            result[i] = queue.peek()[1];
        }
        return result;
    }
}
