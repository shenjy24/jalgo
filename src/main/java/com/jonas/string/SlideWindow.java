package com.jonas.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 滑动窗口系列算法
 * Find All Anagrams in a String:
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * @author shenjy
 * @version 1.0
 * @date 2021-01-27
 */
public class SlideWindow {

    public static void main(String[] args) {
        SlideWindow app = new SlideWindow();
        //[0, 6]
        System.out.println(app.findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.compute(c, (k, ov) -> null == ov ? 1 : ov + 1);
        }

        int valid = 0, left = 0, right = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char e = s.charAt(right);
            right++;
            if (need.containsKey(e)) {
                window.compute(e, (k, ov) -> null == ov ? 1 : ov + 1);
                if (window.get(e).equals(need.get(e))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                if (right - left == p.length()) {
                    res.add(left);
                }

                char q = s.charAt(left);
                left++;
                if (need.containsKey(q)) {
                    if (need.get(q).equals(window.get(q))) {
                        valid--;
                    }
                    window.put(q, window.get(q) - 1);
                }
            }
        }

        return res;
    }

}
