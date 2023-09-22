package cn.baise.service;

import cn.baise.entity.Role;

import java.util.List;

public interface RoleService {
    //全表查询
    List<Role> selRole();
    //修改数据
    Integer upRole(Role role);
    //添加数据
    Integer addRole(Role role);
    //删除
    Integer delRole(Integer id);
}
