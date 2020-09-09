##  异常：

> #### 在Java语言中，将程序执行中发生的不正常情况称为“异常”。
>
> #### （开发过程中的语法错误和逻辑错误不是异常）Java程序在执行过程中所发生的异常事件可分为两类：

>##### ==Error:Java==:虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如：StackOverflowError和OOM。一般不编写针对性的代码进行处理。
>
>###### ==Exception==：其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如：
>
>##### √空指针访问
>
>##### √试图读取不存在的文件
>
>##### √网络连接中断
>
>##### √数组角标越界

### 常见的几个异常：

+ #### java.lang.NullPointerException 空指针异常；  

+ #### java.lang.StringIndexOutOfBoundsException 角标越界

+ #### java.lang.ClassCastException: 类型转换异

+ #### java.lang.NumberFormatException:  数字格式异常

+ #### java.util.InputMismatchException：输入不匹配异常

+ #### java.lang.ArithmeticException: / by zero 算术异常

~~~java
package test;

import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class TestTest {
	@Test
	public void test1() {
		String st1 = "abc";
		// st1 = null;
		// System.out.println(st1.charAt(1)); //空指针异
		System.out.println(st1.charAt(4)); // 角标越界
	}

	@Test
	public void test2() {
		Object object = new Date();
		String string = (String) object;
	}

	@Test
	public void test3() {
		String st1 = "abc";
		int num = Integer.parseInt(st1);
		System.out.println(num);
	}

	@Test
	public void test4() {
		Scanner scanner = new Scanner(System.in);
		int str = scanner.nextInt();
		System.out.println(str);
	}

	@Test
	public void test5() {
		int a = 111;
		int b = 0;
		System.out.println(a / b); // 出现一个无限大的数
	}
}
~~~



### 异常处理机制：

+ ### try-catch-finally  (可以自己解决的)

+ ### throws  （解决的形式是往上报）

![image-20200604155355748](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112503.png)

~~~java
package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;


/*
 * try-catch-finally处理  //编译可能没错 但到运行时可能出错
 * try {
 * 		//可能出现的异常；
 * }catch(异常类1 变量名1){  //异常类型要看子父类关系；有父类的父类在最底层；
 * 		//处理方式；
 * }catch(异常类2 变量名2){
 *	    //处理方式；
 * }
 * ...
 * fianlly{  //可选的 
 * 		//一定会执行的代码 即使try/catch中有return语句
 * }//什么时候得用fianlly：像数据库连接。输入输出流、网络编程等资源，
 * 		JVM是不能自动回收的，需要自己手动进行资源回收释放，就
 * 		需要声明在fianlly中
 * 
 * catch 中异常对象处理方式：
 * 		1、String getMessage();
 * 		2、printStackTrace();
 */
public class TestTest {

	@Test
	public void test3() {
		String st1 = "abc";
		int num = 0;
		try { // 包装异常代码;
			num = Integer.parseInt(st1);
			System.out.println("上面一句一旦出现异常，我这就不输出");
		} catch (NumberFormatException e) { // 匹配并进入指定异常,并处理
			System.out.println("转换异常了，但问题不大");
			System.out.println("错误位置：" + e.getMessage());
			// 或者是：
			// e.printStackTrace();
		}
		System.out.println("我可以执行到这，问题解决了");
		System.out.println(num);
	}

