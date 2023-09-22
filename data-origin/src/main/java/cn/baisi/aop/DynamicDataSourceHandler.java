package cn.baisi.aop;



public class DynamicDataSourceHandler {

    private static final ThreadLocal<String> DATASOURCE_LIST = new ThreadLocal<>();
    public static void setDynamicDataSourceHandler(String key){
        DATASOURCE_LIST.set(key);
    }
    public static String getDynamicDataSourceHandler(){
        return DATASOURCE_LIST.get();
    }
    public static void reovm(){
        DATASOURCE_LIST.remove();
    }
}
