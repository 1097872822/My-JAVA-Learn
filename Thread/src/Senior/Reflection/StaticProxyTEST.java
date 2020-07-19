package Senior.Reflection;
/**
 *@description: 静态代理的举例使用
 *          代理与被代理都是固定的了，无法变动
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 21:37
 */
interface ClothFactory{
    void productCloth();
}

//提供代理类：
class ProxyCF implements ClothFactory{
    private ClothFactory factory;
    //构造器：
    public ProxyCF (ClothFactory factory){
        this.factory = factory;
    }
    @Override
    public void productCloth() {
        System.out.println("工厂就绪");
        factory.productCloth();
        System.out.println("工厂完成工作");
    }
}

//提供被代理类：
class NikeCF implements ClothFactory{

    @Override
    public void productCloth() {
        System.out.println("Nike生产椰子");
    }
}

public class StaticProxyTEST {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeCF nikeCF = new NikeCF();
        //创建代理类的对象
        ProxyCF proxyCF = new ProxyCF(nikeCF);
        proxyCF.productCloth();
    }
}
