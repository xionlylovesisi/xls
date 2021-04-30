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
        int[] nums = {1,3,-1,-3,5,3,6,7};
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
                //优先队列
                PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((ints, t1) -> {
                    return ints[0] == t1[0] ? t1[1] - ints[1] : t1[0] - ints[0];
                });
                for (int i = 0; i < k; i++) {
                    priorityQueue.add(new int[]{nums[i], i});
                }
                int[] result = new int[n - k + 1];
                result[0] = priorityQueue.peek()[0];
                for (int i = k; i < n; i++) {
                    while (!priorityQueue.isEmpty() && priorityQueue.peek()[1] <= i - k) {
                        priorityQueue.poll();
                    }
                    priorityQueue.add(new int[]{nums[i], i});
                    result[i - k + 1] = priorityQueue.peek()[0];
                }
                return result;
            case 2:
                //双端队列
                Deque<Integer> deque = new LinkedList<>();
                for (int i = 0; i < k; i++) {
                    while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                        deque.pollLast();
                    }
                    deque.addLast(i);
                }
                int[] dequeResult = new int[n - k + 1];
                dequeResult[0] = nums[deque.peekFirst()];
                for (int i = k; i < n; i++) {
                    if (deque.getFirst() <= i - k) {
                        deque.pollFirst();
                    }
                    while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                        deque.pollLast();
                    }
                    deque.addLast(i);
                    dequeResult[i - k + 1] = nums[deque.peekFirst()];
                }
                return dequeResult;
            case 3:
                //分块+预处理
                int[] prefix = new int[n];
                int[] suffix = new int[n];
                for (int i = 0; i < n; i++) {
                    if (i % k == 0) {
                        suffix[i] = nums[i];
                    } else {
                        suffix[i] = Math.max(suffix[i - 1], nums[i]);
                    }
                }
                for (int i = n - 1; i >= 0; i--) {
                    if (i == n - 1 || i % k == 0) {
                        prefix[i] = nums[i];
                    } else {
                        prefix[i] = Math.max(prefix[i + 1], nums[i]);
                    }
                }
                int[] preProcessResult = new int[n - k + 1];
                for (int i = 0; i < n - k + 1; i++) {
                    preProcessResult[i] = Math.max(prefix[i], suffix[i + k - 1]);
                }
                return preProcessResult;
            default:
                return null;
        }
    }
}
