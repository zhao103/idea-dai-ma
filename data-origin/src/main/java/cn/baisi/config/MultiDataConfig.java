package cn.baisi.config;

import cn.baisi.aop.DynamicDataSource;
import cn.baisi.enumeration.Mj;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MultiDataConfig {
    //将master交给容器托管
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataConfig(){

        return DataSourceBuilder.create().build();
    }
    //将slave交给容器托管
    @Bean
    @ConfigurationProperties("spring.datasource.slave")
    //condition机制
    @ConditionalOnProperty(prefix = "spring.datasource.slave",name = "enabled",havingValue = "true")
    public DataSource slaveDataConfig(){

        return DataSourceBuilder.create().build();
    }
    @Bean
    @Primary
    public DynamicDataSource setdynamic(){
        Map<Object, Object> map = new HashMap<>();
        map.put(Mj.master.name(),masterDataConfig());
        map.put(Mj.slave.name(),slaveDataConfig());

        return new DynamicDataSource(map,masterDataConfig());
    }

}
