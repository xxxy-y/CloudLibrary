package cn.edu.tyut.config;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.logging.slf4j.Slf4jImpl;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.AutoMappingBehavior;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @Author 羊羊
 * @ClassName MybatisConfig
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 12:08
 * @Package_Name cn.edu.tyut.config
 * @Note 定义MyBatis的核心连接工厂，dataSource来自JdbcConfig中的配置。
 * MapperScannerConfig配置MyBatis要扫描目标文件夹中的mapper文件。
 *
 */
@MapperScan("cn.edu.tyut.mapper")
public class MybatisConfig {
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(@Autowired DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setLogImpl(Slf4jImpl.class);
        configuration.setAutoMappingBehavior(AutoMappingBehavior.FULL);
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setTypeAliasesPackage("cn.edu.tyut.entity");
        // 分页插件配置
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        // 设置插件的方言（Dialect）属性，PageHelper 将根据指定的数据库类型来选择适合该数据库的分页方案
        properties.setProperty("helperDialect", "mysql");
        // 开启或关闭插件的 count 查询功能 true：PageHelper 会自动执行 count 查询来获取总记录数
        properties.setProperty("value", "true");
        pageInterceptor.setProperties(properties);
        Interceptor[] plugins = {pageInterceptor};
        sqlSessionFactoryBean.addPlugins(plugins);
        return sqlSessionFactoryBean;
    }

    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("cn.edu.tyut.mapper");
        return mapperScannerConfigurer;
    }
}