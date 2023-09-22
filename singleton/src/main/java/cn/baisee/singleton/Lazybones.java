package cn.baisee.singleton;

public class Lazybones {
    //懒汉模式

    //唯一的单例对象
    private static Lazybones song = null;
    //私有的构造器
    private Lazybones(){

    }
    //全局访问点
    public static Lazybones book(){
        if(song == null){
            synchronized (Lazybones.class){
                if (song == null){
                    song = new Lazybones();
                }
            }
        }
        return song;
    }
}

