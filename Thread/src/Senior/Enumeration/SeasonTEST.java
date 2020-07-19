package Senior.Enumeration;
/**
 *@description:  枚举类的使用：
 *          1.JDK5之前 需要自定义枚举类；
 *          2.jdk5 由Enum类关键字定义；
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-11 13:36
 */
public class SeasonTEST {
    public static void main(String[] args) {
        Season winter = Season.WINTER;
        System.out.println(winter);
    }
}
class Season{
    //声明Season对象属性
    private final String SeasonNAME; //这两个属性都不一样，则显示赋值和代码块中赋值就不太适合，就应该在构造器中赋值；
    private final String SeasonDESC;
    //私有化构造器 ,并初始化赋值
    private Season(String SeasonNAME,String seasonDESC){
        this.SeasonNAME = SeasonNAME;
        this.SeasonDESC = seasonDESC;
    }
    //提供当前枚举类多个对象
    public static final Season SPRING = new Season("春天","春暖花开");
    public static final Season SUMMER = new Season("夏天","夏日炎炎");
    public static final Season AUTUMN = new Season("秋天","秋高气爽");
    public static final Season WINTER = new Season("冬天","冰天雪地");
    //获取属性：

    public String getSeasonNAME() {
        return SeasonNAME;
    }

    public String getSeasonDESC() {
        return SeasonDESC;
    }

    @Override
    public String toString() {
        return "Season{" +
                "SeasonNAME='" + SeasonNAME + '\'' +
                ", SeasonDESC='" + SeasonDESC + '\'' +
                '}';
    }
}
