package com.xlm.leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * ### 160. 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * #### **示例 1：**
 *
 * ```
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * ```
 *
 * ####
 * @author mcx
 * @date 2021/4/16
 */
public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getSortedListNode(9);
        ListNode l2 = ListNode.getSortedListNode(3);
        ListNode common = ListNode.getSortedListNode(4);
        ListNode.getLastListNode(l1).next = common;
        ListNode.getLastListNode(l2).next = common;
        ListNode.print(getIntersectionNode(l1, l2, 2));
    }

    /**
     *
     * @param headA
     * @param headB
     * @param model 1:HashSet,2:双指针,3:暴力破解
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB, int model) {
        if (headA == null || headB == null) {
            return null;
        }
        switch (model) {
            case 1:
                // hashSet
                Set<ListNode> temporary = new HashSet<>();
                while (headA != null) {
                    temporary.add(headA);
                    headA = headA.next;

                }
                while (headB != null) {
                    if (temporary.contains(headB)) {
                        return headB;
                    }
                    headB = headB.next;
                }
                return null;
            case 2:
                // 双指针
                ListNode currA = headA;
                ListNode currB = headB;
                while (currA != currB) {
                    currA = currA == null ? headB : currA.next;
                    currB = currB == null ? headA : currB.next;
                }
                return currA;
            case 3:
                // 暴力解法
                while (headA != null) {
                    ListNode tempB = headB;
                    while (tempB != null) {
                        if (tempB == headA) {
                            return headA;
                        }
                        tempB = tempB.next;
                    }
                    headA = headA.next;
                }
                return null;
            default:
                return null;
        }
    }
}
