package Senior.RRW.Thread.LOCK;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *@description: ReentranLock是Lock的唯一实现类:介绍一下ReentranLock与synchronized的区别:
 *       > Synchronized是一个同步锁。当一个线程A访问synchronized修饰的代码块时，线程A就会获取该代码块的锁，
 *         如果这时存在其他线程范围该代码块时，将会阻塞，但是不影响这些线程访问其他非同步代码块。
 *       > ReentranLock是可重入锁。由构造方法可知，该锁支持两种锁模式，公平锁和非公平锁。默认是非公平的。
 *
 *       > ReentrantLock：使用上需要显示的获取锁和释放锁，提高可操作性、可中断的获取获取锁以及可超时的获取锁，
 *         默认是非公平的但可以实现公平锁，悲观，独享，互斥，可重入，重量级锁。
 *       > synchronized：关键字，隐式的获取锁和释放锁，不具备可中断、可超时，非公平、互斥、悲观、独享、可重入的重量级 ;
 *
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-07 18:29
 */
/*
    ReentranLocktest 的两种模式：
        公平锁：当线程A获取访问该对象，获取到锁后，此时内部存在一个计数器num+1，其他线程想访问该对象，
                就会进行排队等待(等待队列最前一个线程处于待唤醒状态)，直到线程A释放锁(num = 0)，
                此时会唤醒处于待唤醒状态的线程进行获取锁的操作，一直循环。如果线程A再次尝试获取该对象锁时，
                会检查该对象锁释放已经被占用，如果被占用，会做一次是否为当前线程占用锁的判断，
                如果是内部计数器num+1，并且不需要进入等待队列，而是直接回去当前锁。
        （默认）非公平锁：当线程A在释放锁后，等待对象的线程会进行资源竞争，竞争成功的线程将获取该锁，其他线程继续睡眠。

        公平锁是严格的以FIFO的方式进行锁的竞争，但是非公平锁是无序的锁竞争，刚释放锁的线程很大程度上能比较快的获取到锁，
    队列中的线程只能等待，所以非公平锁可能会有“饥饿”的问题。但是重复的锁获取能减小线程之间的切换，
    而公平锁则是严格的线程切换，这样对操作系统的影响是比较大的，所以非公平锁的吞吐量是大于公平锁的，
    这也是为什么JDK将非公平锁作为默认的实现。
 */
public class ReentranLocktest {
    // ReentrantLock为Lock的唯一实现类
    private Lock lock = new ReentrantLock();

    /**
     * 测试使用lock 的 lock()方法 ：如果锁已经被其他线程获取，则等待
     * @param thread
     */
    public void testLock(Thread thread){
        try {
            // 1.获取锁
            lock.lock();
            System.out.println("线程 " + thread.getName() + " 获取了锁！");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("线程 " + thread.getName() + " 释放了锁！");
            // 必须在 finally 中释放锁，防止死锁
            lock.unlock();
        }
    }

    /**
     * 测试使用lock 的 lock()方法 ：通过这个方法去获取锁时，如果线程正在等待获取锁，
     * 则这个线程能够响应中断，即中断线程的等待状态。
     * @param thread
     */
    public void testLockInterruptibly(Thread thread){
        try {
            // 1.获取锁
            lock.lockInterruptibly();
            System.out.println("线程 " + thread.getName() + " 获取了锁！");
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("线程 " + thread.getName() + " 释放了锁！");
            // 必须在 finally 中释放锁，防止死锁
            lock.unlock();
        }
    }

    /**
     * 测试使用lock 的 tryLock()方法 ：如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），
     * 则返回false
     * @param thread
     */
    public void testTryLock(Thread thread){
        if(lock.tryLock()){// 如果获取到了锁
            try {
                System.out.println("线程 " + thread.getName() + " 获取了锁！");
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("线程 " + thread.getName() + " 释放了锁！");
                // 必须在 finally 中释放锁，防止死锁
                lock.unlock();
            }
        }else {
            // 没有获取到锁
            System.out.println("线程 " + thread.getName() + " 没有获取到锁！");
        }
    }

    /**
     * 测试使用lock 的 tryLock(long time, TimeUnit unit)方法 ：和tryLock()方法是类似的，只不过区别在于这个方法在拿不到锁时会等待一定的时间，
     * 在时间期限之内如果还拿不到锁，就返回false。如果如果一开始拿到锁或者在等待期间内拿到了锁，则返回true。
     * @param thread
     */
    public void testTryLock_time_unit(Thread thread){
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){// 如果获取到了锁
                try {
                    System.out.println("线程 " + thread.getName() + " 获取了锁！");
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    System.out.println("线程 " + thread.getName() + " 释放了锁！");
                    // 必须在 finally 中释放锁，防止死锁
                    lock.unlock();
                }
            }else {
                // 没有获取到锁
                System.out.println("线程 " + thread.getName() + " 没有获取到锁！");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ReentranLocktest testLock = new ReentranLocktest();
        Thread a = new Thread("A") {
            @Override
            public void run() {
                // 测试 lock()
                testLock.testLock(Thread.currentThread());
                System.out.println("-------------------------------");
                // 测试 lockInterruptibly()
                testLock.testLockInterruptibly(Thread.currentThread());
                System.out.println("-------------------------------");
                // 测试 tryLock()
                testLock.testTryLock(Thread.currentThread());
                System.out.println("-------------------------------");
                // 测试 tryLock(long time, TimeUnit unit)
                testLock.testTryLock_time_unit(Thread.currentThread());
               /*testLock.testTryLock_time_unit(Thread.currentThread());*/
            }
        };
        Thread b = new Thread("B") {
            @Override
            public void run() {
                testLock.testTryLock(Thread.currentThread());
            }
        };
        a.start();
        b.start();
    }
}
