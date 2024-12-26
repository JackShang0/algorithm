package com.algorithm.leetcode.codeThoughts.queue;

import java.util.ArrayDeque;
import java.util.Deque;

class MyStack {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1);
        deque.addLast(2);
        deque.add(3);
        deque.addLast(4);
        deque.addFirst(0);  // 默认加队列末尾
        System.out.println(deque);
        Integer i = deque.peekFirst();
        System.out.println(i);
        System.out.println("peek之后队列"+deque);
        Integer peek = deque.peek();
        System.out.println(peek);
        Integer pop = deque.pop();
        System.out.println("pop = " + pop);
        System.out.println("pop 之后 deque = " + deque);
        Integer i1 = deque.pollFirst();
        System.out.println("i1 = " + i1);
        System.out.println("pollfirst之后  deque = " + deque);
        Integer poll = deque.poll();
        System.out.println("poll = " + poll);
        System.out.println("poll 之后 deque = " + deque);
        Integer i2 = deque.pollLast();
        System.out.println("i2 = " + i2);
        System.out.println("polllast 之后 deque = " + deque);
    }

    // Deque 接口继承了 Queue 接口
    // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
    Deque<Integer> que1;
    /** Initialize your data structure here. */
    public MyStack() {
        que1 = new ArrayDeque<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        que1.addLast(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int size = que1.size();
        size--;
        // 将 que1 导入 que2 ，但留下最后一个值
        while (size-- > 0) {
            que1.addLast(que1.peekFirst()); //将最前的值
            que1.pollFirst();
        }

        int res = que1.pollFirst();
        return res;
    }
    
    /** Get the top element. */
    public int top() {
        return que1.peekLast();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que1.isEmpty();
    }
}