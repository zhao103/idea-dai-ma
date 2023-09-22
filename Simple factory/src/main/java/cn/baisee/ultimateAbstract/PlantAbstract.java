package cn.baisee.ultimateAbstract;

//工厂的抽象类
public interface PlantAbstract {
    //造手机
    Cellphone getcellphone();
    //造路由
    RouteAbstract route();
}
