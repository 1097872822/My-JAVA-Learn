package com.interview_question.SaiMa_suanfa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *@description: 《向量表示》
 *      小B所在的团队正在开发一个WEB输入内容相似性检测应用，她想到的一种方法是统计用户输入内容中不同单词的出现频率，
 *      据此建立一个向量表示用户输入的内容。用户输入的内容已经经过过滤处理，只剩下单词和空格，没有标点符号。
 *      各个单词出现频率按从小到大的顺序排列后，即构成了用户输入内容的向量表示。
 *      由于用户输入的内容可能很长，单靠人力完全无法找出来。因此小B希望你能帮忙编写一个程序，输出用户内容的向量表达。
 *
 *      输入包括若干行文本数据，每行表示一个用户输入文档。一行文本由单词和空格组成，单词之间由空格分隔，最多不超过10000个ASCII码字符。
 *      对于每个用户输入文档，输出一行向量表示，数值之间用空格分隔。
 *          样例输入                    样例输出
 *          a bd a d                    1 1 2
 *          b abc b a a                 1 2 2
 *
 *      思路分析：使用特定数据结构记录重复key
 *             （1）使用HashMap记录重复key，存取效率高，方便。且map可以单独获取key或value的集合。
 *             （2）使用String的字符串分割方法
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-10 16:02
 */
public class VectorRepresentation {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String line=s.nextLine();//定义输入的一行字符串
            String[] strs=line.split(" ");//以空格分割字符串，成为字符串数组
            Map<String,Integer> map=new HashMap<String,Integer>();//创建Map对象，此处用到了泛型
        /*
              遍历行字符串数组，并放入map键值对中，循环体中先用map.containsKey(Object key)方法判断key是否
                     是在此map中存在的键，如果不存在，建立新的键值对，如果存在，在旧的键值对的值中+1
        */
            for(String st:strs){
                if(map.containsKey(st)){
                    map.put(st, map.get(st)+1);
                }else{
                    map.put(st, 1);
                }
            }
            //把map值取出用map.values()方法,再转成数组
        /*
        知识拓展：toArray(new Integer[0])是指返回的数组类型是Integer类型的
        如果只写list.toArray()，需要类型强转，返回类型是Object[]
                     如果写list.toArray(new Integer[5])，就不用类型强转了，返回类型是Integer[][]
        里的参数的长度应当小于等于实际长度，因为长度不足的话，会自动补上，而如果长度太长的话就
                     会输出null了，所以一般写实际长度或直接写0，就不会出错。
        */
//            Integer[] counts=map.values().toArray(new Integer[0]);
//            Arrays.sort(counts);//给取出来的map值排序
//            String ans=""+counts[0];//定义输出的答案数组
//            for(Integer i=1;i<counts.length;i++){
//                ans+=" "+counts[i];
//            }
//            System.out.println(ans);

            //即也可以这么写：
                //返回value集合
             Object[] counts = map.values().toArray();
             Arrays.sort(counts); //排序

           //输出前先建造打印结果
            StringBuilder build = new StringBuilder(""+counts[0]);
            for(int i=1;i<counts.length;i++) {
               build.append(" "+counts[i]);
           }
           System.out.println(build.toString());
        }
    }
}
