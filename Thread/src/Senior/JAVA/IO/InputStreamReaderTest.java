package Senior.JAVA.IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *@description:  转换流(属字符流)：
 *             1.InputStreamReader 字节的输入流 ————>字符的输入流：即InputStream——>Reader
 *             2.OutputStreamWriter 字符的输出流 ————> 字节的输出流：即Writer——>OutputStream
 *              提供 字节与字符之间的转换；
 *            编码：字符串字节数组：即给程序看
 *            解码：字节数组字符串：即给程序员看
 *     转换流的编码应用   可以将字符按指定编码格式存储
 *                   可以对文本数据按指定编码格式来解读
 *                   指定编码表的动作由构造器完成
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-21 12:12
 */
public class InputStreamReaderTest {
    @Test //字节的输入流 ————> 字符的输入流
    public void test1(){
        InputStreamReader f2 = null;
        try {
            FileInputStream f1 = new FileInputStream("dbcp.txt");
            f2 = new InputStreamReader(f1,"UTF-8");
            char[] buf = new char[1024];
            int len;
            while ((len = f2.read(buf)) != -1){
                String str = new String(buf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (f2 != null) {
                try {
                    f2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test //字符的输出流 ————> 字节的输出流
    public void test2(){
        InputStreamReader fir = null;
        OutputStreamWriter fow = null;
        try {
            File f1 = new File("dbcp.txt");
            File f2 = new File("dbcp_gbk.txt");
            FileInputStream fi = new FileInputStream(f1);
            FileOutputStream fo = new FileOutputStream(f2);
            fir = new InputStreamReader(fi,"UTF-8");
            fow = new OutputStreamWriter(fo,"gbk");

            char[] buf = new char[1024];
            int len;
            while ((len = fir.read(buf))!= -1){
                fow.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fow != null) {
                try {
                    fow.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fir != null) {
                try {
                    fir.close();
                } catch (IOException e) {
                     e.printStackTrace();
                }
            }
        }
    }
}
