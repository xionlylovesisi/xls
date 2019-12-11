package com.xls;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xls
 * @date 2019-12-11
 * @description
 */
public class FooBarCondition {
    private int n;
    ReentrantLock lock = new ReentrantLock();
    Condition foo = lock.newCondition();
    Condition bar = lock.newCondition();
    AtomicBoolean flag = new AtomicBoolean(false);

    public FooBarCondition(int n) {
        this.n = n;
    }

    public void foo() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (flag.get()){
                    foo.await();
                }
                System.out.print("foo");
                flag.getAndSet(true);
                bar.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public void bar() throws InterruptedException {

        for (int i = 0; i < n; i++) {
            lock.lock();
            try {
                while (!flag.get()){
                    bar.await();
                }
                System.out.print("bar");
                flag.getAndSet(false);
                foo.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBarCondition fooBarSynchronized = new FooBarCondition(100);
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
