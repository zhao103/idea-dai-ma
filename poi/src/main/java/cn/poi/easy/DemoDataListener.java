package cn.poi.easy;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DemoDataListener extends AnalysisEventListener<UserDto> {
    //读取到的数据

    public void invoke(UserDto userDto, AnalysisContext analysisContext) {
        System.out.println("数据是"+userDto);

    }
    public void invokeHeadMap(Map<Integer, String> map, AnalysisContext context) {
        System.out.println(map);

    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
