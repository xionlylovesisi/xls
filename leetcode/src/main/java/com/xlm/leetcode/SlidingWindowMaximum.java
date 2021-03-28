package com.xlm.leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * #### 示例 1：
 * <p>
 * ```
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * <p>
 * ---------------               -----
 * <p>
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * ```
 *
 * @author xls
 * @date 2021/3/20
 * @description
 */
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k, 3);
        System.out.println(Arrays.toString(result));
    }

    /**
     * @param nums
     * @param k
     * @param model 1:优先队列,2:双端队列,3:分块+预处理
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k, int model) {
        int n = nums.length;
        switch (model) {
            case 1:
                PriorityQueue<int[]> window = new PriorityQueue<>((num1, num2) -> num1[0] != num2[0] ? num2[0] - num1[0] : num2[1] - num1[1]);
                for (int i = 0; i < k; i++) {
                    window.add(new int[]{nums[i], i});
                }
                int[] priorityQueueResult = new int[n - k + 1];
                priorityQueueResult[0] = window.peek()[0];
                for (int i = k; i < n; i++) {
                    window.add(new int[]{nums[i], i});
                    while (window.peek()[1] <= i - k) {
                        window.poll();
                    }
                    priorityQueueResult[i - k + 1] = window.peek()[0];
                }
                return priorityQueueResult;
            case 2:
                //双端队列
                Deque<Integer> dequeWindow = new LinkedList<>();
                for (int i = 0; i < k; i++) {
                    while (!dequeWindow.isEmpty() && nums[i] >= nums[dequeWindow.getLast()]) {
                        dequeWindow.pollLast();
                    }
                    dequeWindow.addLast(i);
                }
                int[] dequeResult = new int[n - k + 1];
                dequeResult[0] = nums[dequeWindow.peekFirst()];
                for (int i = k; i < n; i++) {
                    while (!dequeWindow.isEmpty() && nums[i] >= nums[dequeWindow.getLast()]) {
                        dequeWindow.pollLast();
                    }
                    dequeWindow.addLast(i);
                    while (dequeWindow.peekFirst() <= i - k) {
                        dequeWindow.pollFirst();
                    }
                    dequeResult[i - k + 1] = nums[dequeWindow.peekFirst()];
                }
                return dequeResult;
            case 3:
                //分块+预处理
                int[] right = new int[n];
                int[] left = new int[n];
                for (int i = 0; i < n; i++) {
                    if (i % k == 0) {
                        left[i] = nums[i];
                    } else {
                        left[i] = Math.max(nums[i], left[i - 1]);
                    }
                }
                for (int i = n - 1; i >= 0; --i) {
                    if (i == n - 1 || (i + 1) % k == 0) {
                        right[i] = nums[i];
                    } else {
                        right[i] = Math.max(nums[i], right[i + 1]);
                    }
                }
                int[] result = new int[n - k + 1];
                for (int i = 0; i < n - k + 1; i++) {
                    result[i] = Math.max(right[i], left[i + k - 1]);
                }
                return result;
            default:
                return null;
        }
    }
}
