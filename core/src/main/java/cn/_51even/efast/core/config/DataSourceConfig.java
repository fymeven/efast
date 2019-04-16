package cn._51even.efast.core.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@AutoConfigureAfter(DruidDataSourceAutoConfigure.class)
public class DataSourceConfig {

    private static HashMap<Object,Object> dataSourceMap = new HashMap<>();

    public static HashMap<Object, Object> getDataSourceMap() {
        return dataSourceMap;
    }

    public static void setDataSourceMap(HashMap<Object, Object> dataSourceMap) {
        DataSourceConfig.dataSourceMap = dataSourceMap;
    }

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        try{
            druidDataSource.addFilters("stat,wall,log4j");
        }catch (Exception e){

        }
        return druidDataSource;
    }

    @Bean(name = "dynamicDataSource")
    @ConditionalOnProperty(prefix = "spring.datasource",name = "multipart",havingValue = "true")
    public DataSource dynamicDataSource(){
        AbstractRoutingDataSource dynamicDataSource = new AbstractRoutingDataSource() {
            @Override
            protected Object determineCurrentLookupKey() {
                return DataSourceContextHolder.getDataSource();
            }
        };
        dynamicDataSource.setDefaultTargetDataSource(dataSource());
        dataSourceMap.put("defaultDB",dataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

//    @Bean(name = "transactionManager")
//    @ConditionalOnProperty(prefix = "spring.datasource",name = "multipart",havingValue = "true")
//    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }
}
