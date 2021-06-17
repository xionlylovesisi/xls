package com.xlm.leetcode.linked;

/**
 * ### 1669. 合并两个链表
 * <p>
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 * <p>
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 * <p>
 * 请你返回结果链表的头指针。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 * ```
 * <p>
 * #### 示例 2：
 * <p>
 * ```
 * 输入：list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 * 输出：[0,1,1000000,1000001,1000002,1000003,1000004,6]
 * 解释：上图中蓝色的边和节点为答案链表。
 * ```
 *
 * @author mcx
 * @date 2021/6/17
 */
public class MergeInBetweenLinkedLists {
    public static void main(String[] args) {
        ListNode listnode1 = ListNode.getSortedListNode(6);
        ListNode listnode2 = ListNode.getSortedListNode(6);
        ListNode.print(mergeInBetween(listnode1, 3, 4, listnode2));
    }

    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if (list2 == null) {
            return list1;
        }
        if (list1 == null) {
            return list2;
        }
        ListNode dummy = new ListNode(-1, list1);
        ListNode list1Curr = list1;
        ListNode rightPrev = dummy;
        for (int i = 0; i < b; i++) {
            if (i == a - 1) {
                rightPrev = list1Curr;
            }
            list1Curr = list1Curr.next;
        }
        ListNode leftNext = list1Curr.next;
        ListNode list2Curr = list2;
        rightPrev.next = list2;
        while (list2Curr.next != null) {
            list2Curr = list2Curr.next;
        }
        list2Curr.next = leftNext;
        return dummy.next;
    }
}
