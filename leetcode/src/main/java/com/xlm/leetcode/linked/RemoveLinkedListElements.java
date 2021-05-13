package com.xlm.leetcode.linked;

import static com.xlm.leetcode.linked.ListNode.getSortedListNode;

/**
 * ### 203. 移除链表元素
 * <p>
 * 给你一个链表的头节点 `head` 和一个整数 `val` ，请你删除链表中所有满足 `Node.val == val` 的节点，并返回 **新的头节点** 。
 * <p>
 * #### 示例 1：
 * <p>
 * ```
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * ```
 * <p>
 * #### 示例 2：
 * <p>
 * ```
 * 输入：head = [], val = 1
 * 输出：[]
 * ```
 * <p>
 * #### **示例 3：**
 * <p>
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * @author mcx
 * @date 2021/4/1
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode first = getSortedListNode(5);
        ListNode result = removeElements(first, 4, 2);
        ListNode.print(result);
    }

    /**
     * @param head
     * @param val
     * @param model 1:递归,2:迭代
     * @return
     */
    public static ListNode removeElements(ListNode head, int val, int model) {
        if (head == null) {
            return null;
        }
        switch (model) {
            case 1:
                //递归MonitorMetricsAspect
                return removeElementsRecursive(head, val);
            case 2:
                //双指针
                ListNode dummy = new ListNode(-1, head);
                ListNode curr = dummy;
                while (curr.next != null) {
                    if (curr.next.val == val) {
                        curr.next = curr.next.next;
                    }else {
                        curr = curr.next;
                    }
                }
                return dummy.next;
            default:
                return null;
        }
    }

    private static ListNode removeElementsRecursive(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        head.next = removeElementsRecursive(head.next, val);
        return head;
    }
}
