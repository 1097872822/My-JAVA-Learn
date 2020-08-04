package Senior.JAVA.IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *@description:  序列化对象
 *      实例化了一个 SerializableTEST1 对象，并将该对象序列化到一个文件中。
 *      该程序执行后，就创建了一个名为 Serializable.ser 文件。该程序没有任何输出，但是你可以通过代码研读来理解程序的作用。
 * 注意： 当序列化一个对象到文件时， 按照 Java 的标准约定是给文件一个 .ser 扩展名。
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-03 23:43
 */
public class SerializableTEST2 {
    public static void main(String [] args)
    {
        SerializableTEST1 e = new SerializableTEST1();
        e.name = "rrw";
        e.address = "china";
        e.SSN = 11122333;
        e.number = 101;
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("Serializable.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in Serializable.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }
    }
}
