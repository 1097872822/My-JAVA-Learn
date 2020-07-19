package Senior.RRW.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description: 解决线程安全方式三: LOCK锁
 *                  synchronized 与 lock：
 *                      区别： synchronized是在执行完同步代码后悔自动释放同步监视器；
 *                            lock则需要手动 lock.lock();-----lock.unlock();
 * @author: RRW friend_rrw@163.com
 * @create: 2020-06-07 00:38
 */

class stalls implements Runnable {
    //1.实例化 ReentrantLock
    private ReentrantLock lock = new ReentrantLock(true);
    // ctrl + alt + / 参数提示快捷键
    //"fair:true" ： 是否公平，不写就是不公平的；先进先出，先来先得
    //LOCK本身是一个接口，具体使用的是它的子类ReentrantLock；

    private int Kebabs = 100; //继续卖羊肉串

    @Override
    public void run() {
        while (true) {
            try {
                // 2.调用lock方法： //也是类似写成像前面的“单线程”
                lock.lock();
                if (Kebabs > 0) { //串串还有

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：卖出去第"
                            + Kebabs + "串");
                    Kebabs--;
                } else {
                    break;
                }
            } finally {
                //3. 调用解锁方法：
                lock.unlock();
            }
        }
    }
}

public class LOCK_Thread {
    public static void main(String[] args) {
        stalls s1 = new stalls();
        Thread thread1 = new Thread(s1);
        Thread thread2 = new Thread(s1);
        Thread thread3 = new Thread(s1);

        thread1.setName("摊位1：");
        thread2.setName("摊位2：");
        thread3.setName("摊位3：");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
