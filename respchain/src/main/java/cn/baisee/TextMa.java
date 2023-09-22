package cn.baisee;

import cn.baisee.leadership.Dean;
import cn.baisee.leadership.DepartmentApprover;
import cn.baisee.leadership.VicePrincipal;

public class TextMa {
    public static void main(String[] args) {
        //采购需求
        PurchaseRequest purchaseRequest = new PurchaseRequest(8000);
        Approver zr = new DepartmentApprover("崔主任");
        Approver ld = new Dean("郭领导");
        Approver xz = new VicePrincipal("赵校长");
        //zr.setApprover(ld)传的ld到抽象类的approver里面
        zr.setApprover(ld);
        ld.setApprover(xz);
        xz.setApprover(zr);
        ld.show(purchaseRequest);
    }
}
