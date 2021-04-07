package com.vcvinci.leetcode.tree.base;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vinci
 * @version: 1.0.0
 * @ProjectName vcvinci-leetcode
 * @Description: TODO
 * @date 2021/3/256:36 下午
 */
public class BinaryTreeNode<V> {

    V value;

    BinaryTreeNode<V> left;

    BinaryTreeNode<V> right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public BinaryTreeNode<V> setValue(V value) {
        this.value = value;
        return this;
    }

    public BinaryTreeNode<V> getLeft() {
        return left;
    }

    public BinaryTreeNode<V> setLeft(BinaryTreeNode<V> left) {
        this.left = left;
        return this;
    }

    public BinaryTreeNode<V> getRight() {
        return right;
    }

    public BinaryTreeNode<V> setRight(BinaryTreeNode<V> right) {
        this.right = right;
        return this;
    }

    /**
     *                      6
     *                    /  \
     *                   4    9
     *                  /\   / \
     *                 1 5  7  16
     */
    public BinaryTreeNode<Integer> generateBinaryTree() {
        BinaryTreeNode<Integer> left1 = new BinaryTreeNode<Integer>().setValue(4);
        left1.setLeft(new BinaryTreeNode<>(1)).setRight(new BinaryTreeNode<>(5));
        BinaryTreeNode<Integer> right1 = new BinaryTreeNode<Integer>().setValue(9);
        right1.setLeft(new BinaryTreeNode<>(7)).setRight(new BinaryTreeNode<>(16));
        return new BinaryTreeNode<Integer>().setValue(6)
                .setLeft(left1)
                .setRight(right1);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> head = new BinaryTreeNode<>().generateBinaryTree();
        recursionMiddleOrder(head);
        System.out.println("=================================");
        breadthFirstSearch(head);
    }

    // 中序遍历 是顺序的
    public static void recursionMiddleOrder(BinaryTreeNode<Integer> head) {
        if (head == null) {
            return;
        }
        recursionMiddleOrder(head.getLeft());
        System.out.println(head.value);
        recursionMiddleOrder(head.getRight());
    }

    // BFS
    public static void breadthFirstSearch(BinaryTreeNode<Integer> head) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> cur = queue.poll();
            System.out.println(cur.value);
            if (cur.getLeft() != null) {
                queue.offer(cur.getLeft());
            }
            if (cur.getRight() != null) {
                queue.offer(cur.getRight());
            }
        }
    }
}
