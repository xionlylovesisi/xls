package com.xlm.leetcode.stack;


import java.util.Stack;

public class HelperSyncMinStack {
    private Stack<Integer> stack;
    private Stack<Integer> helper;

    /**
     * initialize your data structure here.
     */
    public HelperSyncMinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        stack.add(x);
        if (helper.isEmpty() || helper.peek() >= x) {
            helper.add(x);
        }else{
            helper.add(helper.peek());

        }
    }

    public void pop() {
        Object pop = stack.pop();
        helper.pop();
    }

    public int top() {
        return stack.lastElement();
    }

    public int getMin() {
        return helper.peek();
    }

    public static void main(String[] args) {
        HelperSyncMinStack selfMinStack = new HelperSyncMinStack();
        selfMinStack.push(-2);
        selfMinStack.push(-2);
        selfMinStack.push(-1);
        selfMinStack.push(-1);
        selfMinStack.push(-3);
        selfMinStack.push(-3);
        System.out.println(selfMinStack.getMin());
        selfMinStack.pop();
        System.out.println(selfMinStack.top());
        System.out.println(selfMinStack.getMin());
        selfMinStack.pop();
        System.out.println(selfMinStack.top());
        System.out.println(selfMinStack.getMin());
    }
}

