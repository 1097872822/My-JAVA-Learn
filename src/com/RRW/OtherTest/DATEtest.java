package com.RRW.OtherTest;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@description:   JDK8之前日期时间API测试：
 *             1.SimpleDateFormat
 *                 对日期Date类的格式化 与 解析：
 *                   格式化： 日期 转 字符串；
 *                   解析：  字符串 转 日期
 *             2.Calendar
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-10 03:30
 */
public class DATEtest {
    @Test
    public void test1() throws ParseException {
        //实例化SimpleDateFormat，默认的
        SimpleDateFormat s1 = new SimpleDateFormat();
        //格式化：
        Date d1 = new Date();
        System.out.println(d1);
        String f = s1.format(d1);
        System.out.println(f);

        //解析：
        String str = "20-6-1 上午0:00";  //格式不灵活，是因为用到的是上面的默认构造器：new SimpleDateFormat();
        Date parse = s1.parse(str);
        System.out.println(parse);

        //文档中找SimpleDateFormat 有pattern的格式；
//        SimpleDateFormat sf2 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        //要是还觉得上面的low 不好看，也可以自定：
        SimpleDateFormat sf2 = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");//2020.06.10 04:01:37
        //格式化：
        String f2 = sf2.format(d1);
        System.out.println(f2);

        //解析：
        Date d2 = sf2.parse("2020.06.10 04:01:37");//只能转上面你用的格式；
        System.out.println(d2);
    }
    @Test  //练习 1：“2020.06.10” 转 java.sql.Date格式的
    public void test2() throws ParseException {
        String brithday = "2020.06.01";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy.MM.dd");
        Date date = sf.parse(brithday);
        System.out.println(date);
        java.sql.Date brithDD = new java.sql.Date(date.getTime());
        System.out.println(brithDD);
    }
    /*练习 2： 详见 FishOrNet.java
    渔夫问题： 说某一天，渔夫“三天打渔两天晒网”，问在多年后的某一天他在干嘛？

          //注意：打渔 = 总天数 % 5 == 1,2,3
                 晒网 = 总天数 % 5 == 4,0
                 总天数怎么算：
                    > (date2.getTime() - date1.getTime()) / (1000 *60*60*24) + 1;
                    > (2000-01-01 到 2019-12-31 + 2020-01-01 到 2020-06-01);注意闰年
                 */
}
