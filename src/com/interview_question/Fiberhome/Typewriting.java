package com.interview_question.Fiberhome;

import java.util.Scanner;

/**
 *@description: 2017 烽火校招：学打字
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-06 23:11
 */
/*
    小明同学刚刚学习打字，现在老师叫他输入一个英文字符串。小明发现，这个英文字符串只由大写和小写的英文字母构成。
    小明同学只会使用Caps Lock键来切换大小写输入。最开始，大写锁定处于关闭状态，小明的电脑只能输入小写英文字母。
    当大写锁定关闭时，按一下Caps Lock键可以打开大写锁定，之后只能输入大写字母；当大写锁定打开时，
    按一下Caps Lock键可以关闭大写锁定，之后只能输入小写字母。现在小明想知道输入这个字符串最少需要按键多少次。

    eg：aAAbB --> 8

     next()不会读取字符前/后的空格/Tab键，只读取字符，开始读取字符（字符前后不算）直到遇到空格/Tab键/回车停止读取；
　   nextLine()读取字符前后的空格/Tab键，回车键截止。
 */
public class Typewriting {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int index = 0,sum = 0;
        int TabStatic = 0; //默认状态为关闭 即为0 ，否则为1；
        int L = s.length();
        while (index < L){
            char c = s.charAt(index);
            if (c >= 'A' && c <= 'Z'){
                if (TabStatic == 0){
                    sum++;
                    TabStatic = 1;
                }
            }else if (c >= 'a' && c <= 'z'){
                if (TabStatic == 1){
                    sum++;
                    TabStatic = 0;
                }
            } index++;
        }
        sum += L;
        System.out.println(sum);
    }
}
