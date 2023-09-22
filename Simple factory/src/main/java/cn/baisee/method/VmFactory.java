package cn.baisee.method;

import cn.baisee.simple.CarFactory;
import cn.baisee.simple.Vm;

public class VmFactory implements CarMethodFactory{

    public CarFactory getCar() {

        //返回一个大众车
        return new Vm();
    }
}
