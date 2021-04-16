package com.xlm.leetcode.linked;

import java.util.ArrayList;
import java.util.List;

import static com.xlm.leetcode.linked.ListNode.getSortedListNode;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * 示例 1：
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * <p>
 * 示例 2：
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 *
 * @author mcx
 * @date 2021/3/1
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode first = getSortedListNode(6);
        ListNode middleNode = middleNode(first, 3);
        ListNode.print(middleNode);
    }

    /**
     * @param head
     * @param model 1:借助ArrayList数组,2:通过获取链表长度,3:快慢指针
     * @return
     */
    private static ListNode middleNode(ListNode head, int model) {
        if (head == null || head.next == null) {
            return head;
        }
        switch (model) {
            case 1:
                // 借助ArrayList
                List<ListNode> temporary = new ArrayList<>();
                while (head != null) {
                    temporary.add(head);
                    head = head.next;
                }
                return temporary.get(temporary.size() / 2);
            case 2:
                // 通过获取链表长度
                int linkedListLen = getLinkedListLen(head);
                int midIndex = linkedListLen / 2;
                int index = 0;
                while (head != null) {
                    if (midIndex == index) {
                        break;
                    }
                    head = head.next;
                    index++;
                }
                return head;
            case 3:
                // 快慢指针
                ListNode fast = head, slow = head;
                while (fast != null && fast.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;
                }
                return slow;
            default:
                return head;
        }

    }

    private static int getLinkedListLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
