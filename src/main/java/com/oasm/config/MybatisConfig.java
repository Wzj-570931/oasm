package com.oasm.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.oasm")
@MapperScan("com.oasm")
//@Import(MyImportBeanDefinitionRegistrar.class)
public class MybatisConfig {

    @Bean
    //@Autowired
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    @Bean
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/wzj?useUnicode=true&characterEncoding=utf-8&socketTimeout=50000&autoReconnect=true");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return druidDataSource;
    }
}
