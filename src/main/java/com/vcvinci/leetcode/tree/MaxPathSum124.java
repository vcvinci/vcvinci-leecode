package com.vcvinci.leetcode.tree;

import com.vcvinci.leetcode.tree.base.BinaryTreeNode;

/**
 * @author vinci
 * @version: 1.0.0
 * @ProjectName vcvinci-leetcode
 * @Description: TODO
 * @date 2021/3/256:35 下午
 */
public class MaxPathSum124 {


    public static int MIN = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTreeNode<Integer> integerBinaryTreeNode = new BinaryTreeNode<>().generateBinaryTree();

        System.out.println(maxPathSum(integerBinaryTreeNode));
    }

    public static int maxPathSum(BinaryTreeNode<Integer> head) {
        getAnInt(head);
        return MIN;
    }

    private static int getAnInt(BinaryTreeNode<Integer> head) {
        if (head == null) {
            return 0;
        }
        int left = getAnInt(head.getLeft());
        int right = getAnInt(head.getRight());
        MIN = Math.max(MIN, left + right + head.getValue());
        return Math.max(left, right) + head.getValue();
    }
}
