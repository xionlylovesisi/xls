package com.xlm.leetcode.linked;

/**
 * ### 92. 反转链表 II
 * <p>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * ```
 * <p>
 * **示例 2：**
 * <p>
 * ```
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * ```
 * <p>
 * 实现方案: 1:定位待翻转链表,与原链表断开,翻转链表,将翻转后的链表再拼回原链表,2:一遍循环
 *
 * @author mcx
 * @date 2021/5/12
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = ListNode.getSortedListNode(5);
        ListNode.print(reverseBetween(head, 2, 4, 1));
    }

    /**
     * @param head
     * @param left
     * @param right
     * @param model 1:定位待翻转链表,与原链表断开,翻转链表,将翻转后的链表再拼回原链表,2:一遍循环
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right, int model) {
        if (head == null) {
            return head;
        }
        switch (model) {
            case 1:
                // 定位待翻转链表,与原链表断开,翻转链表,将翻转后的链表再拼回原链表
                int index1 = 0;
                ListNode dummy1 = new ListNode(-1, head);
                ListNode curr = dummy1;
                while (curr != null) {
                    if (index1 == left-1) {
                        ListNode prev = curr;
                        ListNode revertHead = curr.next;
                        curr.next = null;
                        ListNode revertCurr = revertHead;
                        for (int i = left; i < right; i++) {
                            revertCurr = revertCurr.next;
                        }
                        ListNode tailHead = revertCurr.next;
                        revertCurr.next = null;
                        prev.next = reverse(revertHead);
                        revertHead.next = tailHead;
                        break;
                    }
                    curr = curr.next;
                    index1++;
                }
                return dummy1.next;
            case 2:
                //一遍循环

            default:
                return null;
        }
    }

    private static ListNode reverse(ListNode reverseHead) {
        if (reverseHead == null || reverseHead.next == null) {
            return reverseHead;
        }
        ListNode newHead = reverse(reverseHead.next);
        reverseHead.next.next = reverseHead;
        reverseHead.next = null;
        return newHead;
    }
}
