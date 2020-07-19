package Senior.Generic;

import java.util.ArrayList;
import java.util.List;

/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-15 15:49
 */
public class OrderforTEST2<T> {  //自定义的泛型类
    String orderName; //比较明确指定的定义方式；
    int orderID;
    //泛型类内部：
    T orderT;

    public OrderforTEST2() {
    }

    public OrderforTEST2(String orderName, int orderID, T orderT) {
        this.orderName = orderName;
        this.orderID = orderID;
        this.orderT = orderT;
    }

    //getOrderT setOrderT toString 都不是泛型方法；
    //不是说使用了泛型的方法使用了泛型 就是泛型方法
    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "OrderforTEST2{" +
                "orderName='" + orderName + '\'' +
                ", orderID=" + orderID +
                ", orderT=" + orderT +
                '}';
    }
    //静态方法中不能使用类的泛型
//    public static void show(T orderT){
//        System.out.println(orderT);
//    }

    //泛型方法： 在方法中出现泛型结构，泛型参数与类的泛型参数，与所属的泛型类没有任何关系；
    //泛型方法是可以声明为静态的，泛型参数在调用方法时确定，而非在实例化时确定；
    public <E> List<E> copyFromArrayToList(E[] arr){ //这里的E就是上面所说的，它与T没有任何关系
        //将数组E[] 遍历加载到list中 ，copyFromArrayToList()是泛型方法
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr){
            list.add(e);
        }
        return list;
    }
}
