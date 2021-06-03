package com.xlm.leetcode.linked;

import static com.xlm.leetcode.linked.ListNode.getSortedListNode;

/**
 * ### 328. 奇偶链表
 * <p>
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * #### **示例 1:**
 * <p>
 * ```
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * ```
 * <p>
 * #### **示例 2:**
 * <p>
 * ```
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * ```
 * ###
 *
 * @author mcx
 * @date 2021/4/23
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode first = getSortedListNode(6);
        ListNode.print(oddEvenList(first, 1));
    }

    /**
     * @param head
     * @param model 1:分离节点后合并
     * @return
     */
    public static ListNode oddEvenList(ListNode head, int model) {
        if (head == null || head.next == null) {
            return head;
        }
        switch (model) {
            case 1:
                // 分离节点后合并
                ListNode odd = head;
                ListNode evenHead = head.next;
                ListNode even = evenHead;
                while (even != null && even.next != null) {
                    odd.next = even.next;
                    odd = odd.next;
                    even.next = odd.next;
                    even = even.next;
                }
                odd.next = evenHead;
                return head;
            default:
                return null;
        }
    }
}
