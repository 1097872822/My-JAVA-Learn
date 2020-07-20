package Senior.RRW.Thread;

/**
 *@description: 生产者 生产 与 消费者 消费的冲突问题
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-07 18:06
 */

class Shop{
    private int productNum = 0;
    public synchronized void shengchan() { //生产同步方法
        if (productNum < 20){   //产品小于20 就继续生产
            productNum++;
            System.out.println(Thread.currentThread().getName()+
                    "开始生产第："+ productNum+ "个产品");
            notify();//只要一生产就可以开始抢
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void qianggou() { //抢购同步方法
        if (productNum > 0){
            System.out.println(Thread.currentThread().getName()+
                    "开始抢购第："+ productNum+ "个产品");
            productNum--;
            notify(); //一个线程抢一次
        }else {
            //等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Producer extends Thread{ //生产者
    private Shop shop;
    public Producer(Shop shop){
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":开始生产");
        while (true){
            try {
                Thread.sleep(100);//设置生产快些
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.shengchan();
        }
    }
}
class Consumer extends Thread { //消费者
    private Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":开始抢");
        while (true) {
            try {
                Thread.sleep(1000);//设置抢慢一些；
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shop.qianggou();
        }
    }
}
public class CandP_problem {
    public static void main(String[] args) {
        Shop shop = new Shop(); //作为同步监视器 唯一一个
        Producer p1 = new Producer(shop);
        p1.setName("生产者1：");
        //设生产者的优先级较高，避免消费者没有商品的前提下就开始抢；
        p1.setPriority(Thread.MAX_PRIORITY);
        Consumer c1 = new Consumer(shop);
        Consumer c2 = new Consumer(shop);
        Consumer c3 = new Consumer(shop);
        c1.setName("消费者1：");
        c2.setName("消费者2：");
        c3.setName("消费者3：");
        p1.start();
        c1.start();
        c2.start();
        c3.start();
    }
}
