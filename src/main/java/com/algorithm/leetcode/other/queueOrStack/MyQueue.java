package com.algorithm.leetcode.other.queueOrStack;

import java.util.Stack;

/**
 * @description: #232 用栈实现队列
 * @author: shangqj
 * @date: 2024/3/25
 * @version: 1.0
 */
public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;


    public MyQueue() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    public void push(int x) {
        stackIn.push(x);
    }


    //如果 stackOut 为空，那么将所有 stackIn 中的元素都放到 stackOut 中
    public Integer pop() {
        if (!stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }

    public Integer peek() {
        if (!stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }


    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }


}
