package com.xlm.leetcode.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表是否有环(hash方式)
 * @author xls
 * @date 2019-12-11
 * @description
 */
public class HasCycleHash {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }else{
                map.put(head,head.val);
            }
            head = head.next;
        }
        return false;
    }

   static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
