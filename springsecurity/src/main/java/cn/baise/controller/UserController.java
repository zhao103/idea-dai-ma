package cn.baise.controller;

import cn.baise.entity.Role;
import cn.baise.entity.User;
import cn.baise.service.RoleService;
import cn.baise.service.UserService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @PostMapping("/show/seluser")
    //全表查询
    public List seluser(){
        List<User> seluser = userService.seluser();
        return seluser;
    }
    //单表查询
    @GetMapping("/show/usinguser/{id}")
    public User usinguser(@PathVariable("id") Integer id){
        System.out.println("85244444444444444444444444444444444");
        return userService.usinguser(id);
    }

    //修改
    @GetMapping("/show/upuser")
    public Integer upuser( User user){
        return  userService.upuser(user);
    }
    //添加
    @GetMapping("/show/adduser")
    public Integer adduser(User user){

        return userService.adduser(user);
    }
    //删除
    @GetMapping("/show/deluser")
    public Integer deluser( String s){
        System.out.println("需要删除的id:"+s);
        String[] split = s.split(",");
        List<Integer> list=new ArrayList<>();
        for (String s1 : split) {
            if (s1=="" || s1==null){
                continue;
            }
            list.add(Integer.parseInt(s1));
        }
        Integer deluser = userService.deluser(list);
        System.out.println("删除之后受影响行数:"+deluser);
        return deluser;
    }
    //角色全表查询
    @PostMapping("/show/selRole")
    public List selRole(){
        List<Role> roles = roleService.selRole();
        return roles;
    }
    //用用户id查看权限
    @GetMapping("/show/seleuser_roleid")
    public List<Integer> seleuser_roleid(Integer userId){
        System.out.println("id传入成功");
        List<Integer> list = userService.seleuser_roleid(userId);
        return list;
    }
    @GetMapping("/show/patch")
    public String patch(Integer id, String roleIds, ModelMap map){
        //切割
        String[] split = roleIds.split(",");
        List<Integer> oldids = userService.seleuser_roleid(id);
        for (String newid : split){
            if (null==newid || "".equals(newid)){
                continue;
            }
            boolean flag =false;
            for (Integer oldid : oldids){
                if (newid.equals(oldid+"")){
                    oldids.remove(oldid);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                userService.insertuserid_roleid(id,Integer.valueOf(newid));
            }
        }
        oldids.forEach(roleId->userService.deleteuserid_roleid( id , roleId));
        List<User> users = userService.seluser();
        map.put("users" ,users);
        return "操作成功";
    }
}
