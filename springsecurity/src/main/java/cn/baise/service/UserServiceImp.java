package cn.baise.service;

import cn.baise.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
//, UserDetailsService

@Service
public class UserServiceImp implements UserService , UserDetailsService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> roles = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
        return new User("tom", new BCryptPasswordEncoder().encode("123"), roles);
    }

    @Override
    //全表
    public List<cn.baise.entity.User> seluser() {
        List<cn.baise.entity.User> seluser = userMapper.seluser();
        return seluser;
    }

    @Override
    //单行
    public cn.baise.entity.User usinguser(Integer id) {

        return userMapper.usinguser(id);
    }

    @Override
    //修改
    public Integer upuser(cn.baise.entity.User user) {
        return userMapper.upuser(user);
    }

    @Override
    //添加
    public Integer adduser(cn.baise.entity.User user) {
        return userMapper.adduser(user);
    }

//    @Override
//    //删除
//    public Integer deluser(Integer id) {
//        return userMapper.deluser(id);
//    }

    @Override
    public Integer deluser(List<Integer> list) {
        return userMapper.deluser(list);
    }

    @Override
    public List<Integer> seleuser_roleid(Integer userId) {
        return userMapper.seleuser_roleid(userId);
    }
    //添加用户的权限
    @Override
    public Integer insertuserid_roleid(Integer userId, Integer roleId) {
        return userMapper.insertuserid_roleid(userId,roleId);
    }
    //删除用户的权限
    @Override
    public Integer deleteuserid_roleid(Integer userId, Integer roleId) {
        return userMapper.deleteuserid_roleid(userId,roleId);
    }
}
