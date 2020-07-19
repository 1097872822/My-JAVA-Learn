package Senior.Reflection;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 *@description:   通过反射 创建运行时类的对象：
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 19:24
 */
public class NewInstanceTEST {
    @Test  //newInstance()创建对应（People类）运行时的方法，调的其空参的构造器
          //下面的两个异常指的就是：
          //IllegalAccessException:非法访问，即私有的，不能访问；
          //InstantiationException：类没有空参构造器时，报错；
            //即：调的构造器必须是空参的，且必须是共有的，可以访问的；
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<People> peopleClass = People.class;
        People o = peopleClass.newInstance();
        System.out.println(o);
    }

    @Test //体现(完善前面说的)反射的动态性：
    public void test2(){
        for (int i = 0; i < 20; i++) {
            int num = new Random().nextInt(3); //0,1,2
            String classPath = "";
            switch (num) {
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "Senior.Reflection.People";
                    break;
            }
            Object o = null;
            try {
                o = getInstance(classPath);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            System.out.println(o);
        }
    }
    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class forName = Class.forName(classPath);
        return forName.newInstance();
    }
}
