package com.project03.domain;
/**
 *@description:  股票类
 *@author: RRW friend_rrw@163.com
 *@create: 2020-07-18 17:09
 */
public class Architect extends Designer{
    private int stock; //股票

    public Architect() {
    }

    public Architect(String name, int id,int age, double salary, Equipment equipment, double bounus, int stock) {
        super(id, name, age, salary, equipment, bounus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public String getDetailsForTeam(){
        return getMemberDetails() + "\t架构师\t" +
                getBounus() + "\t" + getStock();
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" +
                getStatus() + "\t" +
                getBounus() + "\t" + stock + "\t" +
                getEquipment().getDescription();
    }
}
