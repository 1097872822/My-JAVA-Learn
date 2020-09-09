package com.fiberhome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-19 20:34
 */
public class Calculator33 implements ActionListener{
    private JFrame f;
    private JPanel mp;
    //定义两个文本框用来显示算式和结果
    private JTextField show,showexp;
    //定义数字按钮
    private JButton zero,one,two,three,four,five,six,seven,eight,nine;
    //定义控制按钮
    private JButton CE,C,del,point,neg;
    //定义运算符号按钮
    private JButton div,mul,plus,minus,eql;
    //定义算式的字符串表示
    private String exp,outcome;

    public static void main(String[] args) {
        Calculator33 c=new Calculator33();
        c.display();
    }
    //在构造函数中初始化控件和变量
    Calculator33()
    {
        f=new JFrame("Calculator33");
        Image image=new ImageIcon("D:\\桌面的东西\\壁纸\\4v3yzp.png").getImage(); //添加背景图片
        mp=new Calculator3(image);
        show=new JTextField("0");//创建单行文本控件
        showexp=new JTextField();
        zero=new JButton("0");//创建按钮
        one=new JButton("1");
        two=new JButton("2");
        three=new JButton("3");
        four=new JButton("4");
        five=new JButton("5");
        six=new JButton("6");
        seven=new JButton("7");
        eight=new JButton("8");
        nine=new JButton("9");
        CE=new JButton("CE");
        C=new JButton("C");
        del=new JButton("DEL");
        plus=new JButton("+");
        minus=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        neg=new JButton("+/-");
        point=new JButton(".");
        eql=new JButton("=");
        exp=outcome="";//初始设置存储算式和结果的字符串为空串
    }

    public void display()
    {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭就退出程序

        //设置显示结果的单行文本框相关属性
        show.setFont(new Font(Font.SERIF, Font.BOLD, 40));//设置字体样式
        show.setBorder(BorderFactory.createEmptyBorder());//设置单行文本控件无边框
        show.setHorizontalAlignment(SwingConstants.RIGHT);//设置文本靠右显示
        show.setEnabled(false);//设置单行文本框不能点击
        showexp.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        showexp.setBorder(BorderFactory.createEmptyBorder());
        showexp.setHorizontalAlignment(SwingConstants.RIGHT);
        showexp.setEnabled(false);
        //设置按钮为透明
        CE.setForeground(Color.BLUE);//设置按钮字体颜色为蓝色
        CE.setFont(new Font(Font.SERIF, Font.BOLD, 16));//设置按钮字体样式
        CE.setContentAreaFilled(false);//设置按钮为透明效果
        C.setForeground(Color.BLUE);
        C.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        C.setContentAreaFilled(false);
        div.setForeground(Color.BLUE);
        div.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        div.setContentAreaFilled(false);
        mul.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        mul.setForeground(Color.BLUE);
        mul.setContentAreaFilled(false);
        plus.setForeground(Color.BLUE);
        plus.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        plus.setContentAreaFilled(false);
        minus.setForeground(Color.BLUE);
        minus.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        minus.setContentAreaFilled(false);
        point.setForeground(Color.BLUE);
        point.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        point.setContentAreaFilled(false);
        del.setForeground(Color.BLUE);
        del.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        del.setContentAreaFilled(false);
        eql.setForeground(Color.BLUE);
        eql.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        eql.setContentAreaFilled(false);
        zero.setForeground(Color.BLUE);
        zero.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        zero.setContentAreaFilled(false);
        one.setForeground(Color.BLUE);
        one.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        one.setContentAreaFilled(false);
        two.setForeground(Color.BLUE);
        two.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        two.setContentAreaFilled(false);
        three.setForeground(Color.BLUE);
        three.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        three.setContentAreaFilled(false);
        four.setForeground(Color.BLUE);
        four.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        four.setContentAreaFilled(false);
        five.setForeground(Color.BLUE);
        five.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        five.setContentAreaFilled(false);
        six.setForeground(Color.BLUE);
        six.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        six.setContentAreaFilled(false);
        seven.setForeground(Color.BLUE);
        seven.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        seven.setContentAreaFilled(false);
        eight.setForeground(Color.BLUE);
        eight.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        eight.setContentAreaFilled(false);
        nine.setForeground(Color.BLUE);
        nine.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        nine.setContentAreaFilled(false);
        neg.setForeground(Color.BLUE);
        neg.setFont(new Font(Font.SERIF, Font.BOLD, 16));
        neg.setContentAreaFilled(false);

        //为按钮添加监听事件
        CE.addActionListener(this);
        C.addActionListener(this);
        del.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        point.addActionListener(this);
        neg.addActionListener(this);
        eql.addActionListener(this);
        zero.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);

