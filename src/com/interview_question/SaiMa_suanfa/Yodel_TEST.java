package com.interview_question.SaiMa_suanfa;

import java.util.Scanner;

/**
 *@description: 《约德尔测试》：
 *     说起约德尔人的未来，黑默丁格曾经提出了一个约德尔测试，将约德尔人的历史的每个阶段都用一个字符表达出来。
 *     (包括可写字符,不包括空格。)。然后将这个字符串转化为一个01串。转化规则是如果这个字符如果是字母或者数字，
 *     这个字符变为1,其它变为0。然后将这个01串和黑默丁格观测星空得到的01串做比较，得到一个相似率。
 *     相似率越高,则约德尔的未来越光明   请问:相似率为多少？
 *
 *      要求：第一行为有关约德尔人历史的字符串，第二行是黑默丁格观测星空得到的字符串。
 *      样例输入 【@!%12dgsa 010111100】  输出：66.67%
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-08 16:16
 */
public class Yodel_TEST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String src = scanner.nextLine();
        String des = scanner.nextLine();
        String Change = ""; //这样的方式拼接一开始没想到...
        for (int i = 0; i < src.length(); i++) {
            char p = src.charAt(i);
            if (p >= 'a' && p <= 'z' || p >= 'A' && p <= 'Z' || p >= '0' && p <= '9'){
                Change = Change + "1";   //妙呀
            }else Change = Change + "0";
        }
        int sanme = 0;
        for (int i = 0; i < Change.length(); i++) {
            if (des.charAt(i) == Change.charAt(i)){
                sanme++;
            }
        }
        float out = (float) sanme * 100 / (float) Change.length();  //same是int型
        System.out.printf("%.2f%%",out); // %% 表示直接输出一个 %号 == printf("%");
    }
}
