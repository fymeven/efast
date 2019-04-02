package cn._51even.efast.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import java.util.Properties;

@Configuration
public class TKMyBatisConfig {

    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage(ProjectConfig.MAPPER_PACKAGE);
        Properties properties = new Properties();
        //tk通用mapper
        properties.setProperty("mappers",ProjectConfig.BASE_MAPPER);
        //更新操作判断空字符串 !=null && !=''
        properties.setProperty("notEmpty", "true");
        //实体和表转换时的默认规则：驼峰转下划线大写形式
        properties.setProperty("style","camelhumpAndUppercase");
        //用于校验通用 Example 构造参数 entityClass 是否和当前调用的 BaseMapper<EntityClass> 类型一致
        properties.setProperty("checkExampleEntityClass","true");
        //用于返回主键
        properties.setProperty("order","before");
        //delete时必须设置查询条件才能删除，否则会抛出异常
        properties.setProperty("safeDelete","true");
        //update时必须设置查询条件才能更新，否则会抛出异常
        properties.setProperty("safeUpdate","true");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }

}
