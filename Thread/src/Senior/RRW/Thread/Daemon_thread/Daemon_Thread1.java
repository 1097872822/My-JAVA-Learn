package Senior.RRW.Thread.Daemon_thread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *@description: Java中的守护进程（守护线程）
 *      Java有两种线程：守护线程（Daemon Thread）与 用户线程（User Thread)
 *      守护线程：
 *          是为运行在相同的进程中的其它线程（User Thread）提供服务的，
 *          是一种“在后台提供通用性支持”的线程，
 *          它并不属于程序本体，比如垃圾回收线程就是一个很称职的守护者。
 *      用户线程：就是我们通常谈论到的线程；
 *      两者区别：
 *          它们唯一的区别是判断虚拟机何时离开：
 *              用户线程（User Thread)：Java虚拟机在它所有非守护线程已经离开后自动离开。
 *              守护线程（Daemon Thread）：守护线程则是用来服务用户线程的，
 *                                       如果没有其他用户线程在运行，
 *                                       那么就没有可服务对象，也就没有理由继续下去。
 *           *当线程只剩下守护线程的时候，JVM就会退出.但是如果还有其他的任意一个用户线程还在，JVM就不会退出。
 *           *setDaemon(boolean on)方法可以方便的设置线程的Daemon模式，true为Daemon模式，false为User模式。
 *           *setDaemon(boolean on)方法必须在线程启动【thread.start()】之前调用，当线程正在运行时调用会产生异常。
 *           *isDaemon方法将测试该线程是否为守护线程。值得一提的是，当你在一个守护线程中产生了其他线程，
 *            那么这些新产生的线程不用设置Daemon属性，都将是守护线程，用户线程同理；
 *      注意的点：
 *           1. 在守护线程中产生的新线程也是守护线程 ；
 *           2. 不是所有的应用都可以交给守护线程（Daemon Thread）
 *              因为所有的用户线程都离开时，JVM就该退出了，前面我也说过，当没有用户线程时，守护线程也该退出了，
 *              如果此时交给守护线程的任务（读写操作或者计算逻辑）没有完成，将造成严重的灾难。
 *           3.守护线程并非只有虚拟机内部可以提供，用户也可以手动将一个用户线程设定/转换为守护线程；
 *      守护线程的应用场景:
 *          Web服务器中的Servlet，在容器启动时，后台都会初始化一个服务线程，即调度线程，负责处理http请求，
 *          然后每个请求过来，调度线程就会从线程池中取出一个工作者线程来处理该请求，从而实现并发控制的目的。
 *          也就是说，一个实际应用在Java的线程池中的调度线程。
 *      个人理解：
 *          从我的理解，守护线程就是用来告诉JVM，我的这个线程是一个低级别的线程，不需要等待它运行完才退出，
 *          让JVM喜欢什么时候退出就退出，不用管这个线程。在日常的业务相关的CRUD开发中，其实并不会关注到守护线程这个概念，也几乎不会用上
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-02 11:45
 */
public class Daemon_Thread1 {
    /*完成文件输出的守护线程任务*/
    public static void main(String[] args) throws InterruptedException {
        Runnable tr = new TestRunnable();
        Thread thread = new Thread(tr);
//        thread.setDaemon(true); // 设置守护线程（必须在thread.start()之前）
        thread.start(); // 开始执行分进程
    }
}
/*
    上面这段代码的运行结果是文件daemon.txt中没有daemon字符串。
    但是如果把thread.setDaemon(true);这行代码注释掉，文件daemon.txt是可以
    被写入daemon字符串的，因为这个时候这个线程就是普通的用户线程了。
    简单理解就是，JRE判断程序是否执行结束的标准是所有的前台线程（用户线程）执行完毕了，
    而不管后台线程（守护线程）的状态。
*/
class TestRunnable implements Runnable {
    public void run(){
        try {
            Thread.sleep(1000); // 守护线程阻塞1秒后运行
            File f = new File(
                    "D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread\\src\\Senior\\RRW\\Thread\\daemon.txt");
            FileOutputStream os = new FileOutputStream(f,true);
            os.write("daemon".getBytes());   //写入文件
        } catch(IOException e1) {
            e1.printStackTrace();
        } catch(InterruptedException e2) {
            e2.printStackTrace();
        }
    }
}