package com.fiberhome;

import javax.swing.*;

/**
 * @description: 较为简单的进度条
 * @author: RRW friend_rrw@163.com
 * @create: 2020-08-24 20:50
 */
public class jindutiao4 {
    public static void main(String args[]) {
        JFrame jframe = new JFrame("进度条");  //窗口
        jframe.setSize(450, 100);   //设置窗口大小
        JPanel jpanel1 = new JPanel();  //面板
        JButton jbutton1 = new JButton("完成");
        jbutton1.setEnabled(false);   //设置按钮不可用，为灰色
        JLabel jlabel1 = new JLabel("当前进度:");

        JProgressBar jprogressbar1 = new JProgressBar();  //创建进度条
        jprogressbar1.setMaximum(100);
        jprogressbar1.setMinimum(0);

        jpanel1.add(jlabel1);
        jpanel1.add(jprogressbar1); //添加进度条
        jpanel1.add(jbutton1);   //添加按钮
        jframe.add(jpanel1);   //添加面板

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭时操作
        jframe.setVisible(true);   //设置可见

        try {
            int i = 0;    //计数器
            for (; i <= 100; i++)  //从0到100
            {
                if (i == 100) {
                    jbutton1.setEnabled(true); //进度条满了设置按钮可用
                }
                jprogressbar1.setValue(i);  //设置进度条的当前值
                Thread.sleep(50);      //堵塞50毫秒
            }
        } catch (InterruptedException e) {
        }
    }
}

