package com.jonas.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-05-03
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci app = new Fibonacci();
        System.out.println(app.fib(20));
        System.out.println(app.memoFib(20));
        System.out.println(app.dpFib(20));
        System.out.println(app.dpFib2(20));
    }

    //暴力递归
    public int fib(int n) {
        if (1 == n || 2 == n) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    //带备忘录的递归解法
    public int memoFib(int n) {
        if (n < 1) return 0;
        //初始化备忘录
        Map<Integer, Integer> memo = new HashMap<>();
        return doMemoFib(memo, n);
    }

    private int doMemoFib(Map<Integer, Integer> memo, int n) {
        if (1 == n || 2 == n) return 1;
        if (memo.containsKey(n)) return memo.get(n);
        memo.put(n, doMemoFib(memo, n - 1) + doMemoFib(memo, n - 2));
        return memo.get(n);
    }

    //dp数组的迭代解法
    int dpFib(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        //base case
        dp.put(1, 1);
        dp.put(2, 1);
        for (int i = 3; i <= n; i++) {
            dp.put(i, dp.get(i - 1) + dp.get(i - 2));
        }
        return dp.get(n);
    }

    int dpFib2(int n) {
        if (1 == n || 2 == n) return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}
