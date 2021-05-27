package com.xlm.leetcode.linked;

/**
 * ### 1721. 交换链表中的节点
 * <p>
 * 给你链表的头节点 `head` 和一个整数 `k` 。
 * <p>
 * **交换** 链表正数第 `k` 个节点和倒数第 `k` 个节点的值后，返回链表的头节点（链表 **从 1 开始索引**）。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[1,4,3,2,5]
 * ```
 * <p>
 * #### **示例 2：**
 * <p>
 * ```
 * 输入：head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * 输出：[7,9,6,6,8,7,3,0,9,5]
 * ```
 * <p>
 * #### **示例 3：**
 * <p>
 * ```
 * 输入：head = [1], k = 1
 * 输出：[1]
 * ```
 * <p>
 * #### **示例 4：**
 * <p>
 * ```
 * 输入：head = [1,2], k = 1
 * 输出：[2,1]
 * ```
 *
 * @author mcx
 * @date 2021/5/27
 */
public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        ListNode head = ListNode.getSortedListNode(5);
        ListNode.print(swapNodes(head, 2, 1));
    }

    public static ListNode swapNodes(ListNode head, int k, int model) {
        if (head == null) {
            return null;
        }
        switch (model) {
            case 1:
                //双指针
                ListNode first = head;
                ListNode second = head;
                for (int i = 1; i < k; i++) {
                    first = first.next;
                }
                ListNode left = first;
                while (first.next != null) {
                    first = first.next;
                    second = second.next;
                }
                ListNode right = second;
                int temp = left.val;
                left.val = right.val;
                right.val = temp;
                return head;
            default:
                return null;
        }
    }
}
