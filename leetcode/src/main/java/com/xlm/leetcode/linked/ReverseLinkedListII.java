package com.xlm.leetcode.linked;

/**
 * ### 92. 反转链表 II
 *
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * #### **示例 1：**
 *
 * ```
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * ```
 *
 * **示例 2：**
 *
 * ```
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * ```
 *
 * 实现方案: 1:定位待翻转链表,与原链表断开,翻转链表,将翻转后的链表再拼回原链表,2:一遍循环
 * @author mcx
 * @date 2021/5/12
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        ListNode head = ListNode.getSortedListNode(5);
        ListNode.print(reverseBetween(head, 2, 4, 2));
    }

    /**
     *
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
                ListNode dummy = new ListNode(-1, head);
                ListNode prev = dummy;
                ListNode curr = head;
                int index = 1;
                while (curr != null) {
                    if (index == left) {
                        ListNode reverseHead = curr;
                        for (int i = index; i < right; i++) {
                            curr = curr.next;
                        }
                        ListNode next = curr.next;
                        curr.next = null;
                        prev.next = reverse(reverseHead);
                        reverseHead.next = next;
                        break;
                    }
                    prev = curr;
                    curr = curr.next;
                    index++;
                }
                return dummy.next;
            case 2:
                //一遍循环
                ListNode dummy2 = new ListNode(-1,head);
                ListNode pre = dummy2;
                for (int i = 0; i < left-1; i++) {
                    pre = pre.next;
                }
                ListNode current = pre.next;
                for (int i = 0; i < right - left; i++) {
                    ListNode next = current.next;
                    current.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                }
                return dummy2.next;
            default:
                return null;
        }
    }

    private static ListNode reverse(ListNode reverseHead) {
        ListNode prev = null;
        while (reverseHead != null) {
            ListNode next = reverseHead.next;
            reverseHead.next = prev;
            prev = reverseHead;
            reverseHead = next;
        }
        return prev;
    }
}
