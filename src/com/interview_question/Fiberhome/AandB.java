package com.interview_question.Fiberhome;
import java.util.Scanner;
/**
 *@description: 两数之和
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 19:45
 */
public class AandB {
    public static void main(String[] args) {
        int m;
        double sum=0,n;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n = sc.nextDouble();
            m = sc.nextInt();
            for (int i=0;i<m;i++){
                sum += n;
                n=Math.sqrt(n);
            }
            System.out.printf("%.2f",sum);
        }
    }
}