	@Test
	public void test5() {
		try {
			int a = 111;
			int b = 0;
			System.out.println(a / b); // 出现一个无限大的数
		} catch (ArithmeticException e) {
//			e.printStackTrace();
		} catch (Exception e) {
//			e.printStackTrace();
		} finally {
			System.out.println("我一定会被执行");
		}
	}
	@Test
	public void testFinally() {
		FileInputStream fs = null;
		try {    //可以选中被包围代码块，右键选择“try/catch”包围方式
		File flle = new File("Finally.txt"); 
			fs = new FileInputStream(flle);
			int data = fs.read();
			while (data != -1) {
				System.out.print((char)data);
				data = fs.read();
			}
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {  //finally里还可以套try/catch
			try {
				if (fs != null) //防止空指针异常
					fs.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
//---------------------------------------------------------------------
package test;
/*
 * 	throws： 
 * 		方式：throws + 异常类型 写在方法声明处，表明该方法执行时，
 * 				可能会抛出异常；一旦方法体执行时出现异常，仍会在异常代码处
 * 				生成一个异常类的对象，此对象满足throws后的异常类型时，就抛出；
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

import test.Person.man;

public class Throwstest {
	public static void main(String[] args){
		try {
			ThrowsT1();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	public static void ThrowsT1() throws IOException {
		ThrowsT();
	}
	public static void ThrowsT() throws FileNotFoundException,IOException{
	File file = new File("Finally.txt");
	FileInputStream f = new FileInputStream(file);
	
	int data = f.read();
	while (data != -1) {
		System.out.print((char)data);
		data = f.read();
	}
	f.close();
}
}
//-------------------------------------------------------
//睡眠算法 简易版： (数组无负数)
/*
	睡眠排序由于其独有的排序方式，排序数字最好是非负整数，且最大值不要太大，否则算法会运行很久……非负小数其实也可以，但是排序后的相邻小数的差值不要太小，否则可能会出错，因为多线程的运行有其不确定性和延迟的可能……
*/
package test;
public class SleepSort {
	public static void main(String[] args) {
		int[]  arr = {2,32,21,13,43,5,2,21};
		for (int i : arr) {
			new Thread(()->{
				try {
					Thread.sleep(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}).start();
		}
	}
}


//-------------------------------------
//复杂版：
package test;
//睡眠算法： (数组无负数)
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 虽然睡眠排序挺欢乐的，但是想写好一个睡眠排序也挺不容易的，涉及到
多线程的设计、启动、运行，以及控制的方法，可以算是多线程编程的一次
小小实战！本次睡眠排序，我用CountDownLatch类来控制多线程，
Executors.newCachedThreadPool() 线程池运行多线程
*/

/**
 * 
 * @Description
 * @author RRW      Email:friend_rrw@163.com
 * @version
 * @date 2020年7月18日下午2:07:42
 */
public class SleepSort {

    /**
     * 睡眠者类，也就是睡眠排序操作多线程类，让当前线程睡眠排序数字
     * 那么多秒……睡醒后，就将排序数放入List，完成当前数字的睡眠排序
     */
    static class Sleeper implements Runnable {

        //需要排序的数字之一，也就是睡多少秒
        private int sleepSeconds;
        
        //开始的倒数栅栏，用于控制大家一起开始睡
        private CountDownLatch startLatch;
        
        //结束的倒数栅栏，用于等大家都睡醒了，整理并返回排序结果
        private CountDownLatch finishLatch;
        
        //记录排序结果的List，需要是线程安全的
        private List result;

        /**
         * 睡眠者类的构造方法，用构造传入参数
         * @param sleepSeconds 排序数组中的数字之一，也就是睡多少秒
         * @param startLatch 开始的倒数栅栏，用于控制大家一起开始睡
         * @param finishLatch 结束的倒数栅栏，用于等大家都睡醒了，整理并返回排序结果
         * @param result 记录排序结果的List，需要是线程安全的
         */
        public Sleeper(int sleepSeconds, CountDownLatch startLatch, CountDownLatch finishLatch, List result){
            this.sleepSeconds = sleepSeconds;
            this.startLatch = startLatch;
            this.finishLatch = finishLatch;
            this.result = result;
        }

        /**
         * 睡眠排序的实现方法
         */
        @Override
        public void run() {
            try {
                //start倒数栅栏阻塞，等待所有排序线程就绪
                startLatch.await();
                
                //所有排序线程都启动后，大家同一时间一起睡
                //睡的秒数，就是排序的数字
                Thread.sleep(sleepSeconds * 1000);
                
                //睡醒后，将该排序数放入结果list
                result.add(sleepSeconds);
                
                //结束的倒数栅栏计数减一，以便于大家都睡醒并将结果放入List了
                //主线程统一处理结果List，返回睡眠排序的有序结果
                finishLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 睡眠排序算法(SleepSort)
     * 
     * 这个睡眠排序算法虽然挺欢乐的，但是实现该排序算法
     * 也不简单，涉及到多线程的设计、启动、运行，以及控制
     * 的方法，这里我用CountDownLatch类来控制多线程，
     * Executors.newCachedThreadPool() 线程池运行多线程
     * 
     * 注意：睡眠排序最好是非负整数，且最大值不要太大，
     * 否则算法会运行很久……非负小数其实也可以，但是
     * 排序后的相邻小数的差值不要太小，否则可能会出错，
     * 因为多线程的运行有其不确定性和延迟的可能
     * @param arr 待排序数组
     * @return 运行睡眠排序后，排好序的结果
     */
    public static int[] sleepSort(int[] arr){
        //待返回的排好序的数组
        int[] sorted = new int[arr.length];
        
        try {
            /**
             * 用于统计排序结果的list，需要线程安全，可以选的线程安全List如下：
             * 1、Vector：老牌线程安全list，内部操作方法全用synchronized修饰
             * 2、CopyOnWriteArrayList：写时复制List，用原子操作更新内部数组，
             *      写操作（如add()操作）的时候需要数组复制，适用于读多写少的场景
             * 3、Collections.synchronizedList()：入参一个List的子类实例，返回
             *      一个线程安全的List
             */
            List result = Collections.synchronizedList(new ArrayList<>());

            //开始的倒数栅栏，用以控制所有睡眠排序线程同时同步开始运行
            CountDownLatch startLatch = new CountDownLatch(1);
            
            //结束的倒数栅栏，用以阻塞睡眠排序结束的线程，等所有睡眠
            //线程醒来，并加入自己的睡眠秒数后，取消阻塞所有的睡眠排序
            //线程，以便于保证所有数字都加入了结果List，然后再统一处理
            CountDownLatch finishLatch = new CountDownLatch(arr.length);

            //线程池框架实例，用于执行睡眠排序的多个排序线程
            ExecutorService executor = Executors.newCachedThreadPool();

            //将待排序数组的所有元素，每一个都开启一个睡眠排序线程
            for (int i = 0; i < arr.length; i++) {
                
                //创建当前排序数字的睡眠者类实例，线程睡眠排序数字那么多秒之后，
                //将结果按顺序加入结果List的最末端，实现睡眠排序
                Sleeper sleeper = new Sleeper(arr[i], startLatch, finishLatch, result);
                
                //执行当前排序数字的睡眠者类实例
                executor.execute(sleeper);
            }

            //所有待排序数字的睡眠者类线程都创建完成并启动后，
            //放开start倒数栅栏，大家同时一起睡
            //因为start倒数栅栏构造入参1，所以countDown()只需要调用1次
            startLatch.countDown();

            //finish倒数栅栏阻塞，直到所有睡眠者类线程都完成
            //睡眠排序，并提交结果后，才放开finish倒数栅栏
            //然后处理睡眠排序后的结果
            finishLatch.await();

            //现在所有排序线程均已完成排序，并提交了结果
            //接下来将睡眠排序后的List，整理为数组
            for (int i = 0; i < result.size(); i++) {
                sorted[i] = (int) result.get(i);
            }
            
            //调用线程池框架的shutdown()方法
            //优雅地关闭线程池，结束它的使命
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //返回睡眠排序后的有序数组
        return sorted;
    }

    /**
     * 验证睡眠排序算法
     * @param args
     */
    
    public static void main(String[] args) {
        //待排序数组
        int[] arr = new int[16];
        long startTime = System.currentTimeMillis();
        //随机数类
        Random random = new Random();

        //随机生成排序数组（100以内的整数）
        //当然，本例的排序时间会在至多10秒之内完成
        //该算法运行时间，取决于排序数组中最大的数字
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }

        //打印待排序数组
        System.out.println("睡眠排序前：" + Arrays.toString(arr));

        //进行睡眠排序，返回排好序的新数组
        int[] sleepSortedArr = sleepSort(arr);

        //这里可以将排好序的数组，重新赋给原来的数组，保持之前的操作
        arr = sleepSortedArr;

        //打印睡眠排序后的数组
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println("睡眠排序后：" + Arrays.toString(arr));
    }  
}
//事实证明 如果随机生成数的结果相差很大，且数组越大，它们会睡得很久，这时你都可以敲完一个类的代码了，上面100的以内的随机数，16的数组大小就睡了将近100秒，即使你把它控制的很小范围 也是比不上普通的排序的，拿来练练异常处理、线程啥的是可以的，真正的排序算法是不会涉及的，但睡眠算法也有它相似的应用，这里不再赘述。
~~~



## 异常规则：

+ #### 子类重写的方法抛出的异常类型不大于父类被重写的方法抛出的异常类型；

+ #### 若父类中没有throws，子类中则不能有；意味着如果子类重写的方法中有异常，只能用try/catch方式；

+ #### 当在A方法中，其方法递进的调用了其他方法，建议递进的方法中使用throws，而方法A使用try/catch方法；



### 手动抛出异常：（throw）与  用户自定义异常类：

~~~java
package com.rrw.Exception;

import javax.management.RuntimeErrorException;

public class ThrowStdenttest {
	public static void main(String[] args) {
		try {
			Student stu = new Student();
			stu.regist(-1); // 下面的语句都不执行了，跳到getMessage
			System.out.println(stu);
		} catch (Exception e) {
//				e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

class Student {
	private int id;

	public void regist(int id) throws Exception {
		if (id > 0) {
			this.id = id;
		} else {
			// System.out.println("输入有误");
			// 手动throw：生成异常对象

			// throw new RuntimeException("输入有误");
			//throw new Exception("输入有误");
			throw new CustomException("输入有误");
		}
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
}

package com.rrw.Exception;
/*
  *  自定义异常类:
  * 	1.继承现有的异常结构： RuntimeException/Exception
  * 	2.提供全局常量：serialVersionUID序列号标识类CustomException
  *  	3.提供重载构造器
 */
public class CustomException extends RuntimeException {  
  static final long serialVersionUID = -88888888888888888L;
  	public CustomException() {
		
	}
  	public CustomException (String msg) {
		super(msg);
	}
}
~~~



## 小练习：

#### 编写应用程序EcmDef.java，接收命令行的两个参数，要求不能输入负数，计算两数相除。对数据类型不一致（NumberFormatException）、缺少命令行参数（ArraylndexOutOfBoundsException、除0（ArithmeticException）及输入负数（EcDef自定义的异常）进行异常处理。

#### 提示：

#### （1）在主类（EcmDef）中定义异常方法（ecm）完成两数相除功能。

#### （2）在main（）方法中使用异常处理语句进行异常处理。

#### （3）在程序中，自定义对应输入负数的异常类（EcDef）。

#### （4）运行时接受参数java EcmDef 2010   //args[0]="20”args[1]=“10”

#### （5）Interger类的static方法parselnt（String s）将s转换成对应的int值。

#### 			如：int a=Interger.parselnt（“314"）；//a=314；

~~~java
//EcmDef.java:
package com.rrw.Exception;

public class EcmDef {
	public static void main(String[] args) {
		try {
			int i = Integer.parseInt(args[0]);
			int j = Integer.parseInt(args[1]);
			System.out.println(ecm(i, j));
		} catch (NumberFormatException e) {
//		e.printStackTrace();
			System.out.println("数据类型不一致");
		} catch (ArrayIndexOutOfBoundsException e) {
//		e.printStackTrace();
			System.out.println("缺少命令行参数");
		} catch (ArithmeticException e) {
//		e.printStackTrace();
			System.out.println("分母不能为0");
		} catch (EcDef e) {
			System.out.println(e.getMessage());
		}
	}

	public static int ecm(int i, int j) throws EcDef {
		if (i < 0 || j < 0) {
			throw new EcDef("分子/分母不为负");
		}
		return i / j;
	}
}

//EcDef.java:
package com.rrw.Exception;

public class EcDef extends Exception{
	static final long serialVersionUID = -3333333333333333L;
	public EcDef() {
	
	}
	public EcDef(String msg) {
		super(msg);
	}
}
//测试结果：分母不能为0
~~~

![image-20200604211126399](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112504.png)

![image-20200604211226392](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112505.png)



## 异常处理5个关键字：try-catch-finally throws throw:

![image-20200604211426894](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112506.png)

> #### 世界上最遥远的距离，是我在<u>if</u>里你在<u>else</u>里，似乎一直相伴又永远分离；
>
> #### 世界上最痴心的等待，是我当<u>case</u>你是<u>switch</u>，或许永远都选不上自己；
>
> #### 世界上最真情的相依，是你在<u>try</u>我在<u>catch</u>。无论你发多少脾气，我都不会<u>throws</u>你，一起期待我们的<u>finally</u>。



---



## 项目三：开发团队调度

![image-20200718154113701](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112507.png)

###  ![image-20200718154129733](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112508.png)

![image-20200718154151713](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112509.png)

![image-20200718154213380](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112510.png)

![image-20200718154223752](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112511.png)

![image-20200718154237170](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112512.png)

![image-20200718154248631](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112513.png)

![image-20200718154308308](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112514.png)

![image-20200718154317016](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112515.png)

----

![image-20200718154333509](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112516.png)

![image-20200718154343124](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112517.png)

![image-20200718154355934](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112518.png)

![image-20200718154409369](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112519.png)

![image-20200718154430812](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112520.png)

![image-20200718154439963](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112521.png)

![image-20200718154451796](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112522.png)

![image-20200718154504244](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112523.png)

![image-20200718154515811](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112524.png)

![image-20200718154527323](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112525.png)

![image-20200718154535748](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112526.png)

![image-20200718154544423](https://blogrrw.oss-cn-shenzhen.aliyuncs.com/bloguse/20200909112527.png)

### com.project3.domain:

+ #####  [Architect.java](..\..\E for JAVA EE\test\src\com\project3\domain\Architect.java) 

+ #####  [package-info.java](..\..\E for JAVA EE\test\src\com\project3\domain\package-info.java) 

+ #####  [PC.java](..\..\E for JAVA EE\test\src\com\project3\domain\PC.java) 

+ #####  [Printer.java](..\..\E for JAVA EE\test\src\com\project3\domain\Printer.java) 

+ #####  [Programmer.java](..\..\E for JAVA EE\test\src\com\project3\domain\Programmer.java) 

+ #####  [Designer.java](..\..\E for JAVA EE\test\src\com\project3\domain\Designer.java) 

+ #####  [Employee.java](..\..\E for JAVA EE\test\src\com\project3\domain\Employee.java) 

+ #####  [Equipment.java](..\..\E for JAVA EE\test\src\com\project3\domain\Equipment.java) 

+ #####  [NoteBook.java](..\..\E for JAVA EE\test\src\com\project3\domain\NoteBook.java) 

### com.project3.junit：

+ #####  [NameListServiceTest.java](..\..\E for JAVA EE\test\src\com\project3\junit\NameListServiceTest.java) 

+ #####  [package-info.java](..\..\E for JAVA EE\test\src\com\project3\junit\package-info.java) 

### com.project3.service:

+ #####  [NameListService.java](..\..\E for JAVA EE\test\src\com\project3\service\NameListService.java) 

+ #####  [Status.java](..\..\E for JAVA EE\test\src\com\project3\service\Status.java) 

+ #####  [TeamException.java](..\..\E for JAVA EE\test\src\com\project3\service\TeamException.java) 

+ #####  [TeamService.java](..\..\E for JAVA EE\test\src\com\project3\service\TeamService.java) 

+ #####  [Data.java](..\..\E for JAVA EE\test\src\com\project3\service\Data.java) 

### com.project3.view:

+ #####  [TeamView.java](..\..\E for JAVA EE\test\src\com\project3\view\TeamView.java) 

+ #####  [TSUtility.java](..\..\E for JAVA EE\test\src\com\project3\view\TSUtility.java) 

