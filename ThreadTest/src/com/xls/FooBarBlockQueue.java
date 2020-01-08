package com.xls;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author xls
 * @date 2019-12-11
 * @description
 */
public class FooBarBlockQueue {
    private int n;
    BlockingQueue foo = new LinkedBlockingDeque(1);
    BlockingQueue bar = new LinkedBlockingDeque(1);

    public FooBarBlockQueue(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            Object take = foo.take();
            System.out.print(take.toString());
            bar.put("bar");
        }
    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            foo.put("foo");
            Object take = bar.take();
            System.out.print(take.toString());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBarBlockQueue fooBarSynchronized = new FooBarBlockQueue(100);
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
