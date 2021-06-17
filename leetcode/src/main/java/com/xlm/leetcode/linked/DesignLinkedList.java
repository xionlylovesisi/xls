package com.xlm.leetcode.linked;

/**
 * ### 707. 设计链表
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 * <p>
 * #### **示例：**
 * <p>
 * ```
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 * ```
 *
 * @author xls
 * @date 2021/5/5
 * @description
 */
public class DesignLinkedList {
    public static void main(String[] args) {
        testLinkedList(1);
    }

    /**
     * @param model 1:单链表,2:双链表
     */
    private static void testLinkedList(int model) {
        switch (model) {
            case 1:
                //单向链表
                MyLinkedList linkedList = new MyLinkedList();
                linkedList.addAtHead(1);
                linkedList.addAtTail(3);
                //链表变为1-> 2-> 3
                linkedList.addAtIndex(1, 2);
                linkedList.print();
                //返回2
                System.out.println(linkedList.get(1));
                //现在链表是1-> 3
                linkedList.deleteAtIndex(1);
                linkedList.print();
                //返回3
                System.out.println(linkedList.get(1));
                break;
            case 2:
                //双向链表
                MyDoublyLinkedList myDoublyLinkedList = new MyDoublyLinkedList();
                myDoublyLinkedList.addAtHead(7);
                myDoublyLinkedList.addAtTail(0);
                myDoublyLinkedList.deleteAtIndex(1);
                myDoublyLinkedList.addAtTail(5);
                myDoublyLinkedList.addAtIndex(1, 1);
                myDoublyLinkedList.addAtIndex(2, 6);
                myDoublyLinkedList.deleteAtIndex(2);
                myDoublyLinkedList.deleteAtIndex(1);
                myDoublyLinkedList.addAtTail(7);
                myDoublyLinkedList.addAtIndex(1, 7);
                myDoublyLinkedList.addAtTail(6);
                break;
            default:
                return;
        }
    }

    static class MyDoublyLinkedList {
        private int size = 0;
        private DoublyListNode first;
        private DoublyListNode tail;

        /**
         * Initialize your data structure here.
         */
        public MyDoublyLinkedList() {

        }

        private boolean isElementIndex(int index) {
            return index >= 0 && index < size;
        }

        /**
         * Get the value of the index-th node in the linked list.
         * If the index is invalid, return -1.
         */
        public int get(int index) {
            if (!isElementIndex(index)) {
                return -1;
            }
            return getIndex(index).val;
        }

        private DoublyListNode getIndex(int index) {
            DoublyListNode temp;
            if (index < size / 2) {
                temp = first;
                for (int i = 0; i < index; i++) {
                    temp = temp.next;
                }
            } else {
                temp = tail;
                for (int i = size - 1; i > index; i--) {
                    temp = temp.prev;
                }
            }
            return temp;
        }

        /**
         * Add a node of value val before the first element of the linked list.
         * After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            DoublyListNode f = first;
            DoublyListNode newListNode = new DoublyListNode(null, val, f);
            first = newListNode;
            if (f == null) {
                tail = first;
            } else {
                f.prev = newListNode;
            }
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            DoublyListNode t = tail;
            DoublyListNode newListNode = new DoublyListNode(t, val, null);
            if (t == null) {
                tail = first = newListNode;
            } else {
                t.next = newListNode;
                tail = newListNode;
            }
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            // 在链表中的第 index 个节点之前添加值为 val  的节点。
            // 如果 index 等于链表的长度，则该节点将附加到链表的末尾。
            if (index == size) {
                addAtTail(val);
            } else if (index <= 0) {
                //如果index小于0，则在头部插入节点。
                addAtHead(val);
            } else {
                DoublyListNode indexNode = getIndex(index);
                DoublyListNode newDoublyListNode = new DoublyListNode(indexNode.prev, val, indexNode);
                indexNode.prev.next = newDoublyListNode;
                indexNode.prev = newDoublyListNode;
                size++;
            }
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (!isElementIndex(index)) {
                return;
            }
            if (index == 0) {
                if (first != tail) {
                    first = first.next;
                    first.next.prev = first.prev;
                } else {
                    first = tail = null;
                }
            } else {
                DoublyListNode indexNode = getIndex(index);
                indexNode.prev.next = indexNode.next;
                if (indexNode == tail) {
                    tail = indexNode.prev;
                } else {
                    indexNode.next.prev = indexNode.prev;
                }
            }
            size--;
        }

        public void print() {
            DoublyListNode.print(first);
        }
    }

    static class MyLinkedList {
        private ListNode first;
        private ListNode tail;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            this.size = 0;
        }

        private boolean isElementIndex(int index) {
            return index >= 0 && index < size;
        }

        /**
         * Get the value of the index-th node in the linked list.
         * If the index is invalid, return -1.
         */
        public int get(int index) {
            if (!isElementIndex(index)) {
                return -1;
            }
            if (index == 0) {
                return first.val;
            }
            if (index == size - 1) {
                return tail.val;
            }
            ListNode curr = first;
            int currIndex = 0;
            while (curr != null) {
                if (currIndex == index) {
                    return curr.val;
                }
                curr = curr.next;
                currIndex++;
            }
            return -1;
        }

        /**
         * Add a node of value val before the first element of the linked list.
         * After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            ListNode newNode = new ListNode(val);
            if (first == null) {
                tail = newNode;
            } else {
                newNode.next = first;
            }
            first = newNode;
            size++;
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            ListNode newNode = new ListNode(val);
            if (first == null) {
                first = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        }

        /**
         * Add a node of value val before the index-th node in the linked list.
         * If index equals to the length of linked list, the node will be appended to the end of linked list.
         * If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            ListNode newNode = new ListNode(val);
            if (index <= 0) {
                newNode.next = first;
                first = newNode;
                if (tail == null) {
                    tail = newNode;
                }
            } else if (index == size) {
                tail.next = newNode;
                tail = newNode;
            } else {
                ListNode curr = first;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                newNode.next = curr.next;
                curr.next = newNode;
            }
            size++;
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (!isElementIndex(index)) {
                return;
            }
            if (index == 0) {
                first = first.next;
            } else {
                ListNode curr = first;
                for (int i = 0; i < index - 1; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
                if (index == size - 1) {
                    tail = curr;
                }
            }
            size--;

        }

        public void print() {
            ListNode.print(first);
        }
    }
}