        //设置网格布袋布局
        GridBagLayout gblayout=new GridBagLayout();
        mp.setLayout(gblayout);
        GridBagConstraints g=new GridBagConstraints();
        g.fill=GridBagConstraints.BOTH;//设置当某个单元格未填满时填满整个空间
        g.weightx=1.0;//设置窗口变大时缩放比例
        g.weighty=1.0;
        g.gridx=0;//定位在第一行第一列
        g.gridy=0;
        g.gridwidth=GridBagConstraints.REMAINDER;//填满整行
        g.gridheight=1;//占一行网格
        g.insets=new Insets(5, 5, 0, 5);//设置该组件与其它组件的距离
        gblayout.setConstraints(showexp, g);//将上述
        g.gridx=0;
        g.gridy=1;
        g.gridheight=2;
        g.insets=new Insets(0, 5, 5, 5);
        gblayout.setConstraints(show, g);

        g.insets=new Insets(5, 5, 5, 5);
        g.gridwidth=1;
        g.gridheight=1;

        g.gridy=3;
        g.gridx=0;
        gblayout.setConstraints(CE, g);
        g.gridx=1;
        gblayout.setConstraints(C, g);
        g.gridx=2;
        gblayout.setConstraints(del, g);
        g.gridx=3;
        gblayout.setConstraints(div, g);

        g.gridy=4;
        g.gridx=0;
        gblayout.setConstraints(seven, g);
        g.gridx=1;
        gblayout.setConstraints(eight, g);
        g.gridx=2;
        gblayout.setConstraints(nine, g);
        g.gridx=3;
        gblayout.setConstraints(mul, g);

        g.gridy=5;
        g.gridx=0;
        gblayout.setConstraints(four, g);
        g.gridx=1;
        gblayout.setConstraints(five, g);
        g.gridx=2;
        gblayout.setConstraints(six, g);
        g.gridx=3;
        gblayout.setConstraints(minus, g);

        g.gridy=6;
        g.gridx=0;
        gblayout.setConstraints(one, g);
        g.gridx=1;
        gblayout.setConstraints(two, g);
        g.gridx=2;
        gblayout.setConstraints(three, g);
        g.gridx=3;
        gblayout.setConstraints(plus, g);

        g.gridy=7;
        g.gridx=0;
        gblayout.setConstraints(neg, g);
        g.gridx=1;
        gblayout.setConstraints(zero, g);
        g.gridx=2;
        gblayout.setConstraints(point, g);
        g.gridx=3;
        gblayout.setConstraints(eql, g);

        mp.add(showexp);
        mp.add(show);
        mp.add(CE);
        mp.add(C);
        mp.add(del);
        mp.add(div);
        mp.add(seven);
        mp.add(eight);
        mp.add(nine);
        mp.add(mul);
        mp.add(four);
        mp.add(five);
        mp.add(six);
        mp.add(minus);
        mp.add(one);
        mp.add(two);
        mp.add(three);
        mp.add(plus);
        mp.add(neg);
        mp.add(zero);
        mp.add(point);
        mp.add(eql);

        f.setContentPane(mp);
        f.setSize(440, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        outcome="";
        if((e.getSource())==CE){//清除最后一个输入的操作数
            int pos=posOfLastOperator(exp);//获取最后一个运算符的位置
            if(pos>=0)
                exp=exp.substring(0, pos+1);
            else//只有一个操作数直接清空
                exp="0";
            show.setText(exp);
        }
        else if((e.getSource())==C) {//清空算式
            exp="0";
            show.setText(exp);
        }
        else if((e.getSource())==del) {
            //提取字符串开始到倒数第二个字符
            exp=exp.substring(0, exp.length()-1);
            if(exp.length()==0)//删除全部的输入后设置显示0
                exp="0";
            show.setText(exp);
        }
        else if((e.getSource())==plus||(e.getSource())==minus||(e.getSource())==mul||(e.getSource())==div) {
            if(exp.length()!=0&&(!isOperator(exp.charAt(exp.length()-1))))//确认必须有数字才能输入运算符
                exp+=e.getActionCommand();
            show.setText(exp);
        }
        else if((e.getSource())==neg) {
            int pos=posOfLastOperator(exp);
            if(pos>=0)//算符中存在多个操作数
            {
                if(isDigit(exp.charAt(exp.length()-1)))//只有有数字才能置为负数
                    exp=exp.substring(0, pos+1)+"(-"+exp.substring(pos+1)+")";//设置为负数时加上括号以区分与减号
            }
            else//只有一个操作数
            {
                if(exp!=""&&isDigit(exp.charAt(exp.length()-1)))
                    exp="-"+exp;
            }
            if(exp=="")//设置当算式为空时显示0
                exp="0";
            show.setText(exp);
        }
        else if((e.getSource())==eql) {
            exp+='#';//算式末尾添加’#’
            //从算式中拆分出数字
            String []nums=exp.split("[^.0-9]");
            List<Double> numLst = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {//将每个数字串转化为Double类型
                if (!"".equals(nums[i]))
                    numLst.add(Double.parseDouble(nums[i]));
            }
            double out=getValueOfMid(exp, numLst);//利用中缀式求值
            outcome=""+out;//将求得的结果转为字符串
            exp=exp.substring(0,exp.length()-1);//去除算式后的’#’
            showexp.setText(exp);//第一个单行文本框展示算式
            show.setText(outcome);//第二个单行文本框显示结果
            exp="";//存储算式的字符串清空
        }
        else if((e.getSource())==point) {
            int pos=exp.lastIndexOf('.');//找到最后一个小数点的位置

            if(pos>=0)//前后两个小数点间不能都是数字，即不能2.33时又添加一个小数点变为2.33.
            {
                if(isDigit(exp.charAt(exp.length()-1))&&!isDigitSring(exp.substring(pos+1)))
                    exp+=e.getActionCommand();
            }
            else {//小数点前一个必须是数字
                if(isDigit(exp.charAt(exp.length()-1)))
                    exp+=e.getActionCommand();
            }
            show.setText(exp);
        }
        else {
            if(exp=="0")
                exp="";
            exp+=e.getActionCommand();
            show.setText(exp);
        }
    }

