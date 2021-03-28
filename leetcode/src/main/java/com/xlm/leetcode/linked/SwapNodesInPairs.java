package com.xlm.leetcode.linked;

/**
 * ### 24. 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * #### **示例 1：**
 *
 * ```
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * ```
 *
 * #### **示例 2：**
 *
 * ```
 * 输入：head = []
 * 输出：[]
 * ```
 *
 * #### **示例 3：**
 *
 * ```
 * 输入：head = [1]
 * 输出：[1]
 * ```
 * @author xls
 * @date 2021/3/28
 * @description
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode listNode = ListNode.getSortedListNode(5);
        ListNode.print(swapPairs(listNode, 1));
    }

    /**
     *
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
                ListNode nextHead;
                while (curr != null && curr.next != null) {
                    prev.next = curr.next;
                    nextHead = curr.next.next;
                    curr.next.next = curr;
                    curr.next = nextHead;
                    prev = curr;
                    curr = nextHead;
                }
                return dummy.next;
            case 2:
                // 递归
                return swapPairsRecursive(head);
            default:
                return head;
        }
    }

    private static ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairsRecursive(newHead.next);;
        newHead.next = head;
        return newHead;
    }
}
