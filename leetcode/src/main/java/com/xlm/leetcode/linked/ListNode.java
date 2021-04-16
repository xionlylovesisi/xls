package com.xlm.leetcode.linked;

import java.util.Random;

/**
 * @author mcx
 * @date 2021/3/23
 */
public class ListNode {
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

    public static ListNode getSortedListNode(int len) {
        ListNode first = new ListNode();
        ListNode current = first;
        for (int i = 1; i <= len; i++) {
            current.val = i;
            if (len == i) {
                break;
            }
            current.next = new ListNode();
            current = current.next;
        }
        return first;
    }

    public static ListNode getUnsortedListNode(int len) {
        Random random = new Random();
        ListNode first = new ListNode();
        ListNode current = first;
        for (int i = 1; i <= len; i++) {
            current.val = random.nextInt(len);
            if (len == i) {
                break;
            }
            current.next = new ListNode();
            current = current.next;
        }
        return first;
    }

    public static ListNode getLastListNode(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
