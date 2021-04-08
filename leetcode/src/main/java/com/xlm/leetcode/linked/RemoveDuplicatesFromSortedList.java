package com.xlm.leetcode.linked;

/**
 * @author mcx
 * @date 2021/4/8
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(1);
        first.next.next = new ListNode(2);
        first.next.next.next = new ListNode(3);
        first.next.next.next.next = new ListNode(3);
        ListNode.print(deleteDuplicates(first, 2));
    }

    /**
     *
     * @param head
     * @param model 1:迭代,2:递归
     * @return
     */
    private static ListNode deleteDuplicates(ListNode head, int model) {
        if (head == null || head.next == null) {
            return head;
        }
        switch (model) {
            case 1:
                //迭代
                ListNode dummy = new ListNode(-1, head);
                ListNode curr = head;
                while (curr.next != null) {
                    if (curr.val == curr.next.val) {
                        curr.next = curr.next.next;
                    }else {
                        curr = curr.next;
                    }
                }
                return dummy.next;
            case 2:
                //递归
                return deleteDuplicatesRecursive(head);
            default:
                return null;
        }
    }

    private static ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        while (head.next != null && head.val == head.next.val) {
            head.next = head.next.next;
        }
        head.next = deleteDuplicatesRecursive(head.next);
        return head;
    }
}
