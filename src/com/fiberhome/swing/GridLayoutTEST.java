package com.fiberhome.swing;

import javax.swing.*;
import java.awt.*;

/**
 *@description: GridLayout 布局
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-26 15:47
 */
public class GridLayoutTEST {
    public static void main(String[] args) {
        JFrame jf = new JFrame("GridLayout test");
        GridLayout grid = new GridLayout(10, 10);
        jf.setLayout(grid);
        for (int i = 0; i < 100; i++) {
            jf.add(new Button("" + i));
        }
        jf.setSize(640,480);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
