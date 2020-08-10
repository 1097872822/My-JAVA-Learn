package com.interview_question.SaiMa_suanfa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@description: 《三分线》
 *      小赛很喜欢看A队和B队的篮球比赛。众所周知，篮球每回合根据投篮远近可以得2分或3分。如果投篮距离小于d那么得2分，
 *      大于等于d得3分。我们将d记为三分线。 每次小赛都喜欢通过改变三分线的大小来让自己支持的A队获取更大的优势。
 *      现给出两个队伍投篮得分的距离，小赛希望你能够帮他选择一个合理的三分线，使得A队优势最大。
 *
 *      第一行第一个数为n(1≤n≤2*105)， 表示A队进球数，接下来n个正整数表示A队每次进球的投篮位置
 *      第二行第一个数为m(1≤m≤2*105)，表示B队进球数，接下来m个正整数表示B队每次进球的投篮位置
 *
 *      样例输入            样例输出
 *        3 1 2 3           3
 *        2 5 6
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 11:09
 */
public class ThreePointLne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int anum = sc.nextInt();
        int[] aspot = new int[anum];
        for(int i=0;i<anum;i++){
            aspot[i] = sc.nextInt();
        }
        int bnum = sc.nextInt();
        int[] bspot = new int[bnum];
        for(int i=0;i<bnum;i++){
            bspot[i] = sc.nextInt();
        }
        Arrays.sort(aspot);
        Arrays.sort(bspot);
        int j=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<anum;i++){
            for(;j<bnum;j++){
                if(bspot[j]>=aspot[i]){  //如果一轮比下来bj都 >= aj
                    break;
                }
            }
            int left = (anum-i)*3-(bnum-j)*3+(i*2-j*2);  //3 分差 + 2 分差
            if(left>max)
                max = left;
        }
        int right = anum*3-bnum*3;   //全是3分
        if(right>max)
            max = right;
        int mid = anum*2-bnum*2;    //全是2分
        if(mid>max)
            max = mid;
        System.out.println(max);
    }
}
