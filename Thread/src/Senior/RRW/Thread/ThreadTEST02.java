package Senior.RRW.Thread;
/**
 * @author RRW friend_rrw@163.com
 * @create 2020-06-05-21:01
 */

/**
 * @description: 创建两个线程：
 *      1.一个线程遍历50以内的奇数；
 *      2.一个线程遍历50以内的偶数；
 * @author: RRW friend_rrw@163.com
 * @create: 2020-06-05 21:01
 */
public class ThreadTEST02 {
    public static void main(String[] args) {
//        //方式一：你造你的做你的，我造我的做我的；
////        myThread1 m1 = new myThread1();
////        myThread2 m2 = new myThread2();
////        m1.start();
////        m2.start();
        //方式二：用Thread类的匿名子类
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    if (i % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    if (i % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}

class myThread1 extends Thread {
    @Override
    public void run() {
//        for (int i = 0; i < 50; i++) {
//            if (i % 2 == 0) {
//                System.out.println(Thread.currentThread().getName()+":"+i);
//            }
//        }
    }
}

class myThread2 extends Thread {
    @Override
    public void run() {
//        for (int i = 0; i < 50; i++) {
//            if (i % 2 != 0) {
//                System.out.println(Thread.currentThread().getName()+":"+i);
//            }
//        }
    }
}


