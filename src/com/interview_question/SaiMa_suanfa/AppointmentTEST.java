package com.interview_question.SaiMa_suanfa;
import java.util.Scanner;
/**
 *@description: 《约会》：
 *      Bob和Alice有个约会，一大早Bob就从点(0,0)出发，前往约会地点(a,b)。Bob没有一点方向感，
 *      因此他每次都随机的向上下左右四个方向走一步。简而言之，如果Bob当前在(x,y)，
 *      那么下一步他有可能到达(x+1,y),  (x-1,y),   (x,y+1),   (x,y-1)。
 *      很显然，当他到达目的地的时候，已经很晚了，Alice早已离去。第二天，Alice质问Bob为什么放她鸽子，
 *      Bob说他昨天花了s步到达了约会地点。Alice怀疑Bob是不是说谎了。你能否帮她验证一下？
 *
 *      输入三个整数a,b,s     说谎输出“Yes”，如果Bob可能用s步到达(a,b)；否则输出“No”。
 *
 *      技巧：
 *          起点是(0,0)，终点是(a,b)，考虑到坐标系有正有负，取绝对值，那么可以走的最少的步数即a+b，那么s是应该是
 *          大于等于a+b的。Bob在到达终点前是随机走，所以如果走错了，一定会返回，比如应该走到1，他走到了-1，
 *          则需要再走两步才会到达目标位置，因此如果走错路的话，超出的步数至少为2且为偶数。
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 17:25
 */
public class AppointmentTEST {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int s = sc.nextInt();
    int k = s-Math.abs(a) - Math.abs(b) ;
		if(k>=0 && k%2 == 0){  //如果走错，超出的步数必为偶数
        System.out.printf("%s\n","Yes");
    } else{
        System.out.printf("%s\n","No");
    }
}
}
