package Senior.IO.File;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *@description:  File 类的使用:
 *             File类的一个对象，代表一个文件或者一个文件目录；
 *             File类声明在java.io包下
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-15 22:11
 */
public class Filetest {
    @Test  //创建File类的实例化：
    public void test1(){
        File file1 = new File("hello.txt");//相对路径
        File file2 = new File("D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread\\hello.txt");//绝对路径
        System.out.println(file1);
        System.out.println(file2);
    }
    @Test  //创建File类的获取功能：
    public void test2(){
        File file1 = new File("hello.txt");//相对路径
        File file2 = new File("D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread");//绝对路径
        System.out.println(file1.getAbsoluteFile());//完整路径
        System.out.println(file1.getName());//文件名
        System.out.println(file1.getParent());//上层目录,写相对路径是null
        System.out.println(file2.getParent());//上层目录
        System.out.println(file1.length());//长度
        System.out.println(new Date(file1.lastModified()));//最后一次更改时间
        System.out.println();
        String[] list = file2.list();
        for (String s : list){
            System.out.println(s);   //输出目录下的文件
        }
        System.out.println();
        File[] list1 = file2.listFiles();
        for (File f : list1){
            System.out.println(f);  //输出目录下的文件(带路径)
        }
    }
    @Test //判断功能：
    public void test3(){
        File file1 = new File("hello.txt");
        System.out.println(file1.exists());//是否存在
        boolean b1 = file1.canRead(); //是否可读
        boolean b2 = file1.canWrite(); //是否可写
        System.out.println(b1);
        System.out.println(b2);
    }
    @Test //创建功能：
    public void test4() throws IOException {
        File file = new File("hello1.txt");
        if (!file.exists()){
            file.createNewFile();
            System.out.println("创建文件成功！");
        }
        //创建文件目录：
        File file2 = new File("D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread\\IOIOIO");
        boolean b = file2.mkdir(); //mkdirs()则是如果上层目录不存在也一并创建
        if (b){
            System.out.println("创建成功！");
        }
    }
}
