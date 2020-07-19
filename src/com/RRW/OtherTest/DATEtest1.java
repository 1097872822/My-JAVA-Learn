package com.RRW.OtherTest;
import org.junit.jupiter.api.Test;
import java.util.Date;
/**
 *@description: 日期时间计算 （jdk8之前）
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-09 12:49
 */
public class DATEtest1 {
    @Test
    public void Systemtest(){
        //时间戳
        long time = System.currentTimeMillis();
        System.out.println(time);
    }
    @Test
    public void Datetest(){
       /*
            java.util.Date类：
                |---java.sql.Date类 对应数据库中的日期类型变量；
                        1.实例化；
                        2.util.Date 转 sql.Date
            两个构造器：
                空参构造器：创建对应当前时间的Date对象；
                指定时间的构造器：创建指定毫秒数的Date对象；
            两个方法：
                >toString()
                >getTime()
       */
       //空参构造器：Date():创建对应当前时间的Date对象；
        Date date1 = new Date();
        System.out.println(date1.toString());//Tue Jun 09 13:08:20 CST 2020
        System.out.println(date1.getTime());//1591679300280

        //指定时间的构造器：创建指定毫秒数的Date对象；
        Date date2 = new Date(1591679300280L);

        //实例化创建对象：
        java.sql.Date sqldate = new java.sql.Date(1591679300280L);
        System.out.println("sqldate："+sqldate);//2020-06-09

        //情况1
//        Date date3 = new java.sql.Date(1591679300280L);
//        java.sql.Date date4 = (java.sql.Date)date3;
        //情况2
          Date date5 = new Date();
          java.sql.Date date6 = new java.sql.Date(date5.getTime());
          System.out.println("date6：" + date6);
    }
}
