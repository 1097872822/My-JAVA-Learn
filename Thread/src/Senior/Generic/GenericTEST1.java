package Senior.Generic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *@description:  泛型自定义结构： 泛型类 泛型接口 泛型方法；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-15 15:48
 */
public class GenericTEST1 {
    @Test
    public void test(){
        OrderforTEST2<String> str = new OrderforTEST2<String>("abc",11,"ABC");
        str.setOrderT("RRW");
        System.out.println(str);
    }

    @Test
    public void test1() {
        SubOrder subOrder = new SubOrder();
        subOrder.setOrderT(123); //class SubOrder中指明了Integer
        SubOrder1<String> objectSubOrder1 = new SubOrder1<>();//就可以指明类型<String>
        objectSubOrder1.setOrderT("123");
        System.out.println(objectSubOrder1);
    }
    @Test //泛型不同不能相互赋值
    public void test2(){
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
//        list1 = list2;  不可以相互赋值;
    }
    @Test //测试copyFromArrayToList()泛型方法；
    public void test3(){
        OrderforTEST2<String> ord = new OrderforTEST2<>();
        Integer[] arr = new Integer[]{1,2,3};
        List<Integer> list = ord.copyFromArrayToList(arr);//Integer是由放进去的数字决定的；
        System.out.println(list);
    }
}
