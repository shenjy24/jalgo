package com.jonas.sort;

/**
 * 快速排序
 * 1.选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
 * 2.递归的将p左边和右边的数都按照第一步进行，直到不能递归。
 *
 * @author shenjy 2018/12/26
 */
public class QuickSort {

    public static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            //选定的基准值
            int base = numbers[start];
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end)) {
                    i++;
                }
                while ((numbers[j] > base) && (j > start)) {
                    j--;
                }
                if (i <= j) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j) {
                quickSort(numbers, start, j);
            }
            if (end > i) {
                quickSort(numbers, i, end);
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12, 1, 1, 100};
        quickSort(list, 0, list.length - 1);
        for (int num : list) {
            System.out.print(num + ",");
        }
    }
}
