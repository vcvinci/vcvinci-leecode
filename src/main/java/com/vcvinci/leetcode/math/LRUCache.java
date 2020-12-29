package com.vcvinci.leetcode.math;

import java.util.HashMap;
import java.util.Map;

/**
 * @author vinci
 * @Title: LRUCache
 * @ProjectName vcvinci-leetcode
 * @Description: TODO
 * @date 2020/12/306:39 上午
 */
public class LRUCache {

    class DequeNode {
        int key;
        int value;
        DequeNode pre;
        DequeNode next;

        public DequeNode() {
        }

        public DequeNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, DequeNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DequeNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DequeNode();
        tail = new DequeNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DequeNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        move2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        DequeNode node = cache.get(key);
        if (node == null) {
            DequeNode newNode = new DequeNode(key, value);
            cache.put(key, newNode);
            offerFirst(newNode);
            ++size;
            if (size > capacity) {
                DequeNode tail = pollLast();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            move2Head(node);
        }

    }

    private void offerFirst(DequeNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DequeNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void move2Head(DequeNode node) {
        removeNode(node);
        offerFirst(node);
    }

    private DequeNode pollLast() {
        DequeNode res = tail.pre;
        removeNode(res);
        return res;
    }

}
