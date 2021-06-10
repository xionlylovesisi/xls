package com.xlm.leetcode.linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ### 143. 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * #### 示例 1:
 *
 * ```
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * ```
 *
 * #### **示例 2:**
 *
 * ```
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * ```
 *
 * 实现方案:1:寻找中间节点+翻转链表+合并链表,2:stack,3:ArrayList
 *
 * ###
 * @author mcx
 * @date 2021/6/10
 */
public class ReorderList {

    public static void main(String[] args) {
        ListNode sortedListNode = ListNode.getSortedListNode(5);
        reorderList(sortedListNode, 3);
        ListNode.print(sortedListNode);
    }

    /**
     *
     * @param head
     * @param model 1:寻找中间节点+翻转链表+合并链表,2:stack,3:ArrayList
     */
    public static void reorderList(ListNode head, int model) {
        if (head == null || head.next == null) {
            return;
        }
        switch (model) {
            case 1:
                //寻找中间节点+翻转链表+合并链表
                ListNode middleNode = lookForMiddel(head);
                ListNode rightNode = reverse(middleNode);
                while (head != null && rightNode != null) {
                    ListNode temp = head.next;
                    head.next = rightNode;
                    head = temp;
                    ListNode rightTemp = rightNode.next;
                    rightNode.next = head;
                    rightNode = rightTemp;
                }
                return;
            case 2:
                // stack
                ListNode secondMiddle = lookForMiddel(head);
                Stack<ListNode> rightStack = new Stack<>();
                while (secondMiddle != null) {
                    rightStack.push(secondMiddle);
                    secondMiddle = secondMiddle.next;
                }
                while (head != null && !rightStack.isEmpty()) {
                    ListNode next = head.next;
                    ListNode right = rightStack.pop();
                    head.next = right;
                    right.next = next;
                    head = next;
                }
                return;
            case 3:
                //ArrayList
                List<ListNode> dataList = new ArrayList<>();
                while (head != null) {
                    dataList.add(head);
                    head = head.next;
                }
                int rightIndex = dataList.size() - 1;
                ListNode prev = new ListNode(-1);
                for (int i = 0; i <= rightIndex; i++) {
                    ListNode listNode = dataList.get(i);
                    ListNode rightTempNode = dataList.get(rightIndex);
                    prev.next = listNode;
                    listNode.next = rightTempNode;
                    rightTempNode.next = null;
                    prev = rightTempNode;
                    rightIndex--;
                }
                return;
        }
    }

    private static ListNode reverse(ListNode middleNode) {
        ListNode current = middleNode;
        ListNode prev = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private static ListNode lookForMiddel(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode result = slow.next;
        slow.next = null;
        return result;
    }
}
