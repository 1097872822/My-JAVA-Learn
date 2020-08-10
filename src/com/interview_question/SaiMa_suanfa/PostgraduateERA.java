package com.interview_question.SaiMa_suanfa;

import java.util.Scanner;

/**
 *@description: 《研究生考试》:
 *      考研有4门科目，分别是政治（满分100分），英语（满分100分），数学（满分150分）和专业课（满分150分)
 *      某校计算机专业今年录取研究生的要求是：政治、英语每门课成绩不低于60分，数学和专业课不低于90分，
 *      总成绩不低于310分。并且规定：在满足单科以及总成绩最低要求的基础上，350分以上（含350分）为公费（Gongfei），
 *      310分~349分为自费(Zifei)。    请编程判断考生的录取情况。
 *
 *      输入数据首先包括一个正整数N，表示有N组测试数据。
 *       每组数据包含4个正整数，分别表示考生的四门课成绩（顺序为：政治、英语、数学、专业课）
 *
 *       样例输入              样例输出
 *          3
 *          61 62 100 120      zifei
 *          80 80 120 100      gongfei
 *          55 90 130 130      fail
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 18:45
 */
public class PostgraduateERA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int Eng = scanner.nextInt();
            int Math = scanner.nextInt();
            int Political = scanner.nextInt();
            int Profes = scanner.nextInt();
            System.out.println(resoult(Eng,Math,Political,Profes));
        }
    }

    public static String resoult(int Eng,int Math,int Political,int Profes){
        if (Eng >= 60 && Math >= 90 && Political >= 60 && Profes >= 90
                && Eng+Math+Political+Profes >= 310){
            if (Eng + Math + Political + Profes >= 350 ){
                return "Gongfei";
            }else return "Zifei";
        }
        else return "Fail";
    }
 }
