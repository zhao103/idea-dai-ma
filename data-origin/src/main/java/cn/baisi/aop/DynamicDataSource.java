package cn.baisi.aop;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

//动态数据源类
public class DynamicDataSource extends AbstractRoutingDataSource {
    public DynamicDataSource(Map<Object, Object> targetDataSources,Object defaultTargetDataSource){
        super.setTargetDataSources(targetDataSources);
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.afterPropertiesSet();
    }


    @Override
    //指定当前数据源
    protected Object determineCurrentLookupKey() {
        System.out.println("用的数据源是"+DynamicDataSourceHandler.getDynamicDataSourceHandler());
        //返回的是数据源对应的key
        return DynamicDataSourceHandler.getDynamicDataSourceHandler();
    }
}
