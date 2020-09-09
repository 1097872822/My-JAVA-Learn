package com.fiberhome;

import javax.swing.*;
import java.awt.*;

/**
 *@description: JFrame窗口
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-18 15:13
 */
public class JFrametest extends JFrame {
    public static void main(String[] args) {
        JFrame  jf = new JFrame();
        jf.setBounds(200,200,200,200);
        JPanel jp = new JPanel();
        JLabel jl = new JLabel();
        jp.setBackground(Color.red);
        jp.add(jl);
        jf.add(jp);
        jf.setVisible(true);
    }
}
