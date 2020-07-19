package Senior.JAVA.IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *@description:  缓冲流 ： 提高读写速度的流；
 *      因其内部定义了一个缓冲区，数据先会给操作的文件缓存，再一次性输出
 *      8倍的1024 “DEFAULT_BUFFER_SIZE = 8192;”
 *           1.BufferInputStream
 *           2.BufferOutputStream
 *           3.BufferReader
 *           4.BufferWrite
 *
 *           处理流：“套”在已有的流的基础上；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-20 21:37
 */
public class BufferStreamTEST {
    @Test
    public void test1() {
        String srcF = "D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread\\gggdest.png";
        String desF = "D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread\\gggdest1.png";
        copyBufferFile(srcF, desF);
    }

    public void copyBufferFile(String srcF, String desF) {
        BufferedInputStream B1 = null;
        BufferedOutputStream B2 = null;
        try {
            File file1 = new File(srcF);
            File file2 = new File(desF);
            //造俩文件流
            FileInputStream F1 = new FileInputStream(file1);
            FileOutputStream F2 = new FileOutputStream(file2);
            //造缓冲流
            B1 = new BufferedInputStream(F1);
            B2 = new BufferedOutputStream(F2);
            //读写过程
            byte[] buf = new byte[1024];
            int len;
            while ((len = B1.read(buf)) != -1) {
                B2.write(buf, 0, len);
//                B2.flush();//刷新缓冲区  在write里面已经有了
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //先关闭外层流 BufferedInputStream 与 BufferedOutputStream
            //再关闭内层流 FileInputStream 与 FileInputStream
            //且内层流会随着外层的关闭而关闭，所以只需关闭外层的流
            if (B2 != null) {
                try {
                    B2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (B1 != null) {
                try {
                    B1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test //BufferReader & BufferWrite 实现文本文件的使用 （不能处理非文本文件的）
    public void test2() {
        //造文件造流的匿名合成写法：
        BufferedReader B1 = null;
        BufferedWriter B2 = null;
        try {
            B1 = new BufferedReader(new FileReader(new File("dbcp.txt")));
            B2 = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));
            //读写操作
            //char[] 方式读写
           /* char[] buf = new char[1024];
            int len;
            while ((len = B1.read(buf)) != -1) {
                B2.write(buf, 0, len);
            }*/

           //readLine();一行一行的读：
            String data;
            while ((data = B1.readLine()) != null){ //注意这里是不等于null
                B2.write(data + "\n"); //自己加换行  或者加：
//                B2.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (B1 != null) {
                try {
                    B1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (B2 != null) {
                try {
                    B2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}