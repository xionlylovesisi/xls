package com.xlm.leetcode.linked;

/**
 * k个为一组反转链表(递归方式)
 * @author xls
 * @date 2019-12-12
 * @description
 */
public class ReverseKGroupRecursive {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode reverse = new ReverseKGroupRecursive().reverseKGroup(listNode, 2);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // recursive
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            if (end == null) {
                return start;
            }
            end = end.next;
        }
        ListNode listNode = reverseRecursive(start, end);
        start.next = reverseKGroup(end, k);
        return listNode;
    }


    public ListNode reverseRecursive(ListNode head, ListNode b) {
        if (head.next == b) {
            return head;
        }
        //next
        ListNode newHead = reverseRecursive(head.next, b);
        head.next.next = head;
        head.next = null;

        return newHead;

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
