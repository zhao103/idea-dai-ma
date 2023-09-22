package cn.baisee.leadership;

import cn.baisee.Approver;
import cn.baisee.PurchaseRequest;

public class Dean extends Approver {
    public Dean(String name) {
        super(name);
    }

    public void show(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice()>5000 && purchaseRequest.getPrice()<=10000)
            System.out.println("请求被"+name+"处理");
        else
            approver.show(purchaseRequest);
    }
}
