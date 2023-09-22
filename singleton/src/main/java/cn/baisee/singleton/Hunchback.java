package cn.baisee.singleton;

public class Hunchback {
    //饿汉模式

    //唯一的单例对象
    private static Hunchback singleton = new Hunchback();
    //私有的构造器
    private Hunchback(){

    }
    //全局访问点
    public static Hunchback getInstance(){
        return singleton;
    }
}
