package cn.baisee.leadership;

import cn.baisee.Approver;
import cn.baisee.PurchaseRequest;

public class VicePrincipal extends Approver {

    public VicePrincipal(String name) {
        super(name);
    }

    public void show(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() >=10000)
            System.out.println("请求被"+name+"处理");
        else
            approver.show(purchaseRequest);
    }
}
