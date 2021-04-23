package com.xlm.leetcode.linked;

/**
 * 148. 排序链表:给你链表的头结点 `head` ，请将其按 **升序** 排列并返回 **排序后的链表** 。
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * ### 示例 1：
 * <p>
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * <p>
 * ### 示例 2：
 * <p>
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * @author mcx
 * @date 2021/3/8
 */
public class SortLinkedList {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(3);
        first.next.next = new ListNode(4);
        first.next.next.next = new ListNode(6);
        first.next.next.next.next = new ListNode(5);
        first.next.next.next.next.next = new ListNode(2);
        ListNode.print(sortList(first, 1));
    }

    /**
     * @param head
     * @param model 1: 自顶向下,递归归并排序;2:自底向上,迭代归并排序
     * @return
     */
    public static ListNode sortList(ListNode head, int model) {
        switch (model) {
            case 1:
                // 自顶向下,递归归并排序
                return recursiveSortList(head);
            case 2:
                // 自底向上迭代归并排序
                ListNode dummy = new ListNode(-1, head);
                int length = getLength(head);
                for (int i = 1; i < length; i <<= 1) {
                    ListNode preTail = dummy;
                    head = dummy.next;
                    while (head != null) {
                        ListNode first = head;
                        for (int j = 1; j < i && head != null; j++) {
                            head = head.next;
                        }
                        if (head == null) {
                            preTail.next = first;
                            break;
                        }
                        ListNode second = head.next;
                        head.next = null;
                        head = second;
                        for (int j = 1; j < i && head != null; j++) {
                            head = head.next;
                        }
                        if (head != null) {
                            ListNode next = head.next;
                            head.next = null;
                            head = next;
                        }
                        preTail.next = mergeSortedLinkedList(first, second);
                        while (preTail.next != null) {
                            preTail = preTail.next;
                        }
                    }
                }
                return dummy.next;
            default:
                return null;
        }
    }

    private static ListNode recursiveSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        ListNode first = recursiveSortList(head);
        ListNode second = recursiveSortList(secondHead);
        return mergeSortedLinkedList(first, second);
    }

    private static ListNode mergeSortedLinkedList(ListNode listNode1, ListNode listNode2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val < listNode2.val) {
                curr.next = listNode1;
                listNode1 = listNode1.next;
            } else {
                curr.next = listNode2;
                listNode2 = listNode2.next;
            }
            curr = curr.next;
        }

        curr.next = listNode1 != null ? listNode1 : listNode2;
        return dummy.next;
    }

    private static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
