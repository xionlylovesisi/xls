package com.xlm.leetcode.linked;

/**
 * ### 剑指 Offer 18. 删除链表的节点
 *
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * **注意：**此题对比原题有改动
 *
 * #### **示例 1:**
 *
 * ```
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * ```
 *
 * #### **示例 2:**
 *
 * ```
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 * ```
 *
 * @author mcx
 * @date 2021/4/29
 */
public class ShanChuLianBiaoDeJieDianLcof {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getSortedListNode(9);
        ListNode.print(deleteNode(l1, 3));
    }

    /**
     * 虚拟头结点删除
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
