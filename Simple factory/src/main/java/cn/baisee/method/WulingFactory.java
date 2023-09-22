package cn.baisee.method;

import cn.baisee.simple.CarFactory;
import cn.baisee.simple.WuLingCar;

public class WulingFactory implements CarMethodFactory {
    public CarFactory getCar() {
        //返回一个五菱的车
        return new WuLingCar();
    }
}
