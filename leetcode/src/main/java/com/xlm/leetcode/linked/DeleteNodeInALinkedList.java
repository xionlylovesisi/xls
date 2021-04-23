package com.xlm.leetcode.linked;

/**
 * ### 237. 删除链表中的节点
 *
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 **要被删除的节点** 。
 *
 * #### **示例 1：**
 *
 * ```
 * 输入：head = [4,5,1,9], node = 5
 * 输出：[4,1,9]
 * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * ```
 *
 * #### **示例 2：**
 *
 * ```
 * 输入：head = [4,5,1,9], node = 1
 * 输出：[4,5,9]
 * 解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * ```
 * @author mcx
 * @date 2021/4/23
 */
public class DeleteNodeInALinkedList {
    private static ListNode listNode = new ListNode(4);
    public static void main(String[] args) {
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(9);
        deleteNode(listNode);
        ListNode.print(listNode);
    }

    /**
     * @param node 1:替换下一个节点
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
