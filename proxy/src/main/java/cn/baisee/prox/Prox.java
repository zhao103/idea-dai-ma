package cn.baisee.prox;

import cn.baisee.service.UserService;

public class Prox implements UserService{
    //扩展的对象
    private UserService userService;
    //有参构造
    public Prox(UserService userService){
        this.userService = userService;
    }


    public void add() {
        System.out.println("++++++++++++++++++");
        userService.add();
        System.out.println("==================");

    }

    public String show() {

        return "是是是是 是是是是";
    }
}
