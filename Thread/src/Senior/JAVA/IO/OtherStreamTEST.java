package Senior.JAVA.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@description: 其他流的使用：
 *          标准输入输出流：System.in  /  System.out
 *          数据流：为了方便地操作Java语言的基本数据类型和String的数据，可以使用数据流。
 *                  数据流有两个类：(用于读取和写出基本数据类型、String类的数据）
 *                       DataInputStream 和 DataOutputStream
 *                       分别“套接”在 InputStream 和 OutputStream 子类的流上
 *          对象流（高层次的数据流）： 用于存储和读取基本数据类型数据或对象的处理流。
 *                   它的强大之处就是可以把Java中的对象写入到数据源中，
 *                   也能把对象从数据源中还原回来。
 *                ● 序列化：用ObjectOutputStream类 保存 基本类型数据或对象的机制
 *                ● 反序列化：用ObjectInputStream类 读取 基本类型数据或对象的机制
 *                ● ObjectOutputStream和ObjectInputStream不能序列化static和transient修 饰的成员变量
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-21 13:06
 */
public class OtherStreamTEST {
    //从键盘输入字符串，将读取的整行字符串转成大写；然后继续输入 当输入exit，退出；
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            //处理流
            InputStreamReader Input = new InputStreamReader(System.in);
            //缓冲流
            reader = new BufferedReader(Input);
            while (true) {
                System.out.println("请输入字符串：");
                String data = reader.readLine();
                if ("exit".equalsIgnoreCase(data)) {
                    //equalsIgnoreCase() 方法用于将字符串与指定的对象比较，不考虑大小写。
                    break;
                }
                String upcase = data.toUpperCase();
                System.out.println(upcase);
            }
                    } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/*
    对象流：
        ● 序列化：将对象写入到磁盘或者进行网络传输。
          要求对象必须实现序列化
               ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(“data.txt"));
               Person p = new Person("rrw", 18, "中国", new Pet());
               oos.writeObject(p);
               oos.flush();
               oos.close();
        ● 反序列化：将磁盘中的对象数据源读出。
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(“data.txt"));
                Person p1 = (Person)ois.readObject();
                System.out.println(p1.toString());
                ois.close();
        ● 谈谈你对java.io.Serializable接口的理解，我们知道它用于序列化，
            是空方法接口，还有其它认识吗？
               答：1.实现了Serializable接口的对象，可将它们转换成一系列字节，
                   并可在以后 完全恢复回原来的样子。这一过程亦可通过网络进行。
                   这意味着序列化机 制能自动补偿操作系统间的差异。换句话说，
                   可以先在Windows机器上创 建一个对象，对其序列化，然后通过网络
                   发给一台Unix机器，然后在那里 准确无误地重新“装配”。
                   不必关心数据在不同机器上如何表示，也不必关心字节的顺序或者其他任何细节。

                  2.由于大部分作为参数的类如String、Integer等都实现了
                  java.io.Serializable的接口，也可以利用多态的性质，作为参数使接口更灵活。
 */