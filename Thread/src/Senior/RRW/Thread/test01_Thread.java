package Senior.RRW.Thread;
/**
 * @author RRW friend_rrw@163.com
 * @create 2020-06-05-21:23
 */

/**
 * @description: Thread中常用的方法：
 * 1.start()：启动当前线程；调用run();
 * 2.run():是重写Thread类中的方法；里面放要执行的代码；
 * 3.currentThread():是一个静态方法，返回执行当前代码的线程；
 * * getName():获取当前线程的名字；
 * * setName():创建当前线程的名字；
 * 4.yield():释放执行权；
 * 5.join():A线程调用的B线程的join()方法，使A阻塞
 * B线程先执行完毕，A线程阻塞状态技术，才继续执行；
 * 6.stop():强制结束当前线程，已经out了，不推荐使用；
 * 7.sleep():使当前线程进入sleep(一段时间的阻塞状态)
 * 8.isAlive():判断当前线程是否存活；
 *
 *
 * 线程的优先级：
 * 1.MAX_PRIORITY:10;
 * 2.MIN_PRIORITY:1;
 * 3.NORM_PRIORITY:5;  默认优先级
 * 获取方法：
 *      1.getPriority():获取线程的优先级；
 *      2.setPriority(int p):设置线程的优先级；
 *    注意：并不是说优先级高的会先执行，
 *          有点vip的意思，也有点概率高的意思；也会有穿插执行的情况
 * @author: RRW friend_rrw@163.com
 * @create: 2020-06-05 21:23
 */
class test01Thread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() +
                    ":"+"优先级为：" +getPriority()+ " " + i);
            if (i == 30) {
//            yield();
//                try {
//                    //当i=30时，阻塞5s，并且等待任务分配
//                    sleep(5000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        }
    }

    public test01Thread(String name) {
        super(name);

    }
}

public class test01_Thread {
    public static void main(String[] args) {
        test01Thread t1 = new test01Thread("thread:新名字");
//        t1.setName("线程1:");
        t1.setPriority(Thread.MAX_PRIORITY);//设子线程优先级最高；
        t1.start();
        Thread.currentThread().setName("给主线程命的名:");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);//设主线程的优先级为最低；
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
//            if (i % 20 == 0) {
//                try {
//                    t1.join();//子线程执行完，主线才继续执行；
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

