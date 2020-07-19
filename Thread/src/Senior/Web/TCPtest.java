package Senior.Web;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@description:  TCP网络编程:
 *               客户端——>服务端——>控制台输出
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-23 22:07
 */
public class TCPtest {
    @Test  //客户端
    public void clienttest() {
        Socket socket = null; //新建套接字，填入参数
        OutputStream os = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1"); //确定服务器地址
            socket = new Socket(inet, 8787);
            //造输出流:
            os = socket.getOutputStream();
            os.write("我是客户端~，我想发送数据给你".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭两个流
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test  //服务端
    public void servertest() {
        ServerSocket serverSocket = null;
        Socket socket = null; //接收
        InputStream Inp = null;//输出流
        ByteArrayOutputStream bb = null;
        try {
            serverSocket = new ServerSocket(8787);
            socket = serverSocket.accept();
            Inp = socket.getInputStream();
        /*byte[] buf = new byte[1024];
        int len;
        while ((len = Inp.read(buf)) != -1){
            String str = new String(buf,0,len);
            System.out.println(str);
        }*/
            //上面的写法可能会乱码，下面使用ByteArrayOutputStream:
            //把可能会出现乱码的，一个个装成一个“串”，最后再串葫芦一样输出
            bb = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int len;
            while ((len = Inp.read(buf)) != -1){
                bb.write(buf,0,len);
            }
            System.out.println(bb.toString());
            System.out.println("收到了：" + socket.getInetAddress().getHostAddress() + "的发送请求");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if ( bb != null) {
                try {
                    bb.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if ( Inp != null) {
                try {
                    Inp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if ( socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if ( serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
