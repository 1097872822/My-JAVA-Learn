package Senior.Collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
/**
 *@description: TreeSet 的使用 （可以按照添加对象的指定属性进行排序）
 *                  且顾名思义，其底层实现是一种“树形结构”；
 *                  即TreeMap，采用红黑树的存储结构；且有序，不重复，查询效率比List快；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-13 00:45
 */

public class TreeSetTest {
    @Test   //TreeSet当中添加的数据，只能是相同类的对象，否则报“ClassCastException”错误，
            //且无法体现“按照添加对象的指定属性进行排序”;
    public void test1(){
        TreeSet<People> tree = new TreeSet();
//        tree.add("rrw");
//        tree.add("AIR");
//        tree.add("iphone");
//        tree.add("DD");

        tree.add(new People("rRW",20));
        tree.add(new People("asd",21));
        tree.add(new People("qwer",22));
        tree.add(new People("name",23));
        tree.add(new People("name",103));
        //上面这些new...就涉及到了 “自然排序” 与 “定制排序”；
        //自然排序：
        //如果在CollectionTest.java中重写的
        //compareTo方法中没有比较年龄，单纯只比较了name,则一遇到相同的”name“，则只会输出一个；
        //详细见CollectionTest.java中的重写compareTo写法，使得比较完name，再比较age,从而输出这俩相同的数据；

        Iterator<People> iterator = tree.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    //定制排序(与compator相关):
    @Test
    public void test2(){
        Comparator com = new Comparator() {
            //按年龄从小到大排：
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof People && o2 instanceof People){
                    People p1 = (People) o1;
                    People p2 = (People) o2;
                    return Integer.compare(p1.getAge(),p2.getAge()) ;
                }else {
                    throw new RuntimeException("类型不匹配");
                }
            }
        };
        TreeSet tree = new TreeSet(com); //带参，则定制排序
        tree.add(new People("rRW",20));
        tree.add(new People("asd",21));
        tree.add(new People("qwer",22));
        tree.add(new People("name",23));
        tree.add(new People("name",103));

        Iterator iterator = tree.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
//在自然排序中：比较两个对象是否相等的标准为 compareTo()返回0,不再是equals();
//在定制排序中：比较两个对象是否相等的标准为 compare()返回0,不再是equals();