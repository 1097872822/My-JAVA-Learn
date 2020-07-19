package Senior.RRW.Thread;

/**
 *@description:  使用同步机制解决 懒汉式 的线程安全问题;
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-06 23:34
 */
public class Lazy_singleton {

}
class Bank_Lasy {
    private Bank_Lasy() {
    }

    private static Bank_Lasy instance = null;

    public static Bank_Lasy getInstance() {//直接加synchronized简单解决线程安全的问题；
        //方式一：效果比较差；因为等第一个线程进去执行完之后，资源用完了，但后面的线程还进去，还要一个个告诉它，没东西了，有点浪费的意思；
//        synchronized (Bank_Lasy.class) { //等同于上面直接加synchronized
//            if (instance == null){ //instance就是共享的了
//                instance = new Bank_Lasy();
//            }
//            return instance;
//        }

        //方式二：效率较高；
        if (instance == null) { //多加一个判断，相当于前几个进去的线程进去出来之后，
                                //在入口就告诉后面的线程，里面已经空了；
            synchronized (Bank_Lasy.class) {
                if (instance == null) {
                    instance = new Bank_Lasy();
                }
            }
        }
        return instance;
    }
}

