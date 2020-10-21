package com.jonas.number;

/**
 * @author shenjy
 * @date 2020/10/15
 * @description 正整数的下一个全排列数
 */
public class NextPermutationNum {

    public int solve(int num) {
        return solve(parseToArray(num));
    }

    public int solve(int[] nums) {
        int index = findTransferPoint(nums);
        if (0 == index) {
            reverse(0, nums);
            return parseToInt(nums);
        }
        exchangeHead(index, nums);
        reverse(index, nums);
        return parseToInt(nums);
    }

    public int findTransferPoint(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public void exchangeHead(int index, int[] nums) {
        int head = nums[index - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (head < nums[i]) {
                nums[index - 1] = nums[i];
                nums[i] = head;
                return;
            }
        }
    }

    public void reverse(int index, int[] nums) {
        int head = index;
        int tail = nums.length - 1;
        while (head < tail) {
            int tmp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = tmp;
            head++;
            tail--;
        }
    }

    public int[] parseToArray(int num) {
        String str = String.valueOf(num);
        int[] tmp = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            tmp[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
        }
        return tmp;
    }

    public int parseToInt(int[] nums) {
        int sum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            sum = sum * 10 + nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        NextPermutationNum app = new NextPermutationNum();
        System.out.println(app.solve(1));
    }
}
