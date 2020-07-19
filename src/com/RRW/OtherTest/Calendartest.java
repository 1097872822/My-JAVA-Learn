package com.RRW.OtherTest;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

/**
 *@description:  Calendar （抽象类）日历类
 *              注意:
 *                  获取星期时，老外的星期天是1，星期六是7 ，星期二是1...
 *                  获取月份时，一月是0，二月是1...
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-10 21:05
 */
 public class Calendartest {
    @Test
    public void test(){
        //实例化：
            //方式1：调用其子类 GregorianCalendar 的对象
            //方式2：调用其静态方法 getInstance() 其实就是GregorianCalendar
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());//class java.util.GregorianCalendar
        //常用方法：
            //get()
        int d1 = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        int d2 = calendar.get(Calendar.DAY_OF_MONTH);
        int d3 = calendar.get(Calendar.MONTH);
        System.out.println(d1); //2  表示 今天是这个月的第几个星期
        System.out.println(d2); //10  今天几号
        System.out.println(d3); //5 这里的5 就是指6月，获取月份1月是0...
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,11); //把上面的10号直接改为了11号
        d2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(d2);  //11
            //add()
        calendar.add(Calendar.DAY_OF_MONTH,5);//加上5天,负数即为减去几天
        d2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(d2);  //16
            //getTime() 日历类——>Date
        Date date = calendar.getTime();
        System.out.println(date);
            //setTime() Date——>日历类
        Date D1 = new Date();
        calendar.setTime(D1);
        d2 = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(d2);
    }
}
