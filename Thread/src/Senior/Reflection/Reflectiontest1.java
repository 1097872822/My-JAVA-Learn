package Senior.Reflection;

import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;

/**
 *@description:  Class类的理解 (Strng.class  int.class)
 *           哪些类型可以有Class对象？：
 *              （1）class： 外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类
 *              （2）interface：接口
 *              （3）[]：数组
 *              （4）enum：枚举
 *              （5）annotation：注解@interface
 *              （6）primitive type：基本数据类型
 *              （7）void
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 16:53
 */
public class Reflectiontest1 {
    @Test //Class的实例
    public void test1() throws ClassNotFoundException {
        //调用运行时类的属性： .class
        Class<People> peopleClass = People.class;
        System.out.println(peopleClass); //class Senior.Reflection.People
        //调用运行时类的对象： getClass()
        People p1 = new People();
        Class p1Class = p1.getClass();
        System.out.println(p1Class); //class Senior.Reflection.People
        //*常用*调用Class的静态方法： forName(String classPath)
        Class fClass = Class.forName("Senior.Reflection.People");//"":全类名
        System.out.println(fClass);

        //判断是都是同一个对象？
        System.out.println(peopleClass == p1Class); //true
        System.out.println(peopleClass == fClass);  //true
        System.out.println(p1Class == fClass); //true
        //证明方式不同，但都是指同一个

        //使用类的加载器：ClassLoader
        ClassLoader loader = ReflectionTEST.class.getClassLoader();
        Class aClass = loader.loadClass("Senior.Reflection.People");
        System.out.println(aClass);
        System.out.println(aClass == p1Class);
    }
    @Test //可以说以下的结构：
    public void test2(){
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11);  //true
    }
    /*@Test //类的加载
    public void test3(){
            public static void main(String[] args) {
            System.out.println(A.m);
        }
        }
        class A {
            static {
                m = 300; }
                static int m = 100;
        }

        //第二步：链接结束后m=0
        // 第三步：初始化后，m的值由<clinit>()方法执行决定
        //这个A的类构造器<clinit>()方法由类变量的赋值和静态代码块中的语
        // 句按照顺序合并产生，类似于 :
        //          <clinit>(){
        //              m = 300;
        //              m = 100;
        //              }*/
    }
