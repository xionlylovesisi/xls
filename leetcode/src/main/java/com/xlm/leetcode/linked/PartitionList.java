package com.xlm.leetcode.linked;

/**
 * ### 86. 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * ```
 * <p>
 * #### **示例 2：**
 * <p>
 * ```
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * ```
 *
 * @author mcx
 * @date 2021/6/3
 */
public class PartitionList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);
        ListNode.print(partition(node, 3, 1));
    }

    /**
     *
     * @param head
     * @param x
     * @param model 1:迭代,并使用左右头指针
     * @return
     */
    public static ListNode partition(ListNode head, int x, int model) {
        if (head == null || head.next == null) {
            return head;
        }
        switch (model) {
            case 1:
                //左右头指针
                ListNode leftHead = new ListNode(-1);
                ListNode rightHead = new ListNode(-1);
                ListNode leftCurr = leftHead;
                ListNode rightCurr = rightHead;
                while (head != null) {
                    if (head.val < x) {
                        leftCurr.next = head;
                        leftCurr = head;
                    } else {
                        rightCurr.next = head;
                        rightCurr = head;
                    }
                    ListNode temp = head.next;
                    head = temp;
                }
                rightCurr.next = null;
                leftCurr.next = rightHead.next;
                return leftHead.next;
            default:
                return null;
        }
    }
}
