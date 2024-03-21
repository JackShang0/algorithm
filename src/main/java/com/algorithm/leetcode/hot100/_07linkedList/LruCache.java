package com.algorithm.leetcode.hot100._07linkedList;

import java.util.HashMap;

/**
 * @description:
 * @author: shangqj
 * @date: 2024/3/14
 * @version: 1.0
 */
public class LruCache {


    HashMap<Integer,CLinkedNode> cache = new HashMap<Integer,CLinkedNode>();
    private int size;
    private int capacity;
    private CLinkedNode head,tail;

    public LruCache(int capacity){
        this.size = 0;
        this.capacity = capacity;

        //使用伪头节点和伪尾节点
        head = new CLinkedNode();
        tail = new CLinkedNode();
        head.next = tail;
        tail.next = head;
    }

    public void put(int key,int value){
        CLinkedNode node = cache.get(key);
        if (node==null){
            //如果key存在，创建一个新的节点
            CLinkedNode newNode = new CLinkedNode(key, value);

            //添加进哈希表
            cache.put(key,newNode);

            //添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity){
                //超出容量，删除双向链表的尾部节点
                CLinkedNode tail = removeTail();

                //删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }else {
            //如果key存在，先通过哈希表定位，在修改value，并移动至头节点
            node.value = value;
            moveToHead(node);
        }
    }

    /**
     * 移动节点至头节点
     * @param node node
     */
    private void moveToHead(CLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除尾节点
     * @return
     */
    private CLinkedNode removeTail() {
        CLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    private void removeNode(CLinkedNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(CLinkedNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }


    public int get(int key){
        CLinkedNode cLinkedNode = cache.get(key);
        if (cLinkedNode==null){
            return -1;
        }

        //如果key存在，先通过哈希表定位，再移动到头部
        moveToHead(cLinkedNode);
        return cLinkedNode.value;
    }

    class CLinkedNode{
        int key;
        int value;
        CLinkedNode pre;
        CLinkedNode next;

        public CLinkedNode(){}

        public CLinkedNode(int key,int value){
            key = key;
            value = value;
        }


    }

}

