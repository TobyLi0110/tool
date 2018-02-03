package com.nan.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLockInterrupt {
    private Lock mLock1;
    private Lock mLock2;
    private Lock mLock3;

    public TestLockInterrupt() {
        mLock1 = new ReentrantLock();
        mLock2 = new ReentrantLock();
        mLock3 = new ReentrantLock();
    }

    public void f() {
        System.out.println(Thread.currentThread().getName() + ":try to get lock in f().");

        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + ":get the lock.");

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + ":already marked as interrupted but still running.");
                }

                TimeUnit.SECONDS.sleep(100);//由于主线程很快结束，而子线程还在却sleep了100秒，使得主线程强行打断子线程的sleep，因此抛出异常
            }

            System.out.println(Thread.currentThread().getName() + ":release the lock.");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ":interrupted."+e);
        }
    }

    public void fWithLock() {
        System.out.println(Thread.currentThread().getName() + ":try to get lock in fWithLock().");

        mLock1.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":get the lock.");

            if (Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + ":already marked as interrupted but still running.");
            }

            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ":interrupted." + e);
        } finally {
            mLock1.unlock();
            System.out.println(Thread.currentThread().getName() + ":release the lock.");
        }
    }

    public void fWithTryLock() {
        System.out.println(Thread.currentThread().getName() + ":try to get lock in fWithTryLock().");

        try {
            if (mLock2.tryLock(50, TimeUnit.SECONDS)) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":get the lock.");

                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println(Thread.currentThread().getName() + ":already marked as interrupted but still running.");
                    }

                    TimeUnit.SECONDS.sleep(100);
                } finally {
                    mLock2.unlock();
                    System.out.println(Thread.currentThread().getName() + ":release the lock.");
                }
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ":interrupted.");
        }
    }

    public void fWithLockInterruptibly() {
        System.out.println(Thread.currentThread().getName() + ":try to get lock in fWithLockInterruptibly().");

        try {
            mLock3.lockInterruptibly();
            System.out.println(Thread.currentThread().getName() + ":get the lock.");

            try {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + ":already marked as interrupted but still running.");
                }

                TimeUnit.SECONDS.sleep(100);
            } finally {
                mLock3.unlock();
                System.out.println(Thread.currentThread().getName() + ":release the lock.");
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + ":interrupted.");
        }
    }

    private class Worker implements Runnable {
        private int index;

        public Worker(int index) {
            this.index = index;
        }

        public void run() {
            switch (index) {
                case 1:
                    f();
                    break;
                case 2:
                    fWithLock();
                    break;
                case 3:
                    fWithTryLock();
                    break;
                case 4:
                    fWithLockInterruptibly();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        TestLockInterrupt testLockInterrupt = new TestLockInterrupt();

        for (int i = 3; i <= 3; i++) {
            Thread t1 = new Thread(testLockInterrupt.new Worker(i));
            Thread t2 = new Thread(testLockInterrupt.new Worker(i));

            t1.start();
            t2.start();

            t1.interrupt();
            t2.interrupt();
        }
    }
}
