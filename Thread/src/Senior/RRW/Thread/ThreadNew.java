package Senior.RRW.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@description: 线程创建的4中方式：
 *      1.继承Thread
 *      2.实现Runnable
 *      3.实现Callable
 *      4.使用线程池
 *@author: RRW friend_rrw@163.com
 *@create: 2020-07-20 14:46
 */
public class ThreadNew {
    public static void main(String[] args) {
        new MyThread01().start();
        new Thread(new MyThread02()).start();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(new MyThread03());
        new Thread(futureTask).start();
        try {
            Integer value = futureTask.get();
            System.out.println(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class MyThread01 extends Thread {
    @Override
    public void run() {
        System.out.println("-----MyThread01");
    }
}

class MyThread02 implements Runnable {
    public void run() {
        System.out.println("-----MyThread02");
    }
}

class MyThread03 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("-----MyThread03");
        return 200;
    }
}