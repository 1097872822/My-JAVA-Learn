package Senior.JAVA.IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *@description: 反序列对象：
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-03 23:44
 */
public class SerializableTEST3 {
    public static void main(String [] args)
    {
        SerializableTEST1 e = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("Serializable.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (SerializableTEST1) in.readObject();
            //readObject() 方法中的 try/catch代码块尝试捕获 ClassNotFoundException 异常。
            //对于 JVM 可以反序列化对象，它必须是能够找到字节码的类。如果JVM在反序列化
            // 对象的过程中找不到该类，则抛出一个 ClassNotFoundException 异常。
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized 'Serializable.ser'...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}
/*
    注意，readObject() 方法的返回值被转化成 SerializableTEST1类 引用。当对象被序列化时，
    属性 SSN 的值为 111222333，但是因为该属性是短暂的，该值没有被发送到输出流。
    所以反序列化后 SerializableTEST1 对象的 SSN 属性为 0。
*/