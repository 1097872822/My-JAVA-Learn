package com.interview_question.SaiMa_suanfa;

import java.util.Scanner;

/**
 *@description: 《聊天》
 *      两个人空闲时间都是安排好的，小明的时间表是固定的，是[a1, b1], [a2, b2], …, [ap, bp]；
 *      而小红的时间表比较怪，是依赖她起床时间t的，是[c1+t, d1+t], [c2+t, d2+t], …, [cq+t, dq+t]；
 *      值得注意的是，两个人时间表上的边界点也是空闲时间。小红起床时间t为[l, r]之间的任意一个整点时刻（也包括边界），
 *      只要两人能在任一时刻同时在线进行聊天，那么t就是小红合适的起床时间。询问小红能够有多少个合适的起床时间？
 *
 *      第一行数据四个整数：p,q,l,r (1≤p, q≤50, 0≤l≤r≤1000)。接下来p行数据每一行有一对整数ai,bi(0≤ aibi, cj+1>dj。
 *      样例输入      样例输出（输出能够进行聊天的合适的起床时间点的个数）
 *      2 3 0 20         20
 *      15 17
 *      23 26
 *      1 4
 *      7 11
 *      15 17
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 12:59
 */
/*
    穷举法：
    （1）取（l, r）之间的任意整点时刻，且包含边界。
    （2）该时刻满足任意一个区间，该时刻属于合适时间。
    （3）取时刻 t后， 设小明区间（x1,y1）,小红区间（x2,y2）
          1、x2 <=y2 < x1:不满足
　　      2、y2 >= x2 > y1:不满足
            即： [小红] U [小明] = null
 */
public class Chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p,q,l,r;
        p = scanner.nextInt();
        int[][] ming = new int[p][2];
        q = scanner.nextInt();
        int[][] hong = new int[q][2];
        l = scanner.nextInt();
        r = scanner.nextInt();
        for (int i = 0; i < p; i++) {
            ming[i][0] = scanner.nextInt();
            ming[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < q; i++) {
            hong[i][0] = scanner.nextInt();
            hong[i][1] = scanner.nextInt();
        }
        int count = 0;
        boolean flag;
        for (int i = l; i <= r; i++) {
            for (int j = 0; j < q; j++) {
                //控制跳出第二层循环,若把false赋在外面，算到某一个值可能就会跳出整个循环，导致统计结果缺少；
                flag = false;   //所以此处应该循环回来需要重置flag为false
                int tempX = hong[j][0] + i;   //x2
                int tempY = hong[j][1] + i;   //y2
                for (int k = 0; k < p; k++) {
                    //处理关系：  [ ,y1]  [x2,y2]  [x1, ]
                    if (tempX > ming[k][1] || tempY < ming[k][0]) {
                        continue;    //不满足，直接下一次
                    }else {
                        count++;    //满足，记录
                        flag = true;
                        break;     //跳出最内层循环
                    }
                }
                if (flag) break; //跳出第二层循环
            }
        }
        System.out.println(count);
    }
}
