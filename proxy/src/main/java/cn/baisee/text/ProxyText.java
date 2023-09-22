package cn.baisee.text;

import cn.baisee.prox.Prox;
import cn.baisee.prox.ProxCglib;
import cn.baisee.prox.ProxJDK;
import cn.baisee.service.UserService;
import cn.baisee.service.UserServiceImp;

public class ProxyText {
    public static void main(String[] args) {
        //静态代理
        UserService userService = new UserServiceImp();
//        userService.add();
        Prox prox = new Prox(userService);
        prox.add();
        //jdk的动态代理
        //目标对象
//        UserService userService = new UserServiceImp();
//        //创建代理对象
//        ProxJDK proxJDK = new ProxJDK(userService);
//
//        UserService object = (UserService)proxJDK.getProxInstance();
//        object.add();
//        object.show();

        // Cglib的动态代理
//        UserService userService = new UserServiceImp();
//        ProxCglib proxCglib = new ProxCglib(userService);
//        Object object = proxCglib.getProx();
//        if (object instanceof UserService){
//            ((UserService) object).add();
//        }

    }
}
