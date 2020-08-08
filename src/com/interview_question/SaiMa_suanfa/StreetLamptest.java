package com.interview_question.SaiMa_suanfa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@description:  《路灯问题》：
 *      V先生有一天工作到很晚，回家的时候要穿过一条长l的笔直的街道，这条街道上有n个路灯。假设这条街起点为0，
 *      终点为l，第i个路灯坐标为ai。路灯发光能力以正数d来衡量，其中d表示路灯能够照亮的街道上的点与路灯的最远距离，
 *      所有路灯发光能力相同。为了让V先生看清回家的路，路灯必须照亮整条街道，又为了节省电力希望找到最小的d是多少？
 *
 *      第一行是两个整数：路灯数目n (1≤n≤1000)，街道长度l (1 ≤l≤109)。
 *      第二行有n个整数ai (0 ≤ ai≤ l)，表示路灯坐标，多个路灯可以在同一个点，也可以安放在终点位置。
 *
 *      样例输入                        样例输出
 *      7 15                             2.50
 *      15 5 3 7 9 14 0
 *
 *      我的思路：
 *          明显就是 排序后路灯坐标的最大距离，那么就有下面的情况：
 *            1.排序后坐标中间会出现最大差距路灯，则d = 最大距离 / 2;
 *            2.左边离起始位置距离最大，则d = 左边最大距离；
 *            3.右边离终点位置距离最大，则d = 右边最大距离；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-08 18:55
 */
public class StreetLamptest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int len = scanner.nextInt();
        int[] arrxy = new int[n];
        //赋值操作：
        for (int i = 0; i < n; i++) {
            arrxy[i] = scanner.nextInt();
        }
        Arrays.sort(arrxy); //排序
        double maxdistance = 0;
        //求最大差距：
        for (int i = 1;i < arrxy.length;i++){
            maxdistance = Math.max(maxdistance,arrxy[i]-arrxy[i-1]);
//            if (arrxy[i] - arrxy[i-1] > maxdistance){
//                maxdistance = arrxy[i] - arrxy[i-1];
//            }
        }
        //3种情况的判断：
        double left = arrxy[0]; //左边的路灯离起始位置长度；
        double right = len - arrxy[n-1]; //右边离终点位置长度;
        if (left > right && left > maxdistance/2){
            System.out.printf("%.2f",left);
        } else if (right >= left && right > maxdistance/2){
            System.out.printf("%.2f",right);
        }else System.out.printf("%.2f",maxdistance/2);
    }
}
