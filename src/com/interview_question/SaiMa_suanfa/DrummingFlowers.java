package com.interview_question.SaiMa_suanfa;
import java.util.Scanner;
/**
 *@description: 《击鼓传花》
 *          总所周知不放题目，但：
 *              聪明的小赛提出一个有趣的问题：有多少种不同的方法可以使得从小赛手里开始传的花，传了m次以后，
 *              又回到小赛手里。对于传递的方法当且仅当这两种方法中，接到花的同学按接球顺序组成的序列是不同的，
 *              才视作两种传花的方法不同。比如有3个同学1号、2号、3号，并假设小赛为1号，
 *              花传了3次回到小赛手里的方式有1->2->3->1和1->3->2->1，共2种。
 *
 *              输入共一行，有两个用空格隔开的整数 n(人数)，m（3<=n<=30，1<=m<=30）
 *              样例输入         样例输出
 *              3 3               2
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 15:41
 */
/**
 * 思路：
 * 设n个人第m次回到小赛手里的情况为dp[m][n]
 * dp[m][n]等于第m-1次传递到小赛左右两边的人的情况之和，即 dp[m][n] = dp[m-1][(n-1+n)%n] + dp[m-1][(n+1)%n]
 * 边界值：
 * dp[1][2] = 1     dp[1][2] = dp[0][1] + dp[0][3]   ---------->    dp[0][1] = 1
 * dp[1][n] = 1     dp[1][n] = dp[0][1] + dp[0][n-1] ---------->    dp[0][1] = 1    其余dp[0][i] = 0;
 * 真正的边界值：
 * dp[0][1] = 1    dp[0][i != 1] = 0;
 */
public class DrummingFlowers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;
        //动态规划：
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(j == 1){
                    dp[i][j] = dp[i-1][n] + dp[i-1][j+1];
                }else if(j == n){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][1];
                }else{
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
                }
            }
        }
        System.out.println(dp[m][1]);
    }
    /*
        也可以这样：
        Scanner sc = new Scanner(System.in);
        int n,m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] graph = new int[m+1][n];
        for(int i=0;i<n;i++) graph[0][i] = 0;
        graph[0][0] = 1;
        for(int i=1;i<=m;i++){
            for(int j=0;j<n;j++){
                graph[i][j] = graph[i-1][(j+1)%n]
                + graph[i-1][(j+n-1)%n];
            }
        }
        System.out.println(graph[m][0]);
    */
}
