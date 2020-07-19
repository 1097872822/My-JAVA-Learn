package Senior.NIO;
/**
 *@description: java.NIO:
 *        ● File类的功能比较有限,。而且，大多数方法在出错时仅返回失败，并不会提供异 常信息。
 *        ● NIO. 2为了弥补这种不足，引入了Path接口，代表一个平台无关的平台路径，
 *          描 述了目录结构中文件的位置。Path可以看成是File类的升级版本，
 *          实际引用的资 源也可以不存在。
 *        ● Java7中，可以这样写：
 *            import java.nio.file.Path;
 *            import java.nio.file.Paths;
 *            Path path = Paths.get("index.html");
 *        ● 同时，NIO.2在java.nio.file包下还提供了Files、Paths工具类，
 *          Files包含了大量静态的工具方法来操作文件；
 *          Paths则包含了两个返回Path的静态工厂方法。
 *        ● Paths 类提供的静态 get() 方法用来获取 Path对象：
 *          static Path get(String first, String … more) : 用于将多个字符串串连成路径
 *          static Path get(URI uri): 返回指定uri对应的Path路径
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-21 19:13
 */

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.util.Iterator;

/**
 * Files工具类的使用：操作文件或目录的工具类
 * @author shkstart
 * @create 2019 下午 2:44
 */
public class NIO_TEST {
    @Test
    public void testFiles1() throws IOException {
        Path path1 = Paths.get("d:\\nio", "hello.txt");
        Path path2 = Paths.get("atguigu.txt");

//		Path copy(Path src, Path dest, CopyOption … how) : 文件的复制
        //要想复制成功，要求path1对应的物理上的文件存在。path1对应的文件没有要求。
//		Files.copy(path1, path2, StandardCopyOption.REPLACE_EXISTING);

//		Path createDirectory(Path path, FileAttribute<?> … attr) : 创建一个目录
        //要想执行成功，要求path对应的物理上的文件目录不存在。一旦存在，抛出异常。
        Path path3 = Paths.get("d:\\nio\\nio1");
//		Files.createDirectory(path3);

//		Path createFile(Path path, FileAttribute<?> … arr) : 创建一个文件
        //要想执行成功，要求path对应的物理上的文件不存在。一旦存在，抛出异常。
        Path path4 = Paths.get("d:\\nio\\hi.txt");
//		Files.createFile(path4);

//		void delete(Path path) : 删除一个文件/目录，如果不存在，执行报错
//		Files.delete(path4);

//		void deleteIfExists(Path path) : Path对应的文件/目录如果存在，执行删除.如果不存在，正常执行结束
        Files.deleteIfExists(path3);

//		Path move(Path src, Path dest, CopyOption…how) : 将 src 移动到 dest 位置
        //要想执行成功，src对应的物理上的文件需要存在，dest对应的文件没有要求。
//		Files.move(path1, path2, StandardCopyOption.ATOMIC_MOVE);

//		long size(Path path) : 返回 path 指定文件的大小
        long size = Files.size(path2);
        System.out.println(size);

    }

