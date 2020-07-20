package Senior.RRW.Thread;
/**
 * @description:
 *     线程创建方式二：
 *         eg：搞三个地毯摆摊赚钱，卖肉串；
 * @author: RRW friend_rrw@163.com
 * @create: 2020-06-05 23:13
 */

class Stalls extends Thread { //继承方式；
    private static int Kebabs = 500;//500串肉串；
    // 可能会出现重串，因为存在线程安全问题，待解决
//    private static Object obj = new Object();
    @Override
    public void run() {
             while (true) {
                synchronized (SafetyThread.class) { //或放obj
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Kebabs > 0) { //串串还有
                    System.out.println(getName() + "：卖出去第"
                            + Kebabs + "串");
                    Kebabs--;
                } else {
                    break;
                }
            }
        }
    }
}
public class ThreadTEST03 {
    public static void main(String[] args) {
        Stalls s1 = new Stalls();
        Stalls s2 = new Stalls();
        Stalls s3 = new Stalls();

        s1.setName("摊位1:");
        s2.setName("摊位2:");
        s3.setName("摊位3:");
        s1.start();
        s2.start();
        s3.start();
    }

}
