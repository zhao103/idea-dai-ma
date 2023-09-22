package cn.baise.mapper;

import cn.baise.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //全表查询
    List<User> seluser();
    //单行查询
    User usinguser(Integer id);
    //修改数据
    Integer upuser(User user);
    //添加数据
    Integer adduser(User user);
    //批量删除
    Integer deluser(List<Integer> list);
    //用user去查询role的角色
    List<Integer> seleuser_roleid(Integer userId);
    //添加用户的权限
    Integer insertuserid_roleid(Integer userId,Integer roleId);
    //删除用户的权限
    Integer deleteuserid_roleid(Integer userId,Integer roleId);
}
