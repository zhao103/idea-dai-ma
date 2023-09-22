package cn.baisee.ultimateAbstract;

public class Text {
    public static void main(String[] args) {
        System.out.println("小米系列的产品-----------------");
        PlantAbstract xm = new MiPlant();
        //小米的手机
        Cellphone getcellphone = xm.getcellphone();
        //小米的路由
        RouteAbstract route = xm.route();
        //发短信
        getcellphone.messages();
        //打电话
        getcellphone.phone();
        //小米路由开机
        route.action();
        //小米路由关机
        route.shutdown();
        System.out.println("华为系列的产品===============");
        PlantAbstract hw = new HuaweiPlant();
        //华为的手机
        Cellphone hwphone = hw.getcellphone();
        //华为的路由
        RouteAbstract hwroute = hw.route();
        //打电话
        hwphone.phone();
        //发短信
        hwphone.messages();
        //华为路由开机
        hwroute.shutdown();
        //华为路由关机
        hwroute.action();
    }
}
