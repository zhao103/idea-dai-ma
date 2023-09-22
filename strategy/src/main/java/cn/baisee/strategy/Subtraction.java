package cn.baisee.strategy;

public class Subtraction implements Duck {

    public int arithmetic(int a, int b) {
        System.out.println("计算结果是:");
        return a-b;
    }
}
