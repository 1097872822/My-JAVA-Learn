package Senior.RRW.Thread;
/**
 *@description:  有两个储户分别向同一个账户取前，每次存1000，存3次，每次存完打印账户余额；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-07 16:51
 */
class Account {
    private double balance;
    public Account(double balance) {
        this.balance = balance;
    }
    //存钱方法：（同步方法）
    //如果把synchronized去掉，就会出现下面的存钱冲突问题
        public synchronized void deposit (double money){
            if (money > 0) {
                balance += money;
                try {
                    //在这加了sleep()，极大可能就会出现两个人都往里面存了钱，
                    //但一个人存钱成功之后会多了1000;那是因为这条线程睡了1s，
                    //后面的进来存了，它醒来才发现我就存1000，怎么多了1000？
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()
                        +"存钱" + money + "成功！"+ "\t余额为" + balance);
            }
        }
    }
class Customer extends Thread{
    private Account accs;

    public Customer(Account accs) {
        this.accs = accs;
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            accs.deposit(1000);
        }
    }
}
public class TestAccount {
    public static void main(String[] args) {
        Account accs = new Account(0);
        Customer c1 = new Customer(accs);
        Customer c2 = new Customer(accs);
        c1.setName("RRW");
        c2.setName("LQ");
        c1.start();
        c2.start();
    }
}
