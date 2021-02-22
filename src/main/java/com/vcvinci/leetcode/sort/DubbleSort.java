package com.vcvinci.leetcode.sort;

/**
 * @author vinci
 * @Title: DubbleSort
 * @ProjectName vcvinci-leetcode
 * @Description: TODO
 * @date 2021/1/278:23 上午
 */
public class DubbleSort {

    public static void main(String[] args) {
        int[] arrs = new int[]{31, 32, 5, 6, 12, 9};
        for (int i = 0; i < arrs.length; i++) {
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[i] > arrs[j]) {
                    arrs[i] ^= arrs[j];
                    arrs[j] ^= arrs[i];
                    arrs[i] ^= arrs[j];
                }
            }
        }
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }
    public static void dubble(int[] arrs) {
        for (int i = 1; i < arrs.length; i++) {
            for (int j = 0; j < arrs.length - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    arrs[j] ^= arrs[j + 1];
                    arrs[j + 1] ^= arrs[j];
                    arrs[j] ^= arrs[j + 1];
                }
            }
        }
        for (int i = 0; i < arrs.length; i++) {
            System.out.println(arrs[i]);
        }
    }
}
