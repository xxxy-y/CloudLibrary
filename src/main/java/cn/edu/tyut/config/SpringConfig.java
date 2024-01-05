package cn.edu.tyut.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Author 羊羊
 * @ClassName SpringConfig
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 12:23
 * @Package_Name cn.edu.tyut.config
 */
@Configuration
@Import({
        MybatisConfig.class,
        JdbcConfig.class
})
@ComponentScans({
        @ComponentScan("cn.edu.tyut.service")
})
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class SpringConfig {
    @Bean
    public TransactionManager transactionManager(@Autowired DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}