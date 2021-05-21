package com.xlm.leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * ### 142. 环形链表 II
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * 进阶：
 * <p>
 * 你是否可以使用 O(1) 空间解决此题？
 * <p>
 * #### 示例 1：
 * <p>
 * ```
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * ```
 * <p>
 * #### 示例 2：
 * <p>
 * ```
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * ```
 * <p>
 * #### 示例 3：
 * <p>
 * ```
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * ```
 *
 * @author xls
 * @date 2021/4/11
 * @description
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        ListNode first = new ListNode(3);
        first.next = new ListNode(2);
        first.next.next = new ListNode(0);
        first.next.next.next = new ListNode(-4, first.next);
        System.out.println(detectCycle(first, 2).val);
    }

    /**
     * @param head
     * @param model 1:hash表,2:快慢指针
     * @return
     */
    public static ListNode detectCycle(ListNode head, int model) {
        if (head == null || head.next == null) {
            return null;
        }
        switch (model) {
            case 1:
                // hashSet
                Set<ListNode> walked = new HashSet<>();
                while (head != null) {
                    if (!walked.add(head)) {
                        return head;
                    }
                    head = head.next;
                }
                return null;
            case 2:
                // 快慢指针
                ListNode fast = head;
                ListNode slow = head;
                while (fast != null && fast.next != null && slow != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                    if (fast == slow) {
                        ListNode result = head;
                        while (result != slow) {
                            result = result.next;
                            slow = slow.next;
                        }
                        return result;
                    }
                }
                return null;
            default:
                return null;
        }
    }
}
