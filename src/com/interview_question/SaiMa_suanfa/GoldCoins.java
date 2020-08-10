package com.interview_question.SaiMa_suanfa;
import java.util.Scanner;
/**
 *@description: 《接金币》：
 *      小赛非常喜欢玩游戏，最近喜欢上了一个接金币的游戏。在游戏中，使用帽子左右移动接金币，金币接的越多越好，
 *      但是金币掉到地上就不能再接了。为了方便问题的描述，我们把电脑屏幕分成11格，帽子每次能左右移动一格。
 *      现在给电脑屏幕如图标上坐标：
 *
 *      |__|_ _|_ _|_ _|_ _|_ _|_ _|_ _|_ _|_ _|
 *      0  1   2   3   4   5   6   7   8   9  10
 *
 *      也就是说在游戏里，金币都掉落在0-10这11个位置。开始时帽子刚开始在 5 这个位置，因此在第一秒，帽子只能
 *      接到4,5,6这三个位置中其中一个位置上的金币。问小赛在游戏中最多可能接到多少个金币？（假设帽子可以容纳无穷多个金币）。
 *
 *      第一行为以正整数n ，表示有n个金币掉在屏幕上上。在接下来的n行中，每行有两个整数x,T ,
 *      表示在第 T 秒有一个金币掉在x点上。同一秒钟在同一点上可能掉下多个金币。n=0时输入结束。输入数据以空格隔开；
 *
 *      输入：    输出： 3
 *      3
 *      6 3
 *      8 2
 *      9 3
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 20:19
 */
public class GoldCoins {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] pos=new int[n];
        int[] tim=new int[n];
        for(int i=0;i<n;i++){
            pos[i]=in.nextInt();
            tim[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(tim[j]<tim[i]){
                    swap(pos,i,j);
                    swap(tim,i,j);
                }
            }
        }
        int curPos=5;
        int curTim=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(curPos==pos[i]){
                count++;
                curPos=pos[i];
                curTim=tim[i];
            }
            else if(curPos+(tim[i]-curTim)-pos[i]==0||curPos-(tim[i]-curTim)-pos[i]==0){
                count++;
                curPos=pos[i];
                curTim=tim[i];
            }
        }
        System.out.println(count);
    }
    public static void swap(int a[],int l,int r){
        int temp=a[l];
        a[l]=a[r];
        a[r]=temp;
    }
}
