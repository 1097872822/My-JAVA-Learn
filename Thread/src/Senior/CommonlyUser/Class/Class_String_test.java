package Senior.CommonlyUser.Class;

import org.junit.jupiter.api.Test;

/**
 *@description:  String使用：实例化方式；
 *          1.其被声明为final 不可继承；
 *          2.String实现了Serializable接口，表示字符串支持序列化；
 *                  实现Comparable接口，可以比较大小；
 *          3.内部定义了final char[] value用于存储字符串数据；
 *          4.其表示不可变的字符序列： 不可变性(即使在其后连接其他字符，或者replace()等
 *                                          只要字符不一样，还是会给你新造一个);
 *          面试题： String s = new String("123");方式创建了（内存区）几个对象；
 *                 1.一个是堆空间中的new结构；
 *                 2.一个是char型数组char[]在常量池中的值“123”；
 *
 *          总结：
 *              1、常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量；
 *              2、只要其中有一个是变量，结果就在堆中；
 *              3、如果拼接的结果调用intern()方法，返回值就在常量池中；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-08 13:42
 */
public class Class_String_test {

    @Test//字面量定义方式；
    public void test01(){
        String s1 = "aaa";//字面量定义； String不是java的基本数据类型；
                        //但它却可以像基本数据类型一样的赋值形式赋值；
                        //而不像其他类一样需要new

        String s2 = "aaa";
        System.out.println(s1 == s2);//地址值是否相等 ：true
        /*
            这里值得注意的是，s1和s2其实在内存结构的方法区(含有字符常量池)中，
            在这个结构里，是s1这个对象 它先 =“aaa”，然后给它造“aaa”，s1指向
            这个"aaa"的地址值；这时候s2也 = “aaa”，这时候是会在字符常量池了找
            有么有“aaa”，发现有，那把地址值给s2，s2 = “aaa”；s1s2他们指向的是
            同一个地址，是拿的同一个值；而不是你有一个“aaa”，我也有一个“aaa”；
        */
        s1 = "AAA";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("----------------");
        String s4 = "aaa";
        String s5 = s4.replace("a", "c");
        System.out.println(s5);//ccc
        System.out.println(s4 == s5);//false
    }
    @Test //new + 构造器方式；
    public void test02(){
        String s1 = "构造器方式";
        String s2 = new String("构造器方式");
        String s3 = new String("构造器方式");
        System.out.println(s1 == s2);//false
        System.out.println(s2 == s3);//false
        /*
            new的话就不一样了，我们说new都是在堆空间中创建新的，容易理解，上面
            输出的都是false，因为都是new过的；但 常量池 跟 堆 是在不同区域的，
            而字符串常量在常量池的目的是“共享”，而字符非常量对象存储在堆中；
        */
        System.out.println("----------------");
        People p1 = new People("RRW",22);
        People p2 = new People("RRW",22);
        System.out.println(p1.name == p2.name);//true
        System.out.println(p1.age == p2.age);//true
    }
    @Test
    public void test03(){
        String s1 = "rrw";
        String s2 = "lq";
        String s3 = "rrwlq";
        String s4 = "rrw"+"lq";
        String s5 = s1 + "lq";
        String s6 = s1+s2;
        String s8 = s5.intern();//强制要求s5.intern()方法返回的值一定要在常量池中生成，
                                //所以即使s5不在常量池中，s8用的也常量池中的值；
        String s7 = s3.intern();//返回的是s3在常量池中已存在的“rrwlq”
        System.out.println(s3 == s4);//T
        System.out.println(s3 == s5);//F
        System.out.println(s3 == s6);//F
        System.out.println(s3 == s7);//T
        System.out.println(s3 == s8);//T
        System.out.println(s4 == s6);//F
        System.out.println(s5 == s6);//F

    }
    @Test
    public void test04(){
        String s1 = "rrwlq";
        final String s2 = "rrw"; //加final也是在常量池；
        String s3 = s2 + "lq";
        System.out.println(s1 == s3);//true
    }

}
