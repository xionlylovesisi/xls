package com.xlm.leetcode.linked;

/**
 * ### 147. 对链表进行插入排序
 * <p>
 * 对链表进行插入排序。
 * <p>
 * 插入排序算法：
 * <p>
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * ```
 * <p>
 * ####
 *
 * @author mcx
 * @date 2021/4/16
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode unsortedListNode = ListNode.getUnsortedListNode(6);
        System.out.println("排序前");
        ListNode.print(unsortedListNode);
        System.out.println("排序后");
        ListNode.print(insertionSortList(unsortedListNode, 1));
    }

    /**
     * @param head
     * @param model 1:从前向后遍历插入排序
     * @return
     */
    public static ListNode insertionSortList(ListNode head, int model) {
        if (head == null || head.next == null) {
            return head;
        }
        switch (model) {
            case 1:
                //从前向后遍历
                ListNode dummy = new ListNode(-1, head);
                ListNode curr = head.next;
                ListNode sortedTail = head;
                while (curr != null) {
                    if (sortedTail.val <= curr.val) {
                        sortedTail = curr;
                        curr = curr.next;
                        continue;
                    }
                    ListNode prev = dummy;
                    while (prev.next.val <= curr.val) {
                        prev = prev.next;
                    }
                    sortedTail.next = curr.next;
                    curr.next = prev.next;
                    prev.next = curr;
                    curr = sortedTail.next;
                }
                return dummy.next;
            default:
                return null;
        }
    }
}
