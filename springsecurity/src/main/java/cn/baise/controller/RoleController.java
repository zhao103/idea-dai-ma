package cn.baise.controller;

import cn.baise.entity.Role;
import cn.baise.entity.User;
import cn.baise.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    //修改
    public Integer upRole( Role role){
        return  roleService.upRole(role);
    }
    //添加
    public int addRole( Role role){
        return roleService.addRole(role);
    }
    //删除
    public Integer delRole(Integer id){
        return roleService.delRole(id);
    }
}
