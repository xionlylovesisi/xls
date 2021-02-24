package com.xlm.leetcode.linked;

/**
 * 使用迭代反转链表
 * @author xls
 * @date 2019-12-12
 * @description
 */
public class ReverseIteration {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode reverse = new ReverseIteration().reverseIterator(listNode);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }


    public ListNode reverseIterator(ListNode head) {

        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            //临时保存当前节点的next节点
            ListNode next = curr.next;
            //当前节点的next指向上一次循环的节点
            curr.next = pre;
            //当前节点在下次循环的时候就是前一个节点
            pre = curr;
            // 下次循环的当前节点就是当前循环的当前节点的下一个节点
            curr = next;
        }
        //到最后一次循环结束,也就是当前节点为空的时候,那么这个时候pre节点就是新链表的头结点
        return pre;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
