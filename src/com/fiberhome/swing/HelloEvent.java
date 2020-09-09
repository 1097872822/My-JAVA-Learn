package com.fiberhome.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *@description: 捕获事件
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-26 15:25
 */
public class HelloEvent {
    private static JTextField text = new JTextField(10);
    public static void main(String[] args) {
        JFrame jf = new JFrame("Hello");  //创建JFrame对象
        jf.setLayout(new FlowLayout());	  //设置布局格式
        //为窗口增加文本框
        jf.add(text);
        //为窗口增加按钮
        JButton btn = new JButton("点我"); //按钮对象
        jf.add(btn);
        btn.addActionListener(new ActionListener(){
            //添加事件：
            //定义回调方法：
            public void actionPerformed(ActionEvent e){
                HelloEvent.text.setText("按钮被点击"); //动作

            }
        });
        showMe(jf);

    }
    private static void showMe(JFrame jf){
        //设置窗口在关闭时，程序响应
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,400);  //设置窗口大小
        jf.setVisible(true);  //是否可见
    }
}
