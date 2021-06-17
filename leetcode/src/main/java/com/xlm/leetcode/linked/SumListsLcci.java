package com.xlm.leetcode.linked;

import java.util.Stack;

import static com.xlm.leetcode.linked.ListNode.getSortedListNode;

/**
 * ### 面试题 02.05. 链表求和
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * #### **示例**
 *
 * ```
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * ```
 *
 * 实现方案:1:反向存放迭代,2:正向存放,借助栈
 *
 * ###
 * @author mcx
 * @date 2021/6/17
 */
public class SumListsLcci {
    public static void main(String[] args) {
        ListNode first = getSortedListNode(5);
        ListNode second = getSortedListNode(5);
        ListNode result = addTwoNumbers(first, second, 2);
        ListNode.print(result);
    }

    /**
     *
     * @param l1
     * @param l2
     * @param model 1:反向存放迭代,2:正向存放,借助栈
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
                //反向存放迭代
                int carry = 0;
                ListNode dummy = new ListNode(-1);
                ListNode newHeadCurr = dummy;
                while (l1 != null || l2 != null) {
                    int add1 = l1 != null ? l1.val : 0;
                    int add2 = l2 != null ? l2.val : 0;
                    int sum = add1 + add2 + carry;
                    carry = sum / 10;
                    newHeadCurr.next = new ListNode(sum % 10);
                    l1 = l1 != null ? l1.next : null;
                    l2 = l2 != null ? l2.next : null;
                    newHeadCurr = newHeadCurr.next;
                }
                if (carry > 0) {
                    newHeadCurr.next = new ListNode(carry);
                }
                return dummy.next;
            case 2:
                //正向存放,借助栈
                int positiveCarray = 0;
                Stack<Integer> l1Stack = new Stack<>();
                while (l1 != null) {
                    l1Stack.add(l1.val);
                    l1 = l1.next;
                }
                Stack<Integer> l2Stack = new Stack<>();
                while (l2 != null) {
                    l2Stack.add(l2.val);
                    l2 = l2.next;
                }
                ListNode positiveHead = new ListNode(-1);
                while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
                    int add1 = !l1Stack.isEmpty() ? l1Stack.pop() : 0;
                    int add2 = !l2Stack.isEmpty() ? l2Stack.pop() : 0;
                    int sum = add1 + add2 + positiveCarray;
                    positiveCarray = sum / 10;
                    ListNode newListNode = new ListNode(sum % 10);
                    newListNode.next = positiveHead.next;
                    positiveHead.next = newListNode;
                }
                if (positiveCarray > 0) {
                    ListNode newHead = new ListNode(positiveCarray);
                    newHead.next = positiveHead.next;
                    positiveHead.next = newHead;
                }
                return positiveHead.next;
            default:
                return null;
        }
    }
}
