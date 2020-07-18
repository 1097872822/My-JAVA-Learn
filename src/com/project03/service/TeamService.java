package com.project03.service;

import com.project03.domain.Architect;
import com.project03.domain.Designer;
import com.project03.domain.Employee;
import com.project03.domain.Programmer;

/**
 * @description: 添加 删除等操作；
 * @author: RRW friend_rrw@163.com
 * @create: 2020-07-18 18:00
 */
public class TeamService {
    private static int counter = 1;  //赋值memberID
    private final int MAX_MEMBER = 5; //限制团队开发人数;
    private Programmer[] teams = new Programmer[MAX_MEMBER]; //保存成员
    private int total;  //记录总人数

    public TeamService() {
    }

    //获取所有成员:
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.teams[i];
        }
        return team;
    }

    //添加指定员工:
    public void addMenber(Employee employee) throws TeamException {
        //1.满员，无法添加
        if (total >= MAX_MEMBER) {
            throw new TeamException("队伍已满");
        }
        //2.不是开发人员
        if (!(employee instanceof Programmer)) {
            throw new TeamException("不是团队开发人员");
        }
        //3、已经在开发团队中:
        if (isExist(employee)) {
            throw new TeamException("该员工已在退队中");
        }

        //4.该员工已经是别的退队的成员
        //5.在休假
        Programmer p = (Programmer) employee;
        if (isExist(p)) throw new TeamException("该员工已经在别的团队中");
        switch (p.getStatus()) {
            case BUSY:
                throw new TeamException("该员工已是某团队成员");
            case VOCATION:
                throw new TeamException("该员工在休假");
        }

        //团队限制条件:
        //6.团队中至多只能有一名架构师
        //7.团队中至多只能有两名设计师
        //8.团队中至多只能有三名程序员

        // 获取team中已有的架构师，设计师，程序员的人数：
        int numOFArch = 0;
        int numOFDes = 0;
        int numOFPro = 0;
        for (int i = 0; i < total; i++) {
            if (teams[i] instanceof Architect) {
                numOFArch++;
            } else if (teams[i] instanceof Designer) {
                numOFDes++;
            } else {
                numOFPro++;
            }
        }
        if (p instanceof Architect) {
            if (numOFArch >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOFDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOFPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        //p属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberID(counter++);
        // 将p 添加到team中
        teams[total++] = p;
    }

    private boolean isExist(Employee employee) {
        for (int i = 0; i < total; i++) {
            if (teams[i].getId() == employee.getId()) return true;
        }
        return false;
    }

    //删除退队中的成员：
    public void removeMenber(int memberID) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (teams[i].getMemberID() == memberID) {
                teams[i].setStatus(Status.FREE);
                break;
            }
        }
        //找不到指定menberID的情况:
        if (i == total) {
            throw new TeamException("没有找到指定的员工");
        }
        //删除一个，并覆盖:
        for (int j = i + 1; j < total; j++) {
            teams[j - 1] = teams[j];
        }
        teams[--total] = null;
    }
}