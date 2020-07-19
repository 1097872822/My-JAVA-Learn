package com.project03.domain;
/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-07-18 16:58
 */
public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee(){
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    //设计师不能调最高父类中的toString，只能换成该方法使其调用
    public String getDetails(){
        return id + "\t" + name + "\t" + age + "\t" + salary;
    }

    @Override
    public String toString() {
        return getDetails();
    }
}
