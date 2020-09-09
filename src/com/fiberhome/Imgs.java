package com.fiberhome;

import javax.swing.*;
import java.awt.*;

/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-25 14:15
 */
public class Imgs {
    public static ImageIcon getImage(String filename){
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(Imgs.class.getResource(filename)));
    }
}
