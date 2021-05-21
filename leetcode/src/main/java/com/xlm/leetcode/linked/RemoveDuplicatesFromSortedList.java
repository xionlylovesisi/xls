package com.xlm.leetcode.linked;

/**
 * ### 83. 删除排序链表中的重复元素
 * <p>
 * 存在一个按升序排列的链表，给你这个链表的头节点 `head` ，请你删除所有重复的元素，使每个元素 **只出现一次** 。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * #### 示例 1：
 * <p>
 * ```
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * ```
 * <p>
 * #### 示例 2：
 * <p>
 * ```
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * ```
 *
 * @author mcx
 * @date 2021/4/8
 */
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(1);
        first.next.next = new ListNode(2);
        first.next.next.next = new ListNode(3);
        first.next.next.next.next = new ListNode(3);
        ListNode.print(deleteDuplicates(first, 2));
    }

    /**
     * @param head
     * @param model 1:迭代,2:递归
     * @return
     */
    private static ListNode deleteDuplicates(ListNode head, int model) {
        if (head == null || head.next == null) {
            return head;
        }
        switch (model) {
            case 1:
                //迭代
                ListNode dummy = new ListNode(-1, head);
                ListNode curr = head;
                while (curr.next != null) {
                    if (curr.val == curr.next.val) {
                        curr.next = curr.next.next;
                    } else {
                        curr = curr.next;
                    }
                }
                return dummy.next;
            case 2:
                //递归
                return deleteDuplicatesRecursive(head);
            default:
                return null;
        }
    }

    private static ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        deleteDuplicatesRecursive(head.next);
        if (head.val == head.next.val) {
            head.next = head.next.next;
        }
        return head;
    }
}
