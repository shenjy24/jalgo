package com.jonas.string;

/**
 * 问题：给定一个字符串str, 求其中全部数字子串所代表的数字之和
 * <p>
 * 要求：
 * 1.忽略小数点字符，例如"A1.3"，其中包含两个数字1和3
 * 2.如果紧贴数字子串的左侧出现字符"-"，当连续出现的数量为奇数时，则数字视为负，连续出现的数量
 * 为偶数时，则数字视为正。例如，"A-1BC--12"，其中包含数字为-1和12
 * <p>
 * 举例：
 * 1.str="A1CD2E33"，返回36
 * 2.str="A-1B--2C--D6E"，返回7
 *
 * @author shenjy
 * @since 2019-07-08
 */
public class NumSum {

    public static void main(String[] args) {
        String str = "A-1B---2C--D6E1";
        System.out.println(numSum(str));
    }

    public static int numSum(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }

        char[] chars = str.toCharArray();
        //表示目前的累加和
        int res = 0;
        //表示当前收集到的数字
        int num = 0;
        //表示收集到的数字是否是正数
        boolean posi = true;
        //表示当前值
        int cur = 0;

        for (int i = 0; i < chars.length; i++) {
            cur = chars[i] - '0';
            //当前字符不是数字时，将收集到的数字num累加到res中
            if (cur < 0 || cur > 9) {
                res += num;
                //累加后将num置为0
                num = 0;
                if ('-' == chars[i]) {
                    if (i - 1 > -1 && '-' == chars[i - 1]) {
                        posi = !posi;
                    } else {
                        posi = false;
                    }
                } else {
                    posi = true;
                }
            } else {
                num = num * 10 + (posi ? cur : -cur);
            }
        }

        //因为是以当前字符不是数字字符的时候进行累加，如果是以数字字符结尾则最后一个
        //数字不会累加，因此需要做额外处理
        res += num;
        return res;
    }
}
