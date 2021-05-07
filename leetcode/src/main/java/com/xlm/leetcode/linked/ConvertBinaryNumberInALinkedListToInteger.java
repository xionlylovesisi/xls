package com.xlm.leetcode.linked;

/**
 * ### 1290. 二进制链表转整数
 * <p>
 * 给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。
 * <p>
 * 请你返回该链表所表示数字的 十进制值 。
 * <p>
 * #### **示例 1：**
 * <p>
 * ```
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 * ```
 * <p>
 * #### **示例 2：**
 * <p>
 * ```
 * 输入：head = [0]
 * 输出：0
 * ```
 * <p>
 * #### **示例 3：**
 * <p>
 * ```
 * 输入：head = [1]
 * 输出：1
 * ```
 * <p>
 * #### **示例 4：**
 * <p>
 * ```
 * 输入：head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * 输出：18880
 * ```
 * <p>
 * #### **示例 5：**
 * <p>
 * ```
 * 输入：head = [0,0]
 * 输出：0
 * ```
 *
 * @author mcx
 * @date 2021/5/7
 */
public class ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(getDecimalValue(head, 2));
    }

    /**
     *
     * @param head
     * @param model 1,官方答案模拟,2:递归
     * @return
     */
    public static int getDecimalValue(ListNode head, int model) {
        switch (model) {
            case 1:
                // 官方答案模拟
                int res = 0;
                while (head != null) {
                    res = res * 2 + head.val;
                    head = head.next;
                }
                return res;
            case 2:
                //递归
                return recursiveGetDecimalValue(head);
            default:
                return -1;
        }
    }

    private static int power = 0;

    private static int recursiveGetDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int count = recursiveGetDecimalValue(head.next);
        count += head.val << power++;
        return count;
    }
}
