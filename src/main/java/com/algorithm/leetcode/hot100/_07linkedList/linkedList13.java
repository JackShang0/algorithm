package com.algorithm.leetcode.hot100._07linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: #146 LUR 缓存
 * @author: shangqj
 * @date: 2024/3/14
 * @version: 1.0
 */
public class linkedList13 {


    Entry head, tail;
    int capacity;
    int size;
    Map<Integer, Entry> cache;


    public linkedList13(int capacity) {
        this.capacity = capacity;
        initLinkedList();
        size = 0;
        cache = new HashMap<>(capacity + 2);
    }

    private void initLinkedList() {
        head = new Entry();
        tail = new Entry();

        head.next = tail;
        tail.pre = head;
    }


    public static class Entry {
        public Entry pre;
        public Entry next;
        public int key;
        public int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Entry() {

        }

    }


    /**
     * put的加入缓存的方法
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        //map的查询的时间复杂度为O（1） 所以使用缓存的map查询
        Entry node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
            return;
        }

        //不存在，此时容量已满，删除尾节点
        if (size == capacity) {
            Entry lastNode = tail.pre;
            deleteNode(lastNode);
            cache.remove(lastNode.key);
            size--;
        }

        //加入头节点
        Entry newNode = new Entry();
        newNode.key = key;
        newNode.value = value;
        addNode(newNode);
        cache.put(key, newNode);
        size++;
    }

    private void moveToHead(Entry node) {
        //删除原来节点的关系
        deleteNode(node);
        addNode(node);
    }

    private void addNode(Entry node) {
        node.next.pre = node;
        node.next = head.next;

        node.pre = head;
        head.next = node;
    }

    private void deleteNode(Entry node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;

    }

    public int get(int key){
        Entry entry = cache.get(key);
        if (entry == null){
            return -1;
        }

        moveToHead(entry);
        return entry.value;
    }

    public static void main(String[] args) {
        linkedList13 cache = new linkedList13(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println("cache = " + cache.get(1));
        cache.put(3,3);
        System.out.println("cache = " + cache.get(2));

    }

}
