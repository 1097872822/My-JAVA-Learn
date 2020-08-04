package Senior.JAVA.IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *@description:  流分类：
 *      1.字节流 字符流
 *      2.输入流 输出流
 *      3.节点流 处理流
 *             流结构：
 *        抽象基类：            节点流(文件流)：        缓冲流：
 *        InputStream          FileInputStream       BufferInputStream
 *        OutputStream         FileOutputStream      BufferOutputStream
 *        Reader               FileReader            BufferReader
 *        Write                FileWrite             BufferWrite
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-16 01:03
 */
public class FileReaderWriterTEST {
    public static void main(String[] args) {
        File file = new File("Thread\\hello.txt");
        System.out.println(file.getAbsolutePath());
    }
    @Test //将文件内容输出;
            //注意异常处理，不要在方法直接抛Exception，为保证流资源可以close()，需要try-catch-finally处理；
    public void test1()  {
        //实例化对象
        FileReader f = null; //注意这里不是一上来就给 f 设空哈，而是try/catch的结果
        try {
            File file1 = new File("hello.txt");
            //提供具体流：
            f = new FileReader(file1);
            //数据读入
            int date;  //why int ？ Because：目的是读到文件末尾(-1)
            while ((date = f.read()) != -1){  //这里read一个一个读
                System.out.print((char) date);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流操作
            try {
                if (f != null)//文件为空再关闭
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test //使用read的重载方法：
    public void test2() {
        FileReader f = null;
        try {
            //File类的实例化
            File file = new File("hello.txt");
            //FileReader流的实例化
            f = new FileReader(file);
            //读入操作：
            char[] cbuf = new char[10]; //每次读10个
            int len; //下面不能判断 i<cbuf.length; 可以用len表示每次读几个
                     //我就遍历几个，如果用了length 若不是倍数关系，假设最后剩
                    //3个字符要读了，length会吧最后的10个读出来;
            while (( len = f.read(cbuf)) != -1){//这里的read是(char[] cbuf)
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //或者用下面方式代替for循环，会更“国际化”，for很low的
                String str = new String(cbuf,0,len);//从0位置开始，每次读len个
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            try {
                if (f != null)
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test //从内存写出数据到指定文件中
    public void test3(){
        FileWriter f = null;
        try {
            File file = new File("hello2.txt");
            f = new FileWriter(file,false);//再次运行不再源文件上追加，true反之
            f.write("I am rrw");//再写一次(再执行)，就看上面F还是T了
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (f != null)
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Test //读取A文件 输出到B文件 (复制)
    public void test4() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File f1 = new File("hello.txt");
            File f2 = new File("hello1.txt");
            fr = new FileReader(f1);
            fw = new FileWriter(f2);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                fw.write(cbuf,0,len);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
