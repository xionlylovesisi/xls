package com.xlm.leetcode.linked;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * ### 23. 合并K个升序链表
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * #### **示例 1：**
 *
 * ```
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * ```
 *
 * #### **示例 2：**
 *
 * ```
 * 输入：lists = []
 * 输出：[]
 * ```
 *
 * #### **示例 3：**
 *
 * ```
 * 输入：lists = [[]]
 * 输出：[]
 * ```
 * @author mcx
 * @date 2021/5/19
 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode[] lists = {ListNode.getSortedListNode(5),
                ListNode.getSortedListNode(6),
                ListNode.getSortedListNode(7),
                ListNode.getSortedListNode(8)};
        ListNode.print(mergeKLists(lists, 4));

    }

    /**
     *
     * @param lists
     * @param model 1:顺序合并,2:分治合并,迭代,3:分治合并,递归,4:使用优先队列
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists, int model) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        switch (model) {
            case 1:
                //顺序合并
                ListNode dummy = new ListNode(-1);
                for (int i = 0; i < lists.length; i++) {
                    dummy.next = mergeTwoSortedLinkedList(dummy.next, lists[i]);
                }
                return dummy.next;
            case 2:
                // 分治合并,迭代
                int len = lists.length;
                while (len != 1) {
                    int newIndex = 0;
                    for (int i = 0; i < len; i++) {
                        lists[newIndex++] = mergeTwoSortedLinkedList(lists[i++], i > len - 1 ? null : lists[i]);
                    }
                    len = newIndex;
                }
                return lists[0];
            case 3:
                //分治合并,递归
                return mergeKListsRecursive(lists, 0, lists.length - 1);
            case 4:
                //使用优先队列
                Queue<ListNode> minQueue = new PriorityQueue<>((listNode, t1) -> listNode.val - t1.val);
                for (int i = 0; i < lists.length; i++) {
                    if (lists[i] != null) {
                        minQueue.offer(lists[i]);
                    }
                }
                ListNode priorityQueueDummy = new ListNode(-1);
                ListNode curr = priorityQueueDummy;
                while (!minQueue.isEmpty()) {
                    ListNode min = minQueue.poll();
                    curr.next = min;
                    curr = curr.next;
                    if (min.next != null) {
                        minQueue.offer(min.next);
                    }
                }
                return priorityQueueDummy.next;
            default:
                return null;
        }
    }

    private static ListNode mergeKListsRecursive(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int middle = (right + left) >> 1;
        ListNode first = mergeKListsRecursive(lists, left, middle);
        ListNode second = mergeKListsRecursive(lists, middle + 1, right);
        return mergeTwoSortedLinkedList(first, second);
    }

    private static ListNode mergeTwoSortedLinkedList(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (first != null && second != null) {
            if (first.val < second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }
        curr.next = first == null ? second : first;
        return dummy.next;
    }
}
