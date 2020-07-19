package Senior.Collection;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

/**
 *@description:  Collections 是操作Collection、Map的工具类
 *          Collections 中提供了一系列静态的方法对集合元素进行排序、查询和修改等操作，
 *                      还提供了对集合对象设置不可变、对集合对象实现同步控制等方法
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-14 21:32
 */
public class Collections_TEST {
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(213);
        list.add(-23);
        list.add(1213);
        System.out.println("原："+ list);
        Collections.sort(list);
        System.out.println(list);
        Collections.swap(list,1,2); //交换
        System.out.println(list);
        System.out.println(Collections.frequency(list, 213));//出现几次

        //copy(list dest,List src):
        List dest = Arrays.asList(new Object[list.size()]);
        //源码要求dest的长度要比list的长；  “Source does not fit in dest”
        Collections.copy(dest,list);
        System.out.println(dest);

        //我们前面说：ArrayList HashMap都是线程不安全的：
        //Collections类中提供了多个synchronizedXxx()方法，
        // 该方法可使将指定集 合包装成线程同步的集合，从而可以解决多线程并
        // 发访问集合时的线程安全问题 .
        List list1 = Collections.synchronizedList(list);
    }
    @Test  //io + 泛型 读取文件name.txt 输出文件中姓氏 出现的次数;
    public void test5(){
        HashMap<String,Integer> map = new HashMap<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("D:/name.txt")));
            String value = null; //临时接收文件中的字符串变量；
            StringBuffer buffer = new StringBuffer();
            flag:while ((value = br.readLine())!=null) {//开始读取
                char[] c = value.toCharArray();
                for (int i = 0; i < c.length; i++) {
                    if (c[i] != ' '){
                        buffer.append(String.valueOf(c[i]));
                    }else
                    {
                        if (map.containsKey(buffer.toString())){
                            int count = map.get(buffer.toString());
                            map.put(buffer.toString(),count+1);
                        }else{
                            map.put(buffer.toString(),1);
                        }
                        buffer.delete(0,buffer.length());
                        continue flag;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
