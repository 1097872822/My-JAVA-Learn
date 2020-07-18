package com.project03.junit;

import com.project03.domain.Employee;
import com.project03.service.NameListService;
import com.project03.service.TeamException;
import org.junit.jupiter.api.Test;

/**
 *@description:  对NameListService的测试
 *@author: RRW friend_rrw@163.com
 *@create: 2020-07-18 17:31
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployee(){
        NameListService service = new NameListService();
        Employee[] employees = service.getEmployees();
        for (int i = 0; i < employees.length;i++){
            System.out.println(employees[i]);
        }
    }
    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();
        int id = 1; //输出第一个
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }
    }
}
