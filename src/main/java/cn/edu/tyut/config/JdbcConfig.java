package cn.edu.tyut.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import javax.sql.DataSource;

/**
 * @Author 羊羊
 * @ClassName JdbcConfig
 * @SubmitTime 周五
 * @DATE 2024/1/5
 * @Time 11:58
 * @Package_Name cn.edu.tyut.config
 * @Note 使用@PropertySources注解来读取在类路径下的jdbc.properties数据库配置文件中的数据库连接信息，并定义getDataSource()方法，用于创建DruidDataSource对象，通过DruidDataSource对象返回数据库连接信息。
 */
@PropertySources({
        @PropertySource("classpath:jdbc.properties")
})
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")
    public DataSource getDataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }
}
