package com.interview_question.SaiMa_suanfa;

import java.util.Scanner;
import java.util.Stack;

/**
 * @description: 《简单计算》
 * 用户输入数学算式，就可以得到计算结果。其中涉及的计算包括：”+”、”-”、”*”、”/”、”^”、”(”、”)”，
 * 分别表示加减乘除和指数，其中括号用于调整计算的顺序。合法的表达式如下：
 * x+y+z    x+(y+z)      x*(y+z)+a-b-c^d
 * <p>
 * 输入数据有多行，每行为一个用户输入的算式，保证算式是合法的，每行最多包含不超过200个字符。
 * 所有参与运算的数值均为整数，若为指数，则为正整数。
 * <p>
 * 样例输入                                    样例输出
 * 1+2+3+4+5+6+7+8+9+10                        55
 * 1+2*3+4                                     11
 * 1+2^(3+3)+5                                 70
 * @author: RRW friend_rrw@163.com
 * @create: 2020-08-10 17:15
 */
public class SimpleCalculation {
    public static Stack<Integer> nums = new Stack<>();
    public static Stack<Character> characters = new Stack<>();
    public static int topPre = 0;
    public static int curPre = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String origin = in.nextLine();
            if (origin.contains(")")) {
                origin = caP(origin);
            }
            System.out.println(caculate(origin));
        }
    }

    public static int caculate(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '^':
                    pushChar(c);
                    break;
                case '(':
                    break;
                case ')':
                    break;
                default:
                    String sNum = String.valueOf(c);
                    while (i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))) {
                        ++i;
                        sNum += String.valueOf(str.charAt(i));
                    }
                    pushNum(Integer.valueOf(sNum));
                    break;
            }

        }
        while (!characters.isEmpty()) {
            popCaculate();
        }
        return nums.pop();
    }

    private static int popCaculate() {
        int n1 = nums.pop();
        int n2 = nums.pop();
        char c = characters.pop();
        int result = 0;
        switch (c) {
            case '+':
                result = n2 + n1;
                break;
            case '-':
                result = n2 - n1;
                break;
            case '*':
                result = n2 * n1;
                break;
            case '/':
                result = n2 / n1;
                break;
            case '^':
                result = (int) Math.pow(n2, n1);
                break;
        }
        pushNum(result);

        return result;
    }

    private static void pushNum(int n) {
        nums.push(n);

    }

    public static void pushChar(char c) {
        if (characters.isEmpty()) {
            characters.push(c);
        } else {
            char top = characters.peek();
            topPre = getPriority(top);
            curPre = getPriority(c);
            if (curPre > topPre) {
                characters.push(c);
            } else {
                popCaculate();
                pushChar(c);
            }
        }
    }

    public static String caP(String str) {
        String r = str;
        while (r.contains(")")) {
            String front = r.substring(0, r.indexOf("("));
            String after = r.substring(r.indexOf(")") + 1, r.length());
            String mid = r.substring(r.indexOf("(") + 1, r.indexOf(")"));
            r = front + caculate(mid) + after;
        }
        return r;
    }

    private static int getPriority(char c) {
        int priority = 0;
        switch (c) {
            case '+':
            case '-':
                priority = 1;
                break;
            case '*':
            case '/':
                priority = 2;
                break;
            case '^':
                priority = 3;
                break;
            case '(':
            case ')':
                priority = 4;
                break;
        }
        return priority;
    }
}
// 害，臃肿的java呀...
/*
    来个python的： 接口实现
        while 1:
	    print(int(eval(input().replace('^','**'))))
*/