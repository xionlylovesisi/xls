package com.xlm.leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * ### 141:环形链表
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * #### 示例1:
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点
 * <p>
 * #### 示例2:
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 * @author mcx
 * @date 2021/3/1
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(2, first.next);
        System.out.println(hasCycle(first, 1));
    }

    /**
     * @param head
     * @param model 1:hash表,2,快慢指针;
     * @return
     */
    private static boolean hasCycle(ListNode head, int model) {
        if (head == null || head.next == null) {
            return false;
        }
        switch (model) {
            case 1:
                //hash
                Set<ListNode> hasMarked = new HashSet<>();
                while (head != null) {
                    if (!hasMarked.add(head)) {
                        return true;
                    }
                    head = head.next;
                }
                return false;
            case 2:
                // 快慢指针
                ListNode fast = head;
                ListNode slow = head;
                while (fast != null && fast.next != null) {
                    fast = fast.next.next;
                    slow = slow.next;
                    if (fast == slow) {
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }
}
