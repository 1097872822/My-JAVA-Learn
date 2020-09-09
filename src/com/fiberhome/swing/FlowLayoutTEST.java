package com.fiberhome.swing;

import javax.swing.*;
import java.awt.*;

/**
 *@description: FlowLayout布局
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-26 15:46
 */
public class FlowLayoutTEST {
    public static void main(String[] args) {
        JFrame jf = new JFrame("FlowLayout test");
        jf.setLayout(new FlowLayout());  //设置布局器
        for (int i = 0; i < 121; i++) {
            jf.add(new JButton(i + ""));  //添加121个按钮
        }
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //默认隐藏但不停止程序
    }
}
