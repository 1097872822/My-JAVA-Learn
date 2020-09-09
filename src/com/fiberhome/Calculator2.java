package com.fiberhome;

import javax.swing.*;
import java.awt.*;

/**
 *@description: 计算器2
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-19 20:26
 */
public class Calculator2 {
    private String str="";//输入输出框内容
    private JTextField text_input;//输出框
    private JPanel jp_bottomArea;//按钮区域
    private String []addsButtonString={"1","2","3","+","4","5","6","-","7","8","9","*",".","0","求根","/","=","取反","AC"};
    public Calculator2(){
        //初始化窗体
        JFrame frame=new JFrame("计算器");
        Container c=frame.getContentPane();
        c.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));//设置排布方式为Y轴排列

        frame.setLocation(200,300);//设置位置
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        text_input=new JTextField(30);
        text_input.setHorizontalAlignment(JTextField.RIGHT);
        JPanel jPanel=new JPanel(new GridLayout(1,1,10,10));
        jPanel.add(text_input);
        c.add(jPanel);

        GridBagLayout gridBagLayout=new GridBagLayout();
        GridBagConstraints cs=new GridBagConstraints();
        jp_bottomArea=new JPanel();
        jp_bottomArea.setLayout(gridBagLayout);
        for(int i=0;i<addsButtonString.length;i++){
            if((i+1)%4==0){
                cs.gridwidth=GridBagConstraints.REMAINDER;
            }else if(addsButtonString[i].equals("=")){
                cs.gridwidth=2;
            }else {
                cs.fill=GridBagConstraints.BOTH;
                cs.weightx=1.0;
                cs.gridwidth=1;
            }
            JButton btn = new JButton(addsButtonString[i]);
            gridBagLayout.setConstraints(btn,cs);
            btn.addActionListener(e -> {
                String command = e.getActionCommand();
                setShowTextFiledNew(command);
            });
            jp_bottomArea.add(btn);
        }
        c.add(jp_bottomArea);

        frame.pack();

    }
    /**
     * 设置显示内容窗格
     * @param command 按钮点击命令
     * 如果按下等于，则执行计算
     * 如果按下运算符，则格式为 空格+运算符+空格
     * 如果按下时数字，则直接拼接
     * */
    public void setShowTextFiledNew(String command){
        if(command.equals("=")){
            str=getResult(str);
        }else if(command.equals("+")||command.equals("-")||command.equals("*")||command.equals("/")||command.equals("求根")||command.equals("取反")){
            str=str+" "+command+" ";
        }else if(command.equals("AC")){
            str="";
        }else {
            str=str+command;
        }
        text_input.setText(str);
    }
    /**
     * 计算
     * @param str 需要计算的字符串
     * 根据空格进行分割成字符串数组
     * 然后判断是哪种类型的运算符并进行计算
     * 通过一个result来存放最终结果
     * */
    public String getResult(String str){
        Double result=0.0;
        String []need_to_do=str.split(" ");
        for(int i=0;i<need_to_do.length;i++){
            switch (need_to_do[i]){
                case "+":
                    result=result+(Double.parseDouble(need_to_do[i-1])+Double.parseDouble(need_to_do[i+1]));
                    break;
                case "-":
                    result=result+(Double.parseDouble(need_to_do[i-1])-Double.parseDouble(need_to_do[i+1]));
                    break;
                case "*":
                    result=result+(Double.parseDouble(need_to_do[i-1])*Double.parseDouble(need_to_do[i+1]));
                    break;
                case "/":
                    result=result+(Double.parseDouble(need_to_do[i-1])/Double.parseDouble(need_to_do[i+1]));
                    break;
                case "求根":
                    result=result+(Math.sqrt(Double.parseDouble(need_to_do[i-1])));
                    break;
                case "取反":
                    result=result+(-Double.parseDouble(need_to_do[i-1]));
                    break;
            }

        }
        return result+"";
    }


    public static void main(String[] args) {
        new Calculator2();
    }
}