    public static boolean isDigit(char ch)//判断一个字符是否为数字
    {
        return (ch >= '0'&&ch <= '9');
    }

    public  boolean isDigitSring(String s)//判断一个字符是否都为数字
    {
        for(int i=0;i<s.length();i++)
        {
            if(!isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public boolean isOperator(char c)//判断一个字符是否为运算符或’.’
    {
        return (c=='+')||(c=='-')||(c=='*')||(c=='/')||(c=='.');
    }

    public int posOfLastOperator(String s)//寻找字符串中最后一个运算符(+,-,*,/)的位置
    {
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)!='.'&&isOperator(s.charAt(i)))
                return i;
        }
        return -1;//找不到返回-1
    }

    public static int isp(char ch)//定义栈中运算符优先级，并将相应算符的优先级返回
    {
        switch (ch)
        {
            case')':return 4;
            case'*':return 3;
            case'/':return 3;
            case'+':return 2;
            case'-':return 2;
            case'(':return 1;
            case'#':return 0;
        }
        return -1;
    }

    public static int icp(char ch)//定义栈外运算符优先级，并将相应算符的优先级返回
    {
        switch (ch)
        {
            case')':return 1;
            case'*':return 3;
            case'/':return 3;
            case'+':return 2;
            case'-':return 2;
            case'(':return 4;
            case'#':return 0;
        }
        return 0;
    }

    public static double compute(double a,char ch,double b)//将取出的两个操作数与对应的算符进行计算并返回计算结果
    {
        switch (ch)
        {
            case '+':return a + b;
            case '-':return a - b;
            case '*':return a * b;
            case '/':return a / b;
            default:break;
        }
        return 0;
    }
    //对输入的算式（中缀式）进行求值
    public static double getValueOfMid(String exp, List<Double> numLst)
    {
        Stack<Character> OPTR = new Stack<>();//定义算符栈
        Stack<Double> OPND = new Stack<>();//定义操作数栈
        double outcome=0;//最终结果
        double a,b;//定义两个操作数
        char sym;//定义运算符
        OPTR.push('#');
        int i=0,j=0;
        while(exp.charAt(i)!='#'||OPTR.peek()!='#')
        {
            if(isDigit(exp.charAt(i)))//遍历到数字时则跳过数字字符串，并将之前划分的double类型数据代替压栈
            {
                while(isDigit(exp.charAt(i))||exp.charAt(i)=='.')
                {
                    i++;
                    if(i==exp.length())
                        break;
                }
                i--;
                OPND.push(numLst.get(j));
                j++;
            }
            else
            {
                sym=OPTR.peek();
                int m=isp(sym);
                int n=icp(exp.charAt(i));
                if(m<n)//比较栈内和栈外运算符的优先级
                    OPTR.push(exp.charAt(i));//栈内算符优先级小于栈外，则栈外运算符压栈
                else//栈内运算符优先级大于栈外运算符优先级
                {
                    sym = OPTR.peek();
                    OPTR.pop();//取出栈内的运算符
                    if (sym != '('&&m == n || m>n)
                    {
                        b = OPND.peek();//从操作数栈取出一个操作数
                        OPND.pop();
                        if (!OPND.empty()&&OPTR.peek()!='(')//当操作数栈不为空且不为’(’时继续取出栈中的数进行运算
                        {
                            a = OPND.peek();
                            OPND.pop();
                            OPND.push(compute(a, sym, b));
                            continue;
                        }
                        else//处理负数
                        {
                            switch (sym)//实现一元运算符的运算
                            {
                                case '+':OPND.push(b); break;
                                case '-':OPND.push(-b);break;
                            }
                            continue;
                        }
                    }
                }
            }
            i++;
        }
        outcome=OPND.peek();
        return outcome;
    }
}
