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
        ListNode.print(deleteDuplicates(first, 2));
    }

    /**
     * @param head
     * @param model 1:迭代,2:递归
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head, int model) {
        if (head == null || head.next == null) {
            return head;
        }
        switch (model) {
            case 1:
                //迭代
                ListNode dummy = new ListNode(-1, head);
                ListNode prev = dummy;
                while (prev.next != null && prev.next.next != null) {
                    if (prev.next.val != prev.next.next.val) {
                        prev = prev.next;
                    } else {
                        ListNode repeatCurr = prev.next;
                        while (repeatCurr != null && repeatCurr.next != null && repeatCurr.val == repeatCurr.next.val) {
                            repeatCurr = repeatCurr.next;
                        }
                        prev.next = repeatCurr.next;
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
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val){
                head = head.next;
            }
            return deleteDuplicatesRecursive(head.next);
        }else {
            head.next = deleteDuplicatesRecursive(head.next);
            return head;
        }
    }
}
