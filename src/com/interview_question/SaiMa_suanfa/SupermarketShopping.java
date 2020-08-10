package com.interview_question.SaiMa_suanfa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@description: 《超市购物》 ----背包问题？贪婪算法？
 *      小赛特别爱购物，有一次他获得了在超市免费购物的机会，超市内有n件物品,第i（1<=i<=n）件物品的价值为ai，
 *      但是他能拿的物品的价值总和不能超过V。贪心的小易希望能拿尽量多数量的物品，
 *      那么请你帮他计算下他最多能拿到多少件物品？
 *
 *      第一行是两个整数n表示物品的数量和V，表示小易最多能拿的总价值，
 *      第二行n个整数，a1,a2..an.(1<=ai<=1000)表示每个物品的价值；
 *
 *      样例输入                    样例输出
 *      3 50
 *      50 105 200                    1
 *      5 55
 *      30 20 20 40 100               2
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 16:57
 */
/*
        分析：
        将物品排序，每次只拿当前价值最低的，就可以拿到最多的物品。
 */
public class SupermarketShopping {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n, v;
        while (s.hasNext()) {
            n = s.nextInt();
            v = s.nextInt();
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = s.nextInt();
            }
            //按升序排序
            Arrays.sort(dp);
            int sum = 0;
            int i;
            for (i = 0; i < n; i++) {
                if ((sum + dp[i]) <= v) {
                    sum += dp[i];
                } else {
                    break;
                }
            }
            System.out.println(i);
        }
    }
}
