package com.interview_question.SaiMa_suanfa;
import java.util.Scanner;
/**
 *@description: 《编辑器》：
 *      1.如果你收到一个&lsquo;#&rsquo;，那么你应该删掉一个你已经收到的字符，不包括&lsquo;#&rsquo;；
 *      2。如果你收到&lsquo;@&rsquo;，那么你应该把你收到的一整行都删掉。（&lsquo;#&rsquo;和&lsquo;@&rsquo;
 *          都为不可见字符。）你明白了吗？现在轮到你去解决这个问题啦！
 *      提示： &lsquo和&rsquo分别是左半单引号和右半单引号的html转义符；
 *         样例输入：                   样例输出：
 *          3
 *          whli##ilr#(s#*s)            while(*s)
 *          outcha@putcha(*s=#++)       putchar(*s++)
 *          returnWA##A!##AC            returnAC
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 20:05
 */
public class Editor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String line = in.next();
            char[] ch = line.toCharArray();  //字符串转字符数组
            StringBuffer sb = new StringBuffer();
            for (char c : ch) {
                if(c=='#') {
                    if(sb.length()>0) {
                        //删除下标为 x 的字符；与delete不同：删除a-b（左闭右开，即不删除b）的字符；
                        sb.deleteCharAt(sb.length()-1);
                    }
                } else if(c=='@') {
                    sb.delete(0, sb.length());
                } else {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
        in.close();
    }
}
