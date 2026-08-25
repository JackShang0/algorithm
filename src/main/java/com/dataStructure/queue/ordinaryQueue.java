package com.dataStructure.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 普通队列
 * @author: shangqj
 * @date: 2024/3/25
 * @version: 1.0
 */
public class ordinaryQueue {

    public static void main(String[] args) {
        //Queue queue = new Queue();


        LinkedList<Object> objects = new LinkedList<>();
        Queue<Object> objects1 = new LinkedList<>();
        objects1.offer("");
        int size = objects1.size();
        //objects.push("0");
        objects.offer("1");
        objects.offer("2");
        objects.offer("0");

        System.out.println("objects = " + objects);

        System.out.println(objects.peek());
        System.out.println(objects.peek());
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects.poll());
        System.out.println(objects.isEmpty());



    }
}
