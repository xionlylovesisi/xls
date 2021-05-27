package com.xlm.leetcode.linked;

import java.util.Arrays;
import java.util.Stack;

/**
 * ### 剑指 Offer 06. 从尾到头打印链表
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * #### **示例 1：**
 *
 * ```
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * ```
 *
 * ##
 * @author mcx
 * @date 2021/5/27
 */
public class CongWeiDaoTouDaYinLianBiaoIcof {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(reversePrint(ListNode.getSortedListNode(3), 3)));
    }

    public static int[] reversePrint(ListNode head, int model) {
        if (head == null) {
            return new int[0];
        }
        switch (model) {
            case 1:
                // stack
                Stack<ListNode> allNode = new Stack<>();
                while (head != null) {
                    allNode.add(head);
                    head = head.next;
                }
                int size = allNode.size();
                int[] result = new int[size];
                for (int i = 0; i < size; i++) {
                    result[i] = allNode.pop().val;
                }
                return result;
            case 2:
                //递归
                reversePrintRecursive(head);
                if (data == null) {
                    data = new int[0];
                }
                return data;
            case 3:
                //借助获取长度
                int length = getLength(head);
                int[] resultData = new int[length];
                length--;
                while (head != null) {
                    resultData[length--] = head.val;
                    head = head.next;
                }
                return resultData;
            default:
                return null;
        }
    }

    static int index = 0;
    static int recursiveLen = 0;
    static int[] data;

    private static void reversePrintRecursive(ListNode head) {
        if (head == null) {
            return;
        }
        recursiveLen++;
        reversePrintRecursive(head.next);
        if (data == null) {
            data = new int[recursiveLen];
        }
        data[index++] = head.val;
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
