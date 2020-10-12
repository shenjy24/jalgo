package com.jonas.sort;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @author shenjy
 * @version 1.0
 * @date 2020-10-11
 */
public class RadixSort {

    public static void main(String[] args) {
        RadixSort app = new RadixSort();
        int[] nums = new int[]{73, 22, 93, 1043, 55, 214, 214, 28, 165, 39, 81};
        app.sort(nums, 4);
        Arrays.stream(nums).asLongStream().forEach(System.out::println);
    }

    public void sort(int[] nums, int d) {
        int[][] array = new int[10][nums.length];
        int[] order = new int[10];
        int n = 1;
        while (n <= d) {
            for (int num : nums) {
                int index = (num / (int) Math.pow(10, n - 1)) % 10;
                array[index][order[index]] = num;
                order[index]++;
            }

            int k = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < order[i]; j++) {
                    nums[k] = array[i][j];
                    k++;
                }
                order[i] = 0;
            }
            n++;
        }
    }
}
