package cn.poi.batch;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyDataListener<T> extends AnalysisEventListener<T> {
    private Class<T> Clazz;
    List<T> list = new ArrayList<T>();

    public void invoke(T t, AnalysisContext analysisContext) {
        //将读取的数据存储到list里面
        list.add(t);
        if (list.size() > 1000){
            // 清空list
            list.clear();
        }
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> map, AnalysisContext context) {
        if(null != Clazz) {

            System.out.println("表头：" + map);
        }
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //将数据清空
        list.clear();

    }

    public MyDataListener(Class<T> Clazz) {
        Clazz = Clazz;
    }
}
