package com.fiberhome.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *@description: 简易计算器
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-26 15:56
 */
public class ComputerTEST {
    public static void main(String[] args) {
        CalFrame comp = new CalFrame();
        comp.show();
    }
}

class CalFrame implements ActionListener {  //窗口类
    private JFrame mainFrame;   //窗口对象
    private JTextField text;  //文本框
    private JButton[] buttons;  //按钮组
    private char modifier = '\0';   //运算符
    private double result;  //计算结果
    private boolean flag = false;  //记录是否点击了运算按钮

    public CalFrame() {
        mainFrame = new JFrame("简易计算器-rrw");  //创建组件
        text = new JTextField();
        buttons = new JButton[16];
        init();
        setFontAndColor();   //设置字体颜色
        addEventHandle();   //添加事件
    }

    private void init() {
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        north.setLayout(new FlowLayout());
        center.setLayout(new GridLayout(4, 4, 2, 2));
        text = new JTextField(55);
        north.add(text);
        String str = "123+456-789*0.=/";  //字符串表示
        for (int i = 0; i < 16; i++) {
            JButton jb = new JButton(String.valueOf(str.charAt(i)));
            buttons[i] = jb;
            center.add(jb);
        }
        mainFrame.add(north, BorderLayout.NORTH);
        mainFrame.add(center, BorderLayout.CENTER);
    }

    public void show() {
        mainFrame.pack();
        mainFrame.setSize(800, 700);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void setFontAndColor() {
        Font f = new Font("黑体", Font.BOLD, 20);
        text.setFont(f);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFont(f);
            buttons[i].setForeground(Color.RED);
        }
    }

    public void addEventHandle() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(this);//为每个按钮添加监听器对象
        }
    }

    //实现ActionListener 接口，即可访问本对象的全部属性
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();  //获取按钮上的文本
        if ("0123456789.".indexOf(str) != -1) {  //输入的是数字
            if (flag) {
                text.setText("");//文本框为空
                flag = false; //回复flag
            }
            text.setText(text.getText() + str);//设置字符
        } else if ("+-*/".indexOf(str) != -1) {  //单击运算符按钮
            modifier = str.charAt(0);
            double num = Double.valueOf(text.getText());
            result = num;
            flag = true;
        } else if (str.charAt(0) == '=') {
            if (modifier == '+') {
                double num = Double.valueOf(text.getText());
                result += num;
            }
            if (modifier == '-') {
                double num = Double.valueOf(text.getText());
                result -= num;
            }
            if (modifier == '*') {
                double num = Double.valueOf(text.getText());
                result *= num;
            }
            if (modifier == '/') {
                double num = Double.valueOf(text.getText());
                result /= num;
            }
            text.setText(result + "");
            modifier = '\0';
            result = 0;
        }
    }
}
