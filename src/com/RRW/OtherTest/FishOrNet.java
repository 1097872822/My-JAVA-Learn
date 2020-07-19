package com.RRW.OtherTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *@description: 渔夫打渔问题：
 *      渔夫问题： 说某一天，渔夫“三天打渔两天晒网”，问在多年后的某一天他在干嘛？
 *      //注意：打渔 = 总天数 % 5 == 1,2,3
 *           晒网 = 总天数 % 5 == 4,0
 *          总天数怎么算：
 *             > (date2.getTime() - date1.getTime()) / (1000 *60*60*24) + 1;
 *             > (2000-01-01 到 2019-12-31 + 2020-01-01 到 2020-06-01);注意闰年
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-10 19:44
 */
public class FishOrNet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String beginDate = sc.nextLine();
        String endDate = sc.nextLine();
        String duartion = getTwoDay(endDate,beginDate);
        int dayWork = Integer.parseInt(duartion) % 5;
        if (dayWork == 1 || dayWork == 2 || dayWork == 3 ){
            System.out.println("今天渔夫在打渔");
        }else{
            System.out.println("今天渔夫在晒网");
        }
    }

public static String getTwoDay(String sj1,String sj2){
    //根据题目给定时间格式，修时间格式描述如2011-12-13，对应“yyyy-MM-DD”
    SimpleDateFormat mySD = new SimpleDateFormat("yyyy-MM-dd");
    long day = 0;
        try {
            java.util.Date date = mySD.parse(sj1);
            java.util.Date mydate = mySD.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / (24*60*60*1000);
        } catch (ParseException e) {
//            e.printStackTrace();
            return "";
        }
        return Long.toString(day);
    }
}