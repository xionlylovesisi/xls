package com.xlm.leetcode.stack;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SelfMinStack {
    private Stack<Integer> stack;
    private List<Integer> orderList;

    /**
     * initialize your data structure here.
     */
    public SelfMinStack() {
        stack = new Stack<>();
        orderList = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        orderList.add(x);
        Collections.sort(orderList);
    }

    public void pop() {
        Object pop = stack.pop();
        if (orderList.get(0).equals(pop)) {
            orderList.remove(0);
        }
    }

    public int top() {
        return stack.lastElement();
    }

    public int getMin() {
        return orderList.get(0);
    }

    public static void main(String[] args) {
        SelfMinStack selfMinStack = new SelfMinStack();
        selfMinStack.push(-2);
        selfMinStack.push(0);
        selfMinStack.push(-3);
        System.out.println(selfMinStack.getMin());
        selfMinStack.pop();
        System.out.println(selfMinStack.top());
        System.out.println(selfMinStack.getMin());
    }
}

