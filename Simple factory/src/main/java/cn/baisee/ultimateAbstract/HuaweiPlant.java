package cn.baisee.ultimateAbstract;

//华为工厂
public class HuaweiPlant implements PlantAbstract {
    //华为手机
    public Cellphone getcellphone() {
        return new HuaweiCellphone();
    }
    //华为路由
    public RouteAbstract route() {
        return new HuaweiRoute();
    }
}
