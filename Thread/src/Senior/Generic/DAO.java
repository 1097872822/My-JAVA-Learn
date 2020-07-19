package Senior.Generic;

import java.util.List;

/**
 *@description:   泛型的作用(应用):  指定操作的对象（类，数据表）以带 <> 的形式
 *              DAO ： 数据访问对象 datebase access object
 *@author: RRW friend_rrw@163.com
 *@create: 2020-06-15 19:40
 */
public class DAO<T> { //惭怍具体某个类(数据库表) 的 增删该查方法；
    //添加记录：
    public void add(T ad){

    }
    //删除记录：
    public boolean remove(int index){
        return false;
    }
    //修改记录
    public void update(int index,T a){

    }
    //查询多条记录
    public List<T> getIndex(int index){
        return null;
    }
    //获取类/数据表中的值
    public <E> E getValue(){ //不确定的泛型方法
        return null;
    }
}
