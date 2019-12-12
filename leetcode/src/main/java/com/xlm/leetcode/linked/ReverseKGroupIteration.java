package com.xlm.leetcode.linked;

/**
 * @author xls
 * @date 2019-12-12
 * @description
 */
public class ReverseKGroupIteration {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode reverse = new ReverseKGroupIteration().reverseKGroup(listNode, 5);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        ListNode newHeader = new ListNode(-1);
        ListNode pre = newHeader;
        while (end != null) {
            for (int i = 0; i < k - 1 && end != null; i++) {
                end = end.next;
            }
            if (end == null){
                pre.next = start;
                break;
            }
            ListNode next = end.next;
            end.next = null;
            pre.next = reverseRecursive(start);
            pre = start;
            start = next;
            end = next;
        }
        return newHeader.next;
    }


    public ListNode reverseRecursive(ListNode head) {
        if (head.next == null) {
            return head;
        }
        //next
        ListNode newHead = reverseRecursive(head.next);
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
