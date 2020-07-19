package Senior.Reflection;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *@description:  调用运行时类中指定的结构：属性、方法、构造器
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 19:52
 */
public class ReflectionTEST2 {
    @Test //调属性
    public void test1() throws Exception {
        Class<People> peopleClass = People.class;
        //创建运行时类的对象：
        People p = peopleClass.newInstance();
        //获取指定属性：公有私有都可以调
        Field id = peopleClass.getDeclaredField("id");
        //当 id 设置为 private时，就会报:IllegalAccessException非法访问
        //所以要把其设成可以访问的：
        id.setAccessible(true);
        //设置属性值：
        id.set(p,100);
        //获取对象属性值：
        int o = (int) id.get(p);
        System.out.println(o);
    }
    @Test //调方法：
    public void test2() throws Exception {
        Class<People> peopleClass = People.class;
        People p = peopleClass.newInstance();
        //获取某个方法：且指明方法名与获取的方法形参列表
        Method country1 = peopleClass.getDeclaredMethod("Country", String.class);
        country1.setAccessible(true);
        //country1.invoke(p,"黄土高坡...");//invoke()返回的就是调的方法中的返回值
        Object o = country1.invoke(p, "黄土高坡...");
        System.out.println(o);

        //如果调用静态的方法：(若调其方法中没有返回值，则返回null)
        Method moneyHAS = peopleClass.getDeclaredMethod("MoneyHAS");
        moneyHAS.setAccessible(true);
        moneyHAS.invoke(People.class); //静态就是“People.class”它自己当前运行时类
        //即 当调的是非静态的 我才需要知道你想调谁，它的结构是怎么样的，你得给我指明
        // 而在调的是静态方法，实例已经知道谁是静态的，则invoke()里写null也行的，但不能不写；
    }

    @Test //调构造器： （少用，但指定时，也可以用）
        //大部分情况下都是这么写 People p = peopleClass.newInstance();
    public void test3() throws Exception {
        Class<People> peopleClass = People.class;
        // 调它：
        // private People(int age) {  //年龄设为私有
        //        this.age = age;
        //    }

        //获取指定构造器：
        Constructor<People> constructor = peopleClass.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        People p = constructor.newInstance(222);//搞个外星人的岁数，哈哈
        System.out.println(p);
    }
}
