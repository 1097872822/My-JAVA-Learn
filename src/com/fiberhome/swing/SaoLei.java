package com.fiberhome.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *@description: 扫雷大战
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-26 15:54
 */
public class SaoLei extends MouseAdapter {  //主类继承MouseAdapter
    private JFrame mainFrame;  // 窗口对象
    private int[][] data; //数据数组
    private JButton[][] buttons;   //按钮数组
    private JButton startJB;  //开始按钮
    private Label l;  //标签
    private int row;  //行
    private int col;  //列
    private int minNumber;  //雷数
    private int minCount;  //当前被扫出数
    private boolean isOver;  //游戏结束

    public SaoLei() {  //构造方法
        row = 10;
        col = 10;
        mainFrame = new JFrame("扫雷大战_RRW");  //窗口对象
        data = new int[row][col];  //数组数据
        buttons = new JButton[row][col]; //按钮数据
        startJB = new JButton("start game");  //开始按钮
        l = new Label("welcome to saolei-1");  //初始化标签
        minNumber = row * col / 8;  //雷的数量是总格子数的 1/8
    }

    public void init() {  //初始化方法
        JPanel north = new JPanel();
        JPanel center = new JPanel();
        JPanel south = new JPanel();
        north.setLayout(new FlowLayout());  //布局
        center.setLayout(new FlowLayout());
        south.setLayout(new GridLayout(row, col, 4, 4));  //雷区布局
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(north, BorderLayout.NORTH);  //分别添加面板
        mainFrame.add(center, BorderLayout.CENTER);
        mainFrame.add(south, BorderLayout.SOUTH);
        north.add(l);   //添加标签
        startJB.addActionListener(new ActionListener() {  //开始按钮监听器
            @Override
            //重新游戏
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        buttons[i][j].setText(" ");
                        buttons[i][j].setBackground(Color.WHITE);
                        data[i][j] = 0;
                        isOver = false;
                    }
                }
                hashMine();
                minCount = 0;
                l.setText("Les't go");
            }
        });
        center.add(startJB);
        for (int i = 0; i < row; i++) {  //初始化按钮信息
            for (int j = 0; j < col; j++) {
                buttons[i][j] = new JButton(" ");
                buttons[i][j].setName((i + ":" + j)); //按钮名字记录行列号
//                buttons[i][j].setSize(10,30);
                buttons[i][j].setBackground(Color.WHITE);
                buttons[i][j].addMouseListener(this);
                south.add(buttons[i][j]);
            }
        }
        hashMine();   //随机布局类
    }

    public void start() {
        mainFrame.setSize(800, 450);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    public void hashMine() {  //随机布局方法
        //得到随机数，确定类的位置
        for (int i = 0; i < minNumber; i++) {
            data[(int) (Math.random() * row)][(int) (Math.random() * col)] = -1;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (data[i][j] == -1)
                    continue;
                int sum = 0;  //每个格子周围雷个数
                for (int m = -1; m <= 1; m++) {
                    for (int n = -1; n <= 1; n++) {
                        if (i + m >= 0 && j + n >= 0 && i + m < row && j + n < col) {
                            if (data[i + m][j + n] == -1)
                                sum++;
                        }
                    }
                }
                data[i][j] = sum;
            }
        }
    }

    private void gameOver(boolean over) {
        if (over == true) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (data[i][j] == -1) {
                        buttons[i][j].setText("M");
                        buttons[i][j].setBackground(Color.RED);
                    }
                }
            }
            l.setText("gg-_-");
            isOver = true;
            return;
        }
        int sumPress = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!buttons[i][j].getText().equals(" ")) {
                    sumPress++;
                }
            }
        }
        if (sumPress == row * col) {
            int sum = 0;  //被找出的雷个数
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (data[i][j] == -1 && buttons[i][j].getText().equals("M")) {
                        sum++;
                    }
                }
            }
            if (sum >= minNumber) {
                System.out.println(minNumber);
                l.setText("WIN~");
            }

        }
    }

    public void mousePressed(MouseEvent e) {
        //实现mouselistner 中的方法，监听单击事件
        try {
            if (isOver) return;
            if (e.getButton() == MouseEvent.BUTTON3) {   //右击
                JButton jb = (JButton) e.getSource(); //获取被点击按钮对象
                if (jb.getText().equals("M")) {  //取消标志
                    jb.setText(" ");
                    minCount--;
                    jb.setBackground(Color.WHITE);
                } else {
                    if (minCount < minNumber) {   //还有标志
                        jb.setText("M");
                        jb.setBackground(Color.BLUE);
                        minCount++;
                    } else {
                        l.setText("标志用完");
                    }
                }
            } else {
                JButton jb = (JButton) e.getSource();
                mousePress(jb); //调用方法处理左击事件
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        gameOver(false); //游戏结束
    }

    private void mousePress(JButton jb) {
        String str[] = jb.getName().split(":");
        int i = Integer.parseInt(str[0]);
        int j = Integer.parseInt(str[1]);
        if (data[i][j] == -1) {
            gameOver(true);
            return;
        } else {
            jb.setText(data[i][j] + ""); //设置文本颜色
            jb.setBackground(Color.YELLOW);
            if (data[i][j] == 0) {
                for (int m = 0; m <= 1; m++) {
                    for (int n = 0; n <= 1; n++) {
                        if (i + m >= 0 && j + n >= 0 && i + m < row && j + n < col) {
                            if (buttons[i + m][j + n].getText().equals(" "))
                                mousePress(buttons[i + m][j + n]);  //撬开旁边的按钮
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SaoLei saolei = new SaoLei();
        saolei.init();
        saolei.start();
    }
}