package com.fiberhome.swing;

import javax.swing.*;
import java.awt.*;

/**
 *@description: BorderLayout 布局
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-26 15:32
 */
public class BorderLayoutTEST {
    public static void main(String[] args) {
        JFrame jf = new JFrame("BigDecimal TEST");
        jf.setLayout(new BorderLayout());  //布局样式
        jf.add(new JButton("east"),BorderLayout.EAST);
        jf.add(new JButton("center"),BorderLayout.CENTER);
        jf.add(new JButton("south"),BorderLayout.SOUTH);
        jf.add(new JButton("west"),BorderLayout.WEST);
        jf.add(new JButton("north"),BorderLayout.NORTH);
        jf.setSize(500,500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
