package com.interview_question.SaiMa_suanfa;

import java.util.Scanner;

/**
 *@description: 《分苹果》：
 *      果园里有堆苹果，N（1＜N＜9）只熊来分。第一只熊把这堆苹果平均分为N份，多了一个，它把多的一个扔了，
 *      拿走了一份。第二只熊把剩下的苹果又平均分成N份，又多了一个，它同样把多的一个扔了，拿走了一份，
 *      第三、第四直到第N只熊都是这么做的，问果园里原来最少有多少个苹果？
 *
 *      输入1个整数，表示熊的个数。它的值大于1并且小于9。
 *      样例输入： 5       样例输出：3121
 *
 *      假设有 x 个苹果，N只熊，三只熊的分法：
 *          ①： x % N = 1;                           x - 1 = new x1
 *          ②： [x - (x / N)] % N = 1;               x - 1 = new x2
 *          ③： ...
 *          其实是通过数列演算得到的公式套用；参考：
 *           “https://blog.csdn.net/sinat_27339001/article/details/79870541”
 *           “https://www.sohu.com/a/285029677_571478”
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-08 23:21
 */
public class DivideApples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        // Math.pow（double,double）  ———> int ；
        int apple =new Double(Math.pow(N,N) - N + 1).intValue();
        System.out.println(apple);
    }
}
