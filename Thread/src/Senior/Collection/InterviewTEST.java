package Senior.Collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *@description: 两道题
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-14 15:28
 */
public class InterviewTEST {
    @Test
    public void test1() {
        HashSet set = new HashSet();
        People p1 = new People("name1",22);
        People p2 = new People("name2",42);

        set.add(p1);
        set.add(p2);
        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        /*
            上面这三句代码：这个跟前说到的HashSet()有关了，乍一看，p1.name改名为CC了，
            这时候确实把数组中name为name1，但是接下来的remove操作，他就会找修改后的”CC，22“算出哈希值的位置，
           找不到，相当于没有删除，继续输出，也就是数组中确实存在的且被改了之后的数据；
         */
        //[People{name='name2', age=42}, People{name='CC', age=22}]
        set.add(new People("CC",22));
        System.out.println(set);
        //而上面这俩句，原本找不到的删除数据，我new了，所以CC，22是存在的；这个跟是否重写hashCode还是有出入的
        //因为之前改名为CC后的位置是用name1的哈希值算出来的，所以输出三个数据；
        //并且我们说，set里是不可以有重复的数据的，但这里的数据非“相同”，而是hashCode的值不同的数据；
        //[People{name='CC', age=22}, People{name='name2', age=42}, People{name='CC', age=22}]
        set.add(new People("name1",22));
        System.out.println(set);
        /*
            以上两句，我再new，跟上面的情况分析一致，前面三个数据都在，我现在再new一个相同的，
            也是用name1的哈希值去算的，所以位置冲突（一样），但是经过equals()对比之后，
            发现旧的数据是CC的，所以被视为是不同的数据添加成功！所以有四个数据；
         */
        //Peope equals()被调用..
        //[People{name='CC', age=22}, People{name='name2', age=42},
        // People{name='CC', age=22}, People{name='name1', age=22}]
    }

    //在List内去除重复的数字值
    public static List duplicateList(List list){
        HashSet set = new HashSet(); //使用HashSet()解决
        set.addAll(list); //addAll()就会把重复的值过滤
        return new ArrayList(set);
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list); //把list扔到方法里
        for (Object intteger : list2) {
            System.out.println(intteger);
        }  // 输出 ：1  \n  2   \n    4
    }
}
