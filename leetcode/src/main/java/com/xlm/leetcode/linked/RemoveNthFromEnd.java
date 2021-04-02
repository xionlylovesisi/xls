package com.xlm.leetcode.linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 思路是使用双指针,在一个while循环中让快指针先执行n步,然后快慢指针同时向前,直到快指针走到底
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * @author mcx
 * @date 2021/2/22
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = ListNode.getSortedListNode(5);
        ListNode listNode = removeNthFromEnd(head, 2, 5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * @param head
     * @param n
     * @param model:1,获取长度;2,借助其它数据结构,如栈,数组等;3,双指针;4,一次循环完成
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n, int model) {
        if (n <= 0) {
            return head;
        }
        switch (model) {
            case 1:
                // 获取长度
                ListNode getLengthDummy = new ListNode(-1,head);
                int length = getLength(head);
                if (n > length) {
                    return head;
                }
                int currentIndex = 0;
                int prevIndex = length - n;
                ListNode getLengthCurr = getLengthDummy;
                while (getLengthCurr != null){
                    if (prevIndex == currentIndex) {
                        getLengthCurr.next = getLengthCurr.next.next;
                        break;
                    }
                    getLengthCurr = getLengthCurr.next;
                    currentIndex++;
                }
                return getLengthDummy.next;
            case 2:
                // 借助其它数据结构,数组;
                ListNode arrayDummy = new ListNode(-1,head);
                ListNode arrayCurr = arrayDummy;
                List<ListNode> listNodeList = new ArrayList<>();
                while (arrayCurr!=null){
                    listNodeList.add(arrayCurr);
                    arrayCurr = arrayCurr.next;
                }
                int size = listNodeList.size();
                if (size - 1 < n) {
                    return head;
                }
                ListNode prev = listNodeList.get(size - n - 1);
                prev.next = prev.next.next;
                return arrayDummy.next;
            case 3:
                // 双指针
                ListNode doublePointDummy = new ListNode(-1,head);
                ListNode fast = doublePointDummy;
                ListNode slow = doublePointDummy;
                for (int i = 0; i < n; i++) {
                    fast = fast.next;
                }
                while (fast.next != null){
                    fast = fast.next;
                    slow = slow.next;
                }
                slow.next = slow.next.next;
                return doublePointDummy.next;
            case 4:
                // 双指针 一遍循环
                ListNode doublePoint1IterDummy = new ListNode(-1,head);
                ListNode doublePoint1IterFast = doublePoint1IterDummy;
                ListNode doublePoint1IterSlow = doublePoint1IterDummy;
                int i = 0;
                while (doublePoint1IterFast.next != null) {
                    if (i < n){
                        doublePoint1IterFast = doublePoint1IterFast.next;
                        i++;
                        continue;
                    }
                    doublePoint1IterFast = doublePoint1IterFast.next;
                    doublePoint1IterSlow = doublePoint1IterSlow.next;
                }
                doublePoint1IterSlow.next = doublePoint1IterSlow.next.next;
                return doublePoint1IterDummy.next;
            case 5:
                // 借助其它数据结构,栈;
                ListNode stackDummy = new ListNode(-1,head);
                Stack<ListNode> stack = new Stack<>();
                ListNode stackCurr = stackDummy;
                while (stackCurr != null) {
                    stack.push(stackCurr);
                    stackCurr = stackCurr.next;
                }
                for (int j = 0; j < n; j++) {
                    stack.pop();
                }
                ListNode stackPrev = stack.peek();
                stackPrev.next = stackPrev.next.next;
                return stackDummy.next;
            default:
                break;
        }
        return head;
    }

    private static int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
