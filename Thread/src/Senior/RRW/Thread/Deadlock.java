package Senior.RRW.Thread;
/**
 *@description:  线程的死锁现象1；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-07 00:01
 */
public class Deadlock {
    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();
        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append("1-");//连接一个字符串
                    s2.append("2-");
                    try {  //加sleep()创造出死锁现象
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2){
                        s1.append("3-");
                        s2.append("4-");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append("5-");//连接一个字符串
                    s2.append("6-");
                    synchronized (s1){
                        s1.append("7-");
                        s2.append("8-");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }){}.start();
    }
}
