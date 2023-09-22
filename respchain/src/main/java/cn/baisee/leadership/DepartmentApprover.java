package cn.baisee.leadership;

import cn.baisee.Approver;
import cn.baisee.PurchaseRequest;

public class DepartmentApprover extends Approver {
    public DepartmentApprover(String name) {
        super(name);
    }

    public void show(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000){
            System.out.println("请求被"+name+"处理");
        }else {
            //approver就是领导的值,父类里面的值是子类然后子类去调用父类里面的方法
            approver.show(purchaseRequest);
        }
    }
}
