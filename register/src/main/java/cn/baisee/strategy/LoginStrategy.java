package cn.baisee.strategy;

import cn.baisee.model.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

public interface LoginStrategy {
    Map<String, Object> doMap(User dbUser,HttpSession session);

}

