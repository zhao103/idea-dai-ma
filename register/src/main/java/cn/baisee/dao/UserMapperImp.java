package cn.baisee.dao;

import cn.baisee.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UserMapperImp implements UserMapper {
    @Override
    public User getByUsername(String username) {
        if ("苏轼".equals(username)) {
            return new User("苏轼", "123", "1");
        }
        return null;
    }
}
