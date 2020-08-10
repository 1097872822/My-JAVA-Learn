package com.interview_question.SaiMa_suanfa;
import java.util.Scanner;
/**
 *@description: 《装载学生出游》
 *      参加活动的总共有n个班级，第i班总共有ai名学生，每辆车最大乘车人数为m，满足m>a1, a2, ..., an。
 *      乘车时必须按照班级排列顺序进行乘车，不能调整班级顺序进行拼车。为保证同一个班级的学生在同一辆车上，
 *      如果当前汽车装完上一个班级后，下一个班级所有同学无法装下，那么当前车开走使用下一辆车。
 *      问最少需要多少辆车才能把所有学生运完？
 *
 *      第一行数据是两个整数：n, m，n表示班级数目，m表示汽车最大装载人数。
 *      接下来n行是数据表示每个班级的人数数字a1, a2, ..., an (1≤ai≤m)。
 *          样例输入              样例输出
 *          4 3                      3
 *          2 3 2 1
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 22:06
 */
public class StudentBus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int[] a = new int[n];
            int num = 0;
            int sum = 0;
            for(int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
                sum += a[i];     // 2    3+2   2+2  2+1
                if(sum > m) {   // 2>3?  5>3?  4>3  3>3
                    num ++;    //         1     2
                    sum = a[i];  //       3     2
                }
            }
            System.out.println(num + 1);     // 3
        }
    }
}
