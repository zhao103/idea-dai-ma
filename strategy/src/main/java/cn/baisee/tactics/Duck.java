package cn.baisee.tactics;

public abstract class Duck {
    protected FlyBehavior flyBehavior;

    //鸭子信息
    public abstract void display();
    //鸭子行为
    public void fly() {
       if(null != flyBehavior){
            flyBehavior.fly();
       }
    }

    public void quack() {
        System.out.println("鸭子会叫");
    }

}
