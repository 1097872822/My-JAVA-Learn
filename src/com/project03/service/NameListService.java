package com.project03.service;

import com.project03.domain.PC;
import com.project03.domain.*;

import static com.project03.service.Data.*;

/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-07-18 18:00
 */
public class NameListService {
    private Employee[] employees;
    public NameListService() {//构造器
        //给employees初始化
//		1.根据项目提供的Data类构建相应大小的employees数组
//		2.再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//		3.将对象存于数组中
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < employees.length; i++) {
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);

            Equipment equipment;
            double bounus;
            int stock;
            switch (type){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = creatEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = creatEquipment(i);
                    bounus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bounus);
                    break;
                case ARCHITECT:
                    equipment = creatEquipment(i);
                    bounus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(name,id,age,salary,equipment,bounus,stock);
                    break;
            }
        }
    }
    private Equipment creatEquipment(int index) {
        int type = Integer.parseInt(EQIPMENTS[index][0]);
        switch (type) {
            case PC:
                return new PC(EQIPMENTS[index][1],EQIPMENTS[index][2]);
            case NOTEBOOK:
                double price = Double.parseDouble(EQIPMENTS[index][2]);
                return new NoteBook(EQIPMENTS[index][1],price);
            case PRINTER:
                return new Printer(EQIPMENTS[index][1],EQIPMENTS[index][2]);
        }
        return null;
    }

    public Employee[] getEmployees(){
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (Employee e : employees){
            if (e.getId() == id){
                return e;
            }
        } throw new TeamException("该成员不存在");
    }
}











