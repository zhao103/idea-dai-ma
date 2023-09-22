package cn.baisee.strategy;

import cn.baisee.model.User;
import cn.baisee.model.UserState;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class ValidStrategy implements LoginStrategy{
//    @Autowired
//    private HttpSession session;
    /**
     * 密码不正确处理逻辑
     *
     * @param dbUser
     * @return
     */
    @Override
    public Map<String, Object> doMap(User dbUser,HttpSession session) {
// 1. 正常登录成功，将用户放入 session
        session.setAttribute("loginUser", dbUser);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.VALID.getMessage());
        return resultMap;
    }

}
