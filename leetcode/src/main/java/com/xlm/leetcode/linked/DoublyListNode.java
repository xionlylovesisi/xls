package com.xlm.leetcode.linked;

import java.util.Random;

/**
 * @author mcx
 * @date 2021/3/23
 */
public class DoublyListNode {
    int val;
    DoublyListNode next;
    DoublyListNode prev;

    DoublyListNode() {
    }

    DoublyListNode(int val) {
        this.val = val;
    }

    DoublyListNode(DoublyListNode prev, int val, DoublyListNode next) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public static void print(DoublyListNode head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
