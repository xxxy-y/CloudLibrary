package cn.edu.tyut.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * @Author 羊羊
 * @ClassName SpringConfig
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 12:23
 * @Package_Name cn.edu.tyut.config
 * @Note 1. 声明@Configuration注解,代表配置类
 * 2. 声明@EnableTransactionManagement注解,开启事务注解支持
 * 3. 声明@EnableAspectJAutoProxy注解,开启aspect aop注解支持
 * 4. 声明@ComponentScan("com.atguigu.service")注解,进行业务组件扫描
 * 5. 声明transactionManager(DataSource dataSource)方法,指定具体的事务管理器
 * 6. 声明@Import注解，导入在同一文件夹下的其他配置文件
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