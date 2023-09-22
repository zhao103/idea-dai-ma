package cn.poi.easy;

import cn.poi.strategy.PolicyFactory;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelAnalysisException;
import com.alibaba.excel.util.StringUtils;
import lombok.Data;
import lombok.SneakyThrows;

import cn.poi.strategy.Policyinf;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Custom<T> extends AnalysisEventListener<T> {
    //读取到的正确数据
    private List<T> list = new ArrayList<T>();
    //存储错误的数据
   private List<Mistake<T>> mislist = new ArrayList<Mistake<T>>();
    private Class<T> cla;


    public Custom(Class<T> cla) {
        this.cla = cla;
    }

    public Map<Integer, String> show(){
        //将获取的后端的表头存入
        Map<Integer, String> map = new HashMap<Integer, String>();
        //判断cla是否为空
        if (null != cla){
            //用反射从cla'里面获取属性
            Field[] declaredFields = cla.getDeclaredFields();
            //遍历所有的属性
            for ( Field f: declaredFields  ) {
                //获取属性头上的注解
                ExcelProperty annotation = f.getAnnotation(ExcelProperty.class);
                if (null != annotation){
                    int index = annotation.index();
                    String value = annotation.value()[0];
                    map.put(index,value);
                }
            }
        }
        return map;
    }

    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        Map<Integer, String> show = show();
        try {
            if (show.size() != headMap.size()) {
                throw new ExcelAnalysisException("解析excel出错，个数不对");
            }
            for (Integer k : headMap.keySet()) {
                if (StringUtils.isEmpty(headMap.get(k))) {
                    throw new ExcelAnalysisException("解析excel出错，有空值");
                }
                //判断数据是否相等
                if (!headMap.get(k).equals(show.get(k))) {
                    throw new ExcelAnalysisException("解析excel出错，数据不对");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public void invoke(T t, AnalysisContext analysisContext) {
        //创建工厂
        PolicyFactory<T> policyFactory = new PolicyFactory();
        //获取存储对象的list
//        policyFactory.show().forEach(cha->{
//            List<Mistake<T>> mistakes = cha.checkImportExcel(list);
//            mistakes.forEach(mislist::add);
//        });



        //这个需要导入第三方的依赖文件
//        List<String> bonding = InspectorDto.bonding(t);
//        if (bonding != null || bonding.size() != 0){
//            for (String s : bonding){
//                System.out.println(s);
//            }
//
//        }

    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        System.out.println("执行完成");

    }
}
