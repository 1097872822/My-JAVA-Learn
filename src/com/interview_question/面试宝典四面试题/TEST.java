package com.interview_question.面试宝典四面试题;
/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-27 10:28
 */
public class TEST {
    public static void main(String[] args) {
        char a[] = {'c','+','+'};
        char b[] = {'c','+','+','\0'};
//        char c[] = "C++";
//        char d[] = "c++\0";
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}
