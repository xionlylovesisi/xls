package com.xlm.leetcode.linked;

import java.util.Stack;

/**
 * ### 445. 两数相加 II
 * <p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * #### **示例：**
 * <p>
 * ```
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * ```
 *
 * @author mcx
 * @date 2021/7/9
 */
public class AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getSortedListNode(3);
        ListNode l2 = ListNode.getSortedListNode(2);
        ListNode.print(addTwoNumbers(l1, l2, 2));
    }

    /**
     * @param l1
     * @param l2
     * @param model 1:翻转链表,再计算,2:借助栈
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, int model) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        switch (model) {
            case 1:
                //翻转链表,再计算
                l1 = revert(l1);
                l2 = revert(l2);
                ListNode newHead = null;
                int carry = 0;
                while (l1 != null || l2 != null) {
                    int add1 = l1 == null ? 0 : l1.val;
                    int add2 = l2 == null ? 0 : l2.val;
                    int sum = add1 + add2 + carry;
                    ListNode curr = new ListNode(sum % 10);
                    curr.next = newHead;
                    newHead = curr;
                    carry = sum / 10;
                    l1 = l1 == null ? null : l1.next;
                    l2 = l2 == null ? null : l2.next;
                }
                if (carry > 0) {
                    ListNode curr = new ListNode(carry);
                    curr.next = newHead;
                    newHead = curr;
                }
                return newHead;
            case 2:
                //借助栈
                Stack<Integer> s1 = new Stack<>();
                Stack<Integer> s2 = new Stack<>();
                while (l1 != null) {
                    s1.push(l1.val);
                    l1 = l1.next;
                }
                while (l2 != null) {
                    s2.push(l2.val);
                    l2 = l2.next;
                }
                ListNode newHeadStack = null;
                int stackCarry = 0;
                while (!s1.isEmpty() || !s2.isEmpty()) {
                    int add1 = s1.isEmpty() ? 0 : s1.pop();
                    int add2 = s2.isEmpty() ? 0 : s2.pop();
                    int sum = add1 + add2 + stackCarry;
                    ListNode curr = new ListNode(sum % 10);
                    curr.next = newHeadStack;
                    newHeadStack = curr;
                    stackCarry = sum / 10;
                }
                if (stackCarry > 0) {
                    ListNode curr = new ListNode(stackCarry);
                    curr.next = newHeadStack;
                    newHeadStack = curr;
                }
                return newHeadStack;
            default:
                return null;
        }
    }

    private static ListNode revert(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = revert(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
