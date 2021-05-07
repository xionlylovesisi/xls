package com.xlm.leetcode.linked;

/**
 * ### 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * ```
 * <p>
 * #### **示例 2：**
 * <p>
 * ```
 * 输入：head = []
 * 输出：[]
 * ```
 * <p>
 * #### **示例 3：**
 * <p>
 * ```
 * 输入：head = [1]
 * 输出：[1]
 * ```
 *
 * @author xls
 * @date 2021/3/28
 * @description
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode listNode = ListNode.getSortedListNode(6);
        ListNode.print(swapPairs(listNode, 2));
    }

    /**
     * @param head
     * @param model 1:迭代,2:递归
     * @return
     */
    public static ListNode swapPairs(ListNode head, int model) {
        if (head == null || head.next == null) {
            return head;
        }
        switch (model) {
            case 1:
                //迭代
                ListNode dummy = new ListNode(-1);
                ListNode prev = dummy;
                ListNode curr = head;
                while (curr != null) {
                    ListNode firstHead = curr;
                    for (int i = 1; i < 2 && curr != null; i++) {
                        curr = curr.next;
                    }
                    if (curr == null) {
                        prev.next = reverseLinkedList(firstHead);
                        break;
                    }
                    ListNode nextHead = curr.next;
                    curr.next = null;
                    prev.next = reverseLinkedList(firstHead);
                    prev = firstHead;
                    curr = nextHead;
                }
                return dummy.next;
            case 2:
                // 递归
                return swapPairsRecursive(head,2);
            default:
                return head;
        }
    }

    private static ListNode reverseLinkedList(ListNode firstHead) {
        ListNode pre = null;
        while (firstHead != null) {
            ListNode next = firstHead.next;
            firstHead.next = pre;
            pre = firstHead;
            firstHead = next;
        }
        return pre;
    }

    private static ListNode swapPairsRecursive(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newTail = head;
        for (int i = 1; i < n && head != null; i++) {
            head = head.next;
        }
        if (head == null) {
            return reverseLinkedList(newTail);
        }
        ListNode nextHead = swapPairsRecursive(head.next, n);
        head.next = null;
        ListNode newHead = reverseLinkedList(newTail);
        newTail.next = nextHead;
        return newHead;
    }
}
