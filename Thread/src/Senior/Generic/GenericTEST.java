package Senior.Generic;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *@description:   泛型 测试
 *          1.在集合中，接口或者集合类在 5 的时候都改为带有泛型的结构；
 *          2.实例化集合类时，泛型不能使用基本数据类型；
 *          3.集合类或接口中凡是定义类或接口时，内部结构都将被赋为相对应的泛型；
 *          4.没有指定泛型时，默认为java.lang.Object类
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-15 14:49
 */
public class GenericTEST {
    @Test  //ArrayList为例
    public void test1(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        //加泛型，保证数据安全，后边的可以不加Integer,即“类型推断”
        list.add(76);
        list.add(736);
        list.add(643);
        list.add(-76);
//        list.add("abc");  //问题1：突然混进一个别的类型的
        //问题2：强转出现类型不匹配；
       /* for (Integer source: list){
            int stuSource =  source;
            System.out.println(stuSource);
        }*/
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer stuSource = iterator.next();
            System.out.println(stuSource);
        }
    }
    @Test   //HashMap为例
    public void test2(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("abc",23);
        map.put("xyz",-23);
        map.put("qwer",223);
        //泛型的嵌套：
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            String key = next.getKey();
            Integer value = next.getValue();
            System.out.println(key+ "——>" +value);
        }
    }
    @Test //泛型在继承方面的体现；
                //1.A 是 B 的父类，但是 F<A> 与 F<B> 不具有子父类关系；
                            //但A<F> 与 B<F> 是具有子父类关系的，他们可以相互赋值；
    public void test3(){
        Object obj = null;
        String str = null;  //具有子父类关系
        obj = str; //数组形式也是可以的 (多态性)
    }
    @Test  //泛型的通配符的使用；一定程度上解决了我不需要写一个<String>和一个<Integer>
            //来区分我这个方法只能是做什么类型的操作，我只要找到两个<>和<>的父类，就可以通用了；
        public void test4(){
        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list = null;  //List<?> 作为 List<Object> 与 List<String>的通用父类；
        list = list1;
        list = list2;
//        printtest3(list1);
//        printtest3(list2);
        //使用通配符后的数据读写要求：
        List<String> list3 = new ArrayList<>();
        list3.add("A");
        list3.add("B");
        list = list3;
//        list.add("C"); //add(capture fo ? e)  //限制添加数据，除了null，即不让“读”；
        Object o = list.get(1);//获取1位置上的数据;//get(capture fo ?),可以读取Object类的数；
        System.out.println(o);
    }
    public void printtest3(List<?> list){
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next(); //<?>不管是什么，都不会超出Object类；
        }
    }
    @Test //带限制的通配符：
    public void test5(){
        /*
           对于 ? extends A : F<? extends A> 可作为F<A>与F<B>的父类，其中B是A的子类；
           对于 ? super A : F<? super A> 可作为F<A>与F<B>的父类，其中B是A的父类；
           ? 可以视为(负无穷，正无穷) <? extends A>则可视为(负无穷，A] 有上界
            <? super A> 可视为 [A,正无穷) 有下界
        */
       /* List<? extends People> list1 = null;
        List<? super People> list2 = null;
        List<Sudent> list3 = null;
        List<People> lsit4 = null;
        List<Object> list5 = null;
        list1 = list3;  //可以赋值
        list1 = list4;  //可以
        list1 = list5;  //不可以
        */
    }
}
