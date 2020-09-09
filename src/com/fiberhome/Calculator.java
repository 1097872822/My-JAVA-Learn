package com.fiberhome;

/**
 * @description: 计算器swing
 * @author: RRW friend_rrw@163.com
 * @create: 2020-08-19 17:01
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class Calculator {
    String str1 = "0"; // 运算数1 初值一定为0 为了程序的安全
    String str2 = "0"; // 运算数2
    String signal = "+"; // 运算符
    String result = "";// 结果
    // 状态开关
    int k1 = 1;// 开关1 用于选择输入方向 将要写入str2或 str2
    int k2 = 1;// 开关2 符号键 次数 k2>1说明进行的是2+3-9+8 这样的多符号运算
    int k3 = 1;// 开关3 str1 是否可以被清0 ==1时可以 !=1时不能被清0
    int k4 = 1;// 开关4 str2 同上
    int k5 = 1;// 开关5 控制小数点可否被录入 ==1时可以 !=1 输入的小数点被丢掉
    JButton store; // 寄存器 记录 是否连续按下符号键
    @SuppressWarnings("rawtypes")
    Vector vt = new Vector(20, 10);
    JFrame frame = new JFrame("脚本之家 - 计算器");
    JTextField result_TextField = new JTextField(result, 20);// 20列
    JButton clear_Button = new JButton("清除");
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton button_Dian = new JButton(".");
    JButton button_jia = new JButton("+");
    JButton button_jian = new JButton("-");
    JButton button_cheng = new JButton("*");
    JButton button_chu = new JButton("/");
    JButton button_dy = new JButton("=");

    Calculator() {
        button0.setMnemonic(KeyEvent.VK_0);// 等效键
        // 其它 等效键 略,
        result_TextField.setHorizontalAlignment(JTextField.RIGHT);// 文本框 右对齐
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(4, 4, 5, 5));// 四行四列 边距为5像素
        pan.add(button7);
        pan.add(button8);
        pan.add(button9);
        pan.add(button_chu);
        pan.add(button4);
        pan.add(button5);
        pan.add(button6);
        pan.add(button_cheng);
        pan.add(button1);
        pan.add(button2);
        pan.add(button3);
        pan.add(button_jian);
        pan.add(button0);
        pan.add(button_Dian);
        pan.add(button_dy);
        pan.add(button_jia);
        pan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));// pan对象的边距
        JPanel pan2 = new JPanel();
        pan2.setLayout(new BorderLayout());
        pan2.add(result_TextField, BorderLayout.WEST);
        pan2.add(clear_Button, BorderLayout.EAST);
        frame.setLocation(300, 200); // 主窗口 出现在位置
        frame.setResizable(false); // 不能调大小
        frame.getContentPane().setLayout(new BorderLayout());
        frame.getContentPane().add(pan2, BorderLayout.NORTH);
        frame.getContentPane().add(pan, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        // 事件处理 程 序
        // 数 字 键
        class Listener implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                String ss = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();
                vt.add(store);
                if (k1 == 1) {
                    if (k3 == 1) {
                        str1 = "";
                        k5 = 1;// 还原开关k5状态
                    }
                    str1 = str1 + ss;
                    k3 = k3 + 1;
                    result_TextField.setText(str1);// 显示
                } else if (k1 == 2) {
                    if (k4 == 1) {
                        str2 = "";
                        k5 = 1; // 还原开关k5状态
                    }
                    str2 = str2 + ss;
                    k4 = k4 + 1;
                    result_TextField.setText(str2);
                }
            }
        }
        // 符 号
        class Listener_signal implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                String ss2 = ((JButton) e.getSource()).getText();
                store = (JButton) e.getSource();
                vt.add(store);
                if (k2 == 1) {
                    k1 = 2;// 开关 k1 为1时,向数1写 为2时，向数2写
                    k5 = 1;
                    signal = ss2;
                    k2 = k2 + 1;// 按符号键的次数
                } else {
                    int a = vt.size();
                    JButton c = (JButton) vt.get(a - 2);
                    if (!(c.getText().equals("+"))
                            && !(c.getText().equals("-"))
                            && !(c.getText().equals("*"))
                            && !(c.getText().equals("/"))) {
                        cal();
                        str1 = result;
                        k1 = 2;// 开关 k1 为1时,向数1写 为2时，向数2写
                        k5 = 1;
                        k4 = 1;
                        signal = ss2;
                    }
                    k2 = k2 + 1;
                }
            }
        }
        // 清除
        class Listener_clear implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                k5 = 1;
                k2 = 1;
                k1 = 1;
                k3 = 1;
                k4 = 1;
                str1 = "0";
                str2 = "0";
                signal = "";
                result = "";
                result_TextField.setText(result);
                vt.clear();
            }
        }
        // 等 于
        class Listener_dy implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                cal();
                k1 = 1; // 还原开关k1状态
                // str1=result;
                k2 = 1;
                k3 = 1;// 还原开关k3状态
                k4 = 1; // 还原开关k4状态
                str1 = result; // 为7+5=12 +5=17 这种计算做准备
            }
        }
        // 小数点
        class Listener_xiaos implements ActionListener {
            @SuppressWarnings("unchecked")
            public void actionPerformed(ActionEvent e) {
                store = (JButton) e.getSource();
                vt.add(store);
                if (k5 == 1) {
                    String ss2 = ((JButton) e.getSource()).getText();
                    if (k1 == 1) {
                        if (k3 == 1) {
                            str1 = "";
                            k5 = 1; // 还原开关k5状态
                        }
                        str1 = str1 + ss2;
                        k3 = k3 + 1;
                        result_TextField.setText(str1);// 显示
                    } else if (k1 == 2) {
                        if (k4 == 1) {
                            str2 = "";
                            k5 = 1; // 还原开关k5状态
                        }
                        str2 = str2 + ss2;
                        k4 = k4 + 1;
                        result_TextField.setText(str2);
                    }
                }
                k5 = k5 + 1;
            }
        }
        // 注册 监听器
        Listener_dy jt_dy = new Listener_dy();
        Listener jt = new Listener();// 临听数字键
        Listener_signal jt_signal = new Listener_signal();// 临 听符 号键
        Listener_clear jt_c = new Listener_clear(); // 清除键
        Listener_xiaos jt_xs = new Listener_xiaos();// 小数点 键
        button7.addActionListener(jt);
        button8.addActionListener(jt);
        button9.addActionListener(jt);
        button_chu.addActionListener(jt_signal);
        button4.addActionListener(jt);
        button5.addActionListener(jt);
        button6.addActionListener(jt);
        button_cheng.addActionListener(jt_signal);
        button1.addActionListener(jt);
        button2.addActionListener(jt);
        button3.addActionListener(jt);
        button_jian.addActionListener(jt_signal);
        button0.addActionListener(jt);
        button_Dian.addActionListener(jt_xs);
        button_dy.addActionListener(jt_dy);
        button_jia.addActionListener(jt_signal);
        clear_Button.addActionListener(jt_c);
        // 关闭事件处理程序
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    // 计 算
    public void cal() {
        double a2;// 运算数1
        double b2;// 运算数2
        String c = signal;// 运算符
        double result2 = 0;// 结果
        if (c.equals("")) {
            result_TextField.setText("请输入运算符");
        } else {
            if (str1.equals(".")) // 字符串 "." 转换成double型数据时 会出错 所以手工转
                str1 = "0.0";
            if (str2.equals("."))
                str2 = "0.0";
            a2 = Double.valueOf(str1).doubleValue();
            b2 = Double.valueOf(str2).doubleValue();
            if (c.equals("+")) {
                result2 = a2 + b2;
            }
            if (c.equals("-")) {
                result2 = a2 - b2;
            }
            if (c.equals("*")) {
                result2 = a2 * b2;
            }
            if (c.equals("/")) {
                if (b2 == 0) {
                    result2 = 0;
                } else {
                    result2 = a2 / b2;
                }
            }
            result = ((new Double(result2)).toString());
            result_TextField.setText(result);
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // 界面风格，可以去除
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Calculator cal = new Calculator();
    }
}

