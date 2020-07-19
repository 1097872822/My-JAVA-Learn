package Senior.RRW.Thread;
/**
 *@description:  NEWStalls.java的进阶 ：线程安全
 *                 即 有可能会出现重复（卖出同一串）,或出现-1、0的情况
 *                 如购票 取钱等问题，不能重票错票问题 两个人“同时取一笔钱”这样的情况；
 *           解决：“同步机制”：
 *                  方式一：同步代码块：
 *                         synchronized(同步监视器){
 *                          //需要被同步的代码(操作共享数据(有多个线程操作)的代码)
 *                         //同步监视器：“锁”；即 任何一个类的对象都可以充当“锁”；
 *                         //且多个线程必须同用一把“锁”；相当于“单线程”在操作，效率变低但安全；
 *
 *                         //若是在“继承”的情况下，有可能是new了几个对象，
 *                         //此时，创建共用对象obj时，就得是static的了，使得
 *                         //这几个对象共用一把锁；见：ThreadTEST03.java
 *                         }
 *                         //更简便的写法：使用this，不用再新建共用对象，此时的this，
 *                         //为当前类的对象，则ThreadTEST03中当前类中有三个类的对象，
 *                         //不能用this，可以用类 xxx.class来“充当对象”；此处往后拓展；
 *
 *                  方式二：同步方法：
 *                         //如果操作共享数据的代码完整的声明在一个方法中，
 *                         //那就可以把此方法声明为同步的； private synchronized void FF() {}
 *                         //如果是继承方式实现的呢？ 同样离不开static ，同接口方式操作：
 *                         //写成：private static synchronized void FF() {}
 *                         //总结： 非静态的同步方法，同步监视器是this；
 *                                  静态的同步方法，同步监视器是当前类本身；
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-06 21:12
 */


class NEWStallsforsafety implements Runnable {
    private int Kebabs = 500;
    Object obj = new Object();//保证对象的唯一性；

    @Override
    public void run() {

        while (true) {
//            synchronized (obj) {
//            if (Kebabs > 0) { //串串还有
//                try {  //sleep()放这出现-1的概率大一些
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(Thread.currentThread().getName()
//                        + "：卖出去第" + Kebabs + "串");
//                //sleep()放这出现重 串概率高一些
//                Kebabs--;
//            } else {
//                break;
//            }
//        }
            FF();
        }
    }
    private synchronized void FF() { //同步方法的方式解决
        if (Kebabs > 0) { //串串还有
            try {  //sleep()放这出现-1的概率大一些
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()
                    + "：卖出去第" + Kebabs + "串");
            //sleep()放这出现重 串概率高一些
            Kebabs--;
        }
        }
    }


public class SafetyThread {//实现Runnable接口的方式
    public static void main(String[] args) {
        NEWStallsforsafety s1 = new NEWStallsforsafety();
        Thread t1 = new Thread(s1); //s1是t1/t2/t3共享的
        Thread t2 = new Thread(s1);
        Thread t3 = new Thread(s1);
        t1.setName("摊位1:");
        t2.setName("摊位2:");
        t3.setName("摊位3:");
        t1.start();
        t2.start();
        t3.start();
    }
}