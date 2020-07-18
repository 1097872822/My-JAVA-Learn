package com.project03.view;

import java.util.Scanner;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2020-07-18 15:59
 */
public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);

    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.println("选择错误，请重新输入：");
            } else break;
        }
        return c;
    }

    public static void readReturn() {
        System.out.println("按回车继续...");
        readKeyBoard(100, true);
    }

    /*
        这里说说parseInt(String str) 跟 valueOf(String str) 的区别：
        parseInt(String str)方法是类Integer的静态方法，bai它的作用就是将形参 str 转化为整数；
        str 表示的整数必须合法，不然是会抛异常的。

        valueOf(String str)也是Integer类的静态方法，它的作用是将形参 str 转化为Integer对象，
        就是将str的对象表示形式转化为基本数据类型xxx   他们的值是相等的，但此处不需要用到valueOf
     */
    public static int readInt(){
        int n;
        for (;;){
            String str = readKeyBoard(2,false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.println("数字输入有误，请重新输入");
            }
        }
        return n;
    }
/*
    toUpperCase():
        一个是String类的toUpperCase：返回字符的大写；无参；
        一个是character类的toUpperCase：返回字符的大写，带参
 */
    public static char readConfirmSelection(){
        char c;
        for(;;){
            String str = readKeyBoard(1,false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N'){
                break;
            }else{
                System.out.println("选择错误，请重新输入:");
            }
        }
        return c;
    }

    public static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }
            if (line.length() < 1 || line.length() > limit) {
                System.out.println("输入长度(不大于" + limit + ")错误，请重新输入");
                continue;
            }
            break;
        }
        return line;
    }
}






















