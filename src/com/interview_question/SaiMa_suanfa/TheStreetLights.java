package com.interview_question.SaiMa_suanfa;

import java.util.Scanner;

/**
 *@description: 《马路上的灯》：
 *      城市E的马路上有很多路灯，每两个相邻路灯之间的间隔都是1公里。小赛是城市E的领导，为了使E城市更快更好的发展，
 *      需要在城市E的一段长度为M的主干道上的一些区域建地铁。这些区域要是建了地铁，就需要挪走相应的路灯。
 *      可以把长度为M的主干道看成一个数轴，一端在数轴0的位置，另一端在M的位置；数轴上的每个整数点都有一个路灯。
 *      要建地铁的这些区域可以用它们在数轴上的起始点和终止点表示，已知任一区域的起始点和终止点的坐标都是整数，
 *      区域之间可能有重合的部分。现在要把这些区域中的路灯（包括区域端点处的两个路灯）移走。
 *      你能帮助小赛计算一下，将这些路灯移走后，马路上还有多少路灯？
 *
 *      输入文件的第一行有两个整数M（马路长度）和 N（区域个数）：
 *          样例输入        样例输出
 *          500 3           298
 *          100 200
 *          150 300
 *          360 361
 *
 *        思路技巧：
 *          可以通过画一条数轴表示，发现输入的区域数据有包括部分，且可以使用标记 “1”标记每个区域是否已经
 *          移走了路灯，即使包括，只会标记成 “1” ，固最后判断 0-M 上 没有被标记的点的数量即可；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-09 11:48
 */
public class TheStreetLights {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[] roled = new int[M+1];
        for (int i = 0; i < N; i++) {
            int x =scanner.nextInt();
            int y =scanner.nextInt();
            for (int k = x; k <= y ; k++) {
                roled[k] = 1;
            }
        }
        int sum = 0;
        for (int i = 0; i <= M; i++) {
            if (roled[i] != 1){
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}



