package Senior.Collection;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *@description: Set接口使用 (”Set是特殊的Map“)，一般不会问HashSet,而是问HashSet的底层HashMap；
 *              Set：元素无序，不可重复的集合； 类似“数学集合”
 *                  Set不同于List,使用的都是Collection中声明的方法；
 *                HashSet：作为Set接口的主要实现类；线程不安全的；可以存储null；
 *                LinkedHashSet：作为HashSet的子类；遍历内部数据时，可以按照添加的顺序遍历；
 *                TreeSet：可以按照添加对象的指定属性进行排序；
 *
 *         1.无序性：（不等于随机性）——>哈希(取模、散列、解决冲突)
 *
 *         2.不可重复性：保证添加的元素按照equals()判断时，不能返回true；
 *                     即相同元素只能添加一个；
 *         3.add的过程：以HashSet为例：（背景：保证不可重复性、无序性，且数量庞大时）
 *             底层：数组+链表结构：
 *                     首先通过哈希运算，（取模），确定放在数组的哪个位置；
 *                     如果，这个位置没有数据，直接添加成功；
 *                     如果有(或可能链表上有几个了)：与其比较哈希值——>不一样——>链表的形式在已有元素后面指向新进来的元素
 *                     （“7上8下”：jdk7用的是头插法，jdk8用的是尾插法）；
 *                     添加成功；如果比较哈希值一样，调添加元素所在类的equals()比较，发现eq之后还一样，说明确实是两个一样的数据，
 *                     添加失败，否则成功；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-12 23:05
 */
public class SetTest {
    @Test
    public void test1(){
        Set set = new HashSet();//根据哈希值存放的
        set.add("rrw");
        set.add(123);
        set.add(new People("RRW",20));
        set.add(new People("RRW",20));
        //如果CollectionTest.java里的hashCode没有重写，Set会认为上面是两个地址值
        //不一样但内容一样的值，则会输出两个；所以Set接口在添加数据时应该重写equals()与hashCode()；
        set.add("DD");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()); //输出不是随机的
        }
    }
    @Test  //LinkedHashSet：在上面的HashSet的基础上,在add的过程中，数组+链表的
           //形式存储，且LinkedHashSet的链表为 双向链表，可以记录“先来后到”，会比
           //上面的方法效率高；
    public void test2(){
        Set set = new LinkedHashSet();
        set.add("rrw");
        set.add(123);
        set.add(new People("RRW",20));
        set.add(new People("RRW",20));

        set.add("DD");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
