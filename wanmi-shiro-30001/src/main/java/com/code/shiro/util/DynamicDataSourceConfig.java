package com.code.shiro.util;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(basePackages = "com.code.shiro.login.mapper", sqlSessionFactoryRef = "SqlSessionFactory") //basePackages 我们接口文件的地址
public class DynamicDataSourceConfig {

    // 将这个对象放入Spring容器中
    @Bean(name = "PrimaryDataSource")
    // 表示这个数据源是默认数据源
    @Primary
    // 读取application.properties中的配置参数映射成为一个对象
    // prefix表示参数的前缀
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource getDateSource1() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "SecondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource getDateSource2() {
        return DataSourceBuilder.create().build();
    }

    
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource DataSource(@Qualifier("PrimaryDataSource") DataSource primaryDataSource,
                                        @Qualifier("SecondaryDataSource") DataSource secondaryDataSource) {
        
        //这个地方是比较核心的targetDataSource 集合是我们数据库和名字之间的映射
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put(DataSourceType.DataBaseType.Primary, primaryDataSource);
        targetDataSource.put(DataSourceType.DataBaseType.Secondary, secondaryDataSource);
        DynamicDataSource dataSource = new DynamicDataSource(); 
        dataSource.setTargetDataSources(targetDataSource);
        dataSource.setDefaultTargetDataSource(primaryDataSource);//设置默认对象
        return dataSource;
    }
    
    
    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dynamicDataSource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*/*.xml"));//设置我们的xml文件路径
        return bean.getObject();
    }
}
