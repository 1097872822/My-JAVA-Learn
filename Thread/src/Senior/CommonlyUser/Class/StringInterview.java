package Senior.CommonlyUser.Class;
/**
 *@description: String的形参实参、值传递、参数传递、基本数据类型与引用数据类型测试；
 *          注意：
 *              1.基本数据类型传的是存储的数据；引用数据类型传的是地址值；
 *              2*.在调用change方法时，str和ch传递的都是引用，在方法中修改了
 *                 ch指向对象的内容，由于形参与实参指向相同的对象，因此通过形参
 *                 对对象内容的修改对实参是可见的。对于str来说，修改的是
 *                 引用本身，也就是修改的是引用的值，而不是修改引用指向的内容，
 *                 对引用本身的修改对实参是不可见的。
 *              3.在Java中调用方法时，如果参数是基本类型（byte/short/int/long/float/double/char/boolean)
 *                以及String类型时，形参的改变不影响实参。
 *              4.如果是引用数据类型（不包括String），比如数组int[]/char[]，形参的改变会影响到实参。
 *              5.参考链接：
 *                  “https://www.cnblogs.com/guoguotju/p/7419736.html”
 *                  “https://blog.csdn.net/weixin_39980123/article/details/81843128”
 *                  “https://zhuanlan.zhihu.com/p/24556934”
 *                  “https://zhuanlan.zhihu.com/p/55548266”
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-08 16:12
 */
public class StringInterview {
    String str = new String("good"); //在常量池里；得到的是“内容”
    char[] ch = {'t','e','s','t'};  //在堆中；得到的是字符数组的"地址值“；

    public void change(String str,char ch[]){ //形参；拿到上面的str是不可变的
        str = "food";  //形参作出改变，但不影响实参；“不可变性”；
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringInterview s1 = new StringInterview();
        s1.change(s1.str,s1.ch);//change()方法在stack中重新造了两个形参变量，
                                //并将str，ch的地址赋给它们；
        System.out.println(s1.str);
        System.out.println(s1.ch);
    }
}
