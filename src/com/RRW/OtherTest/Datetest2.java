package com.RRW.OtherTest;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 *@description: 由于之前提到的JDK8的时间API不那么的灵活 人性化
 *               在jdk8时 就引入了java.time 相关的API 其实jdk8之前就有
 *               一个joda-Time的jar包，需要外部引入；
 *            则以下提到的是java-time的几个API:
 *              1.本地日期 (LocalDate)
 *              2.本地时间 (LocalTine)
 *              3.本地日期时间 (LocalDateTime)
 *              4.时区 (ZoneDateTime)  //基本不用
 *              5.持续时间 (Duration)
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-10 21:53
 */
public class Datetest2 {
    @Test  //LocalDate LocalTine LocalDateTime 的使用
    public void test(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate + "\n" + localTime + "\n" + localDateTime );

        //of() 相当于自己填写时间：
        LocalDateTime time = LocalDateTime.of(2020, 10, 6, 10, 00);
        System.out.println(time);
        //getXxx():
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getHour());

        // DateTimeFormatter 日期格式化
            //自定义输出格式： ofPattern("yyyy-MM-dd hh:mm:ss");
        DateTimeFormatter DATE = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化：
        String str = DATE.format(LocalDateTime.now());
        System.out.println(str);
        //解析：
        TemporalAccessor accessor = DATE.parse("2020-06-10 10:34:52");
        System.out.println(accessor);

    }

}
