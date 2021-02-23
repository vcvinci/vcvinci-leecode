package com.vcvinci.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vinci
 * @Title: Fib
 * @ProjectName vcvinci-leetcode
 * @Description: TODO
 * @date 2021/2/2310:48 下午
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib0(6));
        System.out.println(fib1(6));
        System.out.println(fib2(6));
    }

    public static int fib0(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib0(n-1) + fib0(n-2);
    }

    /**
     * 带有缓存的方式
     */
    public static int fib1(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n +1];

        return helper(n, dp);
    }

    private static int helper(int n, int[] dp) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = helper(n-1, dp) + helper(n - 2, dp);
        return dp[n];
    }

    public static int fib2(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) {
            return 0;
        }
        int cur = 1;
        int pre = 1;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = cur + pre;
            pre = cur;
            cur = res;
        }
        return res;
    }

}
