package cn.baisee.ultimateAbstract;

//小米工厂
public class MiPlant implements PlantAbstract {
    //小米造手机
    public Cellphone getcellphone() {

        return new MiCellphone();
    }
    //小米造路由
    public RouteAbstract route() {

        return new MiRoute();
    }
}
