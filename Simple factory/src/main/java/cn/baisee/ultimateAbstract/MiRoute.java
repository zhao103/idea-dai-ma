package cn.baisee.ultimateAbstract;

//小米路由
public class MiRoute implements RouteAbstract{
    public void action() {
        System.out.println("小米路由开机");
    }

    public void shutdown() {
        System.out.println("小米路由关机");
    }
}
