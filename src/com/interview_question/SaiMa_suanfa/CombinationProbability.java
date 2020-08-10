package com.interview_question.SaiMa_suanfa;
import java.util.Scanner;
/**
 *@description: 《组合概率》
 *      某生产零件的工厂为方便管理场内生产的零件种类，现将他们生产的零件从低等到高等零件排序，序号分别为1,2..n，
 *      已知该厂的任意几个低等的零件可以组合成更高等的零件，零件的序号代表了零件的等级，
 *      比如5号零件可以由1号和4号零件组合而成，也可以有2号和3号零件组合而成。
 *      现有一个序号为 x 的零件，它是由 n 个序号在[a,b]区间内的零件组合而成，
 *      求n 个序号在[a,b]区间内的零件组合为 x 零件的概率、
 *
 *      一行输入四个整数依次为n，a，b，x，用空格分隔。数据规模和约定
 * 　　     对于50%的数据，n≤5.
 *          对于100%的数据，n≤100,b≤100.
 *      输出一行为组合为 x 零件的概率，小数点后保留四位小数。
 *
 *      样例输入              样例输出
 *      2 1 3 4               0.3333
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 17:05
 */
public class CombinationProbability {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int x = scanner.nextInt();

        int count = zuhe(n, a, b, x);
        int sum = 1;
        for (int i = 0; i < n; i++)
            sum *= b - a + 1;
        System.out.printf("%.4f", count * 1.00 / sum);
    }

    private static int zuhe(int n, int a, int b, int x) {
        while (n >= 0 && x >= 0) {
            if (n == 0 && x == 0)
                return 1;
            else {
                int count = 0;
                for (int i = a; i <= b; i++) {
                    count += zuhe(n - 1, a, b, x - i);
                }
                return count;
            }
        }
        return 0;
    }
}
