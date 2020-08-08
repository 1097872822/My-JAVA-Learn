package com.interview_question.Fiberhome;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description: 2017 烽火校招：士兵队列
 * @author: RRW friend_rrw@163.com
 * @create: 2020-08-07 00:17
 */
/*
    一队士兵在操场上排成一列，士兵总数为n，每个士兵有各自的身高。士兵列队完毕后，将军走到队列的最前面。
    因为身高不一，有些士兵可能被前面身高更高的挡住了，这样将军就看不到他们。将军能看到某个士兵当且仅当他的
    身高严格大于他前面的所有士兵。  将军发现这些士兵的身高为a1,a2,a3,...,an。而且他恰好能看到m个士兵。
    将军想知道一共有多少种可能的站队方式。两种站队方式不同当且仅当至少存在一个士兵，他站在了队列的不同位置。
    最后方案数可能很大，输出方案数除以1000000007后的余数。

    eg: 输入只有两行，第一行两个数n和m，（1<=m<=n<=1000）
        第二行有n个数，a1到an。（1<=ai<=1000000000）
    样例输入                   样例输出
        4 3                       6
        1 1 2 3
 */
/*
    斯特林推进公式；
     解题思想： 士兵降序排列，f(i,j) 表身高为n，n-1，....，n-i+1的士兵,有f(1,1)=1 f(1,i)=0
                考虑n; n1; : : : ; ni+1个士兵已经站成了一列队伍，现在把身高为ni的士兵插入队列中，由于之前队列中的所有士兵身高都比他高，所以要想看到他，
                他只有站在第1个位置，其他的排队方法都不能看到他。由于它是最矮的，所以他也不会挡住之前队伍中的任何人
                此时： f(i+1,j) = f(i,j-1)+ i*f(i,j)---->F(n,m)
*/
public class Soldiers_Queue {
    public static void main(String[] args) {
        sovle();
    }

    private static void sovle() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[] sds = new int[n];
        for (int i = 0; i < sds.length; i++) {
            sds[i] = scanner.nextInt();
        }
        Arrays.sort(sds);
        int catos = 0;
        int[] nums = new int[n];
        int cnt = 0, i = n - 1;
        while (i >= 0) {
            cnt = 1;
            while (i > 0 && sds[i] == sds[i - 1]) {
                i--;
                cnt++;
            }
            nums[catos++] = cnt;
            i--;
        }
        long[][] dp = new long[catos + 1][m + 1];
        dp[1][1] = getFac(nums[0]);
        int cntSd = nums[0];
        for (int j = 2; j <= catos; j++) {
            cntSd += nums[j - 1];
            for (int k = 1; k <= m; k++) {
                long a1 = 1, a2 = 1;
                for (int l = 0; l < nums[j - 1] - 1; l++) {
                    a2 = (a2 * (cntSd - 1 - l)) % 1000000007;
                }
                a1 = (a2 * (cntSd - nums[j - 1])) % 1000000007;
                a2 = (a2 * (nums[j - 1])) % 1000000007;
                dp[j][k] = ((a1) * dp[j - 1][k] + (a2) * dp[j - 1][k - 1]) % 1000000007;
            }
        }
        System.out.println(dp[catos][m]);

    }

    private static int getFac(int i) {
        if (i <= 1) {
            return 1;
        } else {
            return i * getFac(i - 1);
        }
    }
}
