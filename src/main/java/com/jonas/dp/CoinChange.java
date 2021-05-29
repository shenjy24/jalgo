package com.jonas.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 凑零钱问题：
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，
 * 问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1 。
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-05-04
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange app = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 100;
//        System.out.println(app.coinChange(coins, amount));
        System.out.println(app.memoCoinChange(coins, amount));
//        System.out.println(app.dpCoinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //求子问题
            int subRes = coinChange(coins, amount - coin);
            //子问题无解，跳过
            if (subRes == -1) continue;
            res = Math.min(res, subRes + 1);
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }

    //备忘录解法
    public int memoCoinChange(int[] coins, int amount) {
        Map<Integer, Integer> memo = new HashMap<>();
        return doMemoCoinChange(coins, amount, memo);
    }

    private int doMemoCoinChange(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) return memo.get(amount);
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            //求子问题
            int subRes = doMemoCoinChange(coins, amount - coin, memo);
            //子问题无解，跳过
            if (subRes == -1) continue;
            res = Math.min(res, subRes + 1);
        }
        memo.put(amount, res != Integer.MAX_VALUE ? res : -1);
        return memo.get(amount);
    }

    //DP表解法
    public int dpCoinChange(int[] coins, int amount) {
        Map<Integer, Integer> dp = new HashMap<>();
        //base case
        dp.put(0, 0);
        for (int i = 0; i < (amount + 1); i++) {
            for (int coin : coins) {
                //子问题无解，跳过
                if (i < coin || !dp.containsKey(i - coin)) continue;
                int val = Math.min(dp.getOrDefault(i, Integer.MAX_VALUE), 1 + dp.get(i - coin));
                dp.put(i, val);
            }
        }
        if (!dp.containsKey(amount) || dp.get(amount) == Integer.MAX_VALUE) {
            return -1;
        }
        return dp.get(amount);
    }
}
