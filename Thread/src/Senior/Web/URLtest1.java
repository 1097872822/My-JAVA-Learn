package Senior.Web;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *@description: 将资源从服务器下载到本地
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 13:17
 */
public class URLtest1 {
    public static void main(String[] args) {
        HttpURLConnection ucurl = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://localhost:8080/test/ggg.png");
            ucurl = (HttpURLConnection)url.openConnection();
            ucurl.connect();  //连接
            is = ucurl.getInputStream();
            fos = new FileOutputStream("ppp.png");
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf))!= -1 ){
                fos.write(buf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ucurl != null)
            ucurl.disconnect(); //断开连接
        }
    }
}
