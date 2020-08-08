package com.interview_question.SaiMa_suanfa;

import java.util.Scanner;

/**
 *@description:  《股神》：
 *      经过严密的计算，小赛买了一支股票，他知道从他买股票的那天开始，股票会有以下变化：第一天不变，
 *      以后涨一天，跌一天，涨两天，跌一天，涨三天，跌一天...依此类推。
 *      为方便计算，假设每次涨和跌皆为1，股票初始单价也为1，请计算买股票的第n天每股股票值多少钱？
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-07 21:46
 */

/*
问题解析：本题目你会很容易抓住“只要知道 所输入天数 前面到底跌了多少次，且每次跌的那一天是哪天” 就非常容易算出结果；
        天  数：     1   2   3   4   5   6   7   8   9   10
        涨跌情况：   0   1   -1  1   1   -1  1   1   1   -1
    可以看到 在 3 6 10 15 21... 这些天数是 “跌”的，然后你再捋捋 这一天的价值 跟 “跌”的那一天之间的关系：
        假设，如果是每天都是涨，那么天数和价值是一样的，但是中间跌一次，我要涨两天，才能得到这样的效果，
        并且前面跌了几次，那么就跟理想的天数==价格有“2*跌的次数”，例如第9天：前面跌了2次，固相差2*2=4，即第9天价值为5；
        则： an-a1=(3+n+1)(n-1)/2=(n+4)(n-1)/2 an=3+(n+4)(n-1)/2

下面再来看看公式怎么推：（你可以考虑“等差”数列，这里做最传统的推算）
    我们只要抓住跌的那一天的数列： 3 6 10 15 21... 则有：
        an - a(n-1) = n + 1;
        (a2-a1)+(a3-a2)+(a4-a3)+...+(an-an-1) = 3+4+5+6+...+(n+1) = an - a1
        如果你是用头加尾相加 * 项数/2 的方式计算和的话，要注意第一项是3，第二项是4，那么（n+1）应该是第n-1项（我自己采坑了）
        如果是由等差数列公式：Sn = na1 + [n(n-1)]d/2 算时：也要注意，此处的 n 指的是 共有（n-1）项
        所以你用这个公式算得的结果是第 (n-1)项，此处我右踩了一遍坑，认为求出的结果为什么是正确结果的前面一项；
        小小的公式就引发大量无价值无意义的计算，下次引以为戒；

        由题意可知：第n次跌是发生在第x天，x与n的关系为：
                        x = n2/2 + 3n/2 + 1    (n>=1)
                    也可把公式转化为：
                        n =（根号）(2x+0.25) - 1.5  (x>=1)
 */
public class StockGod {
    public static void main(String[] args) {
            int date;
            Scanner sc = new Scanner(System.in);
//      System.out.println("请输入天数n");
            date = sc.nextInt();
            //方法一：循环加，算法时间复杂度为O(n);
/*      int price = 1, priceDownDate = 3, priceDownNum = 1;
        for(int i = 2; i <= date; i ++){
            if(priceDownDate == i){
                priceDownNum ++;
                priceDownDate = (priceDownNum*priceDownNum + 3*priceDownNum)/2 + 1;
                price --;
            }else{
                price ++;
            }
        }*/
            //方法二：公式求，算法复杂度为1；
            int price , priceDownNum;
            priceDownNum = (int) (Math.sqrt(2*date + 0.25) - 1.5);
//      System.out.println(priceDownNum);
            // 时间与 “跌”的次数 相差为价格
            price = date - 2*priceDownNum;
            System.out.println(price);
        }
}
