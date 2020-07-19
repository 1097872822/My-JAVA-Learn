package Senior.CommonlyUser.Class;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 *@description: String 与其他结构之间的转换
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-08 21:18
 */

public class StringConvertOFotherClass {
    @Test  //String 与 基本数据类型、包装类；
    public void test1(){
        String s1 = "2233";
        int num = Integer.parseInt(s1);//数字2233
        String s2 = String.valueOf(num);//“2233”
    }
    @Test  //String 与 char[];
    public void test2(){
        String s1 = "aaa111";
        char[] chars = s1.toCharArray();//调用toCharArray()方法；
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println();
        char[] arr = new char[]{'1','2','3'};
        String s3 = new String(arr);//调用String的char[]构造器；
        System.out.println(s3);
    }
    @Test  //String 与 byte[]；
    public void test3() throws UnsupportedEncodingException {
        String s1 = "aaa123呜呜呜";
        byte[] b1 = s1.getBytes();//调用String的getBytes()方法；默认字符集UTF-8;
        System.out.println(Arrays.toString(b1));
        byte[] gbks = s1.getBytes("gbk");//gbk编码方式；
        System.out.println(Arrays.toString(gbks));

        String s2 = new String(b1);//默认字符集的 解码过程；
        String s3 = new String(gbks,"gbk");//指定以gbk形式解码；
        System.out.println(s2);
        System.out.println(s3);
    }
}
