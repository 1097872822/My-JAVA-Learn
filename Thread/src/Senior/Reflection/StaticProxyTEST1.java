package Senior.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *@description: 动态代理
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 21:48
 */
interface Man{
    String getAbility();  //能力
    void Struggle(String work); //努力工作
}
//提供被代理类
class Workers implements Man{

    @Override
    public String getAbility() {
        return "996的修改BUG";
    }

    @Override
    public void Struggle(String work) {
        System.out.println("我在努力赚钱，努力地：" + work);
    }
}

//在这整个动态代理与AOP的理解：
class WorkersUtilcomp{  //定义同用的方法
    public void m1(){
        System.out.println("---通用方法1---");
    }
    public void m2(){
        System.out.println("---通用方法2---");
    }
}


/*
    动态代理：
        1、怎么创建一个代理类及对象？
        2、对象调用方法时，怎么动态调用 被代理类的同名方法？
 */
class ProxyFC{
    //通过此方法，返回一个代理类的对象：
    public static Object getProxyInstance(Object o){ // o:被代理类的对象
        //创建代理类对象，方法：newProxyInstance():
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(o); //绑定 o
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),o.getClass().getInterfaces(),myInvocationHandler);
        //（下面的ws ， 加载器 ， 接口 ）
    }
}

class MyInvocationHandler implements InvocationHandler{
    private Object object; //需要用 被代理类的对象进行赋值
    //实例化： 一个绑定的方法
    public void bind(Object object){
        this.object = object;
    }

    //当通过代理类的对象调 A方法时，就会调这个invoke()
    //将被代理类要执行的方法 A，将其功能声明在 invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //WorkersUtilcomp的测试：
        WorkersUtilcomp utilcomp = new WorkersUtilcomp();
        utilcomp.m1();

        // method就是代理类对象调用的方法，也是被代理类调用的方法；
        Object ReturnValue = method.invoke(object, args);// (属性，同名方法的参数args);
        //WorkersUtilcomp的测试：invoke()调用完以后：
        utilcomp.m2();
        return ReturnValue; //实际也是invoke()的返回值
    }
}

public class StaticProxyTEST1 {
    public static void main(String[] args) {
        Workers ws = new Workers();
        // instance 此时就是代理类的对象
        Man instance = (Man) ProxyFC.getProxyInstance(ws);//ws就传给了上面 的 o ；
        //当通过代理对象调用方法时，会自动电泳被代理类中同名的方法；
        //动态调用被代理类中的方法：
        String ability = instance.getAbility();
        System.out.println(ability);
        instance.Struggle("修改前天的BUG");
        System.out.println();

        //诶？这只有一个被代理类啊，我还是看不出“动态性”呢；
        NikeCF nikeCF = new NikeCF();
        ClothFactory proxyInstance = (ClothFactory) ProxyFC.getProxyInstance(nikeCF);
        proxyInstance.productCloth();
    }
}
