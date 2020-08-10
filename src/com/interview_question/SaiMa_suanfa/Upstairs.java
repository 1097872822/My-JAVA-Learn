package com.interview_question.SaiMa_suanfa;
import java.util.Scanner;
/**
 *@description: 《上台阶》
 *      有一楼梯共m级，刚开始时你在第一级，若每次只能跨上一级或二级，要走上第m级，共有多少走法？
 *      注：规定从一级到一级有0种走法。
 *      输入数据首先包含一个整数 n，表示测试实例的个数，然后是n行数据，每行包含一个整数m，表示楼梯的级数。
 *      样例输入            样例输出
 *          2
 *          2   ------->    1
 *          3   ------->    2
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 16:45
 */
public class Upstairs {
    //二叉树 + 斐波那契公式：F(n) = F(n-1) + F(n-2)
    static int  getLevelNumber(int n){
        if(n<1){
            return 0;
        }
        if(n==1){
            return 0;
        }
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        int temp=0;
        int a=0;
        int b=1;
        for(int i=3;i<=n;i++){
            temp=a+b;
            a=b;
            b=temp;
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int a[] = new int[b];
        for (int i = 0; i < b; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < b; i++) {
            System.out.println(getLevelNumber(a[i]));
        }
    }
}
/*
    斐波那契：F(n) = F(n-1) + F(n-2) 实现：

    public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		while(sc.hasNext()) {
			int num = sc.nextInt();
			for(int i=0; i<num; i++) {
				System.out.println(m.Fan(sc.nextInt()));
			}
		}

	}
	public int Fan(int n) {
		if(n == 1) return 0;
		if(n == 2) return 1;
		if(n == 3) return 2;
		return Fan(n-1)+Fan(n-2);
	}
}
*/