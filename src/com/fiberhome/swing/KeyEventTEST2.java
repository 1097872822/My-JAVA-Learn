package com.fiberhome.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *@description: 监视器 & 适配器
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-26 15:52
 */
public class KeyEventTEST2 {
    public static void main(String[] args) {
        JFrame jf = new JFrame("events TEST"); // JF对象
        jf.setLayout(new FlowLayout());  //设置布局管理器
        JTextField jtf = new JTextField(15); //创建文本输入框
        jf.add(jtf);  //把输入框添加到 JFrame中
        jtf.addKeyListener(new KeyAdapter() {  //添加监听器
            @Override
            public void keyTyped(KeyEvent e) {  //事件1
                System.out.print(e.getKeyChar());  //实现
            }
        });
        showMe(jf);  //展示
    }
    private static void showMe(JFrame jf){
        //设置关闭时，程序的响应:
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,400);
        jf.setVisible(true);
    }
}
