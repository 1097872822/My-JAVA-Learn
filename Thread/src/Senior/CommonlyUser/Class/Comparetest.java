package Senior.CommonlyUser.Class;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 *@description:  Java 比较器：
 *         我们以前了解到的对象 ，只有 == 或者 != 的比较关系，但大小不能比较。
 *         要实现就可以使用这两个接口：
 *          1.Comparable  自定义排序
 *          2.Comparator  定制排序（当前元素没有实现comparable接口时，排序不符合要求时）
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-10 23:01
 */
public class Comparetest {
    @Test //Comparable的使用
    public void test1(){
        String[] arr = new String[]{"sw","dd","qe","hg","zz"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));//[dd, hg, qe, sw, zz]
        /*其实String、包装类等是实现了Comparable接口，重写了compareTo方法，得以比较两个对象的大小；*/
    }
    @Test    //Comparable测试
    public void test2(){
        Goods[] arr1 = new Goods[6];
        arr1[0] = new Goods("iPhone X",7000);
        arr1[1] = new Goods("iPhone XR",4000);
        arr1[2] = new Goods("iPhone Xmax",12000);
        arr1[3] = new Goods("iPhone Xs",9000);
        arr1[4] = new Goods("iPhone SE2",3500);
        arr1[5] = new Goods("iPadAir3",4000);
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    @Test //Comparator测试
    public void test3(){
        String[] arr2 = new String[]{"sw","dd","qe","hg","zz"};
        //重写(Object o1,Object o2)方法，比较O1,O2大小；
        Arrays.sort(arr2,new Comparator(){
            //指定规则
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String){
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2); //从大到小
                }
//                return 0;
                throw new RuntimeException("类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr2));
    }

    @Test //Goods的comparator测试：
    public void test4(){
        Goods[] arr1 = new Goods[6];
        arr1[0] = new Goods("iPhone X",7000);
        arr1[1] = new Goods("iPhone XR",4000);
        arr1[2] = new Goods("iPhone Xmax",12000);
        arr1[2] = new Goods("iPhone Xmax",8000);//二手
        arr1[3] = new Goods("iPhone Xs",9000);
        arr1[4] = new Goods("iPhone SE2",3500);
        arr1[5] = new Goods("iPadAir3",4000);
        Arrays.sort(arr1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods) o1;
                    Goods g2 = (Goods) o2;
                    //若商品名一样，按价格排，否则按商品名排：
                    if (g1.getName().equals(g2.getName())){
                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else {
                        return  g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr1));
    }

}
class Goods implements Comparable{  // test2的商品类
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明比较方式：  按价格从低到高,要是价格相等按name从低到高排；
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods){ //是商品？
            Goods phones = (Goods)o;//强转
            if (this.price > phones.price){
                return 1; //大
            }else if (this.price < phones.price){
                return -1; //小
            }else {
//                return 0; //相等
                //要是价格相等，接着指定另一个属性进行排序：
                return this.name.compareTo(phones.name);
                //this前加“-”则为从高到低，因为compareTo()中默认写的是从低到高的；
            }
            //也可以：
//            return Double.compare(this.price,phones.price);
        }
        throw new RuntimeException("数据类型不一致~");
    }
}
