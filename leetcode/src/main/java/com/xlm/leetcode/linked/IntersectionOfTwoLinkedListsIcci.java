package com.xlm.leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * ### 面试题 02.07. 链表相交
 * <p>
 * 给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k个节点与另一个链表的第j个节点是同一节点（引用完全相同），则这两个链表相交。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * ```
 * <p>
 * #### **示例 2：**
 * <p>
 * ```
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * ```
 * <p>
 * #### **示例 3：**
 * <p>
 * ```
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 * ```
 *
 * @author mcx
 * @date 2021/4/29
 */
public class IntersectionOfTwoLinkedListsIcci {
    public static void main(String[] args) {
        ListNode l1 = ListNode.getSortedListNode(9);
        ListNode l2 = ListNode.getSortedListNode(3);
        ListNode common = ListNode.getSortedListNode(4);
        ListNode.getLastListNode(l1).next = common;
        ListNode.getLastListNode(l2).next = common;
        ListNode.print(getIntersectionNode(l1, l2, 3));
    }

    /**
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
                Set<ListNode> set = new HashSet<>();
                while (headA != null) {
                    set.add(headA);
                    headA = headA.next;
                }
                while (headB != null) {
                    if (set.contains(headB)) {
                        return headB;
                    }
                    headB = headB.next;
                }
                return null;
            case 2:
                // 双指针
                ListNode pointA = headA;
                ListNode pointB = headB;
                while (pointB != pointA) {
                    pointA = pointA == null ? headB : pointA.next;
                    pointB = pointB == null ? headA : pointB.next;
                }
                return pointA;
            case 3:
                // 暴力解法
                while (headA != null) {
                    ListNode currB = headB;
                    while (currB != null) {
                        if (headA == currB) {
                            return headA;
                        }
                        currB = currB.next;
                    }
                    headA = headA.next;
                }
                return null;
            default:
                return null;
        }
    }
}
