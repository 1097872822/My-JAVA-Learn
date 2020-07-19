package Senior.Collection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *@description: Map 的实现类：Properties
 *                 处理配置文件的，其key与value都是String类的;
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-14 21:09
 */
public class PropertiesTEST {
    public static void main(String[] args) {
        FileInputStream file = null;
        try {
            Properties poes = new Properties();
            file = new FileInputStream("JDBC.properties");
            poes.load(file);//加载流对应的文件
            String name = poes.getProperty("name");
            String password = poes.getProperty("password");
            System.out.println("name:"+name+",passwoed:"+ password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
