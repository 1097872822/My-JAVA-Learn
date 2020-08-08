package com.interview_question.SaiMa_suanfa;

import java.util.Scanner;

/**
 *@description: 《公交车乘客》
 *      一个公交车经过n个站点，乘客从前门上车，从后门下车。
 *      现在统计了在第i个站，下车人数a[i]，以及上车人数b[i]。
 *      问公交车运行时候车上最多有多少乘客？
 *
 *      第一行读入一个整数n(1<=n<=100)，表示有n个站点
 *       接下来n行，每行两个数值，分别表示在第i个站点下车人数和上车人数
 *
 *       样例输入          输出： 6
 *        4
 *        0 3
 *        2 5
 *        4 2
 *        4 0
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-08 22:32
 */
public class Buspassengers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int maxP = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
                maxP += b - a;
                if (maxP > sum)
                    sum = maxP;
        }
        System.out.println(sum);
    }
}
