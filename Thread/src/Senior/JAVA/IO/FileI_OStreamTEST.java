package Senior.JAVA.IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *@description: 字节流： FileinputStream & FileOutputStream 测试：
 *          void flush() 刷新该流的缓冲，则立即将它们写入预期目标；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-20 19:01
 */
public class FileI_OStreamTEST {
    @Test  //测试非文本文件jpg png
    public void copyFileTEST(){
        String srcPath = "D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread\\gggdest.png";
        String destPath = "D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread\\newggg.png";
        copyFile(srcPath,destPath);
    }

    public void copyFile(String srcPath,String destPath){
        FileInputStream Sr = null;
        FileOutputStream De = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            Sr = new FileInputStream(srcFile);
            De = new FileOutputStream(destFile);
            byte[] buf = new byte[1024];
            int len;
            while ((len = Sr.read(buf))!= -1){
                De.write(buf,0,len);
            }
            System.out.println("Copy Success！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (Sr != null) {
                try {
                    Sr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (De != null) {
                try {
                    De.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
