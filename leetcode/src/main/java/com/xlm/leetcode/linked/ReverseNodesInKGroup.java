package com.xlm.leetcode.linked;

/**
 * ### 25. K 个一组翻转链表
 * <p>
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * ```
 *
 * @author xls
 * @date 2021/3/20
 * @description
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode current = listNode;
        int len = 6;
        for (int i = 1; i <= len; i++) {
            current.val = i;
            if (len == i) {
                break;
            }
            current.next = new ListNode();
            current = current.next;
        }
        ListNode reverse = reverseKGroup(listNode, 3, 2);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    /**
     *
     * @param head
     * @param k
     * @param model 1:迭代,2:递归
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k, int model) {
        switch (model) {
            case 1:
                //迭代
                ListNode dummy = new ListNode(-1);
                ListNode prev = dummy;
                ListNode currHead = head;
                ListNode end = head;
                while (currHead != null) {
                    for (int i = 1; i < k && end != null; i++) {
                        end = end.next;
                    }
                    if (end == null) {
                        prev.next = currHead;
                        return dummy.next;
                    }
                    ListNode nextHead = end.next;
                    end.next = null;
                    prev.next = reverseLinkedNodesIteration(currHead);
                    prev = currHead;
                    currHead = end = nextHead;
                }
                return dummy.next;
            case 2:
                //递归
                return reverseKGroupRecursive(head, k);
            default:
                return null;
        }
    }

    public static ListNode reverseKGroupRecursive(ListNode head, int k) {
        ListNode end = head;
        for (int i = 1; i < k && end != null; i++) {
            end = end.next;
        }
        if (end == null) {
            return head;
        }
        ListNode next = end.next;
        end.next = null;
        ListNode newHead = reverseLinkedNodesIteration(head);
        head.next = reverseKGroupRecursive(next,k);
        return newHead;
    }

    public static ListNode reverseLinkedNodesIteration(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode reverseLinkedNodesRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkedNodesRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
