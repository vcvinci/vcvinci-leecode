package com.vcvinci.leetcode.dp;

/**
 * @author vinci
 * @Title: CollectChange
 * @ProjectName vcvinci-leetcode
 * @Description: TODO
 * @date 2021/2/2311:23 下午
 */
public class CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 11));

        System.out.println(coinChangeDp(coins, 11));
    }

    /**
     * 1. 暴力递归
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            res = Math.min(res, sub + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 动态规划
     *       -> 0, n = 0
     * dp(n) -> INF, n < 0
     *       -> min{dp(n - coin) + 1 | coin > coins}, n > 0
     */
    public static int coinChangeDp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);

            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];

    }
}

