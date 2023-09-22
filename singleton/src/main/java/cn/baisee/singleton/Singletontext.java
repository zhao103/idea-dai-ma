package cn.baisee.singleton;

public class Singletontext extends Thread{
    @Override
    public void run() {
//       Hunchback hunchback = Hunchback.getInstance();
        Lazybones lazybones = Lazybones.book();
        System.out.println(lazybones);
    }
//@36c85f5
//@2ed230e2

    public static void main(String[] args) {
        for (int i= 0; i < 10; i++){
            Singletontext singletontext = new Singletontext();
            singletontext.start();
        }
    }
}
