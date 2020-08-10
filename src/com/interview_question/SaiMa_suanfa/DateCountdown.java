package com.interview_question.SaiMa_suanfa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *@description: 《日期倒计时》：
 *      请设计一个程序计算出今天距离未来的某一天还剩多少天。假设今天是2015年10月18日。
 *      输入一个日期格式为yyyy-MM-dd，不考虑日期是否小于今天。
 *
 *      样例输入            输出：
 *      2015-10-19           1
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 12:51
 */
public class DateCountdown {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date Futuredate = dateFormat.parse(s);  //parse():将String转成相应日期格式
        Date nowdate = dateFormat.parse("2020-08-10");
        Long countdown = Futuredate.getTime() - nowdate.getTime();
        Long Days = Math.abs(countdown / (24*60*60*1000));
        System.out.println(Days);

    }
}



