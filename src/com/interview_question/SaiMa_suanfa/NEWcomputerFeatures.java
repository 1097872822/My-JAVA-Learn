package com.interview_question.SaiMa_suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *@description: 《计算器新功能》
 *      要求多做出一个有新功能的计算器，实现当输入一个数时，能够将这个数分解成一个或多个素因子乘积的形式，
 *      并按素因子的大小排列显示出来。大家对计算器中数的表示应该很清楚的。下面显示出了0 — 5这十个数字的表示形式。
 *      每个数字都占据5 * 3大小的字符区域：
 *       —         __     __           __
 *      | |   |    __|   __|   |__|   |__  ...
 *      | |   |  |__    __|      |    __|
 *       —
 *
 *      hashnextInt(): 判断用户输入是否为数字而非其他形式输入，且仅仅起到判断作用，无输入作用；
 *              需要注意的是：在使用hasNextInt()方法时，一般判断语句if或循环语句while在前，
 *              输入数据在后，以起到先判断数据是否为整型，后执行代码的作用
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-08 21:35
 */
public class NEWcomputerFeatures {
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
        int n = input.nextInt();
        List deposeList = despose(n);
//	    System.out.println(deposeList);
        printResult(deposeList);
    }
}

    private static void printResult(List deposeList) { // [2,2,2,3]
        int number = deposeList.size();   // 4
        String[] line1 = { " - ", "   ", " - ", " - ", "   ", " - ", " - ", " - ", " - ", " - " };
        String[] line2 = { "| |", "  |", "  |", "  |", "| |", "|  ", "|  ", "  |", "| |", "| |" };
        String[] line3 = { "   ", "   ", " - ", " - ", " - ", " - ", " - ", "   ", " - ", " - " };
        String[] line4 = { "| |", "  |", "|  ", "  |", "  |", "  |", "| |", "  |", "| |", "  |" };
        String[] line5 = { " - ", "   ", " - ", " - ", "   ", " - ", " - ", "   ", " - ", " - " };
        StringBuffer printLine1 = new StringBuffer();
        StringBuffer printLine2 = new StringBuffer();
        StringBuffer printLine3 = new StringBuffer();
        StringBuffer printLine4 = new StringBuffer();
        StringBuffer printLine5 = new StringBuffer();
        for (int i = 0; i < number; i++) {  // i=0<4;
            String stringNum = deposeList.get(i).toString();
//				System.out.println(stringNum);
            for (int j = 0; j < stringNum.length(); j++) {
                //在ASCII编码中， 0~9 的编bai码是 0x30~0x39, 所以当c在‘du0'~'9'的范围中时，
                // c - '0' 就相当于计算c的实际数值，例如 c 是 '1', 则 c - '0' = 1, 把字符值转为数字值了 
                printLine1.append(line1[stringNum.charAt(j) - '0']);
                printLine2.append(line2[stringNum.charAt(j) - '0']);
                printLine3.append(line3[stringNum.charAt(j) - '0']);
                printLine4.append(line4[stringNum.charAt(j) - '0']);
                printLine5.append(line5[stringNum.charAt(j) - '0']);
            }
            printLine1.append(" ");
            printLine2.append(" ");
            printLine3.append("*");
            printLine4.append(" ");
            printLine5.append(" ");
        }
        /*
        delete()方法和deleteCharAt()方法都是用来删除StringBuffer字符串指定字符索引的方法，其中
        delete(int a,int b)方法：包含两个参数，使用时删除索引从a到b（包括a不包括b）的所有字符；
        deleteCharAt(int s)方法：只有一个参数，使用时删除索引为a的字符。
         */
        int printLen = printLine1.length();
        printLine1.deleteCharAt(printLen - 1);
        printLine2.deleteCharAt(printLen - 1);
        printLine3.deleteCharAt(printLen - 1);
        printLine4.deleteCharAt(printLen - 1);
        printLine5.deleteCharAt(printLen - 1);
        System.out.println(printLine1);
        System.out.println(printLine2);
        System.out.println(printLine3);
        System.out.println(printLine4);
        System.out.println(printLine5);
    }

    private static List despose(int n) {  // 24
        List deposeList = new ArrayList();
        int primer = 2;
        while (primer <= n) {   // 2 < 24  2 < 12  2 < 6  2 < 3
            if (n % primer == 0) {   // 24 % 2 = 0;    12 % 2 = 0;   6 % 2 = 0;  3 % 2 = 1;
                deposeList.add(primer);   // [2,2,2]
                n = n / primer;   // n = 24 / 2 = 12;    n = 12 / 2 = 6;   n = 6 / 2 = 3;
            } else {
                primer++;   //[3]
            }
        }
        return deposeList;
    }
}
