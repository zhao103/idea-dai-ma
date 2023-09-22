package cn.baisee.tactics;

public class WildDuck extends Duck {
    public WildDuck() {
        flyBehavior = new BadFlyBehavior();
    }

    public void display() {
        System.out.println("这是野鸭子");
    }
    public void fly() {
        System.out.println("鸭子不会飞");
    }

}
