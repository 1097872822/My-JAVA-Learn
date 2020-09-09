package com.fiberhome;

import javax.swing.*;
import java.awt.*;

/**
 * @description:
 * @author: RRW friend_rrw@163.com
 * @create: 2020-08-19 20:30
 */
public class Calculator3 extends JPanel {
    private Image image = null;

    public Calculator3(Image image) {
        this.image = image;
    }

    // 固定背景图片，允许这个JPanel可以在图片上添加其他组件
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}