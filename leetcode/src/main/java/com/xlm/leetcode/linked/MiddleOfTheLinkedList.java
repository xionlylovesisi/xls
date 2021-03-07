package com.xlm.leetcode.linked;

import java.util.ArrayList;
import java.util.List;

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
        ListNode first = new ListNode();
        ListNode current = first;
        int len = 6;
        for (int i = 1; i <= len; i++) {
            current.val = i;
            if (len == i) {
                break;
            }
            current.next = new ListNode();
            current = current.next;
        }
        ListNode middleNode = middleNode(first, 3);
        while (middleNode != null) {
            System.out.println(middleNode.val);
            middleNode = middleNode.next;
        }
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
                while (head != null){
                    temporary.add(head);
                    head = head.next;
                }
                // 当链表长度为偶数时(即有两个中间节点),取后一个节点,此处本应该+1,但是由于数组的下标从0开始,所以此处不需要+1
                // 当链表长度为奇数时,"/"操作符自动向下取整,此处也应该+1,但是由于数组的下标从0开始,所以此处不需要+1
                return temporary.get(temporary.size() / 2);
            case 2:
                // 通过获取链表长度
                int len = getLinkedListLen(head);
                // 此处取中间节点索引的方法为了与数组保持一致,所以链表的索引页从0开始
                int curr = 0;
                int middleIndex = len/2;
                while (head != null){
                    if (middleIndex == curr) {
                        return head;
                    }
                    curr++;
                    head = head.next;
                }
                return null;
            case 3:
                // 快慢指针
                ListNode fast = head;
                ListNode slow = head;
                while (fast != null && fast.next != null){
                    fast = fast.next.next;
                    slow = slow.next;
                }
                return slow;
            default:
                return head;
        }

    }

    private static int getLinkedListLen(ListNode head) {
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
