package Senior.CommonlyUser.Class;

import org.junit.jupiter.api.Test;

/**
 *@description:  StringBuffer 与 StringBuilder的使用：
 *       区别：    //不可变字符序列：
 *              String：//jdk1.0 //
 *           //可变字符序列：
 *              StringBuffer：//jdk1.0 //线程安全的，效率低； //
 *              StringBuilder：//jdk1.5  //线程不安全的，效率高； //
 *       相似：   三者都是用char[] 进行存储的；
 *
 *       底层逻辑：
 *         String s1 = new String(); //char[] value = new char[0];
 *         String s2 = new String("abc"); //char[] value
 *                                          = new char[]{'a','b','c'};
 *
 *         StringBuffer s3 = new StringBuffer();//char[] value = new char[16]; 一开始长度就是是16，用完再加一倍再+2:int newCapacity = (value.length << 1) + 2;
 *         StringBuffer s4 = new StringBuffer("abc");//char[] value = new char["abc".length+16]; 字符串长度+16,但要是输出s4.length的话，那还是3，不会是19;
 *         System.out.println(s4.length());//3
 *
 *       使用：
 *          若经常对字符串进行增加append()操作，应优先使用StringBuffer、StringBuilder
 *          且是带参数的StringBuffer(int copacity)/StringBuilder(int copacity),
 *          因为它扩容复制，效率更高；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-08 22:05
 */

public class StringBuffer_Builder {
    @Test
    public void testStringBuffer(){
        StringBuffer s1 = new StringBuffer("rrw");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
//        s1.delete(2,4);//从第2位开始，删除到第4位(不含第4位)；
        s1.replace(2,4,"RRR");//去掉第2位到第4位,换成"RRR";
        System.out.println(s1);
        s1.insert(2,"我");//从第2位插入"我";
        System.out.println(s1);
        s1.reverse();//反转；
        System.out.println(s1);
        System.out.println(s1.substring(2,6));//返回2-6的字符；
    }

    /*
    方法链：
    @Override
    public StringBuffer append(String str){
        super.append(str);
        return this;
    }*/

    @Test
    public void CompareThem(){
        long starttime = 0;
        long endtime = 0;
        String test = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        starttime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            buffer.append(String.valueOf(i));//连接0-10000；
        }
        endtime = System.currentTimeMillis();
        System.out.println("Bf需要的时间："+ (endtime-starttime));

        starttime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            builder.append(String.valueOf(i));//连接0-10000；
        }
        endtime = System.currentTimeMillis();
        System.out.println("Bb需要的时间："+ (endtime-starttime));

        starttime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            test += i;
        }
        endtime = System.currentTimeMillis();
        System.out.println("String需要的时间："+ (endtime-starttime));
    }
}
