package Senior.Collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *@description: iterator():返回Iterator接口的实例，遍历集合元素；
 *                 内部方法： hasNext() /  next()
 *               Iterator迭代器执行原理：
 *                  当在调Iterator时，就有默认的游标指向列第一个元素的上方，
 *                  然后hasnext()，即下一个，并判断有无元素，有返回true，
 *                  到next()，① 先下移 ；② 返回下移后的元素；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-12 00:26
 */
public class IteratorTest {
    @Test
    public void test(){
        Collection col2 = new ArrayList();
        col2.add(123);
        col2.add(false);//Boolean类型的false
        col2.add(new String("RRW"));
        col2.add(new People("rrw",20));
        Iterator iterator = col2.iterator();
        //打印方式 1
//        for (int i = 0; i < col2.size(); i++) {
//            System.out.println(iterator.next());
//        }
        while (iterator.hasNext()) { //判断里面还有没有元素
//        while (iterator.next() != null) { //错误写法，返回123之后，跳过第二个返回；
            System.out.println(iterator.next());
        }
        //错误写法，当每调iterator时，都会有一个指向第一元素前一个的游标，使得程序一直不断的返回第一个元素，死循环；
//        while (col2.iterator().hasNext()){
//            System.out.println(col2.iterator().next());
//        }
    }
    @Test  //iterator的 remove()方法：
           //  Iterator可以删除集合的元素，但是是遍历过程中通过迭代器对象的
           //remove方法，不是集合对象的remove方法。
           //  如果还未调用next()或在上一次调用 next 方法之后已经调用了
           // remove 方法， 再调用remove都会报IllegalStateException。
    public void test1(){
        Collection col2 = new ArrayList();
        col2.add(123);
        col2.add(false);//Boolean类型的false
        col2.add(new String("RRW"));
        col2.add(new People("rrw",20));
        Iterator iterator = col2.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            if ("RRW".equals(o)){
                iterator.remove();
            }
        }
        iterator = col2.iterator(); //重新生成
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
