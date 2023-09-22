package cn.baisee.chapter;

public class Text {
    public static void main(String[] args) {
        ChargeAndTransverter chargeAndTransverter = new ChargeAndTransverter(new Charger());
        chargeAndTransverter.connect();
        chargeAndTransverter.charge();
    }
}
