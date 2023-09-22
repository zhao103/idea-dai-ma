package cn.baisee.strategy;

public class Text {
    public static void main(String[] args) {
       Environment jia = new Environment(new Addition());
        System.out.println(jia.show(123456,8392901));

    }
}
