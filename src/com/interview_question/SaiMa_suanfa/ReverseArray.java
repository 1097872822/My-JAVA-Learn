package com.interview_question.SaiMa_suanfa;

import java.util.Arrays;
import java.util.Scanner;

/**
 *@description:  《翻转数组》：
 *      给定一个长度为n的整数数组a，元素均不相同，问数组是否存在这样一个片段，只将该片段翻转就可以使整个数组升序排列。
 *      其中数组片段[l,r]表示序列a[l], a[l+1], ..., a[r]。原始数组为
 *      a[1], a[2], ..., a[l-2], a[l-1], a[l], a[l+1], ..., a[r-1], a[r], a[r+1], a[r+2], ..., a[n-1], a[n]，
 *      将片段[l,r]反序后的数组是
 *      a[1], a[2], ..., a[l-2], a[l-1], a[r], a[r-1], ..., a[l+1], a[l], a[r+1], a[r+2], ..., a[n-1], a[n]。
 *
 *      样例输入            样例输出
 *      4                     yes
 *      2 1 3 4
 *
 *      我的思路：
 *          1.如何通过代码找到 源数据与排序后不同的的数据段；
 *          2.找到后怎么判断只需要一次翻转就能与排序后的数据相同；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-08 13:52
 */
public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int L = scanner.nextInt();
        int[] arr = new int[L];
        int[] copy = new int[L];
        while (scanner.hasNext()){
            int left = 0; int right = L-1;
            //赋值操作：
            for (int i = 0; i < L; i++) {
                arr[i] = scanner.nextInt();
                copy[i] = arr[i];
            }
            Arrays.sort(copy);  //排序
            //找到不同的数据块范围：
            while (left<L && copy[left] == arr[left]) left++;
            while (right>=0 && copy[right] == arr[right]) right--;
            int i=0;
            for (i = 0; i <= right-left; i++) {
                //如果此处没有执行 break； 说明 被翻转块数据是可以通过翻转后与排序数据相等的；
                //同时保证需要翻转的数据的长度跟 i 相同；若 一开始copy[left+i] != arr[right-i]
                //说明至少需要2次翻转才能符合题目要求； 可以使用{1,3,2，5，4}演算一下；
                if (copy[left+i] != arr[right-i]) break;
            }
            if (i > right-left) //如果 i < right-left的话，说明要翻转的块中有至少2次翻转才符合要求；
                System.out.println("yes");
            else System.out.println("no");
        }
    }
}
