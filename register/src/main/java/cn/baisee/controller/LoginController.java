package cn.baisee.controller;

import cn.baisee.model.User;
import cn.baisee.service.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import cn.baisee.service.LoginService;

import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }
    @PostMapping("/login")
    public String login(User user, ModelMap map) {
// 调用 service 层完成登录功能
        Map<String, Object> resultMap = loginService.login(user);
        if (resultMap != null) {
            map.put("result", resultMap);
        }
        return "index";
    }

}
