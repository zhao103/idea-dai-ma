package cn.baisee.strategy;

public class Environment {
    private Duck duck;

    public Environment(Duck duck) {
        this.duck = duck;
    }
    public int show(int a,int b){
        return duck.arithmetic(a,b);
    }
}
