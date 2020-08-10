package com.interview_question.SaiMa_suanfa;
import java.util.Scanner;
/**
 *@description: 《搬圆桌》
 *      小A有一张半径为r的圆桌，其中心位于(x,y)，现在他想把圆桌的中心移到(x1, y1)。每次移动一步，
 *      小A都得在圆桌边界上固定一个点，然后将圆桌绕这个点旋转。 问最少需要几步才能把圆桌移到目标位置？
 *
 *      一行五个整数r,x,y,x1,y1( 1 ≤ r ≤ 100000,  - 100000 ≤ x, y, x1, y1 ≤ 100000)。
 *      样例输入      样例输出
 *      2 0 0 0 4          1
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 22:50
 */
public class RoundTable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        {
            int r = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            System.out.println(getStep(r,x,y,x1,y1));
        }
    }
    /**
     * 计算移动的最少步数:
     * (1）移动距离刚好是2r的倍数：移动次数 = 距离 / 2r
     * (2）移动距离不是2*r的倍数：移动次数 = 距离 / 2r +1。表明如果想要移动到指定位置，需要执行一次距离<2r的移动。
     * 算法思想：每次移动都必须在圆桌边缘固定一个点然后将圆桌绕这个点旋转
     * 则旋转后的圆心与最初圆心的连线肯定是圆直径(2r)的倍数，如果不是整数倍需要向上取整
     *
     *      其实这题不同想的太复杂，如果 sqrt（rx*rx+ry*ry）即x,y 与 x1,,y1的距离 都是2r的倍数，
     *          如果不是，则 +1就行，不用考虑它怎么移动到这个x1,y1点上，因为它只要在2r倍数范围内，它就能找到这个目标点；
     * */
    public static int getStep(int r,int x,int y,int x1,int y1)
    {
        double step = 0;
        double rx = Math.abs(x - x1);
        double ry = Math.abs(y - y1);
        step = Math.sqrt(rx*rx+ry*ry)/(2*r);
        //ceil向上取整函数
        return (int)Math.ceil(step);
        /*
            还可以这样：

            //计算两个圆心的距离
              double distance=Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
            //一次旋转环，两圆心最大相距2*r
              long result=(long)distance/(2*r);
            //如果不是 2r 的倍数，直接 +1
            if(distance%(2*r)!=0)
               result++;
*/
    }
}

