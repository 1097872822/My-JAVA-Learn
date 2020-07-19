package Senior.RRW.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 *@description: 创建线程的方式四： 使用线程池；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-07 21:50
 */

class Dowork implements Runnable{
private int sum = 0;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+
                        ":"+i);
                sum += i;
            }
        }
        System.out.println("总和："+sum);
    }
}

public class ThreadPool {
    public static void main(String[] args) {
/*        //1.创建一个可重用固定线程数的线程池：
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //提供实现Runnable/Callable接口实现类的对象，告诉线程池要干嘛；
        executorService.execute(new Dowork());//适用于Runnable
        //executorService.submit(Callable callable);//使用于Callable
        executorService.shutdown(); //关闭线程池；
*/

        //那上面提到的线程管理怎么体现呢？
        //首先就要设置线程池的属性： 那属性怎么获取？
        //发现用池executorService.不出这些属性；而ExecutorService是一个接口，没有对象
        //则可以使用getClass（）获取接口ExecutorService实现某个类的对象；
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(executorService.getClass());//class java.util.concurrent.ThreadPoolExecutor
        /*实际上ThreadPoolExecutor这个类有：
              ThreadPoolExecutor extends AbstractExecutorService;
              AbstractExecutorService implements ExecutorService;
              如上的对应关系；考虑强转一下：
              */
        ThreadPoolExecutor executorService1 = (ThreadPoolExecutor) executorService;
        //此时executorService1.是 ThreadPoolExecutor 返回的对象，就可以看到它的属性了
        executorService1.setCorePoolSize(10);//线程核心数
        //executorService1.setMaximumPoolSize(20);//最大线程数
        //executorService1.setKeepAliveTime();//无任务等待时长后终止
        executorService1.execute(new Dowork());
        executorService1.shutdown();
    }
}
