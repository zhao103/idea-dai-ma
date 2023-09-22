package cn.baisi.service;

import cn.baisi.entity.User;
import cn.baisi.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserMapper usermapper;
    @Override
    public List<User> usersetAll() {

        return usermapper.usersetAll();
    }

}
