package com.interview_question.SaiMa_suanfa;

import java.util.Scanner;

/**
 *@description: 《回文》：
 *      给定一个字符串，问是否能够通过添加一个字母将其变成“回文串”。 “回文串”是指正着和反着读都一样的字符串。
 *      如：”aa”,”bob”,”testset”是回文串，”alice”,”time”都不是回文串。
 *
 *      样例输入    输出：
 *       coco       yes
 *
 *      技巧： 如题，增加一个字符串可以形成“回文”，那么反向思路，删除其中一个字符，即可形成“回文”，那么，
 *             只需要在循环中每次删除遍历数组[i]位置的字符，与reverse()后的字符串相比较，相同则可实现；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 21:24
 */
public class Reply {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String ini = "NO";
        for (int i = 0; i < str.length(); i++) {
            StringBuffer Delbuffer = new StringBuffer(str);
            Delbuffer.deleteCharAt(i);
            StringBuffer Revbuffer = new StringBuffer(Delbuffer);
            Revbuffer.reverse();
            if (Revbuffer.toString().equals(Delbuffer.toString())){
                ini = "YES";
            }
        }
        System.out.println(ini);
    }
}