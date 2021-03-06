package Senior.Collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *@description:  Map接口： 双列数据  (key-value) ( y=f(x) )
 *              HashMap： Map的主要实现类 / 线程不安全的，效率较高；/ 可以存null、key/value
 *                  LinkedHashMap：(在底层HashMap基础上加了"前后指针：before 和 after")
 *                                 保证在遍历map元素时，可按添加顺序遍历；
 *
 *              TreeMap：按照key-value进行排序；（按key） 底层使用红黑树；
 *              Hashtable：不常用的古老实现类  /  线程安全的，效率低；不可以存null、key/value
 *                  Properties：处理配置文件的，其key与value都是String类的
 *
 *          且HashMap 7之前，数组+链表；
 *                    8以后，数组+链表+红黑树（当索引位置上的链表存储个数>8,且数组长度>64时，如果小于64，首先考虑数组扩容，先别用树）
 *          常见问题：
 *              1.HashMap底层实现；
 *                  (jdk 7): 创建对象： HashMap map = new HashMap(); / 实例化以后，底层创建
 *                            一长度为16的(扩容的话是2倍)一维数组Entry[] table。/ map.put(key,value); 使用key所在类的
 *                            hashCode()计算哈希值，得到数组中的位置，判断是否添加成功(注意如果比较到的equals他们
 *                            的key一样的话，不同于前面提到的，此时会把put进来的key相同的value值替换)；
 *                  (jdk 8) 与 7 的不同：
 *                          new HashMap() 不会先创建长度16的数组(当put的时候才会创建)，而用的是数组Node[]；
 *
 *              2.HashMap与且Hashtable的异同；
 *              3.CurrentHashMap 与 Hashtable的异同；
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-14 17:30
 */
public class MapTest {
    @Test //Map 中的增删改方法：
    public void test1() {
        //添加、删除、修改操作：
        Map map = new HashMap();
        map.put("rrw", 11);
        map.put("rrw", 12); //HshSet的不可重复性，有体现修改新值的操作
        map.put("Lrw", 13);
        map.put("Trw", 14);
        map.remove("rrw"); //remove(Object key),还有指定删除key-value的，因为不同的key值是可以相同的
        System.out.println(map);
        map.clear();
        System.out.println(map.size());// 清空后 是 0
        System.out.println(map);//  {}
    }

    @Test //Map中的查方法：
    public void test2() {
        Map map = new HashMap();
        map.put("rrw", 11);
        map.put("Lrw", 13);
        map.put("Trw", 14);
        System.out.println(map.get("rrw")); //找不到返回 null
        boolean b = map.containsKey("Lrw");//是否有 key：Lrw
        System.out.println(b);
        map.clear();
        System.out.println(map);// {}
    }

    @Test //Map 中元视图/遍历方法：
    public void test3() {
        Map map = new HashMap();
        map.put("rrw", 11);
        map.put("Lrw", 13);
        map.put("Trw", 14);
        Set set = map.keySet();  //遍历key
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Collection values = map.values();
        for (Object object : values) {  //遍历values
            System.out.println(object);
        }
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()) {
            Object obj = iterator1.next();
            Map.Entry entry = (Map.Entry) obj;//Entry里有getKey();和getValue()方法；
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    //TreeMap: 是按key排序的，且要求key的类型相同；(自然排序、定制排序)
    @Test
    public void test4() {  //自然排序：
        TreeMap tree = new TreeMap();
        People p1 = new People("RRW", 22);
        People p2 = new People("sss", 25);
        People p3 = new People("qwer", 33);
        People p4 = new People("def2", 12);
        tree.put(p1, 89);
        tree.put(p2, 79);
        tree.put(p3, 99);
        tree.put(p4, 103);

        Set entrySet2 = tree.entrySet();
        Iterator iterator2 = entrySet2.iterator();
        while (iterator2.hasNext()) {
            Object obj = iterator2.next();
            Map.Entry entry2 = (Map.Entry) obj;
            System.out.println(entry2.getKey() + "source：" + entry2.getValue());
        }
    }

    @Test
    public void test5() {
        TreeMap tree = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按年龄排：
                if (o1 instanceof People && o2 instanceof People) {
                    People p1 = (People) o1;
                    People p2 = (People) o2;
                    return Integer.compare(p1.getAge(), p2.getAge());
                }
                throw new RuntimeException("类型不匹配");
            }
        });
        People p1 = new People("RRW", 22);
        People p2 = new People("sss", 25);
        People p3 = new People("qwer", 33);
        People p4 = new People("def2", 12);
        tree.put(p1, 89);
        tree.put(p2, 79);
        tree.put(p3, 99);
        tree.put(p4, 103);

        Set entrySet2 = tree.entrySet();
        Iterator iterator2 = entrySet2.iterator();
        while (iterator2.hasNext()) {
            Object obj = iterator2.next();
            Map.Entry entry2 = (Map.Entry) obj;
            System.out.println(entry2.getKey() + "source：" + entry2.getValue());
        }
    }
}
