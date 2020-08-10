package com.interview_question.SaiMa_suanfa;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *@description: 《比较大小》：
 *      现在有"abcdefghijkl”12个字符，将其所有的排列中按字典序排列，给出任意一种排列，
 *      说出这个排列在所有的排列中是第几小的？
 *
 *      样例输入                        输出：
 *          3
 *          abcdefghijkl   ----------> 1
 *          hgebkflacdji   ----------> 302715242
 *          gfkedhjblcia   ----------> 260726926
 *
 *        思路：一般人可能不知道（包括我），康托展开公式：
 *              指的就是：{1,2,3,4,...,n}的排列总共有n!种，将它们从小到大排序，怎样知道其中一种排列是有序序列中的第几个？
 *              例如，{3，2，1} 共有 6种； 其中第一位3，小于3的有1,2，有2*2！个； 第二位2，同理有：1*1！=1；
 *              所以小于{3,2}的有 2*2！+1*1! = 5个（即321最大）
 *
 *              再如打乱一些：   1324是{1,2,3,4}排列数中第几个大的数：
 *                  第一位是1小于1的数没有，是0个，0*3!；
 *                  第二位是3小于3的数有1和2，但1已经在第一位了，所以只有一个数2，1*2!；
 *                  第三位是2小于2的数是1，但1在第一位，所以有0个数，0*1!，
 *                  所以比1324小的排列有0*3!+1*2!+0*1!=2个，1324是第三个大数。
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 14:51
 */
