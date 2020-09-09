package com.fiberhome;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *@description: 旋转等待 JD
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-25 14:10
 */
public class TestWaitUnit extends JFrame{
        private JPanel contentPane;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        TestWaitUnit frame = new TestWaitUnit();
                        frame.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        /**
         * Create the frame.
         */
        public TestWaitUnit() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 480, 360);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            setContentPane(contentPane);

            int windowWidth = this.getWidth(); //获得窗口宽
            int windowHeight = this.getHeight(); //获得窗口高
            Toolkit kit = Toolkit.getDefaultToolkit(); //定义工具包
            Dimension screenSize = kit.getScreenSize(); //获取屏幕的尺寸
            int screenWidth = screenSize.width; //获取屏幕的宽
            int screenHeight = screenSize.height; //获取屏幕的高
            setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);//设置窗口居中显示

            JPanel panel = new JPanel();
            contentPane.add(panel, BorderLayout.CENTER);

            JButton button = new JButton("测试");
            button.setPreferredSize(new Dimension(100,35));
            button.setBackground(new Color(244,111,22));
            button.setFont(new java.awt.Font("微软雅黑",1,20));
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    //旋转等待显示
                    final WaitUtil waitUtil = new WaitUtil();
                    SwingWorker<String, Void> sw = new SwingWorker<String, Void>() {

                        StringBuffer sb = new StringBuffer();

                        @Override
                        protected String doInBackground() throws Exception {
                            //-------------模拟任务开始---------------
                            for(int i = 0; i < 10000; i++){
                                sb.append("" + i);
                                System.out.println(sb.toString());
                                Thread.sleep(150);
                            }
                            //--------------模拟任务结束--------------
                            return sb.toString();
                        }

                        @Override
                        protected void done() {
                            //将耗时任务执行完得到的结果移至done来进行处理，处理完关闭旋转等待框
                            try {
                                String result = get();
                                System.out.println(result);
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            // 关闭旋转等待框
                            if(waitUtil != null) {
                                waitUtil.dispose();
                            }
                        }
                    };
                    sw.execute();
                    waitUtil.setVisible(true);  //将旋转等待框WaitUnit设置为可见
                }
            });
            panel.add(button);
        }
    }
