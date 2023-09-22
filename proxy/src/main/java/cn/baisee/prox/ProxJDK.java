package cn.baisee.prox;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxJDK {
    //声明目标对象
    private Object target;

    public ProxJDK(Object target){
        this.target = target;
    }

    public Object getProxInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("这是jdk的动态代理第一个");
                        Object ink = method.invoke(target,args);
                        System.out.println("这是jdk的动态代理第二个+++++++++");
                        return ink;
                    }
                }
        );
    }
}
