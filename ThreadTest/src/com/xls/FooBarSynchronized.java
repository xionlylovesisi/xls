package com.xls;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author xls
 * @date 2019-12-11
 * @description
 */
public class FooBarSynchronized {
    private int n;
    AtomicBoolean flag = new AtomicBoolean(false);
    public FooBarSynchronized(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this){
                while (flag.get()) {
                    this.wait();
                }
                System.out.print("foo");
                flag.compareAndSet(false,true);
                this.notifyAll();
            }
        }
    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this){
                while (!flag.get()) {
                    this.wait();
                }
                System.out.print("bar");
                flag.compareAndSet(true,false);
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBarSynchronized fooBarSynchronized = new FooBarSynchronized(20);
        new Thread(() -> {
            try {
                fooBarSynchronized.foo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fooBarSynchronized.bar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
