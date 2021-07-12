package com.xlm.leetcode.linked;

import java.util.HashSet;
import java.util.Set;

/**
 * ### 817. 链表组件
 * <p>
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。
 * <p>
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * <p>
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * ```
 * <p>
 * #### **示例 2：**
 * <p>
 * ```
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * ```
 *
 * @author mcx
 * @date 2021/5/12
 */
public class LinkedListComponents {
    public static void main(String[] args) {
        ListNode sortedListNode = ListNode.getSortedListNode(3);
        int[] g = new int[]{0, 1, 3};
        System.out.println(numComponents(sortedListNode, g, 1));
    }

    /**
     * @param head
     * @param G
     * @param model 1:使用HashSet
     * @return
     */
    public static int numComponents(ListNode head, int[] G, int model) {
        if (head == null) {
            return 0;
        }
        switch (model) {
            case 1:
                // 使用HashSet
                Set<Integer> subList = new HashSet<>(G.length);
                for (int i : G) {
                    subList.add(i);
                }
                int result = 0;
                while (head != null) {
                    boolean needCount = subList.contains(head.val) && (head.next == null || !subList.contains(head.next.val));
                    if (needCount) {
                        result++;
                    }
                    head = head.next;
                }
                return result;
            default:
                return 0;
        }
    }
}
