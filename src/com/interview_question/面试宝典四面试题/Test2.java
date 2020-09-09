package com.interview_question.面试宝典四面试题;

/**
 *@description: 传值与传引用
 *@author: RRW friend_rrw@163.com
 *@create: 2020-09-03 16:50
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 t1 = new Test2();
        t1.first();
    }

    class Value {
        public int i = 15;
    }

    public void first() {
        int i = 5;
        Value v = new Value();
        v.i = 25;
        second(v, i);
        System.out.println(v.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;  //通过引用的副本改变原对象的值为20
        Value val = new Value();
        v = val;  //引用的副本指向一个新的Object
        System.out.println(v.i + " " + i);
    }
}

