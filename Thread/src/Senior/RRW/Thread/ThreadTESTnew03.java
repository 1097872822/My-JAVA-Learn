package Senior.RRW.Thread;
/**
 * @author RRW friend_rrw@163.com
 * @create 2020-06-05-23:28
 */

/**
 *@description:  ThreadTEST03的改进：
 *           第二种线程创建的方式：
 *           第一种是MThread中的1.2.3.4步骤
 *        具体步骤：
 *        1、创建一个实现Runnable()接口的类；
 *        2、实现类实现Runnable()中的run()抽象方法；
 *        3、创建实现类的对象；
 *        4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象；
 *        5、通过Thread类的对象调start();
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-05 23:28
 */
//class NewofcreateThread implements Runnable{
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 == 0){
//                System.out.println(Thread.currentThread().getName()+
//                        ":" + i);
//            }
//        }
//    }
//}
//public class ThreadTESTnew03 {
//    public static void main(String[] args) {
//        NewofcreateThread n1 = new NewofcreateThread();
//        Thread t1 = new Thread(n1);
//        //以前我们说：此处t1调的是Thread类里面重写的run();
//        //此处的run()是Runnable类中的target的run();
//        // Thread t1 = new Thread(n1);其实是Thread里的
//        //"public Thread(Runnable target) {}"，也就是说
//        //n1赋给了target，也就是Thread类的run();
//        t1.start();
//
//        //再启动一个线程：
//        Thread t2 = new Thread(n1);
//        t2.start();
//    }
//}

class NEWStalls implements Runnable {
    private int Kebabs = 100;

    @Override
    public void run() {
        while (true) {
            if (Kebabs > 0) { //串串还有
                System.out.println(Thread.currentThread().getName()
                        + "：卖出去第" + Kebabs + "串");
                Kebabs--;
            } else {
                break;
            }
        }
    }
}
public class ThreadTESTnew03 { //实现Runnable接口的方式
    public static void main(String[] args) {
        NEWStalls s1 = new NEWStalls();
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
