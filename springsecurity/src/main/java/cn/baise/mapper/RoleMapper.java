package cn.baise.mapper;

import cn.baise.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    //全表查询
    List<Role> selRole();
    //修改数据
    Integer upRole(Role role);
    //添加数据
    Integer addRole(Role role);
    //删除
    Integer delRole(Integer id);

}
