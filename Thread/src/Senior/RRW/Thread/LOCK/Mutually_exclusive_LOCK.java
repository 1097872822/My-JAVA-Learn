package Senior.RRW.Thread.LOCK;

/**
 * @description: 互斥锁 ：
 *          当使用synchroinzed锁住多段不同的代码片段，
 *          但是这些同步块使用的同步监视器对象是同一个时，那么这些代码
 *          片段之间就是互斥的。多个线程不能同时执行他们。
 * @author: RRW friend_rrw@163.com
 * @create: 2020-08-07 19:53
 */
public class Mutually_exclusive_LOCK {
    public static void main(String[] args) {
        final Boo boo = new Boo();
        Thread t1 = new Thread() {
            public void run() {
                boo.methodA();
            }
        };
        Thread t2 = new Thread() {
            public void run() {
                boo.methodB();
            }
        };
        t1.start();
        t2.start();
    }
}

class Boo {
    public synchronized void methodA() {
        Thread t = Thread.currentThread();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t.getName() + ":运行A方法完毕！");
    }

    public void methodB() {
        synchronized (this) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ":正在运行方法B...");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(t.getName() + ":运行B方法完毕！");
        }
    }
}
/*
    Thread-0:运行A方法完毕！
    Thread-1:正在运行方法B...
    Thread-1:运行B方法完毕！
 */