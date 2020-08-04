package Senior.JAVA.IO;

import java.io.Serializable;

/**
 *@description: JAVA （对象）序列化机制
 *          一个对象可以被表示为一个字节序列，该字节序列包括该对象的数据、有关对象的类型的信息和存储在对象中数据的类型。
 *          对象的类型信息、对象的数据，还有对象中的数据类型可以用来在内存中新建对象。
 *          在一个平台上序列化的对象可以在另一个完全不同的平台上反序列化该对象。
 *
 *@author: RRW friend_rrw@163.com
 *@create: 2020-08-03 23:31
 */
/*
    public final void writeObject(Object x) throws IOException
    上面的方法序列化一个对象，并将它发送到输出流。
    public final Object readObject() throws IOException,ClassNotFoundException
    上述 ObjectInputStream 类包含如下反序列化一个对象的方法；该方法从流中取出下一个对象，
    并将对象反序列化。它的返回值为Object，因此，你需要将它转换成合适的数据类型。
*/
public class SerializableTEST1 implements Serializable {
    public String name;
    public String address;
    public transient int SSN;  //transient关键字只能修饰变量，而不能修饰方法和类。
    /*
    在实际开发过程中，我们常常会遇到这样的问题，这个类的有些属性需要序列化，
    而其他属性不需要被序列化，打个比方，如果一个用户有一些敏感信息（如密码，银行卡号等），
    为了安全起见，不希望在网络操作（主要涉及到序列化操作，本地序列化缓存也适用）
    中被传输，这些信息对应的变量就可以加上transient关键字。换句话说，这个字段的
    生命周期仅存于调用者的内存中而不会写到磁盘里持久化。

    即：实现Serilizable接口，将不需要序列化的属性前添加关键字transient，
        序列化对象的时候，这个属性就不会序列化到指定的目的地中。

    注意：本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
          一个静态变量不管是否被transient修饰，均不能被序列化），反序列化后类中static型变量的值做为
          当前JVM中对应static变量的值，这个值是JVM中的不是反序列化得出的。
          这说明反序列化后类中static型变量其值为当前JVM中对应static变量的值。

      但：对象的序列化可以通过实现两种接口来实现，若实现的是Serializable接口，则所有的序列化将会自动进行，
         若实现的是Externalizable接口，则没有任何东西可以自动序列化，需要在writeExternal方法中进行
         手工指定所要序列化的变量，这与是否被transient修饰无关。
    */
    public int number;
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address + " " + SSN + " " + number );
    }
    /*
    请注意，一个类的对象要想序列化成功，必须满足两个条件：
    该类必须实现 java.io.Serializable 接口。
    该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的。
    */
}

