package Senior.Collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 *@description: Iterator迭代器接口：foreach
 *          使用 foreach 循环遍历集合元素
 *                   Java 5.0 提供了 foreach 循环迭代访问 Collection和数组。
 *                   遍历操作不需获取Collection或数组的长度，无需使用索引访问元素。
 *                   遍历集合的底层调用Iterator完成操作。
 *                   foreach还可以用来遍历数组。
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-12 12:43
 */
public class Foreachtest {
    @Test
    public void test1() {
        Collection col2 = new ArrayList();
        col2.add(123);
        col2.add(false);//Boolean类型的false
        col2.add(new String("RRW"));
        col2.add(new People("rrw", 20));
        for (Object obj : col2){  //(集合元素类型 局部变量：集合对象)
            //集合col2取第一个元素赋给Object类型的obj，输出，再给第二个...
            System.out.println(obj);
        }
    }
    @Test
    public void test2(){
        String[] arr = new String[]{"123","123","123"};
        for (Object o : arr){  //o是新变量，它的更改赋值不会影响arr[]
            o = "321";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
