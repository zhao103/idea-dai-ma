package cn.baisee.service;

import java.util.Map;
import cn.baisee.model.User;

public interface LoginService {

    Map<String, Object> login(User user);
}
