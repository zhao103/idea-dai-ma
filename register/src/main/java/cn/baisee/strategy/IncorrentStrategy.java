package cn.baisee.strategy;

import cn.baisee.model.User;
import cn.baisee.model.UserState;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class IncorrentStrategy implements LoginStrategy{
    @Override
    public Map<String, Object> doMap(User dbUser, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>();
    // 1. 记入数据库密码错误次数
    // 2. 判断密码错误达到一定次数，锁定当前用户
    // 3. 页面提示用户还有几次机会，或者忘了密码，提示他怎么找回密码等操作
        resultMap.put("msg", UserState.INCORRENT.getMessage());
        return resultMap;
    }
}
