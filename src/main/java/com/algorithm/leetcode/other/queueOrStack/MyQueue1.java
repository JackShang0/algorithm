package com.algorithm.leetcode.other.queueOrStack;

import java.util.Stack;

/**
 * @description: #232
 * @author: shangqj
 * @date: 2024/3/25
 * @version: 1.0
 */
public class MyQueue1 {

    //定义两个栈来实现队列的功能  栈是先进后出，队列是先进先出
    Stack<Integer> stackOut;
    Stack<Integer> stackIn;


    public MyQueue1() {
        stackOut = new Stack<>();
        stackIn = new Stack<>();
    }


    //将数据push到入栈中
    public void push(int x) {
        stackIn.push(x);
    }


    public Integer pop() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.pop();
    }


    public Integer peek() {
        if (stackOut.isEmpty()){
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
        return stackOut.peek();
    }

    public boolean empty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }


}
