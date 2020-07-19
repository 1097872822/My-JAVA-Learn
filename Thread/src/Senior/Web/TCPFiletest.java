package Senior.Web;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *@description:  TCP的简单文件发送
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-23 22:52
 */
public class TCPFiletest {
    @Test //客户端
    public void test1(){
        Socket Int1 = null;
        OutputStream os = null;
        FileInputStream f1 = null;
        try {
            Int1 = new Socket(InetAddress.getByName("127.0.0.1"), 8888);
            os = Int1.getOutputStream();
            f1 = new FileInputStream(new File("ggg.png"));
            byte[] buf = new byte[1024];
            int len;
            while ((len = f1.read(buf))!=-1){
                os.write(buf,0,len);
            }

            Int1.shutdownOutput();//关闭数据输出，表示完成传输，同时也告诉了服务端传输完毕；

            //获取服务端反馈：
            InputStream is = Int1.getInputStream();
            ByteArrayOutputStream ops = new ByteArrayOutputStream();
            byte[] buf1 = new byte[1024];
            int len1;
            while ((len1 = is.read(buf))!= -1){
                ops.write(buf1,0,len1);
            }
            System.out.println(ops.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (Int1 != null) {
                try {
                    Int1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (f1 != null) {
                try {
                    f1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test //服务端
    public void test2(){
        ServerSocket serverSocket = null;
        InputStream op = null;
        FileOutputStream f1 = null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            op = socket.getInputStream();
            f1 = new FileOutputStream(new File("gggTCP1.png"));
            byte[] buf = new byte[1024];
            int len;
            while ((len = op.read(buf))!= -1 ){
                f1.write(buf,0,len);
            }

            System.out.println("客户端传输完毕！");
            //返回信息给客户端：
            OutputStream ops = socket.getOutputStream();
            ops.write("我已收到你的文件~".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (op != null) {
                try {
                    op.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (f1 != null) {
                try {
                    f1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
