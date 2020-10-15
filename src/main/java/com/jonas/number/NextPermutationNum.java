package com.jonas.number;

/**
 * @author shenjy
 * @date 2020/10/15
 * @description 正整数的下一个全排列数
 */
public class NextPermutationNum {

    public int solve(int num) {
        String str = String.valueOf(num);
        int length = str.length();
        int index = length - 1;
        int last = Integer.parseInt(String.valueOf(str.charAt(length - 1)));
        for (int i = length - 1; i > 0; i--) {
            int current = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (current >= last) {
                last = current;
                index--;
            } else {
                break;
            }
        }
        int before = Integer.parseInt(String.valueOf(str.charAt(index)));
        String sub = str.substring(index + 1);
        int subLength = sub.length();
        int replaceIndex = 0;

        int minGap = Integer.MAX_VALUE;
        for (int i = 0; i < subLength - 1; i++) {
            int current = Integer.parseInt(String.valueOf(sub.charAt(i)));
            if (current > before && current - before < minGap) {
                minGap = current - before;
                replaceIndex = i;
            }
        }

        int replaceNum = Integer.parseInt(String.valueOf(sub.charAt(replaceIndex)));
        StringBuilder result = new StringBuilder(str);
        result.replace(index, index + 1, String.valueOf(replaceNum));
        result.replace(index + replaceIndex + 1, index + replaceIndex + 2, String.valueOf(before));

        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        NextPermutationNum app = new NextPermutationNum();
        System.out.println(app.solve(2431));
    }
}
