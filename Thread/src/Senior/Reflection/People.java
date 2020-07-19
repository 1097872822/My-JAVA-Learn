package Senior.Reflection;
/**
 * @author RRW friend_rrw@163.com
 * @create 2020-06-24-15:01
 */

/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-24 15:01
 */
public class People {
    public String name;
    private int age;
    private int id;

    public People() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public People(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    private People(int age) {  //年龄设为私有
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("rongwang");
    }
    private String showFriend(String Friname){
        System.out.println("My friend is :"+Friname);
        return Friname;
    }

    private String Country(String country){
        System.out.println("我的老家在:" + country);
        return country;
    }
    private static void MoneyHAS(){
        System.out.println("我有100块钱");
    }

    //重写toString  在ReflectionTEST2.java中 test3测试用
    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                '}';
    }
}
