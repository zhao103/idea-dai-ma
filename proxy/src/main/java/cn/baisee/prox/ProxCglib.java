package cn.baisee.prox;

import cn.baisee.service.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxCglib implements MethodInterceptor {
    //动态代理的对象
    private Object target;
    //构造
    public ProxCglib(UserService target) {
        this.target = target;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("事务开启");
        Object object = method.invoke(target,objects);
        System.out.println("事务关闭");
        return object;
    }
    public Object getProx(){
        Enhancer enhancer = new Enhancer();
        //设置代理类的字节码,不用在获取接口
        enhancer.setSuperclass(target.getClass());
        //设置一个回调,传递当前对象
        enhancer.setCallback(this);
        //创建代理对象并且返回
        return enhancer.create();
    }
}
