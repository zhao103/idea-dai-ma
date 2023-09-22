package cn.baisee.strategy;

import cn.baisee.model.User;
import cn.baisee.model.UserState;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class UnRegisterStrategy implements LoginStrategy{
    @Override
    public Map<String, Object> doMap(User dbUser, HttpSession session) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.UNREGISTER.getMessage());
        return resultMap;
    }
}
