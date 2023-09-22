package cn.baisee.ultimateAbstract;

//华为路由
public class HuaweiRoute implements RouteAbstract{
    public void action() {
        System.out.println("华为路由开机");
    }

    public void shutdown() {
        System.out.println("华为路由关机");
    }
}
