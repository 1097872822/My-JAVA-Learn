package Senior.RRW.Thread.LOCK;

/**
 *@description: 互斥锁 & 读写锁
 *      （1）synchronized 是互斥锁；
 *      （2）ReentrantLock 顾名思义 ：可重入锁
 *      （3）ReadWriteLock :读写锁
 *     读写锁特点：
 *          a）多个读者可以同时进行读
 *          b）写者必须互斥（只允许一个写者写，也不能读者写者同时进行）
 *          c）写者优先于读者（一旦有写者，则后续读者必须等待，唤醒时优先考虑写者）
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-07 19:25
 */


import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
* @Description: ReentrantLock (可重入锁)
* @Author: RRW
* @Date: 2020/8/7
*/
class Outputter1 {
    private Lock lock = new ReentrantLock();// 锁对象
    public void output(String name) {
        lock.lock();      // 得到锁
        try {
            for (int i = 0; i < name.length(); i++) {
                System.out.print(name.charAt(i));
            }
        } finally {
            lock.unlock();// 释放锁
        }
    }
}
/*ReentrantLock 类实现了Lock ，它拥有与synchronized 相同的并发性和内存语义，但是添加了类似锁投票、定时锁等候和可中断锁等候的一些特性。此外，它还提供了在激烈争用情况下更佳的性能。
（换句话说，当许多线程都想访问共享资源时，JVM 可以花更少的时候来调度线程，把更多时间用在执行线程上。）*/
//需要注意的是，用sychronized修饰的方法或者语句块在代码执行完之后锁自动释放，而是用Lock需要我们手动释放锁，所以为了保证锁最终被释放(发生异常情况)，要把互斥区放在try内，释放锁放在finally内！！

/**
* @Description: 读写锁ReadWriteLock
 *      上例中展示的是和synchronized相同的功能，那Lock的优势在哪里？
 *      例如一个类对其内部共享数据data提供了get()和set()方法，如果用synchronized，则代码如下：
* @Author: RRW
* @Date: 2020/8/7
*/
class syncData {
    private int data;// 共享数据        
    public synchronized void set(int data) {
        System.out.println(Thread.currentThread().getName() + "准备写入数据");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.data = data;
        System.out.println(Thread.currentThread().getName() + "写入" + this.data);
    }

    public synchronized void get() {
        System.out.println(Thread.currentThread().getName() + "准备读取数据");
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "读取" + this.data);
    }


    /*然后写个测试类来用多个线程分别读写这个共享数据：*/
    public static void main(String[] args) {
//        final Data data = new Data();
        final syncData data = new syncData();
//        final RwLockData data = new RwLockData();

        //写入
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.set(new Random().nextInt(30));
                    }
                }
            });
            t.setName("Thread-W" + i);
            t.start();
        }
        //读取
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        data.get();
                    }
                }
            });
            t.setName("Thread-R" + i);
            t.start();
        }
    }
}

/*
    从运行结果看：现在一切都看起来很好！各个线程互不干扰！
    等等..读取线程和写入线程互不干扰是正常的，但是两个读取线程是否需要互不干扰？？
    对！读取线程不应该互斥！

    我们可以用读写锁ReadWriteLock实现：
    import java.util.concurrent.locks.ReadWriteLock;
    import java.util.concurrent.locks.ReentrantReadWriteLock;
*/
class Data {
    private int data;// 共享数据
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public void set(int data) {
        rwl.writeLock().lock();// 取到写锁
        try {
            System.out.println(Thread.currentThread().getName() + "准备写入数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.data = data;
            System.out.println(Thread.currentThread().getName() + "写入" + this.data);
        } finally {
            rwl.writeLock().unlock();// 释放写锁
        }
    }

    public void get() {
        rwl.readLock().lock();// 取到读锁
        try {
            System.out.println(Thread.currentThread().getName() + "准备读取数据");
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "读取" + this.data);
        } finally {
            rwl.readLock().unlock();// 释放读锁
        }
    }
}

/*
    与互斥锁定相比，读-写锁定允许对共享数据进行更高级别的并发访问。虽然一次只有一个线程（writer 线程）
    可以修改共享数据，但在许多情况下，任何数量的线程可以同时读取共享数据（reader 线程）
    从理论上讲，与互斥锁定相比，使用读-写锁定所允许的并发性增强将带来更大的性能提高。
    在实践中，只有在多处理器上并且只在访问模式适用于共享数据时，才能完全实现并发性增强
    例如，某个最初用数据填充并且之后不经常对其进行修改的 collection，因为经常对其进行搜索
    （比如搜索某种目录），所以这样的 collection 是使用读-写锁定的理想候选者。
 */