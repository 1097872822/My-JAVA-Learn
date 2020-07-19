package Senior.Web;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *@description: java网络编程  涉及：InetAddress类
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-23 21:37
 */
public class InternetTEST {
    public static void main(String[] args) {
        try {
            InetAddress Int1 = InetAddress.getByName("192.168.200.103");
            System.out.println(Int1);
            InetAddress Int2 = InetAddress.getByName("www.baidu.com");
            System.out.println(Int2);
            //获取本地：
            InetAddress Int3 = InetAddress.getLocalHost();
            System.out.println(Int3);
            System.out.println(Int2.getHostName());
            System.out.println(Int2.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