public class CompareSize {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        for(int i = 0; i < n; i++){
            String str = s.nextLine();
            char[] ch = str.toCharArray();  //toCharArray() 方法将字符串转换为字符数组。 {a,b,c}
            System.out.println(f(ch));
        }
        s.close();
    }

    static int f(char[] ch){
        int rank = 1;
        for(int i = 0; i < ch.length; i++){
            //计算字符ch[i] 与 'a'的差值 * ch[i]后面的字符排列组合数:
            rank += (ch[i]-'a')*f2(ch.length-i);
            for(int j = i; j < ch.length; j++){
                if(ch[j] > ch[i]){
                    ch[j]--;
                }
            }
        }
        return rank;
    }

    //一共多少种排列组合，即：n！
    static int f2(int n){
        int sum=1;
        for(int i = 1; i < n; i++){
            sum = sum*i;
        }
        return sum;   // 3! = 6;
    }


    /*---------------------------------------------------------------------------------------*/

    @Test
    /*
        康拓展开算法：
        找出 52413 是这个数组的全排列中的第几个:
            5 作为第一个数，比它小的数有四个，5 的后面有4个位置可待排序使用，则这四个数的全排列有 4 * 4! 种
            2 作为第二个数，比它小的数只有一个，2 后面只有3个位置可用来做全排列使用，全排列的个数是 1 * 3!
            4 作为第三个数，比它小的数有3个，但是2已经使用过了，所以只能用2个，全排列的个数是 2 * 2!
            同理可得 1 有 0 * 1！种，3 有 0 * 0！种

            把上面提到的全排列的种数相加就得到了 106
            因为这种算法是从 0 开始计算的，所以 52413 是第 106+1 个排列
     */
    public void KTZK1(){
        System.out.println(cantorExpansion(52413)); // 107
        System.out.println(cantorExpansion(312)); // 5
        System.out.println(cantorExpansion(34125)); // 61
    }
    /*
      输入一个整数，返回它是该数组全排列里面的第几个数
     */
    public static int cantorExpansion(int n) {
        int position = 0;
        String number = String.valueOf(n);
        for (int i = 0; i < number.length(); i++) {
            position += (getMinCount(number.charAt(i), number, i) * getFactorial1(number.length()-i-1));
        }
        return position + 1;
    }
    // 求小于等于 x 的数有几个，且排除已经处理过的数
    public static int getMinCount(char x, String number, int index) {
        Integer num = Integer.valueOf(String.valueOf(x));
        for (int i = 0; i < index; i++) {
            Integer tmp = Integer.valueOf(String.valueOf(number.charAt(i)));
            if (tmp < num) {
                num--;
            }
        }
        return num - 1;
    }

    // 求x的阶乘
     static int getFactorial1(int x) {
        if (x == 0)
            return 1;
        int res = x;
        for (int i = 1; i < x; i++) {
            res *= i;
        }
        return res;
    }

    /*---------------------------------------------------------------------------------------*/

    @Test
    /*
        康托展开的逆运算：
        {1,2,3,4,5}的全排列已经从小到大排序，要找出第16个数：
        1. 首先用16-1得到15
        2. 用15去除4! 得到0余15 ----->  有0个数比它小的数是1,即 1
        3. 用15去除3! 得到2余3  ----->  有2个数比它小的数是3，但1已经在之前出现过了,即 4
        4. 用3去除2! 得到1余1   ----->  有1个数比它小的数是2，但1已经在之前出现过了，即 3
        5. 用1去除1! 得到1余0   ----->  有1个数比它小的数是2，但1,3,4都出现过了，即 5
            最后一个数只能是 2  所以 第16个数是 14352

        再如： 该数组的全排列中的第 100 个排列是什么数找到：
            上面提到过，康托展开是从 0 开始计算的，所以求 100 个排列数的时候应该求的是 99
            12345 作为第一个排列数，每一个数字可以排列的次数是 4!，3!，2!，1!，0!
            用 99 / 24 = 4 ... 3 可以得到第99个排列的第一个数字应该是 array[4] = 5
            第一个数找到之后更新 k 为上一次计算的余数，同时把上一次在数组中找到的数删除，重复以上过程
            最终得到一个数字序列，该序列就是第 100 个排列对应的数据
     */
    public void KTZK2() {
        System.out.println(inverseCantorExpansion(5, 100));//51342
        System.out.println(inverseCantorExpansion(8, 2));// 12345687
    }
    /**
     * 给出 [1,2,3,...,n] 数组以及该数组全排列的第 K 个序列编号，求第 K 个数是啥
     *
     * @param n 数组的最大值
     * @param k 序号
     * @return 第K个数的值
     */
    public static String inverseCantorExpansion(int n, int k) {
        // 先搞一个1~n的数组，用来在里面选择合适的数字加入 ans 中
        ArrayList<Integer> array = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            array.add(i + 1);
        }

        StringBuilder ans = new StringBuilder();
        k -= 1;

        // 执行 n 次循环得到 n 个数，组合成一个答案
        for (int i = 0; i < n; i++) {
            // 计算从 (n-1)! 开始的阶乘
            int Xfactorial = getFactorial2(n - i - 1);
            // 计算获取数组的那一个位置的数字
            int index = k / Xfactorial;
            // 获取该数字
            ans.append(array.get(index));
            // 更新 k 为上一次除法计算的余数
            k %= Xfactorial;
            // 同时更新数组，删除已经获得过的数字
            array.remove(index);
        }
        return ans.toString();
    }

    // 求x的阶乘
    public static int getFactorial2(int x) {
        if (x == 0)
            return 1;
        int res = x;
        for (int i = 1; i < x; i++) {
            res *= i;
        }
        return res;
    }

    /*---------------------------------------------------------------------------------------*/

    @Test
    /*
        蓝桥杯2017模拟赛-排列序列: 康拓展开的 排列序数：
             X星系的某次考古活动发现了史前智能痕迹。这是一些用来计数的符号，经过分析它的计数规律如下：
            （为了表示方便，我们把这些奇怪的符号用a~q代替）
            abcdefghijklmnopq 表示0
            abcdefghijklmnoqp 表示1
            abcdefghijklmnpoq 表示2
            abcdefghijklmnpqo 表示3
            abcdefghijklmnqop 表示4
            abcdefghijklmnqpo 表示5
            abcdefghijklmonpq 表示6
            abcdefghijklmonqp 表示7
      问： 在一处石头上刻的符号是：bckfqlajhemgiodnp ，请你计算出它表示的数字是多少？
     */
    public void KTZK3(){
        int[] f = new int[18];
        int[] dig = {0,2,3,11,6,17,12,1,10,8,5,13,7,9,15,4,14,16}; //将abcd....对应为1,2,3,4...数字
        long sum = 0;
        for(int i = 1;i<dig.length;i++){
            long t = 0;
            for(int j = 1;j<f.length;j++){
                if(j==dig[i]){f[j]=1;break;}
                if(f[j]==0)t++;
            }
            sum+=(t)*f(dig.length-1-i);//此处康托展开式公式
        }
        System.out.println(sum);
    }
    public static long f(long n){

        long s = 1;
        for(int i = 1;i<=n;i++)
            s*=i;
        return s;
    }
}