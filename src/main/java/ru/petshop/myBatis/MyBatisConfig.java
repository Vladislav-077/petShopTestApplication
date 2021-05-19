package ru.petshop.myBatis;

import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import ru.petshop.config.Config;

import javax.sql.DataSource;

@Log4j2
@Configuration
@MapperScan("ru.petshop.mapper")
public class MyBatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        return factoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


    private DataSource dataSource() {
        log.info("DataSource initializer");
        DataSource dataSource = new PooledDataSource(Config.DRIVER, Config.DATABASE_URL, Config.USER, Config.PASSWORD);
        return dataSource;
    }
}
