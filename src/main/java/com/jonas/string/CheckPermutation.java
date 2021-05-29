package com.jonas.string;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode567:
 * Given two strings s1 and s2, return true if s2 contains the permutation of s1.
 * In other words, one of s1's permutations is the substring of s2.
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-05-29
 */
public class CheckPermutation {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.compute(c, (k, ov) -> null == ov ? 1 : ov + 1);
        }

        int valid = 0, left = 0, right = 0;
        while (right < s2.length()) {
            //e是将移入窗口的字符
            char e = s2.charAt(right);
            //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            if (need.containsKey(e)) {
                window.compute(e, (k, ov) -> null == ov ? 1 : ov + 1);
                if (need.get(e).equals(window.get(e))) {
                    valid++;
                }
            }

            /*** debug 输出的位置 ***/
            System.out.printf("window: [%s, %s)%n", left, right);

            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                if (need.size() == valid) {
                    return true;
                }

                //q是将移出窗口的字符
                char q = s2.charAt(left);
                //左移窗口
                left++;
                //进行窗口内数据的一系列更新
                if (need.containsKey(q)) {
                    if (need.get(q).equals(window.get(q))) {
                        valid--;
                    }
                    window.put(q, window.get(q) - 1);
                }
            }
        }
        return false;
    }
}
