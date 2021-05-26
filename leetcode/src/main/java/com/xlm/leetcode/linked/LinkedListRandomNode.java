package com.xlm.leetcode.linked;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ### 382. 链表随机节点
 * <p>
 * 给定一个单链表，随机选择链表的一个节点，并返回相应的节点值。保证每个节点被选的概率一样。
 * <p>
 * 进阶:
 * 如果链表十分大且长度未知，如何解决这个问题？你能否使用常数级空间复杂度实现？
 * <p>
 * #### **示例:**
 * <p>
 * ```
 * // 初始化一个单链表 [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 * <p>
 * // getRandom()方法应随机返回1,2,3中的一个，保证每个元素被返回的概率相等。
 * solution.getRandom();
 * ```
 *
 * @author mcx
 * @date 2021/5/26
 */
public class LinkedListRandomNode {
    public static void main(String[] args) {
        Solution solution = new Solution(ListNode.getSortedListNode(3), 3);
        for (int i = 0; i < 5; i++) {
            System.out.println(solution.getRandom());
        }
    }

    static class Solution {
        private int model;
        private ListNode listNode;
        private int index = 1;
        private List<Integer> allListNode = new ArrayList<>();
        private Random random = new Random();

        /**
         * @listNode head The linked list's head.
         * Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        /**
         *
         * @param head
         * @param model 1:轮询,2:借助ArrayList,3:蓄水池抽样
         */
        public Solution(ListNode head, int model) {
            this.model = model;
            switch (model) {
                case 1:
                    //轮询
                    this.listNode = head;
                case 2:
                    //借助 list
                    this.listNode = head;
                    while (head != null) {
                        allListNode.add(head.val);
                        head = head.next;
                    }
                    break;
                case 3:
                    //蓄水池
                    this.listNode = head;
                    break;
            }
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            if (this.listNode == null) {
                return -1;
            }
            switch (model) {
                case 1:
                    //轮询
                    int currIndex = 1;
                    ListNode curr = listNode;
                    int result = -1;
                    while (curr != null) {
                        if (currIndex == index) {
                            result = curr.val;
                            if (curr.next == null) {
                                index = 0;
                            }
                            break;
                        }
                        currIndex++;
                        curr = curr.next;
                    }
                    index++;
                    return result;
                case 2:
                    //借助 list
                    return allListNode.get(random.nextInt(allListNode.size()));
                case 3:
                    //蓄水池
                    ListNode currNode = listNode;
                    int res = currNode.val;
                    int currentIndex = 1;
                    while (currNode != null) {
                        if (random.nextInt(currentIndex++) == 0) {
                            res = currNode.val;
                        }
                        currNode = currNode.next;
                    }
                    return res;
                default:
                    return -1;
            }
        }
    }

}
