package Senior.IO.File;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @Description: 练习2：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 * @Author: RRW
 * @Date: 2020/6/15
 */
public class FindJPGFileTest {
    @Test
    public void test1() {
        File srcFile = new File("d:\\IOtext");
        String[] fileNames = srcFile.list();
        for (String fileName : fileNames) {
            if (fileName.endsWith(".jpg")) {
                System.out.println(fileName);
            }
        }
    }
    @Test
    public void test2() {
        File srcFile = new File("d:\\IOtext");
        File[] listFiles = srcFile.listFiles();
        for (File file : listFiles) {
            if (file.getName().endsWith(".jpg")) {
                System.out.println(file.getAbsolutePath());
            }
        }
    }

    /*
     * File类提供了两个文件过滤器方法
     * public String[] list(FilenameFilter filter)
     * public File[] listFiles(FileFilter filter)

     */
    @Test
    public void test3() {
        File srcFile = new File("d:\\IOtext");
        File[] subFiles = srcFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jpg");
            }
        });
        for (File file : subFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }
}
