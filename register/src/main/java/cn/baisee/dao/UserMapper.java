package cn.baisee.dao;

import cn.baisee.model.User;

public interface UserMapper {
    //通过账户名字获取内容
    User getByUsername(String username);
}
