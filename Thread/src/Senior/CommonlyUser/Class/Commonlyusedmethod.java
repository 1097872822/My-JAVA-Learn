package Senior.CommonlyUser.Class;

import org.junit.jupiter.api.Test;

/**
 *@description: String 常用方法：
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-08 18:48
 */

public class Commonlyusedmethod {
    @Test
    public void test1(){
        String s1= "RRw";
        System.out.println(s1.length());//获取长度；
        System.out.println(s1.charAt(0));//获取第0位；
        System.out.println(s1.isEmpty());//判断是否为空；
        System.out.println(s1.toLowerCase());//将所有字符转换为小写；
        System.out.println(s1.toUpperCase());//将所有字符转换为大写；
        String s2 = "  mY namE iS rRw !  ";
        System.out.println("---" + s2.trim() + "---");//去掉首尾的空格，开发会用到，比如用户输入多了空格；
        String s3 = "rrW";
        System.out.println(s3.equalsIgnoreCase(s1));//忽视大小写比较字符串是否相同；
        System.out.println(s3.compareTo(s1));//编码形式比较；0就是相等；
        System.out.println(s3.substring(1));//从第1位开始截取；
        System.out.println(s2.substring(5,9));//左闭右开，从4开始截取到9(不包含9);
    }
    @Test
    public void test2(){
         String s1 = "Hello Wrold~";
         boolean b1 = s1.endsWith("ld~");//判断是否以“ld~”结尾；
        System.out.println(b1);
        boolean b2 = s1.startsWith("HE");
        boolean b3 = s1.startsWith("ll",2);//从2位置开始，是否为ll
        System.out.println(b2);
        System.out.println(b3);
        String s2 = "LL";
        System.out.println(s1.contains(s2));//s1中是否包含“LL”；
        System.out.println(s1.indexOf("l"));//返回“ll”的第一个索引；否则返回-1；
        System.out.println(s1.indexOf("l",9));//从第9位开始找是否出现“l”；返回其第一个出现的索引；
        System.out.println(s1.lastIndexOf("l"));//从后往前
        System.out.println(s1.lastIndexOf("l",3));
    }
    @Test
    public void test3() {
        String s1 = "11wo 22ai 33xuexi! 44wowo";
        System.out.println(s1.replace("w", "我"));
        System.out.println(s1.replace("wo","WO"));
        //正则： 先去掉数字部分，换成","；再去掉开头结尾为“，”的字符；
        System.out.println(s1.replaceAll("\\d+",",").replaceAll("^,|,$",""));

        String s2 = "1111";
        boolean num = s2.matches("\\d+");//判断是是否全是数字；
        System.out.println(num);
        String s3 = "0000-1234567";
        boolean phone = s3.matches("0000-\\d{7}");//判断是否为一个号码，7是以“0000-”开头后的长度是否为7；
        System.out.println(phone);

        String[] s4 = s3.split("\\-");//以“-”切割字符串；
        for (int i = 0; i <s4.length; i++) {
            System.out.println(s4[i]);
        }
    }
}
