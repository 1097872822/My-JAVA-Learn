package com.fiberhome;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2020-08-24 20:09
 */
public class jindutiao extends JFrame {
    public jindutiao() {
        this.setTitle("100%进度使用");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 250, 200);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(contentPane);
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        final JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        new Thread() {
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progressBar.setValue(i);
                }
                progressBar.setString("加载完成！");
            }
        }.start();
        contentPane.add(progressBar);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        jindutiao example = new jindutiao();
    }
}

