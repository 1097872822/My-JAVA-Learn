package com.project03.domain;
/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-07-18 17:10
 */
public class Printer implements Equipment{
    private String name;
    private String tupe;

    public Printer() {
    }

    public Printer(String name, String tupe) {
        this.name = name;
        this.tupe = tupe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTupe() {
        return tupe;
    }

    public void setTupe(String tupe) {
        this.tupe = tupe;
    }

    @Override
    public String getDescription() {
        return name + "(" + tupe + ")";
    }
}
