package com.jonas.string;

/**
 * 题目：给定两个字符串str1和str2，返回两个字符串的最长公共子序列。
 * 举例：str1="1A2C3D4B56",str2="B1D23CA45B6A", "123456"或者"12C4B6"都是最长公共子序列，返回哪一个都行。
 * <p>
 * 时间复杂度：O(M*N)
 * 空间复杂度：O(M*N)
 *
 * @author shenjy 2018/12/24
 */
public class MaxSubSequence {

    /**
     * 填充动态规划表
     *
     * @param str1
     * @param str2
     * @return
     */
    public int[][] getdp(char[] str1, char[] str2) {
        int[][] dp = new int[str1.length][str2.length];
        dp[0][0] = str1[0] == str2[0] ? 1 : 0;
        //第一列
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
        }
        //第一行
        for (int j = 1; j < str2.length; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (str1[i] == str2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public String lcse(String str1, String str2) {
        if (null == str1 || "".equals(str1) || null == str2 || "".equals(str2)) {
            return "";
        }

        char[] chs1 = str1.toCharArray();
        char[] chs2 = str2.toCharArray();
        int[][] dp = getdp(chs1, chs2);

        /**
         * 通过动态规划表还原出最长公共子序列，具体方法如下：
         * 1、从矩阵的右下方开始，有三种移动方式：向上、向左、向左上。
         * 2、如果dp[i][j]大于dp[i-1][j]和dp[i][j-1]，说明之前计算dp[i][j]的时候，一定是选择了决策dp[i-1]dp[j-1]+1,
         * 可以确定str[i]等于str[j]，并且这个字符一定属于最长公共子序列，把这个字符放进res，然后向左上方移动。
         * 3、如果dp[i][j]等于dp[i-1][j]，说明之前在计算dp[i][j]的时候，dp[i-1][j-1]+1这个决策不是必须选择的决策，向上方移动即可。
         * 4、如果dp[i][j]等于dp[i][j-1]，与步骤3同理，向左方移动。
         * 5、如果dp[i][j]同时等于dp[i-1][j]和dp[i][j-1]，向上还是向下无所谓，选择其中一种即可，反正不会错过必须选择的字符。
         */
        int i = chs1.length - 1;
        int j = chs2.length - 1;
        char[] res = new char[dp[i][j]];
        int index = res.length - 1;
        while (index >= 0) {
            if (j > 0 && dp[i][j] == dp[i][j - 1]) {
                j--;
            } else if (i > 0 && dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                res[index--] = chs1[i];
                i--;
                j--;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        MaxSubSequence sequence = new MaxSubSequence();
        String str1="1A2C3D4B56";
        String str2="B1D23CA45B6A";
        System.out.println(sequence.lcse(str1, str2));
    }
}
