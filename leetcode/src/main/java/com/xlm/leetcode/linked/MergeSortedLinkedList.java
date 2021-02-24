package com.xlm.leetcode.linked;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * @author xls
 * @date 2020/9/23
 * @description
 */
public class MergeSortedLinkedList {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(4);
        ListNode second = new ListNode(1);
        second.next = new ListNode(3);
        second.next.next = new ListNode(4);
        ListNode merged = mergeSortedLinked(first, second, 2);
        printLinked(merged);
    }

    /**
     * 合并两个有序链表
     *
     * @param first
     * @param second
     * @param model  1:迭代;2:递归.
     * @return
     */
    private static ListNode mergeSortedLinked(ListNode first, ListNode second, int model) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        switch (model) {
            case 1:
                // 迭代
                ListNode dummy = new ListNode(-1);
                ListNode current = dummy;
                while (first != null && second != null) {
                    if (first.val <= second.val) {
                        current.next = first;
                        current = current.next;
                        first = first.next;
                    } else {
                        current.next = second;
                        current = current.next;
                        second = second.next;
                    }
                }
                current.next = first != null ? first : second;
                return dummy.next;
            case 2:
                // 递归
                return recursiveMerge(first, second);
            default:
                return null;
        }
    }

    private static ListNode recursiveMerge(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        if (first.val <= second.val) {
            first.next = recursiveMerge(first.next, second);
            return first;
        } else {
            second.next = recursiveMerge(first, second.next);
            return second;
        }
    }

    private static void printLinked(ListNode merged) {
        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


