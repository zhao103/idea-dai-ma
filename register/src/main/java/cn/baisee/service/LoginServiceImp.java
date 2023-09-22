package cn.baisee.service;

import cn.baisee.dao.UserMapper;
import cn.baisee.model.User;
import cn.baisee.model.UserState;
import static cn.baisee.model.AppConstant.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Service
public class LoginServiceImp implements LoginService{

    @Autowired
    private HttpSession session;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Map<String, Object> login(User user) {
        User dbUser = userMapper.getByUsername(user.getUsername());
// 2. 判断用户状态
        UserState state = checkUserState(dbUser, user.getPassword());
// 3. 根据用户状态进行相应操作，这些相应的操作，我们把它定义成方法
        switch (state) {
            case ABNORMAL:
                return doAbnormalMap(dbUser);
            case INCORRENT:
                return doIncorrentMap(dbUser);
            case LEAVE:
                return doLeaveMap(dbUser);
            case NOMENU:
                return doNoMenuMap(dbUser);
            case UNREGISTER:
                return doUnRegisterMap(dbUser);
            case VALID:
                return doValidMap(dbUser);
        }
        return null;
    }
    private Map<String,Object> doValidMap(User dbUser){
        session.setAttribute("loginUser",dbUser);
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.VALID.getMessage());
        return resultMap;
    }
    private Map<String,Object> doUnRegisterMap(User dbUser){
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.UNREGISTER.getMessage());
        return resultMap;
    }
    private Map<String, Object> doNoMenuMap(User dbUser) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.NOMENU.getMessage());
        return resultMap;
    }
    private Map<String, Object> doLeaveMap(User dbUser) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.LEAVE.getMessage());
        return resultMap;
    }
    private Map<String, Object> doIncorrentMap(User dbUser) {
        Map<String, Object> resultMap = new HashMap<>();
// 1. 记入数据库密码错误次数
// 2. 判断密码错误达到一定次数，锁定当前用户
// 3. 页面提示用户还有几次机会，或者忘了密码，提示他怎么找回密码等操作
        resultMap.put("msg", UserState.INCORRENT.getMessage());
        return resultMap;
    }
    private Map<String, Object> doAbnormalMap(User dbUser) {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", UserState.ABNORMAL.getMessage());
        return resultMap;
    }
    private UserState checkUserState(User dbUser, String password) {
// 1. 如果user为null，用户状态为未注册
        if (dbUser == null) {
            return UserState.UNREGISTER;
        }
// 2. 如果密码不正确，返回密码不正确状态
        if (!password.equals(dbUser.getPassword())) {
            return UserState.INCORRENT;
        }
// 3. 如果用户状态为 1，表示用户状态正常
        if (LOGIN_STATE_VALID.equals(dbUser.getState())) {
            return UserState.VALID;
        }
// 4. 如果用户状态为 2，表示用户状态异常
        if (LOGIN_STATE_ABNORMAL.equals(dbUser.getState())) {
            return UserState.ABNORMAL;
        }
// 5. 如果用户状态为 3，表示用户已离职
        if (LOGIN_STATE_LEAVE .equals(dbUser.getState())) {
            return UserState.LEAVE;
        }
        return UserState.NOMENU;
    }
}
