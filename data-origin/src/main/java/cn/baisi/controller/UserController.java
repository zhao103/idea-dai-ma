package cn.baisi.controller;

import cn.baisi.entity.Stu;
import cn.baisi.entity.User;
import cn.baisi.note.DataSource;
import cn.baisi.service.StuService;
import cn.baisi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.xml.ws.Service;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StuService stuService;

    @RequestMapping("/user/getuser")
    public String getalluser(){
        List<User> users = userService.usersetAll();
        for (User user : users) {
            System.out.println(user.getStudent());
        }
        return "你好ya";
    }

    @RequestMapping("/stu/getstu")
    public List<Stu> getallstu(){
        List<Stu> stus = stuService.StusetAll();
        for (Stu stu : stus) {
            System.out.println(stu.getSname());
        }
        return stus;
    }
}
