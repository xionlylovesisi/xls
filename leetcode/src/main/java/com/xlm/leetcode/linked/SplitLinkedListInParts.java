package com.xlm.leetcode.linked;

/**
 * ### 725. 分隔链表
 * <p>
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 * <p>
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 * <p>
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 * <p>
 * 返回一个符合上述规则的链表的列表。
 * <p>
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * ```
 * <p>
 * #### **示例 2：**
 * <p>
 * ```
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 * ```
 *
 * @author mcx
 * @date 2021/7/8
 */
public class SplitLinkedListInParts {
    public static void main(String[] args) {
        ListNode sortedListNode = ListNode.getSortedListNode(3);
        ListNode[] listNodes = splitListToParts(sortedListNode, 5, 1);
        for (ListNode listNode : listNodes) {
            if (listNode != null) {
                ListNode.print(listNode);
            } else {
                System.out.println("null");
            }
            System.out.println("-----");
        }
    }

    /**
     * @param root
     * @param k
     * @param model 1:拆分链表
     * @return
     */
    public static ListNode[] splitListToParts(ListNode root, int k, int model) {
        ListNode[] result = new ListNode[k];
        if (root == null) {
            return result;
        }
        switch (model) {
            case 1:
                // 拆分链表
                int len = getLen(root);
                int avgLength = len / k;
                int reminder = len % k;

                ListNode nextHead = root;
                for (int i = 0; i < k; i++) {
                    if (nextHead == null) {
                        break;
                    }
                    ListNode currHead = nextHead;
                    ListNode curr = nextHead;
                    for (int j = 0; j < avgLength + (i < reminder ? 1 : 0) - 1; j++) {
                        curr = curr.next;
                    }
                    nextHead = curr.next;
                    curr.next = null;
                    result[i] = currHead;
                }
                return result;
            default:
                return null;
        }
    }

    public static int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
