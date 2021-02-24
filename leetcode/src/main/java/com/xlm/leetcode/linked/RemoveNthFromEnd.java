package com.xlm.leetcode.linked;

import java.util.Stack;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 思路是使用双指针,在一个while循环中让快指针先执行n步,然后快慢指针同时向前,直到快指针走到底
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * @author mcx
 * @date 2021/2/22
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = removeNthFromEnd(head, 5, 4);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * @param head
     * @param n
     * @param modle:1,获取长度;2,借助栈;3,双指针;4,一次循环完成
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n, int modle) {
        if (n <= 0) {
            return head;
        }
        switch (modle) {
            case 1:
                int len = getLength(head);
                if (len < n) {
                    return head;
                }
                ListNode dummy = new ListNode(-1, head);
                ListNode curr = dummy;
                for (int i = 1; i < len - n + 1; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
                return dummy.next;
            case 2:
                Stack<ListNode> container = new Stack<>();
                ListNode stackDummy = new ListNode(-1, head);
                ListNode stackCurr = stackDummy;
                while (stackCurr != null) {
                    container.push(stackCurr);
                    stackCurr = stackCurr.next;
                }
                for (int i = 1; i <= n; i++) {
                    container.pop();
                    if (container.isEmpty()) {
                        return head;
                    }
                }
                ListNode prev = container.peek();
                prev.next = prev.next.next;
                return stackDummy.next;
            case 3:
                ListNode doublePointerDummy = new ListNode(-1, head);
                ListNode fast = doublePointerDummy;
                ListNode slow = doublePointerDummy;
                for (int i = 1; i <= n; i++) {
                    if (fast.next == null) {
                        return head;
                    }
                    fast = fast.next;
                }
                while (fast.next != null) {
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = slow.next.next;
                return doublePointerDummy.next;
            case 4:
                ListNode oneIterateDummy = new ListNode(-1, head);
                ListNode first = oneIterateDummy;
                ListNode second = oneIterateDummy;
                while (first.next != null) {
                    if (n <= 0) {
                        second = second.next;
                    }
                    n--;
                    first = first.next;
                }
                if (n > 0) {
                    return head;
                }
                second.next = second.next.next;
                return oneIterateDummy.next;
            default:
                break;
        }
        return head;
    }

    private static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
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
