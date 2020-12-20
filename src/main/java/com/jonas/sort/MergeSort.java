package com.jonas.sort;

/**
 * 归并排序: 将两个有序的数组归并为一个更大的有序数组
 *
 * @author shenjy 2020/12/20
 */
public class MergeSort {
    //归并所需的辅助数组
    private static int[] aux;

    public static void mergeSort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        sort(a, start, mid);         //将左半边排序
        sort(a, mid + 1, end); //将右半边排序
        merge(a, start, mid, end);   //合并结果
    }

    private static void merge(int[] a, int start, int mid, int end) {
        //将a[start...mid]和a[mid+1,end]归并
        int i = start, j = mid + 1;
        //将a[start...end]复制到aux[start...end]
        for (int k = start; k <= end; k++) {
            aux[k] = a[k];
        }
        for (int k = start; k <= end; k++) { //归并回到a[start...end]
            if (i > mid)               a[k] = aux[j++];    //左边数组用尽
            else if (j > end)          a[k] = aux[i++];    //右边数组用尽
            else if (aux[j] < aux[i])  a[k] = aux[j++];
            else                       a[k] = aux[i++];
        }
    }

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12, 1, 1, 100};
        mergeSort(list);
        for (int num : list) {
            System.out.print(num + ",");
        }
    }
}
