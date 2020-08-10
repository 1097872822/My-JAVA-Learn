package com.interview_question.SaiMa_suanfa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@description: 《喷水装置》--- 一道经典的 “贪心算法”题；即在本题中理解为，即使剩下很小的一块区域没有喷到，但依然使用剩下的最大半径装置去喷，即贪婪；
 *      小赛家有一块草坪，长为20米，宽为2米，妈妈要他给草坪浇水，在草坪上放置半径为Ri的喷水装置，
 *      每个喷水装置可以给以它为中心的半径为实数Ri(1＜Ri＜15)的圆形区域浇水。他家有充足的喷水装置i（1＜i＜600)个，
 *      并且一定能把草坪全部湿润。你能帮他计算一下，把整个草坪全部湿润，最少需要几个喷水装置。
 *
 *      输入第一个数字为喷水装置的个数n，后面n个数字分别为n个喷水装置的半径r，r表示该喷水装置能覆盖的圆的半径。
 *      样例输入                样例输出
 *      5                       2
 *      2 3.2 4 4.5 6
 *
 *      贪婪思路: 半径排序————>从最大的半径开始—————>焦点连续——————>勾股之后得到l并乘以2并相加，
 *      当总长度大于20的时候，认为全部覆盖；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 23:46
 */
public class WaterWorks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  //装置个数;
        Double[] keep = new Double[n];
        for (int i= 0; i < n; i++){
            keep[i] = scanner.nextDouble();
        }
        Arrays.sort(keep);  //排序
        double max = 0;
        int i;
        for (i = n-1; i >= 0; i--){   //依次取最大半径的装置计算
            max += 2 * Math.sqrt(keep[i] * keep[i] -1); //每个喷水装置覆盖 的 长度为 2√(rr-1)
            if (max >= 20) break;
        }
        System.out.println(n-i); //因为i=n-1，则n-i可以表示需要装置个数
        scanner.close();
    }
}
