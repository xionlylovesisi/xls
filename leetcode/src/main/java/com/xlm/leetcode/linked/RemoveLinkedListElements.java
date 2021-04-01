package com.xlm.leetcode.linked;

import static com.xlm.leetcode.linked.ListNode.getSortedListNode;

/**
 * @author mcx
 * @date 2021/4/1
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode first = getSortedListNode(5);
        ListNode result = removeElements(first, 4, 1);
        ListNode.print(result);
    }

    /**
     *
     * @param head
     * @param val
     * @param model 1:递归,2:迭代
     * @return
     */
    public static ListNode removeElements(ListNode head, int val, int model) {
        switch (model) {
            case 1:
                //递归
                return removeElementsRecurisve(head, val);
            case 2:
                //双指针
            default:
                return null;
        }
    }

    private static ListNode removeElementsRecurisve(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        head.next = removeElementsRecurisve(head.next, val);
        return head;
    }
}
