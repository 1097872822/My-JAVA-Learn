package com.interview_question.Fiberhome;
import java.util.Scanner;
/**
 *@description: 《水仙花数》
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 19:45
 */
public class shuixianhuashu {
    public static void main (String[] args){
        int m,n;
        int j = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            m = sc.nextInt();
            n = sc.nextInt();
            double x = 0, y = 0, z = 0;
            double MI = 3;
            if (100 <= m && m <= n && n <= 999) {
                for (int i = m; i <= n; i++) {
                    x = i / 100;
                    y = (i % 100) / 10;
                    z = i % 10;
                    if (Math.pow(x, MI) + Math.pow(y, MI) + Math.pow(z, MI) == i) {
                        j = j + 1;
                        if (j > 1) {
                            System.out.print(i + " ");
                        } else System.out.print(i);
                    }
                }
            }
            if (j == 0) System.out.println("no");
        }
    }
}
