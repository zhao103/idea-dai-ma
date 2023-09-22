package cn.baisee.chapter;

public class ChargeAndTransverter implements Transverter{
    private Charger charger;

    public ChargeAndTransverter(Charger charger) {
        this.charger = charger;
    }


    public void connect() {
        System.out.println("用三个孔的插头进行转接");
    }


    public void charge() {
        charger.charge();
    }
}
