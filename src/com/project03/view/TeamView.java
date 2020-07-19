package com.project03.view;

import com.project03.domain.Employee;
import com.project03.domain.Programmer;
import com.project03.service.NameListService;
import com.project03.service.TeamException;
import com.project03.service.TeamService;

/**
 *@description:
 *@author: RRW friend_rrw@163.com
 *@create: 2020-07-18 17:59
 */
public class TeamView {
    private NameListService listService = new NameListService();
    private TeamService teamService = new TeamService();

    public void enterMainMenu(){
        char key = 0;
        boolean loopFlag = true;
        /*
        对于 while 语句而言，如果不满足条件，则不能进入循环。但有时候我们需要即使不满足条件，也至少执行一次。
        do…while 循环和 while 循环相似，不同的是，do…while 循环至少会执行一次。
         */
       do {
           if (key != '1')  listAllEmployees();
               System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
               key = TSUtility.readMenuSelection();
           System.out.println();
           switch (key){
               case '1':
                   listTeam();
                   break;
               case '2':
                   addMember();
                   break;
               case '3':
                   deleteMember();
                   break;
               case '4':
                   System.out.println("是否退出？(Y/N)");
                   char yn = TSUtility.readConfirmSelection();
                   if (yn == 'Y')
                       loopFlag = false;
                       break;
           }
       }while (loopFlag);
    }

    //显示所有成员信息:
    private void listAllEmployees(){
        System.out.println("" +
                "\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] employees = listService.getEmployees();
        if (employees.length == 0){
            System.out.println("没有客户记录");
        }else{
            System.out.println("ID\\t姓名\\t年龄\\t工资\\t职位\\t状态\\t奖金\\t股票\\t领用设备");
        }
        for (Employee e:employees){
            System.out.println(" " + e);
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    //显示开发团队列表:
    public void listTeam(){
        System.out.println("\n--------------------团队成员列表---------------------\n");
        Programmer[] team = teamService.getTeam();
        if (team.length == 0){
            System.out.println("开发团队目前没有成员！");
        }else {
            System.out.println("TID/ID\\t姓名\\t年龄\\t工资\\t职位\\t奖金\\t股票");
        }
        for (Programmer p : team){
            System.out.println(" " + p.getDetailsForTeam());
        }
        System.out.println("---------------------------------------------------------------");
    }
    //添加团第成员：
    private void addMember(){
        System.out.println("-------------------添加成员----------------------------");
        System.out.println("输入要添加的成员");
        int id = TSUtility.readInt();

        try {
            Employee e = listService.getEmployee(id);
            teamService.addMenber(e);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败,原因是:" + e.getMessage());
        }
        //按回车继续
        TSUtility.readReturn();
    }
    //删除团队中的成员:
    private void deleteMember(){
        System.out.println("-------------------删除成员---------------------");
        System.out.println("请输入要删除的成员TID：");
        int id = TSUtility.readInt();
        System.out.println("确认删除？(Y/N)");
        char yn = TSUtility.readConfirmSelection();
        if (yn == 'N') return;

        try {
            teamService.removeMenber(id);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage() );
        }
        //回车继续：
        TSUtility.readReturn();
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}