package com.interview_question.DerivedClass;
/**
 *@description:
 *          2）通过继承Rect类编写一个具有确定位置的矩形类PlainRect，其确定位置用矩形的左上角坐标来标识，包含：
 *          添加两个属性：矩形左上角坐标startX和startY。
 *
 *      两个构造方法：
 *           带4个参数的构造方法，用于对startX、startY、width和height属性
 *      初始化；
 *          不带参数的构造方法，将矩形初始化为左上角坐标、长和宽都为0的矩形；
 *      添加一个方法：判断某个点是否在矩形内部的方法isInside(double x,double y)。如在矩形内，返回true, 否则，返回false。
 *
 *      提示：点在矩形类是指满足条件：
 *                  x>=startX&&x<=(startX+width)&&y<startY&&y>=(startY-height)
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 19:20
 */
public class PlainRect extends Rect{
    private double startX;
    private double startY;

    public PlainRect() {
        super();
        this.startX = 0;
        this.startY = 0;
    }

    public PlainRect(double wight, double high, double startX, double startY) {
        super(wight, high);
        this.startX = startX;
        this.startY = startY;
    }
    public boolean isInside(double x,double y){
        return (x>=startX&&x<=(startX+wight)&&y<startY&&y>=(startY-high));
    }
}
