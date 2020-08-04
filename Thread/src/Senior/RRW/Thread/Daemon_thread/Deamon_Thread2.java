package Senior.RRW.Thread.Daemon_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@description: 守护线程测试2
 *          java 的守护进程示例,当任务执行完毕，守护进程运行结束；
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-02 12:15
 */
public class Deamon_Thread2 {
    public static void main(String[] args) {
        Thread d = new Daemons();
        System.out.println("d.isDaemon() = " + d.isDaemon());
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Waiting for CR");
        try {
            stdin.readLine();
            /*
            read方法：读取单个字符。 返回：作为一个整数（0-65535)
            读入的字符，如果已到达流末尾，则返回 -1 ；

            readLine方法：读取一个文本行。通过下列字符之一即可认为某行已终止：换行 ('\n')、回车 ('\r')
            或回车后直接跟着换行。返回：包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
            */
        } catch (IOException e) {
        }
    }
}
//主线程类
class Daemons extends Thread {
    private static final int SIZE = 10;
    private Thread[] t = new Thread[SIZE];
    public Daemons() {
        setDaemon(true);
        start();
    }
    public void run() {
        for (int i = 0; i < SIZE; i++) {
            t[i] = new DaemonSpawn(i);
        }
        for (int i = 0; i < SIZE; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon());
        }
        while (true) {
            yield();
        }
    }
}

//子线程类（守护线程） DaemonSpawn类
class DaemonSpawn extends Thread {
    public DaemonSpawn(int i) {
        System.out.println("DaemonSpawn " + i + " started");
        start();
    }
    public void run() {
        while (true) {
            yield();
        }
    }
}