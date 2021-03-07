package com.xlm.leetcode.linked;

import java.util.ArrayList;
import java.util.List;
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
        ListNode head = new ListNode();
        ListNode current = head;
        int len = 5;
        for (int i = 1; i <= len; i++) {
            current.val = i;
            if (len == i) {
                break;
            }
            current.next = new ListNode();
            current = current.next;
        }
        ListNode listNode = removeNthFromEnd(head, 5, 5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * @param head
     * @param n
     * @param model:1,获取长度;2,借助其它数据结构,如栈,数组等;3,双指针;4,一次循环完成
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n, int model) {
        if (n <= 0) {
            return head;
        }
        switch (model) {
            case 1:
                // 获取长度
                ListNode dummy1 = new ListNode(-1, head);
                int length = getLength(head);
                // 要删除的节点不存在
                if (n > length) {
                    return head;
                }
                int prevIndex = length - n;
                ListNode curr = dummy1;
                int iterateIndex = 0;
                while (curr != null) {
                    if (iterateIndex == prevIndex) {
                        curr.next = curr.next.next;
                        break;
                    }
                    iterateIndex++;
                    curr = curr.next;
                }
                return dummy1.next;
            case 2:
                // 借助其它数据结构,数组;
                ListNode dummy2 = new ListNode(-1, head);
                List<ListNode> temporary = new ArrayList<>();
                ListNode curr2 = dummy2;
                while (curr2 != null) {
                    temporary.add(curr2);
                    curr2 = curr2.next;
                }
                int len = temporary.size();
                if (len - 1 < n) {
                    return head;
                }
                int waitRemovedPrevIndex = len - n - 1;
                ListNode prevNode = temporary.get(waitRemovedPrevIndex);
                prevNode.next = prevNode.next.next;
                return dummy2.next;
            case 3:
                // 双指针
                ListNode dummy3 = new ListNode(-1, head);
                ListNode first = dummy3;
                ListNode second = dummy3;
                for (int i = 0; i < n; i++) {
                    first = first.next;
                }
                while (first.next != null) {
                    first = first.next;
                    second = second.next;
                }
                second.next = second.next.next;
                return dummy3.next;
            case 4:
                // 双指针 一遍循环
                ListNode dummy4 = new ListNode(-1, head);
                ListNode first4 = dummy4;
                ListNode second4 = dummy4;
                while (first4.next != null) {
                    if (n > 0) {
                        first4 = first4.next;
                        n--;
                        continue;
                    }
                    first4 = first4.next;
                    second4 = second4.next;
                }
                second4.next = second4.next.next;
                return dummy4.next;
            case 5:
                // 借助其它数据结构,栈;
                ListNode dummy5 = new ListNode(-1, head);
                Stack<ListNode> temporary5 = new Stack<>();
                ListNode curr5 = dummy5;
                while (curr5 != null) {
                    temporary5.push(curr5);
                    curr5 = curr5.next;
                }
                if (temporary5.size() - 1 < n) {
                    return head;
                }
                for (int i = 0; i < n; i++) {
                    temporary5.pop();
                }
                ListNode waitRemovedPrevNode = temporary5.peek();
                waitRemovedPrevNode.next = waitRemovedPrevNode.next.next;
                return dummy5.next;
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
