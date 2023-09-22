package cn.baisee.strategy;

//加法策略
public class Addition implements Duck {


    public int arithmetic(int a, int b) {
        System.out.println("计算结果是:");
        return a+b;
    }
}
