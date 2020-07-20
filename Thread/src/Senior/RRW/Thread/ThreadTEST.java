package Senior.RRW.Thread;
/**
 *@description: 线程创建步骤：
 *          1.创建一个继承于Thread类的子类；
 *          2.重写thread类的run()
 *          3.创建thread类的子类对象；
 *          4.通过此对象调用start()
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-05 17:24
 */
public class ThreadTEST {
    public static void main(String[] args) {
        MThread m1 = new MThread();//主线程造了一个对象
        //首先是启动线程，然后调子类重写父类的run(),
        // 且start()只能被同一对象调用一次；
        m1.start(); //由mThread对象去执行run方法，这是支线程

        //再启动一个线程：
        MThread m2 = new MThread();
        m2.start();

        //以下还是main 主线程执行的操作：
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName()+
                    ":" + "我是主线程");
        }
        System.out.println(Thread.currentThread().getName()+"OMG");//主线程继续执行着，输出这条语句；
        //Thread.currentThread().getName() 获取当前 线程的线程名
    }
}

class MThread extends Thread{
    @Override
    public void run(){
        //线程操作：
        for (int i = 0; i < 50; i++) {
            if (i % 2 == 0){
                System.out.println(
                        Thread.currentThread().getName()+"-"+i + " ");
            }
        }
    }

}
