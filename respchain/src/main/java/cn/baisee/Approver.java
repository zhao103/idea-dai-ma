package cn.baisee;

public abstract class Approver {
    //审批人的姓名
    protected String name;
    //下一个审批人
    protected Approver approver;
    //审批人的姓名
    public Approver(String name) {
        this.name = name;
    }
    //下一个审批人
    public void setApprover(Approver approver) {
        this.approver = approver;
    }
    //审批方法
    public abstract void show(PurchaseRequest purchaseRequest);
}
