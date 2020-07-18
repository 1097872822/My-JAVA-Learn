package com.project03.domain;
/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-07-18 17:09
 */
public class Designer extends  Programmer{
    private double bounus;

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bounus) {
        super(id, name, age, salary, equipment);
        this.bounus = bounus;
    }

    public double getBounus() {
        return bounus;
    }

    public void setBounus(double bounus) {
        this.bounus = bounus;
    }
    public String getDetailsForTeam(){
        return getMemberDetails() + "\t设计师\t" + getBounus();
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" +
                getStatus() + "\t" +
                getBounus() + "\t\t" +
                getEquipment().getDescription();
    }
}
