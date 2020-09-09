package com.fiberhome;

import javax.swing.*;
import java.awt.*;

/**
 *@description: "菊花"圈测试  旋转等待dialog
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-25 13:49
 */
public class JUHUA {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        juhuaquan2 glasspane =  new juhuaquan2();
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        glasspane.setBounds(200, 200, (dimension.width) / 2, (dimension.height) / 2);
        frame.setGlassPane(glasspane);
        glasspane.start();//开始动画加载效果
        frame.setVisible(true);

// Later, to disable,在合适的地方关闭动画效果
        glasspane.stop();
    }
}
