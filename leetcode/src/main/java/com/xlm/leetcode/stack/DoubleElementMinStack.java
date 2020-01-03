package com.xlm.leetcode.stack;


import java.util.Stack;

public class DoubleElementMinStack {
    private Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public DoubleElementMinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.add(x);
            stack.add(x);
        } else {
            Integer min = stack.peek();
            stack.add(x);
            if (x < min) {
                stack.add(x);
            }else{
                stack.add(min);
            }
        }
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.get(stack.size()-2);
    }

    public int getMin() {
        return stack.peek();
    }

    public static void main(String[] args) {
        DoubleElementMinStack selfMinStack = new DoubleElementMinStack();
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

