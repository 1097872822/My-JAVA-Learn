package com.interview_question.SaiMa_suanfa;
import java.util.Scanner;
/**
 *@description: 《投篮游戏》
 *      球场有p个篮筐，编号为0, 1, ..., p-1，每个篮筐下面有个袋子，每个袋子最多能装入一个篮球。
 *      现在有n个篮球，第i个篮球有一个数字xi，投篮规则是将数字为xi的篮球，投入篮筐编号为xi除以p所得的余数。
 *      如果袋子里面已经有球，那么篮球就会弹出，投篮游戏结束，输出i；
 *      否则重复进行将篮球投完，游戏结束，输出-1。问小赛会在何时结束游戏？
 *
 *      第一行数据是两个整数：p, n (2≤p,n≤300)，p表示篮筐数目，n表示篮球数目。接着n行数据表示篮球上的数字xi
 *
 *      样例输入                    样例输出
 *      10 5                        4
 *      0
 *      21                          思路：有点像hash算法的冲突问题，将每一个数 % p后，若有冲突，结束游戏；
 *      53
 *      41
 *      53
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 00:39
 */
public class ShootingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int p = scan.nextInt();             //篮筐数   10
        int n = scan.nextInt();             //篮球数   5
        boolean[] used = new boolean[p];
        int i = 1;   //从第一个篮球开始
        while( i <= n){                     // 1<=5  2<=5  3<=5     4<=5
            int curr = scan.nextInt();      // 0      21     53       41
            int res = curr % p;            // 0%10=0;  21%10=1  3      1
            if (used[res]) {               // false;   false;  flase;  true;
                System.out.println(i);   //哪个冲突，就输出              4
                return;
            }else{
                used[res] = true;          //[true,true,false,true,
            }
            i++;                           //   2    3    4
        }
        System.out.println(-1);
    }
}
