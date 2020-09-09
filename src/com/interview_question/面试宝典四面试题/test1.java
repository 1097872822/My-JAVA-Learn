package com.interview_question.面试宝典四面试题;
/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-26 16:23
 */
public class test1 {
    static {
        int x = 5;  //不影响后面的x
    }
    static int x , y ;

    public static void main(String[] args) {
        x--;     //-1
        myMethod();
        System.out.println(x + y++ + x);
}
    public static void myMethod() {
        y = x++ + ++x;  //使用的是main方法中的x    //输出 y=0+0
//        System.out.println(x);    //此时的 x=1 【先计算++x，此时x=0 ，再计算x++，此时x=1】
//        System.out.println(y);    //此时的 y=0
    }
}
