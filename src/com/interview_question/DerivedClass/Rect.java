package com.interview_question.DerivedClass;
/**
 *@description: 1）编写一个矩形类Rect，包含：
 *              两个protected属性：矩形的宽width；矩形的高height。
 *              两个构造方法：
 *                  1．一个带有两个参数的构造方法，用于将width和height属性初化；
 *                  2．一个不带参数的构造方法，将矩形初始化为宽和高都为10。
 *
 *              两个方法：
 *                  求矩形面积的方法area()
 *                  求矩形周长的方法perimeter()
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 19:17
 */
public class Rect {
    protected double wight;
    protected double high;

    public Rect(double wight, double high) {
        this.wight = wight;
        this.high = high;
    }

    public Rect() {
        wight = 10;
        high = 10;
    }
    public double rea(){
        return high * wight;
    }
    public double perimeter(){
        return (high+wight) *2;
    }
}
