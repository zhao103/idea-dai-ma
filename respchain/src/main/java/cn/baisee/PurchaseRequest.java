package cn.baisee;

public class PurchaseRequest {
    //请求金额
    private float price = 0.0f;


    public float getPrice() {
        return price;
    }

    public PurchaseRequest(float price) {
        this.price = price;
    }
}
