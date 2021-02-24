package com.xlm.leetcode.linked;

/**
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
        ListNode merged = mergeSortedLinked(first, second);
        printLinked(merged);
    }

    private static void printLinked(ListNode merged) {
        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
    }

    /**
     * 最好时间复杂度:O(n+m)
     * 最坏时间复杂度:O(n+m)
     * 平均时间复杂度:O(n+m)
     *
     * @param first
     * @param second
     * @return
     */
    private static ListNode mergeSortedLinked(ListNode first, ListNode second) {
        ListNode newHeader = new ListNode(-1);
        /**
         * 此处使用-1的临时头节点是参考了官方的答案,起初是使用的和下面循环中判断类似的代码来识别的头节点
         * 使用临时头节点的方式更为优雅,代码更少
         */
        ListNode prev = newHeader;
        while (first != null && second != null) {
            if (first.val > second.val) {
                prev.next = second;
                second = second.next;
            } else {
                prev.next = first;
                first = first.next;
            }

            prev = prev.next;
        }
        prev.next = first != null ? first : second;
        return newHeader.next;
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


