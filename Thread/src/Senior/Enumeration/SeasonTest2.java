package Senior.Enumeration;
/**
 *@description: Enum类关键字定义枚举类
 *                  定义的枚举类默认继承于java.lang.Enum类
 *            主要方法：
 *             values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的 枚举值。
 *             valueOf(String str)：可以把一个字符串转为对应的枚举类对象。
 *                  要求字符 串必须是枚举类对象的“名字”。如不是，会有运行时异常： IllegalArgumentException。
 *             toString()：返回当前枚举类对象常量的名称
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-11 13:54
 */
public class SeasonTest2 {
    public static void main(String[] args) {
        Seasonenum summer = Seasonenum.SUMMER;
        //toString():
        System.out.println(summer);  //SUMMER 是Enum类中输出的方法；如果不想用，就在下面重写toString方法
        System.out.println();
        //values():
        Seasonenum[] values = Seasonenum.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }
        System.out.println();
        //+线程的状态：
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        System.out.println();
        //valueOf(String objName): 返回指定对象明的数据
        Seasonenum autumn = Seasonenum.valueOf("AUTUMN");
        System.out.println(autumn);

        autumn.show();
    }
}
interface info {  //枚举类实现接口
    void show();
}
enum Seasonenum implements info{
    //提供当前枚举类多个对象  ，可以在其后添加{ }在里面写上不一样的show()方法；
    SPRING ("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天：3-5");
        }
    },
    SUMMER ("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("夏天：6-8");
        }
    },
    AUTUMN ("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天:9-11");
        }
    },
    WINTER ("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("冬天:12-2");
        }
    };
    //声明Season对象属性
    private final String SeasonNAME;
    private final String SeasonDESC;
    //私有化构造器 ,并初始化赋值
    private Seasonenum(String SeasonNAME,String seasonDESC){
        this.SeasonNAME = SeasonNAME;
        this.SeasonDESC = seasonDESC;
    }
    public String getSeasonNAME() {
        return SeasonNAME;
    }

    public String getSeasonDESC() {
        return SeasonDESC;
    }

    @Override  //重写之后按照重写方法输出
    public String toString() {
        return "Seasonenum{" +
                "SeasonNAME='" + SeasonNAME + '\'' +
                ", SeasonDESC='" + SeasonDESC + '\'' +
                '}';
    }
}