package Senior.Reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *@description: Reflection(反射) 特性：动态性
 *       Java反射机制提供的功能 ：
 *          在运行时判断任意一个对象所属的类
 *          在运行时构造任意一个类的对象
 *          在运行时判断任意一个类所具有的成员变量和方法
 *          在运行时获取泛型信息
 *          在运行时调用任意一个对象的成员变量和方法
 *          在运行时处理注解
 *          生成动态代理
 *     主要API:
 *       java.lang.Class:代表一个类
 *       java.lang.reflect.Method:代表类的方法
 *       java.lang.reflect.Field:代表类的成员变量
 *       java.lang.reflect.Constructor:代表类的构造器
 *
 *     为什么用 & 该怎么用：
 *          1.想下面提到的公共部分，new 或者 反射 都可以用，那么，实际开发中
 *            应该还是用new的方式；  但像网页请求服务时，服务器是先跑的，它不知道
 *            客户端想要干什么，要什么样的对象，用什么方法，想干嘛；这个情景需要
 *            使用反射了，比如你在网页请求登录，网页后写入“/login”，那反射做的就是
 *            去找相关的操作，属性，方法等给你返回，这就体现了反射的动态性。
 *          2.那有反射机制，那跟OOP的”封装性“是不是有冲突？
 *             既然存在，那他们肯定是不矛盾的；反射体现的是“能不能”；封装性则体现
 *             的是“建议(我的比较好，你就别费劲了，效果都一样)”
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 14:47
 */
public class ReflectionTEST {
    //反射前，People能做的：
    @Test
    public void test1() {
        People p1 = new People("RRW", 22,001);
        p1.name = "rrw";
        System.out.println(p1.toString());
        p1.show();
        //则像 showFriend()方法 与 private的(int age)的构造器都不能直接调用
    }

    @Test
    public void test2() throws Exception {
        //反射之后：
        //反射也可以创建People类的对象
        Class peopleClass = People.class;
        //得到特定构造器 constructor
        Constructor constructor = peopleClass.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("RRW",22);
        People peo = (People) obj;
        System.out.println(peo.toString());
        //反射也调用一下属性
        Field name1 = peopleClass.getDeclaredField("name");//获取特定的属性名
        name1.set(peo,"newRRW");
        System.out.println(peo.toString());
        //调方法：
        Method show = peopleClass.getDeclaredMethod("show");
        show.invoke(peo);

        //反射调用私有的构造器:
        Constructor declaredConstructor = peopleClass.getDeclaredConstructor(int.class);
        declaredConstructor.setAccessible(true);
        People peo1 = (People) declaredConstructor.newInstance(99);
        System.out.println(peo1);
        //反射调用私有的属性:
        Field age1 = peopleClass.getDeclaredField("age");
        age1.setAccessible(true);
        age1.set(peo1,111);
        System.out.println(peo1);
        //反射调用私有的方法:
        Method showFriend1 = peopleClass.getDeclaredMethod("showFriend", String.class);
        showFriend1.setAccessible(true);
        showFriend1.invoke(peo1,"lanqi");
        //或用变量接收，获取返回值：
        String showFriend = (String) showFriend1.invoke(peo1,"lanqi");
        System.out.println(showFriend);
    }
}