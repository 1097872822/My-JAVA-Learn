package Senior.Annotation;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
/**
 *@description:  Annotation 使用
 *          示例一：生成文档相关的注解
 *          示例二：在编译时进行格式检查(JDK内置的三个基本注解)
 *              @Override: 限定重写父类方法, 该注解只能用于方法
 *              @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。
 *              通常是因为所修饰的结构危险或存在更好的选择.
 *              @SuppressWarnings: 抑制编译器警告,如属性，方法声明了没有用；
 *
 *          自定义注解：
 *              public @interface RRW_Annotation {
 *              String value() default "自定义注解"; }
 *
 *          示例三：跟踪代码依赖性，实现替代配置文件功能<往后“反射”再跟进>
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-11 16:55
 */
public class AnnotationTEST {
    public static void main(String[] args) {
        Person p1 = new man();
        p1.sing();//man can run
        //@SuppressWarnings: 抑制编译器警告:
        @SuppressWarnings("unused")
        int a = 1;
        @SuppressWarnings({"unused","rawtype"})
        ArrayList list = new ArrayList();
    }
    //通过反射获取注解信息：
    @Test
    public void TestgetAnnotation(){
        Class manClass = man.class;
        Annotation[] annotations = manClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);//@Senior.Annotation.RRW_Annotation(value=自定义注解)
        }
    }
}

@RRW_Annotation()
class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sing() {
        System.out.println("I can sing");
    }
    public void dance() {
        System.out.println("I can dance");
    }
}
interface info{
}

class man extends Person implements info{
    @Override
    public void sing() {
        System.out.println("man can run");
    }
}
