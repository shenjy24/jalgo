package com.jonas.sort;

import java.util.Random;

/**
 * 快速排序
 * 1.选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
 * 2.递归的将p左边和右边的数都按照第一步进行，直到不能递归。
 *
 * @author shenjy 2018/12/26
 */
public class QuickSort {

    public static void quickSort(int[] numbers) {
        //打乱顺序，消除对输入的依赖
        shuffle(numbers);
        sort(numbers, 0, numbers.length - 1);
    }

    public static void sort(int[] a, int start, int end) {
        if (start >= end) return;
        int j = partition(a, start, end);
        sort(a, 0, j - 1); //将左半部分a[start...j-1]排序
        sort(a, j + 1, end);    //将右半部分a[j+1...end]排序
    }

    private static int partition(int[] a, int start, int end) {
        //将数组切分为a[start...i-1], a[i],a[i+1...end]
        int i = start, j = end + 1;
        int v = a[start];
        while (true) {
            //扫描左右
            while (a[++i] <= v) if (i == end) break;
            while (v <= a[--j]) if (j == start) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        //将v=a[j]放入正确的位置
        swap(a, start, j);
        //a[start..j-1] <= a[j] <= a[j+1...end]达成
        return j;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shuffle(int[] a) {
        int length = a.length;
        Random rand = new Random();
        for (int i = length; i > 0; i--) {
            int randInd = rand.nextInt(i);
            swap(a, randInd, i - 1);
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12, 1, 1, 100};
        quickSort(list);
        for (int num : list) {
            System.out.print(num + ",");
        }
    }
}
