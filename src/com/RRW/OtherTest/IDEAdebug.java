package com.RRW.OtherTest;
import org.junit.jupiter.api.Test;
/**
 *@description:   小坑题：
 *  为什么是 第一个输出是 4： 和
 *  为什么第二个输出是"null"：源码是这么写的：
 *         private AbstractStringBuilder appendNull() {
 *         int c = count;
 *         ensureCapacityInternal(c + 4);
 *         final char[] value = this.value;
 *         value[c++] = 'n';
 *         value[c++] = 'u';
 *         value[c++] = 'l';
 *         value[c++] = 'l';
 *         count = c;
 *         return this;
 *     }
 *   为什么报异常：源码：
 *         public StringBuilder(String str) {
 *         super(str.length() + 16);
 *         append(str);
 *     }
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-10 02:53
 */
public class IDEAdebug {
    @Test
    public void testStringBuffer(){
        String s1 = null;
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        System.out.println(sb.length()); //4
        System.out.println(sb); //"null"
        StringBuilder sb1 = new StringBuilder(s1); //java.lang.NullPointerException
        System.out.println(sb1);//执行不到
    }
}
/*
    step over ：步过：即单步执行；一行行走；
    step in ：一个是进入；一个是强制步入(方法)；
    step out：跳出(方法)
*/