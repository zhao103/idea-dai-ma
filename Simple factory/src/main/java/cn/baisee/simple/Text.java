package cn.baisee.simple;

import cn.baisee.method.VmFactory;
import cn.baisee.method.WulingFactory;

public class Text {
    public static CarFactory getCat(String type){
        if("五菱".equals(type)){
            return new WuLingCar();
        }else if ("大众".equals(type)){
            return new Vm();
        }
        return null;
    }
    public static void main(String[] args) {
        CarFactory cat = Text.getCat("五菱");
        cat.show();
        //工厂方法
//        CarFactory wl = new WulingFactory().getCar();
//        CarFactory dz = new VmFactory().getCar();
//        wl.show();
//        dz.show();
    }
}
