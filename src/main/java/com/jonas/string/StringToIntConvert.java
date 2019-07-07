package com.jonas.string;

/**
 * 问题：给定一个字符串str,如果str符合日常书写的整数形式，
 * 并且属于32位整数的范围，返回str所代表的整数值，否则返回0
 * <p>
 * 举例：
 * str="123", 返回123
 * str="023", 不符合日常的书写习惯，所以返回0
 * str="A12", 返回0
 * str="0", 返回0
 * str="2147483647", 返回2147483647
 * str="2147483648", 溢出返回0
 * str="-123", 返回-123
 *
 * @author shenjy
 * @since 2019-07-07
 */
public class StringToIntConvert {

    public static void main(String[] args) {
        System.out.println(convert("-2147483638"));
        System.out.println(convert("-2147483658"));
    }

    public static int convert(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }

        char[] chars = str.toCharArray();
        if (!isValid(chars)) {
            return 0;
        }

        //判断是否是正数
        boolean posi = chars[0] != '-';
        //负数比正数拥有更大的绝对值范围，那么转换过程中一律以负数的形式记录绝对值
        int minq = Integer.MIN_VALUE / 10;
        int minr = Integer.MIN_VALUE % 10;

        //结果变量
        int res = 0;
        //当前字符大小
        int cur = 0;
        for (int i = posi ? 0 : 1; i < chars.length; i++) {
            cur = '0' - chars[i];
            //判断是否会溢出
            if ((res < minq) || (res == minq && cur < minr)) {
                return 0;
            }
            res = res * 10 + cur;
        }
        if (posi && res == Integer.MIN_VALUE) {
            return 0;
        }

        return posi ? -res : res;
    }

    public static boolean isValid(char[] chars) {
        //如果 str不以'-'开头，也不以数字字符开头，例如，str=="A12", 返回false
        if (chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
            return false;
        }
        if (chars[0] == '-' && (chars.length == 1 || chars[1] == '0')) {
            return false;
        }
        if (chars[0] == '0' && chars.length > 1) {
            return false;
        }
        //str中有一个非数字字符，则返回false
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }
        return true;
    }
}
