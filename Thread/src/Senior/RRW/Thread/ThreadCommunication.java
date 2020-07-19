package Senior.RRW.Thread;

/**
 *@description:  线程的通信问题；
 *                使用两个线程交替打印1-100；
 *             注意：1.wait()/notify()/notifyAll()三个方法必须都是调用同一个监视器,
 *                  否则出现“java.lang.IllegalMonitorStateException”非法监视器状态异常；
 *
 *                  2.wait()/notify()/notifyAll()虽然在线程中出现，但是他们是
 *                  定义在Object类中的，而sleep()是定义在Thread类中的；言外之意，同步监视器
 *                  为任何一个类（只被调用一次）都可以充当，那么这个充当同步监视器的对象，则这个
 *                  对象方法wait()/notify()/notifyAll()，则应该在Object类中；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-07 17:20
 */
class NUMber implements Runnable{
    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (obj) {
                obj.notify();//唤醒一个(优先级高的)线程，就可以实现线程121212交替打印了；
//                notifyAll();//全部唤醒
                if (number <= 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {
                        obj.wait(); //进入阻塞等待
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else{
                    break;
                }
            }
        }
    }
}
public class ThreadCommunication {
    public static void main(String[] args) {
        NUMber n = new NUMber();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.setName("线程1：");
        t2.setName("线程2：");
        t1.start();
        t2.start();
    }
}
