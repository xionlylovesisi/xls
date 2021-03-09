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
        ListNode listNode = sortList(first, 2);
        printLinked(listNode);
    }

    private static void printLinked(ListNode merged) {
        while (merged != null) {
            System.out.println(merged.val);
            merged = merged.next;
        }
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
                // 获取链表的length
                // 定义子链表长度subLength初始化为1
                // 长度为1的链表本身就是有序的,利用合并有序链表的方法合并相邻的两个子链表
                // 合并之后会得到一个subLength*2的有序链表,
                // 对链表剩余的节点执行上面两部操作,得到每subLength*2个节点有序的链表
                // 将subLength*2继续上面的步骤,知道subLength>链表的length
                int totalLength = getLength(head);

                ListNode dummyHead = new ListNode(-1, head);
                for (int i = 1; i < totalLength; i = i << 2) {
                    ListNode prev = dummyHead;
                    ListNode curr = dummyHead.next;
                    while (curr != null) {
                        ListNode node1 = curr;
                        for (int j = 1; j < i && curr != null; j++) {
                            curr = curr.next;
                        }
                        ListNode node2 = curr.next;
                        curr.next = null;
                        curr = node2;
                        for (int j = 1; j < i && curr != null; j++) {
                            curr = curr.next;
                        }
                        ListNode next = null;
                        if (curr != null) {
                            next = curr.next;
                            curr.next = null;
                        }
                        curr = next;
                        ListNode sortedListNode = mergeSortedLinkedList(node1, node2);
                        prev.next = sortedListNode;
                        while (prev.next != null) {
                            prev = prev.next;
                        }
                    }
                }
                return dummyHead.next;
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
        ListNode nextHead = slow.next;
        slow.next = null;
        ListNode listNode1 = recursiveSortList(head);
        ListNode listNode2 = recursiveSortList(nextHead);
        return mergeSortedLinkedList(listNode1, listNode2);
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
