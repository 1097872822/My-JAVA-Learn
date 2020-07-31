package Senior.Collection;
import org.junit.jupiter.api.Test;
import java.util.*;
/**
 *@description:  集合：数组、集合都是对多个对象数据进行存储(内存层面)操作的结构，即java容器；
 *       集合的两种体系：
 *        1.Collection：单列集合，用来存一个一个数据；
 *               List：元素有序，可重复的集合；即 “动态数组”
 *                  主要实现类：ArrayList、LinkList、Vector
 *               Set：元素无序，不可重复的集合； 类似“数学集合”
 *                  HashSet、LinkedHashSet、TreeSet
 *        2.Map：双列集合，存储(key - value) 一对一对的数据；
 *               Map接口，保存具有映射关系的“key-value（键值对）”的集合；
 *               类似“数学函数y=f(x)”，一个自变量x（key），对应一个y（value）,
 *               但一个y（value）,可以有多个解 x（key）;
 *                    HashMap、LinkedHashMap、TreeMap、Hashtable、Properties
 *
 *          注意： 向Collection接口的实现类的对象中加数据时，需要其所在类重写equals()；
 *                 equals()也是可以比较集合的，且跟顺序有关;
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-11 21:51
 */
public class CollectionTest {
    @Test
    // add、addAll、isEmpty、clean：方法
    public void test1(){
        Collection col = new ArrayList();
        //add(Object e)  将元素e添加到col集合中
        col.add("a");
        col.add("b");
        col.add(100);//自动装箱
        col.add(new Date());
        System.out.println(col.size()); //4

        //addAll(): 将col1集合中的元素添加到当前集合中
        Collection col1 = new ArrayList();
        col1.add("234");
        col1.addAll(col);
        System.out.println(col1.size()); //5
        System.out.println(col1);

        //isEmpty 判断当前集合是否为空：
        System.out.println(col1.isEmpty());
        //clear():清空集合：
        col1.clear();
        System.out.println(col1);
    }
    @Test  //contains(注意new对象的重写equals方法前后对比)：是否含有某元素；
           // containsAll：判断形参中的元素是否存在集合中；
           // remove（removeAll）：删除某（几个）个元素；
           // retainAll: 求交集
    public void test2(){
        Collection col2 = new ArrayList();
        col2.add(123);
        col2.add(false);//Boolean类型的false
        col2.add(new String("RRW"));
        col2.add(new People("rrw",20));
        //contains(Object obj) 判断集合中是否含obj
        boolean c1 = col2.contains("RRW");
        System.out.println(c1);
        System.out.println();
        System.out.println(col2.contains(new String("RRW"))); //比内容,使用equals()判断
        System.out.println();
        System.out.println(col2.contains(new People("rrw",20)));//fslse
        //从false （没有重写equals之前是“==”比较） ---> true（重写equals后）:
        //这里是new了一个对象，拿这个对象所在的类People重写的equals()，且把这个对象
        //放到equals(Object o)中跟上面add的顺序做比较，在第四个位置发现相同，返回true;

        //containsAll(Collection obj):判断形参obj中所有的元素是否存在当前集合；
        System.out.println();
        Collection col3 = Arrays.asList("RRW",123); //asList：集合
        System.out.println(col3.containsAll(col3)); //true 都有

        //remove(Object obj): 移除某个对象；
        col2.remove(123);
        System.out.println(col2);
        //removeAll(Collection obj):相对于containsAll(Collection obj)
        Collection col4 = Arrays.asList(123,"RRW");
        col2.removeAll(col4); //只删除有共同交集的元素
        System.out.println(col2);

        //retainAll(): 求交集
        Collection col5 = Arrays.asList(false,123);
        col2.retainAll(col5);
        System.out.println(col2);
    }
    @Test
    public void test3(){
        Collection col2 = new ArrayList();
        col2.add(123);
        col2.add(false);//Boolean类型的false
        col2.add(new String("RRW"));
        col2.add(new People("rrw",20));

        //HashCode():
        System.out.println(col2.hashCode()); //725687639通过哈希运算之后的哈希值
        //集合 ———> 数组  toArray()
        Object[] arr = col2.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        //数组 ——> 集合： asList()  {分<String>、<int[]>}
        List<String> strings = Arrays.asList("123", "rrw", new String("LQ"));
        System.out.println(strings); //[123, rrw, LQ]

        List<int[]> list = Arrays.asList(new int[]{123, 312});
        System.out.println(list); // [[I@71423665] 被认为是Int型的 一个数组
        List list1 = Arrays.asList(new Integer[]{123,312});
        System.out.println(list1);
    }
}
class People implements Comparable<People>{  //test2的测试类
    String name;
    int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People() {
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("Peope equals()被调用..");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return age == people.age &&
                Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override  //有泛型时  就不用去比较判断他是不是 “instanceof People”了
    public int compareTo(People o) {
        return this.name.compareTo(o.name);
    }


    //按名字从小到大排,年龄从大到小排；
  /* @Override  //没有泛型时：
    public int compareTo(Object o) {
        if (o instanceof People){
            People p2 = (People) o;
//            return this.name.compareTo(p2.name);
            int comp = this.name.compareTo(p2.name);
            if (comp != 0){
                return comp;
            }else {
                return -Integer.compare(this.age,p2.age);
            }
        }else {
            throw new RuntimeException("输入类型不一致");
        }
    }*/
}