package cn.baisee.singleton;

public class Girl {
   private volatile static Girl song = null;
   private Girl(){

   }
   private static Girl show(){
      if(song == null){
         synchronized (Girl.class){
            if(song == null){
               song = new Girl();
            }
         }
      }
      return song;
   }
}
