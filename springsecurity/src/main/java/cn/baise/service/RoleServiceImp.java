package cn.baise.service;

import cn.baise.entity.Role;
import cn.baise.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    //全表查询
    @Override
    public List<Role> selRole() {
        return roleMapper.selRole();
    }
    //修改
    @Override
    public Integer upRole(Role role) {
        return roleMapper.upRole(role);
    }
    //添加
    @Override
    public Integer addRole(Role role) {
        return roleMapper.addRole(role);
    }
    //删除
    @Override
    public Integer delRole(Integer id) {
        return roleMapper.delRole(id);
    }
}
