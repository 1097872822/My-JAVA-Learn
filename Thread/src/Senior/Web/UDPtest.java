package Senior.Web;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *@description:  udp的网络编程
 *                udp是不可靠的连接方式，只管发送，不需要连接
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 11:42
 */
public class UDPtest {
    @Test
    public void Send(){
        DatagramSocket socket = null;//空参构造器
        try {
            socket = new DatagramSocket();
            String str = "UDP的发送方式";
            byte[] data = str.getBytes();
            InetAddress address = InetAddress.getLocalHost();
            //指明发送的数据，长度，地址，端口
            DatagramPacket packet = new DatagramPacket(data,0,data.length,address,9999);
            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }

    @Test
    public void Recv(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9999);
            byte[] buf = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buf,0,buf.length);
            socket.receive(packet);
            //将获取的数据，从0开始，长度，写入一个new String()，在控制台输出
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null)
            socket.close();
        }
    }
}
