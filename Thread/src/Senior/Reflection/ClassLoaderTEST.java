package Senior.Reflection;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *@description: Class   类的加载器
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 18:55
 */
public class ClassLoaderTEST {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTEST.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2
        //调用系统类加载的getParent()：获取扩展类的加载器
        ClassLoader loader = classLoader.getParent();
        System.out.println(loader);//sun.misc.Launcher$ExtClassLoader@182decdb
        //获取引导类加载器，主要加载java的核心类库，无法自定义加载
        ClassLoader parent = loader.getParent();
        System.out.println(parent);//null 不是没有，而是不能直接获取，因为它已经是扩展类了；

        ClassLoader stringload = String.class.getClassLoader();
        System.out.println(stringload); //null 同上，因为String是引导类加载的
    }
    @Test //Properties :读取配置文件
    public void test2() throws IOException {
        Properties properties = new Properties();
       /* 方式1：
        FileInputStream f1 = new FileInputStream("jdbc1.properties");
        properties.load(f1);*/
       //方式2： 注意文件位置应该在当前 ”src“ 下
        ClassLoader classLoader = ClassLoaderTEST.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc1.properties");
        properties.load(resourceAsStream);

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println("name:"+name +"\n" + "password:"+password);
    }
}
