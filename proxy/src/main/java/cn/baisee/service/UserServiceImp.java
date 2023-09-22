package cn.baisee.service;

public class UserServiceImp implements UserService{
    public void add() {
        System.out.println("恭喜你账户添加成功");
    }


    public String show() {
        System.out.println("这是祥龙尊者的方法");
        return "祥龙尊者np";
    }
}
