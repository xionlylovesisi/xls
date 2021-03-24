package com.xlm.leetcode.linked;

/**
 * ### 82. 删除排序链表中的重复元素 II
 * <p>
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 *没有重复出现* 的数字。
 * <p>
 * #### 示例 1:
 * <p>
 * ```
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * ```
 * <p>
 * #### 示例 2:
 * <p>
 * ```
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * ```
 *
 * @author mcx
 * @date 2021/3/23
 */
public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(2);
        first.next.next.next = new ListNode(3);
        first.next.next.next.next = new ListNode(4);
        ListNode.print(deleteDuplicates(first, 1));
    }

    public static ListNode deleteDuplicates(ListNode head, int model) {
        if (head == null || head.next == null) {
            return head;
        }
        switch (model) {
            case 1:
                //迭代
                // prev:前一个不重复的节点
                // currentHead:当前可能重复的节点
                // end: 可能重复节点范围的最后一个节点
                ListNode dummy = new ListNode(-1);
                ListNode prev = dummy;
                ListNode currentHead = head;
                ListNode end = head;
                while (currentHead.next != null && end.next != null) {
                    if (currentHead.val != end.next.val) {
                        if (currentHead == end) {
                            prev.next = end;
                            prev = end;
                        }
                        currentHead = end.next;
                    }
                    end = end.next;
                }
                if (currentHead == end) {
                    prev.next = end;
                    prev = end;
                }
                prev.next = null;
                return dummy.next;
            default:
                return null;
        }
    }
}
