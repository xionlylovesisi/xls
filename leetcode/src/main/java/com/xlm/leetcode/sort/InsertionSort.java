package com.xlm.leetcode.sort;

import java.util.Arrays;

/**
 * 直接插入排序(straight Insertion Sort)
 * @author xls
 * @date 2020-02-18
 * @description
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {20, 40, 30, 10, 60, 50};
        System.out.println("before sort:" + Arrays.toString(a));
//        insertSortFor(a);
        insertSortWhile(a);
        System.out.println("after  sort:" + Arrays.toString(a));

    }

    /**
     * 插入排序嵌套while循环
     *
     * @param a 待排序数组
     */
    private static void insertSortWhile(int[] a) {
        int length = a.length;
        int insertNum, j;
        for (int i = 1; i < length; i++) {
            insertNum = a[i];
            j = i - 1;
            while (j >= 0 && a[j] > insertNum) {
                a[j + 1] = a[j];
                j--;
            }
            if (j + 1 != i) {
                a[j + 1] = insertNum;
            }
        }
    }

    /**
     * 插入排序for循环嵌套
     *
     * @param a 待排序数组
     */
    private static void insertSortFor(int[] a) {
        int length = a.length;
        int i, j;
        int insertNum = 0;
        for (i = 1; i < length; i++) {
            insertNum = a[i];
            for (j = i - 1; j >= 0 && a[j] > insertNum; j--) {
                a[j + 1] = a[j];
            }
            if (j + 1 != i) {
                a[j + 1] = insertNum;
            }
        }
    }
}
