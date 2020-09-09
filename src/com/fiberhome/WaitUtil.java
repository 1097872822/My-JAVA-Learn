package com.fiberhome;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 *@description: SwingWorker实现旋转等待提示的功能  旋转等待dialog
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-25 14:06
 */
public class WaitUtil extends JDialog {
    private static final long serialVersionUID = 6987303361741568128L;
    private final JPanel contentPanel = new JPanel();


    /**
     * Create the dialog.
     */
    public WaitUtil() {
        setBounds(0, 0, 550, 280);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);
        {
            JLabel lblLoading = new JLabel("Loading...");
            lblLoading.setForeground(Color.DARK_GRAY);
            lblLoading.setOpaque(false);
            //com/fiberhome/dialoggif/5-130H2191323-52. gif
            lblLoading.setIcon(Imgs.getImage("5-121204193R0-50.gif"));
            lblLoading.setFont(new Font("宋体", Font.PLAIN, 25));
            lblLoading.setBounds(0, 0, 400, 250);
            contentPanel.add(lblLoading);
        }

        setModalityType(ModalityType.APPLICATION_MODAL);    //置顶显示
        setUndecorated(true);   //禁用或启用此窗体的装饰(true:禁用；false:启用)
        setLocationRelativeTo(null);    //设置窗口相对于指定组件的位置(null表示置于屏幕的中央)
    }
}

