package com.xlm.leetcode.linked;

/**
 * 206. 反转链表:反转一个单链表。
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * ### 示例 1：
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author mcx
 * @date 2021/3/9
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode current = head;
        int len = 5;
        for (int i = 1; i <= len; i++) {
            current.val = i;
            if (len == i) {
                break;
            }
            current.next = new ListNode();
            current = current.next;
        }
        ListNode listNode = reverseList(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * @param head
     * @param model 1:递归;2:迭代
     * @return
     */
    public static ListNode reverseList(ListNode head, int model) {
        switch (model) {
            case 1:
                // 递归
                return recursiveReverse(head);
            case 2:
                //迭代
                ListNode prev = null;
                ListNode curr = head;
                while (curr != null) {
                    ListNode nextTail = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextTail;
                }
                return prev;
            default:
                return null;
        }
    }

    private static ListNode recursiveReverse(ListNode head) {
        //递归:如果当前节点的下一个节点为空,则该节点为新的头结点直接返回,
        if (head == null || head.next == null) {
            return head;
        }
        //使用当前节点的next递归调用
        ListNode newHead = recursiveReverse(head.next);
        // 将当前节点的下一个节点的next指向当前节点,当前节点的下一个节点指向空;
        head.next.next = head;
        head.next = null;
        // 返回新的头结点
        return newHead;
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
