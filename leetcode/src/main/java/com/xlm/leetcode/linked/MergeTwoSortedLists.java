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
public class MergeTwoSortedLists {
    public static void main(String[] args) {

        ListNode first = ListNode.getSortedListNode(3);
        ListNode second = ListNode.getSortedListNode(3);
        ListNode.print(mergeSortedLinked(first, second, 2));
    }

    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @param model 1:迭代;2:递归.
     * @return
     */
    private static ListNode mergeSortedLinked(ListNode l1, ListNode l2, int model) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        switch (model) {
            case 1:
                // 迭代
                ListNode dummy = new ListNode(-1);
                ListNode newCurr = dummy;
                while (l1 != null && l2 != null) {
                    if (l1.val < l2.val) {
                        newCurr.next = l1;
                        l1 = l1.next;
                    } else {
                        newCurr.next = l2;
                        l2 = l2.next;
                    }
                    newCurr = newCurr.next;
                }
                newCurr.next = l1 == null ? l2 : l1;
                return dummy.next;
            case 2:
                // 递归
                return mergeSortedLinkedRecursive(l1, l2);
            default:
                return null;
        }
    }

    private static ListNode mergeSortedLinkedRecursive(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeSortedLinkedRecursive(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeSortedLinkedRecursive(l1, l2.next);
            return l2;
        }
    }
}


