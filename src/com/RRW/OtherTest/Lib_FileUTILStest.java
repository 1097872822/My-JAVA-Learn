package com.RRW.OtherTest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 *@description:  导库测试
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-21 19:52
 */
public class Lib_FileUTILStest {
    public static void main(String[] args) {
        File f1 = new File("\\D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread\\ggg.png");
        File f2 = new File("\\D:\\E for JAVA EE\\SeniorForJava_IJ\\Thread\\ggg222.png");
        try {
            FileUtils.copyFile(f1,f2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
