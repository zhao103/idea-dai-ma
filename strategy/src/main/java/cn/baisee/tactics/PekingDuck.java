package cn.baisee.tactics;

public class PekingDuck extends Duck{
    public PekingDuck() {
        flyBehavior = new GoodFlyBehavior();
    }

    public void display() {
        System.out.println("这是北京鸭");
    }
    public void fly() {
        System.out.println("鸭子会飞");
    }
}
