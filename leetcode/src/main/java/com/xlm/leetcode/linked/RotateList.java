package com.xlm.leetcode.linked;

/**
 * ### 61. 旋转链表
 * <p>
 * 给你一个链表的头节点 `head` ，旋转链表，将链表每个节点向右移动 `k` 个位置。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 * ```
 * <p>
 * #### **示例 2：**
 * <p>
 * ```
 * 输入：head = [0,1,2], k = 4
 * 输出：[2,0,1]
 * ```
 *
 * @author mcx
 * @date 2021/6/3
 */
public class RotateList {
    public static void main(String[] args) {
        ListNode.print(rotateRight(ListNode.getSortedListNode(2), 2, 2));
    }

    /**
     *
     * @param head
     * @param k
     * @param model 1:迭代,双指针
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k, int model) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        switch (model) {
            case 1:
                // 迭代
                int len = 1;
                ListNode oldEnd = head;
                while (oldEnd.next != null) {
                    len++;
                    oldEnd = oldEnd.next;
                }
                int prevIndex = len - k % len;
                if (prevIndex == len) {
                    return head;
                }
                ListNode prev = new ListNode(-1, head);
                for (int i = 0; i < prevIndex; i++) {
                    prev = prev.next;
                }
                ListNode newHead = prev.next;
                prev.next = null;
                oldEnd.next = head;
                return newHead;
            case 2:
                // 双指针
                int pointLen = getLen(head);
                int index = k % pointLen;
                if (index == pointLen || index == 0) {
                    return head;
                }
                ListNode first = head;
                ListNode second = head;
                for (int i = 0; i < index; i++) {
                    first = first.next;
                }
                while (first.next != null) {
                    second = second.next;
                    first = first.next;
                }
                ListNode result = second.next;
                second.next = null;
                first.next = head;
                return result;
            default:
                return null;
        }
    }

    private static int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
