package com.interview_question.Fiberhome;
import java.util.Scanner;
/**
 *@description: 2017 烽火校招：小明的棋盘
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-06 22:24
 */
/**
 * 小明有天看到一个放满黑子和白子交替的大小为n*m的棋盘。
 * 然而小明只喜欢只有一种颜色的棋盘，即只有黑子或者白子。
 * 小明拥有超能力可以将一个里面的矩阵的棋子的颜色反转,但是他一天最多只能使用c次超能力。
 * 如果可以将所有棋子变成一种颜色，小明就会买这个棋盘，请问小明是否会买这个棋盘。
*/
public class CheckForxiaoming {
    public static void main(String args[]){
        Scanner cin=new Scanner(System.in);
        int T,c;
        long n,m;
        while (cin.hasNext()) {
            T=cin.nextInt();
            for (int i = 0; i < T; i++) {
                n=cin.nextInt();
                m=cin.nextInt();
                c=cin.nextInt();
                //对于n×m的棋盘共有2×（n-1）+2×（m-1）个分割符，需要n/2+m/2次矩形覆盖（向下取整数）
                System.out.println((n/2+m/2)<=c?"Yes":"No");
            }
        }
    }
}
/*
    第一行一个整数 T(T≤10) 表示数据组数。
    每组数据有一行, 三个正整数 n,m,c(1≤n,m,c≤1e9)。

    样例输入
        2
        1 2 1  yes
        2 2 1  no
*/