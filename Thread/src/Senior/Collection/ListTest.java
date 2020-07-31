package Senior.Collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@description: Collection子接口之 List接口：
 *          List接口使用方法时，对于Collection兼顾了Set的无序操作，而List是
 *              有序的“动态数组”，就会在Collection的方法中扩展出了一些“索引操作”的方法；
 *          三个实现类：
 *              ArrayList： 作为List接口的主要实现类；线程不安全的，效率高 / 底层使用Object[] 顺序存储
 *              LinkedList：  跟ArrayList跟List接口一起出现(1.2) / 底层使用双向链表存储 / 对于频繁插入删除的操作效率高
 *              Vector：  比较久远的实现类(1.0出现);  线程安全的，效率不高 / 底层使用Object[] 存储
 *
 *    三者异同：
 *      同：三个类都实现了List接口；
 *          三者存储的数据特点都是存储有序，可重复的数据；
 *      异：如上述；
 *
 *      ArrayList 与 LinkList：区别：
 *          两个都是效率较高的线程不安全的数组操作；
 *          对于随机访问的set、get方法，基于动态数组结构的ArrayList更有优势，因为LinkList要移动指针。
 *          对于增删操作频繁的情况，基于链表结构的LinkList更有优势，因为ArrayList需要移动数据;
 *
 *      ArrayList 与 Vector 的区别：
 *          Vector是线程同步的，即线程安全的；
 *          但是Vector因此而开销较大，访问速度更慢；
 *          Vector的扩容是 2倍，ArrayList是 1.5倍；
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-12 13:08
 */
public class ListTest {
    @Test
    /*
        add()：添加元素，可以指定位置添加；
        remove():删除元素，可指定位置删除
        asList()：添加集合,在末尾添加 addAll（）
        get(index):获取指定位置的元素
        indexOf():返回集合中首次出现的元素的位置
        set()： 将某个位置是的元素”改“为指定元素
        subList(): 返回元素，指定从index1开始，到index2结束，不会影响源集合
    */
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(false);//Boolean类型的false
        list.add(new String("RRW"));
        list.add(new People("rrw",20));
//        System.out.println(list);
        //void add(int index,Object element):在index位置插入elsment元素
        list.add(2,"LANQI");
        System.out.println(list);
        //boolean addAll(int index, Collection elsment):从index位置开始将elsment中 的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list);

        //Object get(int index):获取指定index位置的元素
        System.out.println(list.get(2));

        //int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("RRW"));
        //Object remove(int index):移除指定index位置的元素，并返回此元素
        System.out.println(list.remove(2));
        //Object set(int index, Object ele):设置指定index位置的元素为ele
        list.set(1,"cc");
        System.out.println(list);
        //List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex 位置的子集合
        List subList = list.subList(2, 4);
        System.out.println(subList); //不会对原本的list造成影响
        System.out.println(list);
    }
    @Test  //小面试题：
    public void test2(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    public void updateList(List list){
        list.remove(2);//删除的是位置2的数据；
        //自动装箱，IDEA有提示index；要是硬看，还有一个remove(Object o)的方法；
    }
}
