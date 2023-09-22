package cn.baisi.service;

import cn.baisi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    //查询方法
    List<User> usersetAll();
}
