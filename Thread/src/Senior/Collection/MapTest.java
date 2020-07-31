package Senior.Collection;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 *@description:
 *          // HashMap中重要常量：
 *              1.default_initial_capacity:默认初始容量
 *              2.maximum_capacity:最大支持容量；
 *              3.default_load_factor:默认加载因子；
 *              4.treeify_threshold:链表阈值；
 *              5.untreeify_threshold:非链表阈值；
 *              6.min_treeify_capacity:最小hash表容量（最小树化结构容量）
 *                当要树化时，min_treeify_capacity需要resize（扩容）到treeify_threshold的4倍；
 *
 *           扩容机制：
 *              数组：16默认，0.75因子，>12临界，16X2倍，重新计算位置(消耗大)——>预设元素个数！
 *              树化：链长=8，数组<64，扩容； 数组>=64，链——>树，节点类型：Node——>TreeNode；如果减少元素后，树形节点<6，树——>链;
 *
 *           与1.8之前的变化：（8之前是将”同义“记录存储在链表中）
 *              1.new HashMap()时不会先建16长度的默认数组，而是第一次Map.put()时创建；
 *              2.数组的类型：7中为Entry类型，8中为Node类型；
 *              3.“7上8下”：7中是头插，8尾插；
 *              4.链>8，数组>64，采用红黑树，即数组+链表+树形结构；
 *
 *          负载因子大小为什么是0.75？
 *              1.大了，冲突率上升，链表易长，比较次数增多；
 *              2.小了，冲突下降，链短，性能相对高了；但易扩容，扩容要重新计算，浪费资源；
 *----------------------------------------------------------------------------------------------
 *             Map接口： 双列数据  (key-value) ( y=f(x) )
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
 *------------------------------------------------------------------------------------------------
 *
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
 *                 (1).Hashtable 继承了 Dictionary类，而 HashMap 继承的是 AbstractMap 类。
 *                 (2).Hashtable是线程安全,效率低，而HashMap则非线程安全.效率高;
 *                 (3).Hashtable中，key和value都不允许出现null值,HashMap允许;
 *                 (4).HashMap是没有contains方法的，而包括containsValue和containsKey方法；hashtable则保留了contains方法;
 *                 (5).hash值的计算不同：
 *                      ①：HashMap有个hash方法重新计算了key的hash值,因为hash冲突变高，
 *                      所以通过一种方法重算hash值的方法：
 *                       return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 *
 *                      ②：Hashtable通过计算key的hashCode()来得到hash值就为最终hash值；
 *                      ③：计算索引位置方法不同：
 *                          HashMap在求hash值对应的位置索引时，index = (n - 1) & hash。将哈希表的大小固定为了2的幂，
 *                          因为是取模得到索引值，故这样取模时，不需要做除法，只需要做位运算。位运算比除法的效率要高很多。
 *
 *                          HashTable在求hash值位置索引时计算index的方法：
 *                          int index = (hash & 0x7FFFFFFF) % tab.length;
 *                          &0x7FFFFFFF的目的是为了将负的hash值转化为正值，因为hash值有可能为负数，而&0x7FFFFFFF后，只有符号位改变，而后面的位都不变。
 *                 (6)初始数组长度与扩容不同：
 *                      HashMap：初始size：16； 扩容2倍；
 *                      Hashtable：初始size：11； 扩容2倍+1；
 *
 *              3.ConcurrentHashMap 与 HashMap、Hashtable的异同；
 *                  ConcurrentHashMap：1.底层采用分段的数组+链表实现，线程安全
 *                                  2.通过把整个Map分为N个Segment，可以提供相同的线程安全，但是效率提升N倍，默认提升16倍。(读操作不加锁，由于HashEntry的value变量是 volatile的，也能保证读取到最新的值。)
 *                                  3.Hashtable的synchronized是针对整张Hash表的，即每次锁住整张表让线程独占，ConcurrentHashMap允许多个修改操作并发进行，其关键在于使用了锁分离技术
 *                                  4.有些方法需要跨段，比如size()和containsValue()，它们可能需要锁定整个表而而不仅仅是某个段，这需要按顺序锁定所有段，操作完毕后，又按顺序释放所有段的锁
 *                                  5.扩容：段内扩容（段内元素超过该段对应Entry数组长度的75%触发扩容，不会对整个Map进行扩容），插入前检测需不需要扩容，有效避免无效扩容
 *                       ConcurrentHashMap是jdk5后提出的替代 Hashtable的性能提升，扩展性优与Hashtable；
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
        /*map的遍历方法：
          1.传统的遍历map集合的方法1; keySet()
          2.传统的遍历map集合的方法2; entrySet()
          3.使用增强For循环来遍历map集合方法1; keySet()
          4.使用增强For循环来遍历map集合方法2; entrySet()

          keySet() & entrySet()
            使用entrySet()方法，获取maps集合中的每一个键值对;
            使用keySet()方法，获取maps集合中的所有键，遍历键取得所对应的值;
        */
        Set set = map.keySet();  //遍历key
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();
        Collection values = map.values();
        for (Object object : values) {  //遍历values
            System.out.println(object);
        }
        System.out.println();
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
        People p1 = new People("rRW", 22);
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
