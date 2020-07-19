package Senior.JAVA.IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *@description:  随机存储文件流： RandomAccessFile的使用：
 *      ● 实现了DataInput、DataOutput这两个接口，也就意味着这个类既可以读也 可以写。
 *      ● 支持 “随机访问” 的方式，程序可以直接跳到文件的任意 地方来读、写文件。
 *      ● 可以作为输入流(文件存在，从头覆盖，要是长度短，只覆盖前面的)
 *        也可以作为输出流
 *              支持只访问文件的部分内容
 *              可以向已存在的文件后追加内容
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-21 16:36
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile RAF1 = null;
        RandomAccessFile RAF2 = null;
        try {
            RAF1 = new RandomAccessFile(new File("ggg.png"), "r");
            RAF2 = new RandomAccessFile(new File("ggg123.png"), "rw");
            byte[] buf = new byte[1024];
            int len;
            while ((len = RAF1.read())!= -1){
                RAF2.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (RAF1 != null) {
                try {
                    RAF1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (RAF2 != null) {
                try {
                    RAF2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test2() throws IOException {
        RandomAccessFile f1 = new RandomAccessFile("test.txt", "rw");
//        f1.write("xyz".getBytes());  //重新写入(但只会覆盖写入的长度)
//        f1.close();
        f1.seek(3); //指定位置覆盖
        f1.write("rrw".getBytes());
        f1.close();
    }
}
//RandomAccessFile思考题见 ByteArrayOutputStreamTest.java