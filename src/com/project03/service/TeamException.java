package com.project03.service;
/**
 *@description: 自定义异常类
 *@author: RRW friend_rrw@163.com
 *@create: 2020-07-18 18:00
 */
public class TeamException extends Exception{
    static final long serialVersionUID = -231313131232113123L;
    public TeamException(){

    }
    public TeamException (String msg){
        super(msg);
    }
}
