package com.algorithm.leetcode.other.queueOrStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: #225 用队列实现栈
 * @author: shangqj
 * @date: 2024/3/25
 * @version: 1.0
 */
public class MyStack {

    Queue<Integer> queue;

    public MyStack(){
        queue = new LinkedList<>();
    }

    //每offer一个数进来，都重新排列，把这个数放到对首
    public void push(int x){
        queue.offer(x);
        int size = queue.size();
        //移动除了A的其他数
        while (size-- >1){
            queue.offer(queue.poll());
        }
    }

    public Integer pop (){
        return queue.poll();
    }

    public Integer top(){
        return queue.peek();
    }

    public boolean empty(){
        return queue.isEmpty();
    }

}
