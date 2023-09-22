package cn.baise.entity;

import lombok.Data;

@Data
public class User {
    //id
    private Integer id;
    //用户名字
    private String username;
    //电话
    private String telephone;
    //邮箱
    private String mail;
    //密码
    private String password;
    //状态
    private int status;

}
