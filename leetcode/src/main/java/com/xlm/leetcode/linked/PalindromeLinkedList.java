package com.xlm.leetcode.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * ### 234. 回文链表
 * <p>
 * 请判断一个链表是否为回文链表。
 * <p>
 * #### **示例 1:**
 * <p>
 * ```
 * 输入: 1->2
 * 输出: false
 * ```
 * <p>
 * #### **示例 2:**
 * <p>
 * ```
 * 输入: 1->2->2->1
 * 输出: true
 * ```
 *
 * @author mcx
 * @date 2021/4/29
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getSortedListNode(3);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(l1, 3));
    }

    /**
     * @param head
     * @param model 1:快慢指针,2:将值复制到数组中,再使用双指针,3:递归
     * @return
     */
    public static boolean isPalindrome(ListNode head, int model) {
        if (head == null) {
            return false;
        }
        switch (model) {
            case 1:
                //快慢指针+翻转链表
                ListNode fast = head;
                ListNode slow = head;
                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                }
                ListNode right = reverseLinkedList(slow);
                while (right != null && head != null) {
                    if (right.val != head.val) {
                        return false;
                    }
                    right = right.next;
                    head = head.next;
                }
                return true;
            case 2:
                // 将值复制到数组中,再使用双指针
                List<ListNode> list = new ArrayList<>();
                while (head != null) {
                    list.add(head);
                    head = head.next;
                }
                int rightIndex = list.size() - 1;
                for (int i = 0; i < rightIndex; i++) {
                    if (list.get(i).val != list.get(rightIndex).val) {
                        return false;
                    }
                    rightIndex--;
                }
                return true;
            case 3:
                //递归
                front = head;
                return recursiveIsPalindrome(head);
            default:
                return false;
        }
    }
    private static ListNode front = null;
    private static boolean recursiveIsPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        if (!recursiveIsPalindrome(head.next)) {
            return false;
        }
        if (front.val != head.val) {
            return false;
        }
        front = front.next;
        return true;
    }


    private static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
