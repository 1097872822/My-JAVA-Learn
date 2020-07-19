package Senior.RRW.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@description: 线程创建的方式三：实现Callable接口；
 *            为什么Callable要比Runnable好？
 *              1.call()有返回值；支线程执行完毕可以给其他线程返回结果；
 *              2.call()可以抛出异常，可以被外面的操作捕获异常信息；
 *              3.Callable支持泛型；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-07 20:43
 */
//1、创建一个实现Callable的实现类：
class CallableThread implements Callable{
    //2、实现call()方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {  //call():回调方法
        //这里涉及包装Integer，方法是Object类的返回，而下面return sum；是int型的,多态形式了；
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0){
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

public class CallableTest {
    public static void main(String[] args) {
        //3、创建callable接口实现类的对象：
        CallableThread C1 = new CallableThread();
        //4、将此callable接口实现类的UI想走位传递到FutureTask构造器中，创建FutrueTask的对象；
        FutureTask futureTask = new FutureTask(C1);
        //创建线程：
        //5、将FutrueTask的对象作为参数传递到Thread类的构造器中，创建Thread类对象，调用start();
        new Thread(futureTask).start();//FutureTask也实现了Runnable
        //源码：public class FutureTask<V> implements RunnableFuture<V> {
        try {
            //6、获取Callable总call()方法的返回值
            //get()方法返回值是FutureTask构造器参数Callable实现类重写call()的返回值 即sum
            Object sum = futureTask.get();
            System.out.println("我是call()的返回，总和：" + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (
                ExecutionException e) {
            e.printStackTrace();
        }

    }
}
