package com.RRW.OtherTest;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;

/**
 *@description: JAVA8 新的日期计算类：
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 13:57
 */
public class Java8_DATE {
    @Test // Period类：主要是Period类方法getYears（），getMonths（）和getDays（）来计算.
    public void Period_test(){
        LocalDate today = LocalDate.now();
        System.out.println("Today : " + today);
        LocalDate birthDate = LocalDate.of(1997, Month.NOVEMBER, 9);
        System.out.println("BirthDate : " + birthDate);

        Period p = Period.between(birthDate, today);
        System.out.printf("年龄 : %d 年 %d 月 %d 日", p.getYears(), p.getMonths(), p.getDays());
    }


    @Test  // Duration类:提供了使用基于时间的值（如秒，纳秒）测量时间量的方法。
    public void Duration_test(){
        Instant inst1 = Instant.now();
        System.out.println("Inst1 : " + inst1);
        Instant inst2 = inst1.plus(Duration.ofSeconds(10));
        System.out.println("Inst2 : " + inst2);
        System.out.println("Difference in milliseconds : " + Duration.between(inst1, inst2).toMillis());
        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());
    }

    @Test //ChronoUnit类:可用于在单个时间单位内测量一段时间，例如天数或秒。以下是使用between（）方法来查找两个日期之间的区别的示例。
    public void ChronoUnit_test(){

        LocalDate startDate = LocalDate.of(2020, Month.JANUARY, 1);
        System.out.println("开始时间  : " + startDate);

        LocalDate endDate = LocalDate.of(2020, Month.AUGUST, 10);
        System.out.println("结束时间 : " + endDate);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("两天之间的差在天数   : " + daysDiff + "天");
    }

    @Test
    public void Temporal_test(){
        Date date =new Date();
        Date date2 = new Date();
        date.setTime(date2.getTime()+1000*60*60*24*20);
        Temporal temporal =date.toInstant();
        Temporal temporal1 =date2.toInstant();
        long i = ChronoUnit.DAYS.between(temporal1,temporal);
        System.out.println(date2);
        System.out.println(date);
        System.out.println(i);
    }
}
