package com.jonas.number;

import java.util.Stack;

/**
 * 移除正整数的k个数，求最小值
 *
 * @author shenjy
 * @version 1.0
 * @date 2020-10-21
 */
public class RemoveKDigits {

    public String solve(String num, int k) {
        int[] nums = parseToArray(num);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!stack.empty() && k > 0 && cur < stack.peek()) {
                stack.pop();
                k--;
            }
            if (stack.empty() && 0 == cur) {
                continue;
            }
            stack.push(cur);
        }
        return parseToResult(stack, k);
    }

    private String parseToResult(Stack<Integer> stack, int k) {
        if (stack.size() <= k) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stack.size() - k; i++) {
            result.append(stack.get(i));
        }
        return result.toString();
    }

    private int[] parseToArray(String num) {
        int[] tmp = new int[num.length()];
        for (int i = 0; i < num.length(); i++) {
            tmp[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return tmp;
    }

    public static void main(String[] args) {
        RemoveKDigits app = new RemoveKDigits();
        System.out.println(app.solve("10200", 1));
    }
}
