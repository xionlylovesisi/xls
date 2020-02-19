package com.xlm.leetcode.sort;

import java.util.Arrays;

/**
 * 希尔排序(Shell sort)
 *
 * @author xls
 * @date 2020-02-18
 * @description
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = {
                9, 1, 2, 5, 7, 4, 8, 6, 3, 5
        };
        System.out.println("排序前:" + Arrays.toString(array));
        shellSort(array);
        System.out.println("排序后:" + Arrays.toString(array));
    }

    private static void shellSort(int[] array) {
        int d = array.length;
        while (d != 0) {
            d = d / 2;
            for (int x = 0; x < d; x++) {
                for (int i = x + d; i < array.length; i += d) {
                    int j = i - d;
                    int temp = array[i];
                    for (; j >= 0 && temp < array[j]; j -= d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
            System.out.println("gap = " + d + ",array:" + Arrays.toString(array));
        }
    }
}