    @Test
    public void testFiles2() throws IOException{
        Path path1 = Paths.get("d:\\nio", "hello.txt");
        Path path2 = Paths.get("atguigu.txt");
//		boolean exists(Path path, LinkOption … opts) : 判断文件是否存在
        System.out.println(Files.exists(path2, LinkOption.NOFOLLOW_LINKS));

//		boolean isDirectory(Path path, LinkOption … opts) : 判断是否是目录
        //不要求此path对应的物理文件存在。
        System.out.println(Files.isDirectory(path1, LinkOption.NOFOLLOW_LINKS));

//		boolean isRegularFile(Path path, LinkOption … opts) : 判断是否是文件

//		boolean isHidden(Path path) : 判断是否是隐藏文件
        //要求此path对应的物理上的文件需要存在。才可判断是否隐藏。否则，抛异常。
//		System.out.println(Files.isHidden(path1));

//		boolean isReadable(Path path) : 判断文件是否可读
        System.out.println(Files.isReadable(path1));
//		boolean isWritable(Path path) : 判断文件是否可写
        System.out.println(Files.isWritable(path1));
//		boolean notExists(Path path, LinkOption … opts) : 判断文件是否不存在
        System.out.println(Files.notExists(path1, LinkOption.NOFOLLOW_LINKS));
    }
    /**
     * StandardOpenOption.READ:表示对应的Channel是可读的。
     * StandardOpenOption.WRITE：表示对应的Channel是可写的。
     * StandardOpenOption.CREATE：如果要写出的文件不存在，则创建。如果存在，忽略
     * StandardOpenOption.CREATE_NEW：如果要写出的文件不存在，则创建。如果存在，抛异常
     *
     * @author shkstart 邮箱：shkstart@126.com
     * @throws IOException
     */
    @Test
    public void testFiles3() throws IOException{
        Path path1 = Paths.get("d:\\nio", "hello.txt");

//		InputStream newInputStream(Path path, OpenOption…how):获取 InputStream 对象
        InputStream inputStream = Files.newInputStream(path1, StandardOpenOption.READ);

//		OutputStream newOutputStream(Path path, OpenOption…how) : 获取 OutputStream 对象
        OutputStream outputStream = Files.newOutputStream(path1, StandardOpenOption.WRITE,StandardOpenOption.CREATE);


//		SeekableByteChannel newByteChannel(Path path, OpenOption…how) : 获取与指定文件的连接，how 指定打开方式。
        SeekableByteChannel channel = Files.newByteChannel(path1, StandardOpenOption.READ,StandardOpenOption.WRITE,StandardOpenOption.CREATE);

//		DirectoryStream<Path>  newDirectoryStream(Path path) : 打开 path 指定的目录
        Path path2 = Paths.get("e:\\teach");
        DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path2);
        Iterator<Path> iterator = directoryStream.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
//-------------------------------------------------------------/

        //如何使用Paths实例化Path
        @Test
        public void PathTest1() {
            Path path1 = Paths.get("d:\\nio\\hello.txt");//new File(String filepath)

            Path path2 = Paths.get("d:\\", "nio\\hello.txt");//new File(String parent,String filename);

            System.out.println(path1);
            System.out.println(path2);

            Path path3 = Paths.get("d:\\", "nio");
            System.out.println(path3);
        }

        //Path中的常用方法
        @Test
        public void PathTest2() {
            Path path1 = Paths.get("d:\\", "nio\\nio1\\nio2\\hello.txt");
            Path path2 = Paths.get("hello.txt");

//		String toString() ： 返回调用 Path 对象的字符串表示形式
            System.out.println(path1);

//		boolean startsWith(String path) : 判断是否以 path 路径开始
            System.out.println(path1.startsWith("d:\\nio"));
//		boolean endsWith(String path) : 判断是否以 path 路径结束
            System.out.println(path1.endsWith("hello.txt"));
//		boolean isAbsolute() : 判断是否是绝对路径
            System.out.println(path1.isAbsolute() + "~");
            System.out.println(path2.isAbsolute() + "~");
//		Path getParent() ：返回Path对象包含整个路径，不包含 Path 对象指定的文件路径
            System.out.println(path1.getParent());
            System.out.println(path2.getParent());
//		Path getRoot() ：返回调用 Path 对象的根路径
            System.out.println(path1.getRoot());
            System.out.println(path2.getRoot());
//		Path getFileName() : 返回与调用 Path 对象关联的文件名
            System.out.println(path1.getFileName() + "~");
            System.out.println(path2.getFileName() + "~");
//		int getNameCount() : 返回Path 根目录后面元素的数量
//		Path getName(int idx) : 返回指定索引位置 idx 的路径名称
            for (int i = 0; i < path1.getNameCount(); i++) {
                System.out.println(path1.getName(i) + "*****");
            }

//		Path toAbsolutePath() : 作为绝对路径返回调用 Path 对象
            System.out.println(path1.toAbsolutePath());
            System.out.println(path2.toAbsolutePath());
//		Path resolve(Path p) :合并两个路径，返回合并后的路径对应的Path对象
            Path path3 = Paths.get("d:\\", "nio");
            Path path4 = Paths.get("nioo\\hi.txt");
            path3 = path3.resolve(path4);
            System.out.println(path3);

//		File toFile(): 将Path转化为File类的对象
            File file = path1.toFile();//Path--->File的转换

            Path newPath = file.toPath();//File--->Path的转换
        }
    }


