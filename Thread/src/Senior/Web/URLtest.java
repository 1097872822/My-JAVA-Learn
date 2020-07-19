package Senior.Web;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *@description: URL网络编程
 * 一个URL对象生成后，其属性是不能被改变的，但可以通过它给定的 方法来获取这些属性：
 *      常用方法：
 *          public String getProtocol() ———>获取该URL的协议名
 *          public String getHost() ———>获取该URL的主机名
 *          public String getPort() ———>获取该URL的端口号
 *          public String getPath() ———>获取该URL的文件路径
 *          public String getFile() ———>获取该URL的文件名
 *          public String getQuery() ———>获取该URL的查询名
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 12:01
 */
public class URLtest {
    public static void main(String[] args) {
        //实例化：
        try {
            URL url = new URL("http://localhost:8080/examples/ggg.png?username=RRW");
            //常用方法：
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
