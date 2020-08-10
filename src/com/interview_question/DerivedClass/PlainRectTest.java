package com.interview_question.DerivedClass;
/**
 *@description: 3）编写PlainRect类的测试程序
 *                  创建一个左上角坐标为（10，10），长为20，宽为10的矩形对象；
 *                  计算并打印输出矩形的面积和周长；
 *                  判断点(25.5，13)是否在矩形内，并打印输出相关信息。
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 19:25
 */
public class PlainRectTest {
    public static void main(String[] args) {
        PlainRect p1 = new PlainRect(20,10,10,10);
        System.out.println(p1.rea());
        System.out.println(p1.perimeter());
        System.out.println(p1.isInside(25.5,13));
    }
}
